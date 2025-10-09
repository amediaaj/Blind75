package com.amediaa.demos.streams;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOps implements Demo {

    @Override
    public void execute() {
        // map strings to ints, toList
        List<String> strings = List.of("one", "two", "three", "four");
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();
        IO.println("lengths = " + lengths);

        IO.printBorder();

        IntSummaryStatistics stats = strings.stream()
                .mapToInt(String::length)
                .summaryStatistics();
        IO.println("stats = " + stats);

        IO.printBorder();

        // filtering
        long count = strings.stream()
                .map(String::length)
                .filter(length -> length == 3)
                .count();
        IO.println("count = " + count);

        IO.printBorder();

        // summing population, imperative approach
        record City(String name, int population) {}
        record Country(String name, List<City> cities) {}
        City newYork= new City("New York", 8_258);
        City losAngeles = new City("Los Angeles", 3_821);
        Country usa = new Country("USA", List.of(newYork, losAngeles));
        City london = new City("London", 8_866);
        City manchester = new City("Manchester", 568);
        Country uk = new Country("United Kindgom", List.of(london, manchester));
        City paris = new City("Paris", 2_103);
        City marseille = new City("Marseille", 877);
        Country france = new Country("France", List.of(paris, marseille));
        List<Country> countries = List.of(usa, uk, france);
        int totalPopulation = 0;
        // nested loop for suming population
        for (Country country: countries) {
            for (City city: country.cities()) {
                totalPopulation += city.population();
            }
        }
        IO.println("Total population = " + totalPopulation);

        IO.printBorder();

        // Stream all countries, flatten their city lists into a single stream,
        // map each city to its population (int), and sum all populations.
        totalPopulation =
                countries.stream()
                        .flatMap(country -> country.cities().stream())
                        .mapToInt(City::population)
                        .sum();
        IO.println("Total population = " + totalPopulation);

        IO.printBorder();

        // Parsing ints
        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };
        strings = List.of("1", " ", "2", "3 ", "", "3");
        List<Integer> ints =
                strings.stream()
                        .flatMap(flatParser)
                        .collect(Collectors.toList()); // Modifiable List
        IO.println("ints = " + ints);

        IO.printBorder();

        // Stream all strings, emit each successfully parsed integer into the output stream,
        // and collect the resulting stream of ints into a List.
        strings = List.of("1", " ", "2", "3 ", "", "3");
        ints =
                strings.stream()
                        .<Integer>mapMulti(
                                (string, consumer) -> {
                                    try {
                                        consumer.accept(Integer.parseInt(string));
                                    } catch (NumberFormatException ignored) {
                                    }
                                })
                        .toList(); // Unmodifiable List
        IO.println("ints = " + ints);

        IO.printBorder();

        // Create a stream from the list of integers, remove duplicates using distinct(),
        // and collect the result into an unmodifiable list
        ints = List.of(1, 4, 2, 1, 3, 3);
        List<Integer>  distincts =
                ints.stream()
                        .distinct()
                        .toList();
        IO.println("distinct ints: " + distincts);

        IO.printBorder();

        strings = List.of("one", "two", "three", "four");

        // Natural sort
        List<String> naturalSort =
                strings.stream()
                        .sorted()
                        .toList();
        IO.println("natural sort: " + naturalSort);

        // Comparator.comparingInt allows sorting elements by an int key
        // by passing a function that takes a String and returns an int (here, the length)
        List<String> shortestFirst =
                strings.stream()
                        .sorted(Comparator.comparingInt(String::length))
                        .toList();
        IO.println("shortest first: " + shortestFirst);

        IO.printBorder();

        // Create an infinite IntStream starting at 0, incrementing by 1
        // Map each integer to i / 3 (integer division), which groups every 3 consecutive numbers to the same value
        // Use distinct() to keep only unique results
        // Limit the stream to the first 5 distinct values
        // Collect the result into an int[] array
        var ints_arr = IntStream.iterate(0, i -> i + 1)
                .map(i -> i / 3)
                .distinct()
                .limit(5)
                .toArray();

        IO.println("ints = " + Arrays.toString(ints_arr));

        IO.printBorder();

        // OutOfMemoryError
        // Attempting to sort an infinite stream

        IO.println("Attempted sort of infinite stream");
        IO.println("OutOfMemoryError");
        IO.println("Initial Heap: " + Runtime.getRuntime().totalMemory()/1024/1024 + " MB");
        IO.println("Max Heap: " + Runtime.getRuntime().maxMemory()/1024/1024 + " MB");

//        ints_arr = IntStream.iterate(0, i -> i + 1)
//                .map(i -> i /3)
//                .sorted()
//                .limit(5)
//                .toArray();
//        IO.println("ints = " + Arrays.toString(ints_arr));

        IO.printBorder();

        // Skipping elements
        // Also see dropWhile, takeWhile (short circuit vs. filter )
        ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result =
                ints.stream()
                        .skip(2)
                        .limit(5)
                        .toList();
        IO.println("result = " + result);

        IO.printBorder();

        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);

// 1st pattern: concat
        List<Integer> concat =
                Stream.concat(list0.stream(), list1.stream())
                        .toList();

// 2nd pattern: flatMap
        // Flatten multiple streams into a single list
        // Stream.of(...) creates a Stream<Stream<Integer>> (a stream of streams)
        // flatMap(Function.identity()) “unzips” each inner stream and merges all elements into one Stream<Integer>
        // concat produces a SIZED stream, whereas flatmap does not.
        List<Integer> flatMap =
                Stream.of(list0.stream(), list1.stream(), list2.stream())
                        .flatMap(Function.identity()) // Think: unzip, then merge
                        .toList();

        IO.println("concat  = " + concat);
        IO.println("flatMap = " + flatMap);

        IO.printBorder();

        strings = List.of("one", "two", "three", "four");
        List<String> result_list =
                strings.stream()
                        .peek(s -> IO.println("Starting with = " + s))
                        .filter(s -> s.startsWith("t"))
                        .peek(s -> IO.println("Filtered = " + s))
                        .map(String::toUpperCase)
                        .peek(s -> IO.println("Mapped = " + s))
                        .toList();
        IO.println("result = " + result_list);

    }
}
