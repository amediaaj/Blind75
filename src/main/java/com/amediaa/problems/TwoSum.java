package com.amediaa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum extends Problem<TwoSumInput, int[]> {
    public TwoSum() {
        super("1. Two Sum", List.of(new TwoSumInput(
                new int[] {1, 2},
                3
        )), List.of(new int[] {1, 0}));
    }

    @Override
    int[] solution(TwoSumInput input) {
        return twoSum(input.getNums(), input.getTarget());
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                return new int[] { i , map.get(diff)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}

class TwoSumInput {
    private int[] nums;
    private int target;

    public TwoSumInput(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] getNums() {
        return nums;
    }

    public int getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return String.format("{ nums: %s, target: %d }", Arrays.toString(nums), target);
    }
}

