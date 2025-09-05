package com.amediaa.problems;

import com.amediaa.common.Problem;

import java.util.List;

public class MaxProduct extends Problem<int[], Integer> {

    public MaxProduct() {
        super("152. Maximum Product in Subarray",List.of(new int[] {2,3,-2,4}), List.of(6));
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        // Initialize min, max, and result to first element
        int min = nums[0], max = nums[0], result = nums[0];

        // Start loop at second element
        for(int i = 1; i < nums.length; i++) {
            // Assign current element
            int cur = nums[i];

            // Store the max in a temporary variable
            // Consider current, current times min, and current times max
            int tempMax = Math.max(cur, Math.max(cur * max, cur * min));

            // Update min
            // Consider current, current times min, and current times max
            min = Math.min(cur, Math.min(cur * max, cur * min));

            // Update max
            max = tempMax;

            // Update result if max is higher
            result = Math.max(result, max);
        }

        // Return the product
        return result;
    }

    @Override
    Integer solution(int[] input) {
        return maxProduct(input);
    }
}
