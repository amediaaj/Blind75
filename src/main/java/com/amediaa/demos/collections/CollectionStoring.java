package com.amediaa.demos.collections;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.*;
import java.util.function.Predicate;

record User(String name){};

public class CollectionStoring implements Demo {

    @Override
    public void execute() {

        // add and remove
        IO.println("add & remove: ");
        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        IO.println("strings = " + strings);
        strings.remove("one");
        IO.println("strings = " + strings);

        IO.println("");

        // contains
        IO.println("contains:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");

        if (strings.contains("one")) {
            IO.println("one is here");
        }

        if (!strings.contains("three")) {
            IO.println("three is not here");
        }

        User rebecca = new User("Rebecca");

        // Checking if Collection of String contains element of type User
        if (!strings.contains(rebecca)) {
            IO.println("Rebecca is not here");
        }

        IO.println("");

        // Methods that handle other collections
        // containsAll(), addAll(), removeAll(), retainAll()

        // containsAll defines the inclusion
        IO.println("contains all:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> first = new ArrayList<>();
        first.add("one");
        first.add("two");

        Collection<String> second = new ArrayList();
        second.add("one");
        second.add("four");

        IO.println("Is first contained in strings? " + strings.containsAll(first));
        IO.println("Is second contained in strings? " + strings.containsAll(second));

        // addALL defines the union
        IO.println("\naddAll:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        first = new ArrayList<>();
        first.add("one");
        first.add("four");

        boolean hasChanged = strings.addAll(first);

        IO.println("Has strings changed? " + hasChanged);
        IO.println("strings = " + strings);

        // removeAll defines the compliment
        IO.println("\nremoveAll:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> toBeRemoved = new ArrayList<>();
        toBeRemoved.add("one");
        toBeRemoved.add("four");

        hasChanged = strings.removeAll(toBeRemoved);

        IO.println("Has strings changed? " + hasChanged);
        IO.println("strings = " + strings);

        // retainAll defines the intersection
        IO.println("\nretainAll:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> toBeRetained = new ArrayList<>();
        toBeRetained.add("one");
        toBeRetained.add("four");

        hasChanged = strings.retainAll(toBeRetained);

        IO.println("Has strings changed? " + hasChanged);
        IO.println("strings = " + strings);

        // isEmpty
        IO.println("\nisEmpty:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        if (!strings.isEmpty()) {
            IO.println("Indeed strings is not empty!");
        }
        IO.println("The number of elements in strings is " + strings.size());

        // size, clear
        IO.println("\nsize, clear:");
        strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        IO.println("The number of elements in strings is " + strings.size());
        strings.clear();
        IO.println("After clearing it, this number is now " + strings.size());


        // toArray
        IO.println("\ntoArray: ");
        strings = List.of(
                "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15"); // suppose you have 15 elements in that collection

        String[] tabString1 = strings.toArray(new String[] {}); // you can pass an empty array
        String[] tabString2 = strings.toArray(new String[15]);   // or an array of the right size

        // Another toArray example
        IO.println("\ntoArray: ");
        strings = List.of("one", "two");

        String[] largerTab = {"three", "three", "three", "I", "was", "there"};
        IO.println("largerTab = " + Arrays.toString(largerTab));

        String[] result = strings.toArray(largerTab);
        IO.println("result = " + Arrays.toString(result)); // [one, two, null, I, was, there]

        IO.println("Same arrays? " + (result == largerTab));

        // Predicate
        IO.println("\nPredicate example:");
        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        strings = new ArrayList<>();
        strings.add(null);
        strings.add("");
        strings.add("one");
        strings.add("two");
        strings.add("");
        strings.add("three");
        strings.add(null);

        IO.println("strings = " + strings);
        strings.removeIf(isNullOrEmpty);
        IO.println("filtered strings = " + strings);
    }
}
