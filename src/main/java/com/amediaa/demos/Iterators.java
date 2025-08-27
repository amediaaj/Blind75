package com.amediaa.demos;

import com.amediaa.Demo;

import java.util.*;

public class Iterators implements Demo {


    private static int nextId = 0;

    @Override
    public void execute() {
        iterator();
    }

    private void iterator() {
        String[] names = {"Cassidy", "Bill", "Cletus", "Alex"};
        String[] roles = {"Manager", "Pet", "Cook"};
        List<Employee> employees = new ArrayList<>();

        for(var name : names) {
            employees.add(new Employee(nextId++, name, roles[new Random().nextInt(roles.length)]));
        }

        for(var employee : employees) {
            System.out.format("Id: %s Name: %s Role: %s %n", employee.id, employee.name, employee.role);
        }

        System.out.println();

        // Demonstration of removing elements with Iterator
        for(java.util.Iterator<Employee> it = employees.iterator(); it.hasNext();) {
            if(it.next().name.equals("Alex")) {
                it.remove();
            }
        }

        for(var employee : employees) {
            System.out.format("Id: %s Name: %s Role: %s %n", employee.id, employee.name, employee.role);
        }
    }

    class Employee {
        int id;
        String name;
        String role;

        public Employee(int id, String name, String role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }
    }
}
