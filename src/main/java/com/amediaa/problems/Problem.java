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

    protected String stringify(Object obj) {
        if (obj == null) return "null";

        return switch (obj) {
            case int[] s     -> Arrays.toString(s);
            case long[] s    -> Arrays.toString(s);
            case double[] s  -> Arrays.toString(s);
            case boolean[] s -> Arrays.toString(s);
            case char[] s    -> Arrays.toString(s);
            case float[] s   -> Arrays.toString(s);
            case short[] s   -> Arrays.toString(s);
            case byte[] s    -> Arrays.toString(s);
            case Object[] s  -> Arrays.deepToString(s);
            default          -> obj.toString();
        };
    }

    protected boolean isEqual(S output, S expected) {
        if (output == null || expected == null) {
            return output == expected;
        }

        Class<?> outClass = output.getClass();
        Class<?> expClass = expected.getClass();

        if (outClass.isArray() && expClass.isArray()) {
            return switch (output) {
                case Object[] s when expected instanceof Object[] e -> Arrays.deepEquals(s, (Object[]) expected);
                case int[] s    when expected instanceof int[]    e -> Arrays.equals(s, (int[]) expected);
                case long[] s   when expected instanceof long[]   e -> Arrays.equals(s, (long[]) expected);
                case double[] s when expected instanceof double[] e -> Arrays.equals(s, (double[]) expected);
                case boolean[] s when expected instanceof boolean[] e -> Arrays.equals(s, (boolean[]) expected);
                case char[] s   when expected instanceof char[]   e -> Arrays.equals(s, (char[]) expected);
                case byte[] s   when expected instanceof byte[]   e -> Arrays.equals(s, (byte[]) expected);
                case float[] s  when expected instanceof float[]  e -> Arrays.equals(s, (float[]) expected);
                case short[] s  when expected instanceof short[]  e -> Arrays.equals(s, (short[]) expected);
                default -> false;
            };
        }

        return output.equals(expected);
    }

}
