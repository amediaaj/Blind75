package com.amediaa.demos.collections;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.*;

public class CollectionFactoryMethods implements Demo {
    @Override
    public void execute() {
        // Immutable collections (factory methods)
        List<String> stringList = List.of("one", "two", "three");
        Set<String> stringSet = Set.of("one", "two", "three");

        // Immutable copies
        Collection<String> strings = Arrays.asList("one", "two", "three");
        List<String> list = List.copyOf(strings);
        Set<String> set = Set.copyOf(strings);

        // Rotations
        List<String> strings_list = Arrays.asList("0", "1", "2", "3", "4");
        IO.println(strings);
        int fromIndex = 1, toIndex = 4;
        Collections.rotate(strings_list.subList(fromIndex, toIndex), -1);
        IO.println(strings);

        // Wrapping a Collection in an unmodifiable Collection
        // Does not copy, but places a reference inside a wrapper
        strings_list = Arrays.asList("0", "1", "2", "3", "4");
        List<String> immutableStrings = Collections.unmodifiableList(strings_list);

        // Changes to original modifiable collection reflected in unmodifiable collection
        strings_list = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4"));
        List<String> immutableStrings_list = Collections.unmodifiableList(strings_list);
        IO.println(immutableStrings_list);
        strings_list.add("5");
        IO.println(immutableStrings_list);
    }
}
