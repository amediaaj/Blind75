package com.amediaa.problems;

import com.amediaa.Demo;
import java.util.List;

public abstract class Problem<T> implements Demo {
    protected T[] testData;

    public Problem(T[] testData) {
        this.testData = testData;
    }
}