package com.amigoscode._3_oop._6_solid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise: SOLID Principles
 *
 * Practice all five SOLID principles by refactoring problematic code
 * into clean, well-structured designs.
 *
 * S - Single Responsibility Principle (SRP)
 * O - Open/Closed Principle (OCP)
 * L - Liskov Substitution Principle (LSP)
 * I - Interface Segregation Principle (ISP)
 * D - Dependency Inversion Principle (DIP)
 */
public class SolidExercises {

    // =========================================================================
    // SRP - Single Responsibility Principle
    // "A class should have only one reason to change."
    //
    // PROBLEM: UserManager below does THREE things — validation, persistence,
    // and notification. If any one of these changes, the whole class changes.
    // =========================================================================

    // This is the BROKEN version. Do not modify it — write the fix below.
    static class UserManagerBroken {
        void createUser(String name, String email) {
            // Validates
            if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
            if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
            // Saves to database
            System.out.println("Saving user " + name + " to database...");
            // Sends welcome email
            System.out.println("Sending welcome email to " + email + "...");
        }
    }

     //- UserValidator with a method: void validate(String name, String email)
    //     that throws IllegalArgumentException for invalid input
    class UserValidator {
        public void validate(String name, String email) {
            if (name == null || email == null || name.isEmpty() || email.isEmpty())
                throw new IllegalArgumentException();
            Pattern emailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailPattern.matcher(email);
            if (!matcher.matches())
                throw new IllegalArgumentException("Email is not in valid format");
        }
    }

    // TODO: 1 - Refactor by creating three separate classes:
    //
    //   - UserRepository with a method: void save(String name, String email)
    //     that prints "Saving user <name> to database..."

    class UserRepository {
        public void save(String name, String email) {
            System.out.printf("Saving user %s to database...", name);
        }
    }
    //   - UserNotifier with a method: void sendWelcome(String email)
    //     that prints "Sending welcome email to <email>..."
    class UserNotifier {
        public void sendWelcome(String email) {
            System.out.printf("Sending welcome email to %s...", email);
        }
    }
    //   Then create a refactored UserManager that uses all three via
    //   constructor injection and has a createUser(name, email) method.
    class UserManager {
        private UserNotifier userNotifier;
        private UserRepository userRepository;
        private UserValidator userValidator;

        public UserManager(UserNotifier UserNotifier, UserRepository userRepository, UserValidator userValidator) {
            this.userNotifier = UserNotifier;
            this.userRepository = userRepository;
            this.userValidator = userValidator;
        }

        public void createUser(String name, String email) {
            userValidator.validate(name, email);
            userNotifier.sendWelcome(email);
            userRepository.save(name, email);
        }

    }


    // =========================================================================
    // OCP - Open/Closed Principle
    // "Open for extension, closed for modification."
    //
    // PROBLEM: Adding a new discount type requires modifying the existing
    // calculateDiscount method with another if/else branch.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class DiscountCalculatorBroken {
        double calculateDiscount(String type, double price) {
            if ("SEASONAL".equals(type)) return price * 0.10;
            if ("CLEARANCE".equals(type)) return price * 0.50;
            // To add a new type, you must modify THIS method — violates OCP!
            return 0;
        }
    }

    interface Discount {
        double apply(double price);
    }

    class SeasonalDiscount implements Discount{
        @Override
        public double apply(double price) {
            return price * 0.2;
        }
    }

    class ClearanceDiscount implements Discount{
        @Override
        public double apply(double price) {
            return price * 0.5;
        }
    }

    class DiscountCalculator {
        public double calculate(Discount discount, double price) {
            return discount.apply(price);
        }
    }

    // TODO: 2 - Refactor using an interface:
    //   - Create a Discount interface with: double apply(double price)
    //   - Create SeasonalDiscount implementing Discount (10% off)
    //   - Create ClearanceDiscount implementing Discount (50% off)
    //   - Create a DiscountCalculator class with a method:
    //     double calculate(Discount discount, double price)
    //     that just calls discount.apply(price)
    //   Now new discount types can be added without modifying DiscountCalculator.


    // =========================================================================
    // LSP - Liskov Substitution Principle
    // "Subtypes must be substitutable for their base types."
    //
    // PROBLEM: MutableSquare extends MutableRectangle but breaks the contract.
    // Setting width on a square also changes height, which surprises code
    // that expects normal rectangle behavior.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MutableRectangleBroken {
        protected int width;
        protected int height;
        void setWidth(int w) { this.width = w; }
        void setHeight(int h) { this.height = h; }
        int area() { return width * height; }
    }

    static class MutableSquareBroken extends MutableRectangleBroken {
        @Override void setWidth(int w) { this.width = w; this.height = w; }
        @Override void setHeight(int h) { this.width = h; this.height = h; }
        // BUG: rect.setWidth(5); rect.setHeight(3); rect.area() -> 9, not 15!
    }

    // TODO: 3 - Fix the LSP violation. Create IMMUTABLE versions:
    //   - Create a LspShape interface with: int area()
    //   - Create an ImmutableRectangle class implementing LspShape with
    //     final fields width and height, constructor, and area() returning width * height
    //   - Create an ImmutableSquare class implementing LspShape with
    //     a final field side, constructor, and area() returning side * side
    //   Now neither class pretends to be the other. Both satisfy LspShape.
    interface LspShape {
        int area();
    }

    public static class ImmutableRectangle implements LspShape {

        private final int width;
        private final int height;

        public ImmutableRectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int area() {
            return width * height;
        }
    }


    public static class ImmutableSquare implements LspShape {

        private final int side;

        public ImmutableSquare(int side) {
            this.side = side;
        }

        @Override
        public int area() {
            return side * side;
        }
    }


    // =========================================================================
    // ISP - Interface Segregation Principle
    // "No client should be forced to depend on methods it does not use."
    //
    // PROBLEM: Robot is forced to implement eat() and sleep() even though
    // robots don't eat or sleep.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    interface WorkerBroken {
        void work();
        void eat();
        void sleep();
    }

    static class HumanWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Human working"); }
        public void eat()   { System.out.println("Human eating"); }
        public void sleep() { System.out.println("Human sleeping"); }
    }

    static class RobotWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Robot working"); }
        public void eat()   { /* Robots don't eat — forced to implement! */ }
        public void sleep() { /* Robots don't sleep — forced to implement! */ }
    }

    interface Sleepable {
        void sleep();
    }

    interface Eatable {
        void eat();
    }

    interface Workable {
        void work();
    }

    class HumanWorker implements Sleepable, Eatable, Workable {

        @Override
        public void eat() {
            System.out.println("Human eat");
        }

        @Override
        public void sleep() {
            System.out.println("Human sleep");
        }

        @Override
        public void work() {
            System.out.println("Human work");
        }
    }

    // TODO: 4 - Fix the ISP violation by splitting into smaller interfaces:
    //   - Workable interface with: void work()
    //   - Eatable interface with: void eat()
    //   - Sleepable interface with: void sleep()
    //   - HumanWorker class implementing Workable, Eatable, Sleepable
    //   - RobotWorker class implementing only Workable
    //   Now RobotWorker is not forced to implement methods it cannot use.


    // =========================================================================
    // DIP - Dependency Inversion Principle
    // "Depend on abstractions, not on concretions."
    //
    // PROBLEM: ReportGenerator directly creates MySQLDatabase inside itself.
    // It is tightly coupled to MySQL and cannot work with any other database.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MySQLDatabaseBroken {
        String query(String sql) {
            return "MySQL result for: " + sql;
        }
    }

    static class ReportGeneratorBroken {
        private MySQLDatabaseBroken database = new MySQLDatabaseBroken(); // tight coupling!
        String generateReport() {
            return database.query("SELECT * FROM reports");
        }
    }

    interface Database {
        String query(String sql);
    }

    class MySQLDatabase implements Database {
        @Override
        public String query(String sql) {
            return "MySQLDatabase result: " + sql;
        }
    }

    class PostgreSQLDatabase implements Database {
        @Override
        public String query(String sql) {
            return "PostgresSQLDatabase result: " + sql;
        }
    }


    // TODO: 5 - Fix the DIP violation:
    //   - Create a Database interface with: String query(String sql)
    //   - Create MySQLDatabase implementing Database
    //   - Create PostgreSQLDatabase implementing Database
    //     (its query() returns "PostgreSQL result for: " + sql)
    //   - Create ReportGenerator that takes Database in its constructor
    //     (constructor injection) and uses it in generateReport()


    // =========================================================================
    // Main method to test all exercises
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=== SOLID Exercises ===\n");

        // TODO: 6 - Test SRP: Create UserValidator, UserRepository, UserNotifier,
        //   and a refactored UserManager. Call createUser("Alice", "alice@test.com").


        // TODO: 7 - Test OCP: Create a DiscountCalculator and several Discount
        //   implementations. Calculate discounts for a $100 item and print results.


        // TODO: 8 - Test DIP: Create a ReportGenerator with MySQLDatabase,
        //   generate a report. Then create another with PostgreSQLDatabase
        //   and generate a report. Print both results to show the
        //   implementation was swapped without changing ReportGenerator.

    }
}
