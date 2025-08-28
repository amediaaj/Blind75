package com.amediaa.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum extends Problem<int[], int[]> {

    public TwoSum() {
        super(new int[] {1, 2}, new int[] {0, 1});
    }

    @Override
    int[] solution(int[] input) {
        // TODO: fix hardcoing of target argument
        return twoSum(input, 3);
    }

    // LeetCode 1
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Loop over all elements
        for(int i = 0; i < nums.length; i++) {

            // Calculate target - element
            int diff = target - nums[i];

            // If map contains difference
            if(map.containsKey(diff)) {
                // Then the matching number was already encountered
                // So return current index, and matching number index
                return new int[] { i , map.get(diff)};
            } else {
                // Otherwise place the current element and index in the map
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}

