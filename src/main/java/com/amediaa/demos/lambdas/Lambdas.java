package com.amediaa.demos.lambdas;

import com.amediaa.common.Demo;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

@FunctionalInterface
interface Operation<T> {
    T operate(T value1, T value2);
}

public class Lambdas implements Demo {

    @Override
    public void execute() {
        var result1 = calculate1((s1, s2) -> s1 + s2, 3, 4);
        System.out.println(result1);

       var result2 =  calculate1((s1, s2) -> s1 + s2, "Hello ", "World");
        System.out.println(result2);

        // Assignment of lambda expression
        BiConsumer<Double, Double> p1 = (lat, lng) -> {
            System.out.printf("[lat:%.3f long:%.3f]%n", lat, lng);
        };
    }

    public <T> T calculate1(BinaryOperator<T> function, T value1, T value2) {
        return function.apply(value1, value2);
    }

    // Uses custom interface that mirrors BinaryOperator
    public <T> T calculate2(Operation<T> function, T value1, T value2) {
        return function.operate(value1, value2);
    }

    public <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}
