package com.amediaa.functional_programming;

import com.amediaa.common.Demo;

import java.util.List;

public class Exercises implements Demo {

    @Override
    public void execute() {
        section1();
        System.out.println("*******************************");
        section2();
        System.out.println("*******************************");
        section3();
        System.out.println("*******************************");
        section4();
        System.out.println("*******************************");
        section5();
        System.out.println("*******************************");
        section6();
    }

    void section1() {
        // Print only odd numbers from the List
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(s -> s  % 2 == 1)
                .forEach(System.out::println);
    }

    void section2() {
        // Print all courses
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.forEach(System.out::println);
    }

    void section3() {
        // Print courses that contain "Spring"
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .filter(s -> s.contains("Spring"))
                .forEach(System.out::println);
    }

    void section4() {
        // Print courses that have at least four letters
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .filter(s -> s.length() >= 4)
                .forEach(System.out::println);
    }

    void section5() {
        // Print the cube of odd numbers
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(s -> s  % 2 == 1)
                .map(s -> s * s * s)
                .forEach(System.out::println);
    }

    void section6() {
        // Print the number of characters in each course name that have at least five characters
        List<String> courses = List.of(
                "Spring", "Spring Boot", "API",
                "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes");

        for (String course : courses) {
            if(course.length() >= 5) {
                System.out.printf("%s: %d\n", course, course.length());
            }
        }

        System.out.println("*******************************");

        courses.stream()
                .filter(s -> s.length() >= 5)
                .map(s -> String.format("%s: %d", s, s.length()))
                .forEach(System.out::println);
    }
}
