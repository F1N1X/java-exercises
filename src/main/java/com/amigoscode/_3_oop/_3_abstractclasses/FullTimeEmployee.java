package com.amigoscode._3_oop._3_abstractclasses;

// TODO: 4 - Create a FullTimeEmployee class that extends Employee.
//   - Constructor takes name and baseSalary, calls super(name, baseSalary)
//   - Implement calculatePay() to simply return baseSalary

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculatePay() {
        return baseSalary;
    }
}
