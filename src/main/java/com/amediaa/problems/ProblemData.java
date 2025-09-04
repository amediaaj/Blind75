package com.amediaa.problems;

// TODO: Currently not using this class.
public abstract class ProblemData<T, S> {
    private final T input;
    private final S expected;

    public ProblemData(T input, S expected) {
        this.input = input;
        this.expected = expected;
    }

    public T getInput() {
        return input;
    }

    public S getExpected() {
        return expected;
    }
}
