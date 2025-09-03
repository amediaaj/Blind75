package com.amediaa.problems;

import com.amediaa.Demo;
import java.util.*;

// Abstract base class for problems
public abstract class Problem<T, S> implements Demo {

    private final String name;
    private final List<T> inputs;
    private final List<S> expectedOutputs;

    public Problem(String name, List<T> inputs, List<S> expectedOutputs) {
        this.name = name;
        if (inputs.size() != expectedOutputs.size()) {
            throw new IllegalArgumentException("Inputs and expected outputs must have the same size.");
        }
        this.inputs = inputs;
        this.expectedOutputs = expectedOutputs;
    }

    // Each subclass must implement this
    abstract S solution(T input);

    @Override
    public void execute() {
        System.out.println(name);
        for (int i = 0; i < inputs.size(); i++) {
            T input = inputs.get(i);
            S expected = expectedOutputs.get(i);
            S output = solution(input);

            System.out.printf("Test Case %d:%n", i + 1);
            System.out.printf("  Input   : %s%n", stringify(input));
            System.out.printf("  Output  : %s%n", stringify(output));
            System.out.printf("  Expected: %s%n", stringify(expected));
            System.out.println(isEqual(output, expected) ? "  ✅ Passed" : "  ❌ Failed");
            System.out.println();
        }
    }

    // Smart stringification for different data types
    protected String stringify(Object obj) {
        if (obj == null) return "null";

        if (obj instanceof int[]) return Arrays.toString((int[]) obj);
        if (obj instanceof long[]) return Arrays.toString((long[]) obj);
        if (obj instanceof double[]) return Arrays.toString((double[]) obj);
        if (obj instanceof boolean[]) return Arrays.toString((boolean[]) obj);
        if (obj instanceof char[]) return Arrays.toString((char[]) obj);
        if (obj instanceof float[]) return Arrays.toString((float[]) obj);
        if (obj instanceof short[]) return Arrays.toString((short[]) obj);
        if (obj instanceof byte[]) return Arrays.toString((byte[]) obj);
        if (obj instanceof Object[]) return Arrays.deepToString((Object[]) obj);

        return obj.toString();
    }

    protected boolean isEqual(S output, S expected) {
        if (output == null || expected == null) {
            return output == expected;
        }

        if (output.getClass().isArray() && expected.getClass().isArray()) {
            if (output instanceof Object[] && expected instanceof Object[]) {
                return Arrays.deepEquals((Object[]) output, (Object[]) expected);
            } else if (output instanceof int[] && expected instanceof int[]) {
                return Arrays.equals((int[]) output, (int[]) expected);
            } else if (output instanceof long[] && expected instanceof long[]) {
                return Arrays.equals((long[]) output, (long[]) expected);
            } else if (output instanceof double[] && expected instanceof double[]) {
                return Arrays.equals((double[]) output, (double[]) expected);
            } else if (output instanceof boolean[] && expected instanceof boolean[]) {
                return Arrays.equals((boolean[]) output, (boolean[]) expected);
            } else if (output instanceof char[] && expected instanceof char[]) {
                return Arrays.equals((char[]) output, (char[]) expected);
            } else if (output instanceof byte[] && expected instanceof byte[]) {
                return Arrays.equals((byte[]) output, (byte[]) expected);
            } else if (output instanceof float[] && expected instanceof float[]) {
                return Arrays.equals((float[]) output, (float[]) expected);
            }
        }

        return output.equals(expected);
    }
}
