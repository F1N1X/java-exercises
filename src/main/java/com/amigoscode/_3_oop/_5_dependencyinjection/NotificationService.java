package com.amigoscode._3_oop._5_dependencyinjection;




// TODO: 4 - Create the NotificationService class.
//   - Add a private final field: messageSender (MessageSender)
//   - Create a constructor that takes a MessageSender parameter
//     and assigns it to the field. This is constructor injection —
//     the dependency is provided from outside, not created inside.

public class NotificationService {
    private final MessageSender messageSender;
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    public void sendNotification(String to, String message) {
        messageSender.send(to, message);
    }
}

// TODO: 5 - In NotificationService, add a method:
//   void sendNotification(String to, String message)
//   This method should delegate to messageSender.send(to, message).
//   NotificationService does NOT know whether it is using email or SMS.


class NotificationDemo {
    public static void main(String[] args) {
        // TODO: 6 - Create a NotificationService with an EmailSender.
        //   Call sendNotification("alice@example.com", "Hello via email!").
        //   Then create ANOTHER NotificationService with an SmsSender.
        //   Call sendNotification("+1234567890", "Hello via SMS!").
        NotificationService notificationService = new NotificationService(new EmailSender());
        notificationService.sendNotification("alice@example.com", "Hello via email!");
        System.out.println();
        NotificationService notificationService2 = new NotificationService(new SmsSender());
        notificationService2.sendNotification("+1234567890", "Hello via SMS!");


        // TODO: 7 - Demonstrate swapping implementations:
        //   Create a MessageSender variable, assign EmailSender to it,
        //   pass it to NotificationService and send a message.
        //   Then reassign the variable to SmsSender,
        //   create a new NotificationService and send a message.
        //   Notice how NotificationService code never changed —
        //   only the injected dependency changed.
        MessageSender sender = new SmsSender();
        NotificationService service3 = new NotificationService(sender);
        System.out.println();
        service3.sendNotification("Test", "Message");
        System.out.println("Swap");
        sender = new EmailSender();
        service3 = new NotificationService(sender);
        service3.sendNotification("Swapped","New Swapp");



    }
}
