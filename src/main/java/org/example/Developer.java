package org.example;

public class Developer {
    public static void main(String[] args) {
        Employee dev = new Employee(100, "Thanhtra", 1000);

        dev.setId(101);
        dev.setName("Thanhbinh");

        System.out.println("Developer ID: " + dev.getId());
        System.out.println("Developer Name: " + dev.getName());
        System.out.println("Developer Salary: " + dev.getSalary());
    }
}
