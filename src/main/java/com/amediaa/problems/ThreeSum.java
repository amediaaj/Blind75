package com.amediaa.problems;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum extends Problem<int[], List<List<Integer>>>{
    public ThreeSum() {
        super("15. 3Sum", List.of(new int[] {-1,0,1,2,-1,-4}), List.of(List.of(List.of(-1,-1,2), List.of(-1,0,1))));
    }

    // Two pointer solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    results.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return results;
    }

    // HashSet solution
    public List<List<Integer>> threeSumHash(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();

        for(int i=0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i] ) {
                continue;
            }

            int target = -nums[i];

            Set<Integer> diff_set = new HashSet<Integer>();

            for(int j=i+1; j < nums.length; j++) {

                int diff = target - nums[j];

                if(diff_set.contains(diff)) {
                    results.add(Arrays.asList(nums[i], nums[j], diff));
                } else {
                    diff_set.add(nums[j]);
                }
            }
        }

        return new ArrayList(results);
    }

    @Override
    List<List<Integer>> solution(int[] input) {
        return threeSum(input);
    }

    @Override
    protected boolean isEqual(List<List<Integer>> output, List<List<Integer>> expected) {
        if (output == null || expected == null) return output == expected;
        if (output.size() != expected.size()) return false;

        Set<List<Integer>> outputSet = new HashSet<>();
        for (List<Integer> triplet : output) {
            if (triplet == null || triplet.size() != 3) return false;
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            outputSet.add(sorted);
        }

        Set<List<Integer>> expectedSet = new HashSet<>();
        for (List<Integer> triplet : expected) {
            if (triplet == null || triplet.size() != 3) return false;
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            expectedSet.add(sorted);
        }

        return outputSet.equals(expectedSet);
    }
}
