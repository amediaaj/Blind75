package com.amediaa.demos;

import com.amediaa.Demo;

import java.util.*;

class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.getName()).compareTo(o2.gpa + o2.getName());
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int id;
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    protected double gpa;

    Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.00, 4.00);
    }

    @Override
    public int compareTo(Student o) {
//        return this.name.compareTo(o.name);

        // Box the primitive int for access to compareTo
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

    @Override
    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                ", GPA=" + GPA +
//                '}';

        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    //    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }


    String getName() {
        return name;
    }
}

public class Comparables implements Demo {

    @Override
    public void execute() {
        Student jack = new Student("Jack");
        String jill = "Jill";

        // Does not compile due to generic type safety
        // i.e. Student implements Comparable<Student>
        // jack.compareTo(jill);

        Student[] students = new Student[]{
                new Student("Cassidy"),
                new Student("Bill"),
                new Student("Cletus"),
                new Student("Alex")
        };

        Collections.shuffle(Arrays.asList(students));
        System.out.println(Arrays.deepToString(students));
        Arrays.sort(students);
        System.out.println(Arrays.deepToString(students));
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.deepToString(students));
    }
}
