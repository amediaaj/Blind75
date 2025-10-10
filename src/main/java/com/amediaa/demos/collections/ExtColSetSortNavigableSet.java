package com.amediaa.demos.collections;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtColSetSortNavigableSet implements Demo {

    @Override
    public void execute() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six");
        Set<String> set = new HashSet<>();
        set.addAll(strings);
        set.forEach(IO::println);
    }
}
