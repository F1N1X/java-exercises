package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

// TODO: 1 - Make the Employee class abstract. Add two protected fields:
//   - name (String)
//   - baseSalary (double)
//   Create a constructor that takes both fields and assigns them.
public abstract class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        if (name == null || baseSalary < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.baseSalary = baseSalary;
    }
    // TODO: 2 - Declare an abstract method: double calculatePay()
    //   Each subclass will compute pay differently.
    abstract double calculatePay();

    // TODO: 3 - Create a concrete method: String getDetails()
    //   Return: "<name> - Pay: $<calculatePay()>"
    //   Use String.format("%.2f", calculatePay()) for formatting.
    public String getDetails() {
        return name + " - Pay: " + String.format("%.2f", calculatePay());
    }
}
// TODO: 6 - In the EmployeeDemo class below, complete the main method:
//   - Create a List<Employee> with at least one FullTimeEmployee
//     and one ContractEmployee
//   - Iterate over the list and print getDetails() for each employee



class EmployeeDemo {
    public static void main(String[] args) {
        // Complete TODOs 6 and 7 here
        List<Employee> employes = List.of(
                new FullTimeEmployee("Petro", 60_000),
                new ContractEmployee("Martha", 40.00, 100));

        for (var employee : employes)
            System.out.println(employee.getDetails());

        System.out.println(getHighestPay(employes).name);
    }

    public static Employee getHighestPay(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparing(Employee::calculatePay))
                .orElseThrow();
    }
}



// TODO: 7 - Add a method in EmployeeDemo: static Employee getHighestPaid(List<Employee> employees)
//   that returns the employee with the highest calculatePay() value.
//   Call it from main and print the result.