package com.amediaa.demos;

import com.amediaa.common.Demo;

public class FunctionalInterfaces implements Demo {
    @Override
    public void execute() {
        int value1 = 5;
        int value2 = 7;
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);

        System.out.printf("CALLING calculator((s1, s2) -> s1 + s2, value1, value2)%n");
        System.out.println("calculator RETURNED:  " + calculator((s1, s2) -> s1 + s2, value1, value2));
    }

    public <T> T calculator(Operation<T> function, T value1, T value2) {
        return function.operate(value1, value2);
    }

    @FunctionalInterface
    public interface Operation<T> {
        T operate(T t1, T t2);
    }
}
