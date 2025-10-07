package com.amediaa.demos.collections;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;
import com.amediaa.demos.Iterators;

import java.util.*;

public class IteratingElements implements Demo {

    @Override
    public void execute() {

        // iterator from type Collection
        Collection<String> strings = List.of("one", "two", "three");
        for (String element : strings) {
            IO.println(element);
        }

        IO.println("");

        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
            String element = iterator.next();
            if(element.length() == 3) {
                IO.println(element);
            }
        }

        IO.println("");

        try {
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                strings.remove(element); // Should use iterator.remove
//              iterator.remove();
            }
        } catch (UnsupportedOperationException e) {
            IO.println("Removing element causes exception");
        } finally {
            IO.println(strings);
        }

        IO.println("--------------------------------");

        // iterator from type myColection
        MyCollection myCollection = new MyCollection();
        myCollection.arr[0] = "Element 1";
        myCollection.arr[1] = "Element 2";
        myCollection.arr[2] = "Element 3";

        Iterator<String> iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            IO.println(next);
        }

        IO.println("--------------------------------");

        myCollection.forEach(s -> IO.println(s));

        // standalone iterator
        String[] elements = {"ELement 1", "Element 2", "Element 3"};
        CustomIterator iterator_custom = new CustomIterator(elements);

        while (iterator_custom.hasNext()) {
            IO.println(iterator_custom.next());
        }

        IO.println("--------------------------------");

        // Range iterator example
        for (int i : new Range(0, 5)) {
            IO.println("i = " + i);
        }
    }


    class Range implements Iterable<Integer> {

        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int index = start;

                @Override
                public boolean hasNext() {
                    return index < end;
                }

                @Override
                public Integer next() {
                    if (index > end) {
                        throw new NoSuchElementException("" + index);
                    }
                    int currentIndex = index;
                    index++;
                    return currentIndex;
                }
            };
        }
    }


    class CustomIterator implements Iterator<String> {
        private String[] elements;
        private int index = 0;

        public CustomIterator(String[] elements) {
            this.elements = elements;
        }

        @Override
        public boolean hasNext() {
            return index < elements.length && elements[index] != null;

        }

        @Override
        public String next() {
            return elements[index++];
        }
    }

    class MyCollection implements Iterable {

        private final String[] arr = new String[10];

        ArrayList<String> test; // ArrayList implements List which extends Collection which extends Iterable

        @Override
        public Iterator iterator() {
            return new Iterator() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < arr.length && arr[index] != null;
                }

                @Override
                public Object next() {
                    return arr[index++];
                }
            };
        }
    }
}
