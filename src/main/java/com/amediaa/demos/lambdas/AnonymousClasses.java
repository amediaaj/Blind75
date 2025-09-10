package com.amediaa.demos.lambdas;

import com.amediaa.common.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// For demonstrating the framework for lambda expressions
public class AnonymousClasses implements Demo {

    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    @Override
    public void execute() {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new AnonymousClasses.Person("Alex", "Amedia"), // Demonstrate that the record is a static nested class
                new Person("Bob", "Barker"),
                new Person("Cassidy", "Hare"),
                new Person("Bill", "Barker"),
                new Person("Lil", "Clee")
        ));

        // Declaring variable of type Comparator<Person>
        var comparatorLastName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        // Passing object of type Comparator<Person> to sort
        people.sort(comparatorLastName);
        System.out.println(people);

        // Passing anonymous class expression directly to sort
        people.sort(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
        System.out.println(people);

        // Passing lambda expression directly to sort
        // "A functional interface is the target type for a lambda expression"
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);

        // Cannot be annotated FunctionalInterface,
        //  because the interface contains multiple non-overriding abstract methods,
        //  due to inheritance
//        @FunctionalInterface
        interface enhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new enhancedComparator<Person>() {
            // "Interfaces inherit abstract methods"
            // Therefore we have two overrides here

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return result == 0 ? secondLevel(o1, o2) : result;
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}
