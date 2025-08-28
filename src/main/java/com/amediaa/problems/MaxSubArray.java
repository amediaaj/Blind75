package com.amediaa.problems;

public class MaxSubArray extends Problem<int[], Integer>{
    public int maxSubArray(int[] nums) {
        int current = 0;
        int max_subarray = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if(current < 0) {
                current = 0;
            }

            current = current + nums[i];
            max_subarray = Math.max(max_subarray, current);
        }

        return max_subarray;
    }

    public MaxSubArray() {
        super(new int[] {-2,1,-3,4,-1,2,1,-5,4}, 6);
    }

    @Override
    Integer solution(int[] input) {
        return maxSubArray(input);
    }
}
