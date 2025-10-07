package com.amediaa.demos.collections;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.*;

public class ExtendingCollectionWithList implements Demo {
    @Override
    public void execute() {
        // Create and populate a list
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");
        IO.println("Original list: " + fruits);

// Access elements by index
        IO.println("");
        IO.println("=== Accessing Elements ===");
        IO.println("First fruit: " + fruits.get(0));
        IO.println("Last fruit: " + fruits.get(fruits.size() - 1));

// Insert at specific position
        fruits.add(1, "blueberry");
        IO.println("After inserting blueberry at index 1: " + fruits);

// Replace element
        fruits.set(2, "blackberry");
        IO.println("After replacing index 2 with blackberry: " + fruits);

// Find indexes
        IO.println("");
        IO.println("=== Finding Elements ===");
        IO.println("Index of 'cherry': " + fruits.indexOf("cherry"));
        IO.println("Index of 'grape' (not found): " + fruits.indexOf("grape"));

// Work with sublists
        IO.println("");
        IO.println("=== Sublist Operations ===");
        List<String> middleFruits = fruits.subList(1, 4);
        IO.println("Sublist (indices 1-3): " + middleFruits);

// Remove elements
        fruits.remove(0);  // Remove by index
        fruits.remove("date");  // Remove by value
        IO.println("After removals: " + fruits);

// Try with different types
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        IO.println("");
        IO.println("=== Working with Numbers ===");
        IO.println("Numbers: " + numbers);
        IO.println("Second number: " + numbers.get(1));
        IO.println("Contains 30? " + numbers.contains(30));

        // ListIterator (extends Iterator)
        // hasPrevious, previous
        // nextIndex, previousIndex
        // set(element) to update the last element returned by next or previous
        IO.println("");
        IO.println("=== Working with ListIterator ===");
        List<String> numbers_strings = Arrays.asList("one", "two", "three");
        for (ListIterator<String> iterator = numbers_strings.listIterator(); iterator.hasNext();) {
            String nextElement = iterator.next();
            if (Objects.equals(nextElement, "two")) {
                iterator.set("2");
            }
        }
        IO.println("numbers = " + numbers);

    }
}
