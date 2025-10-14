package com.amediaa.demos.streams;

import com.amediaa.common.Demo;
import com.amediaa.common.IO;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingStreams implements Demo {
    @Override
    public void execute() {
        DemoSpliterator();
        IO.printBorder();
        DemoEmptyString();
        IO.printBorder();
        DemoFactoryMethods();
        IO.printBorder();
        DemoSupplier();
        IO.printBorder();
        DemoRange();
        IO.printBorder();
        DemoRandom();

    }

    void DemoRandom() {
        Random random = new Random(314L);

        List<Integer> randomInts =
                random.ints(10, 1, 5)
                        .boxed()
                        .toList();
        IO.println("randomInts = " + randomInts);

        random = new Random(314L);

        List<Boolean> booleans =
                random.doubles(1_000, 0d, 1d)
                        .mapToObj(rand -> rand <= 0.8) // you can tune the probability here
                        .toList();

// Let us count the number of true in this list
        long numberOfTrue =
                booleans.stream()
                        .filter(b -> b)
                        .count();
        IO.println("Number of true = " + numberOfTrue);

        random = new Random(314L);

        List<String> letters =
                random.doubles(1_000, 0d, 1d)
                        .mapToObj(rand ->
                                rand < 0.5 ? "A" : // 50% of A
                                        rand < 0.8 ? "B" : // 30% of B
                                                rand < 0.9 ? "C" : // 10% of C
                                                        "D")  // 10% of D
                        .toList();

        Map<String, Long> map =
                letters.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((letter, number) -> IO.println(letter + " :: " + number));
    }

    void DemoRange() {
        String[] letters = {"A", "B", "C", "D"};

        List<String> listLetters =
                IntStream.range(0, 10)
                        .mapToObj(index -> letters[index % letters.length])
                        .collect(Collectors.toList());
        IO.println("listLetters = " + listLetters);
    }

    void DemoSupplier() {
        Stream<String> generated = Stream.generate(() -> "+");
        List<String> strings = generated.limit(5L).toList();
        IO.println("strings = " + strings);

        Stream<String> iterated = Stream.iterate("+", s -> s + "+");
        iterated.limit(5L).forEach(IO::println);

        // Same output as above, except passes a Predicate
        iterated = Stream.iterate("+", s -> s.length() <= 5, s -> s + "+");
        iterated.forEach(IO::println);
    }

    void DemoFactoryMethods() {
        Stream<Integer> intStream = Stream.of(1, 2, 3);
        List<Integer> ints = intStream.toList();
        IO.println("ints = " + ints);

        String[] stringArray = {"one", "two", "three"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        List<String> strings = stringStream.collect(Collectors.toList());
        IO.println("strings = " + strings);
    }

    void DemoEmptyString() {
        Stream<String> empty = Stream.empty();
        List<String> strings = empty.toList();
        IO.println("strings = " + strings);
    }

    // Useful for legacy APIs that return Iterator but you want to leverage Streams.
    void DemoSpliterator() {
        Iterator<Integer> iterator = new Iterator<>() {
            private int index = 0;
            public boolean hasNext() {
                return index < 10;
            }
            public Integer next() {
                return index++;
            }
        };

        long estimateSize = 10L;
        int characteristics = 0;
        Spliterator<Integer> spliterator = Spliterators.spliterator(iterator, estimateSize, characteristics);

        boolean parallel = false;
        Stream<Integer> stream = StreamSupport.stream(spliterator, parallel);

        List<Integer> ints = stream.toList();
        IO.println("ints = " + ints);
    }
}
