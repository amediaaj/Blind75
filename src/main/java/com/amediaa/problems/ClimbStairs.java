package com.amediaa.problems;

import java.util.List;

public class ClimbStairs extends Problem<Integer, Integer> {


    public ClimbStairs() {
        super("70. Climbing Stairs", List.of(2), List.of(2));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;  // Base case: Only one way to climb 1 stair
        }

        int one = 1;   // Ways to climb to step 1
        int two = 2;   // Ways to climb to step 2

        // Every step's ways is summation of ways of previous two steps
        for (int i = 3; i <= n; i++) {
            int total = one + two;
            one = two;              // Shift window forward
            two = total;
        }

        return two;
    }

    @Override
    Integer solution(Integer input) {
        return climbStairs(input);
    }
}
