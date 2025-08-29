package com.amediaa.problems;

import com.amediaa.Demo;

public abstract class Problem<T, S> implements Demo {
    // TODO: Support multiple sets of input and expected

    private final T input;
    private final S expected;

    public Problem(T input, S expected) {
        this.input = input;
        this.expected = expected;
    }

    abstract S solution(T input);

    @Override
    public void execute() {
        S output = solution(input);
        // TODO: Fix printing of input, output, and expected
        System.out.printf("Input: %s Output: %s Expected: %s%n", input, output, expected);
    }
}