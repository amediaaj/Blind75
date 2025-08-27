package com.amediaa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum extends Problem<TwoSumData> {

    public TwoSum() {
        super(new TwoSumData[] {
                new TwoSumData(new int[] {1, 2, 3, 5}, 7)
        });
    }

    @Override
    public void execute() {
        solve();
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

    private void solve() {
        System.out.println(Arrays.toString(
                twoSum(testData[0].getSequence(), testData[0].getTarget())));
    }
}

class TwoSumData{
    private int[] sequence;
    private int target;

    TwoSumData(int[] sequence, int target) {
        this.sequence = sequence;
        this.target = target;
    }

    int getTarget() {
        return target;
    }

    int[] getSequence() {
        return sequence;
    }
}
