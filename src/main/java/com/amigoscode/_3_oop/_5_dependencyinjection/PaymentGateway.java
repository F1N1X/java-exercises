package com.amigoscode._3_oop._5_dependencyinjection;

/**
 * Exercise: Dependency Injection - Order Processing
 *
 * Build an order processing system where OrderProcessor depends on
 * abstractions (interfaces) rather than concrete classes. The payment
 * gateway and order repository are injected through the constructor.
 *
 * Key concepts:
 * - Multiple dependencies injected via constructor
 * - Separating concerns (payment vs persistence)
 * - Easy to swap implementations (e.g., test doubles)
 * - Clean, testable architecture
 */

// TODO: 1 - PaymentGateway

interface PaymentGateway {
    boolean charge(double amount);
}


class StripeGateway implements PaymentGateway {

    @Override
    public boolean charge(double amount) {
        System.out.printf("[Stripe] Charging $%.2f%n", amount);
        return true;
    }
}


// TODO: 2 - OrderRepository

interface OrderRepository {
    void save(Order order);
}


class InMemoryOrderRepository implements OrderRepository {

    @Override
    public void save(Order order) {
        System.out.printf("[Repository] Order saved: %s%n", order);
    }
}


// TODO: 3 - Order

record Order(
        String id,
        String item,
        double amount
) {}


// TODO: 4 + 5 - OrderProcessor

class OrderProcessor {

    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;


    public OrderProcessor(
            PaymentGateway paymentGateway,
            OrderRepository orderRepository
    ) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
    }


    public boolean processOrder(Order order) {

        boolean paymentSuccessful = paymentGateway.charge(order.amount());

        if (paymentSuccessful) {
            orderRepository.save(order);
            return true;
        }

        System.out.println("Payment failed for order: " + order.id());
        return false;
    }
}



class OrderProcessorDemo {

    public static void main(String[] args) {

        PaymentGateway stripeGateway = new StripeGateway();

        OrderRepository repository = new InMemoryOrderRepository();


        OrderProcessor processor = new OrderProcessor(
                stripeGateway,
                repository
        );


        Order order = new Order(
                "ORD-001",
                "Java Course",
                29.99
        );


        boolean result = processor.processOrder(order);

        System.out.println("Order successful: " + result);
    }
}