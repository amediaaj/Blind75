package com.amediaa.problems;

public class ProductExceptSelf extends Problem<int[], int[]> {
    public ProductExceptSelf() {
        super(new int[] {1, 2, 3, 4}, new int[] {24, 12, 8, 6});
    }

    @Override
    int[] solution(int[] input) {
        return productExceptSelf(input);
    }

    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;

        int[] ans = new int[nums.length];
        ans[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1] * pre;
            pre = ans[i];
        }

        for(int i = nums.length-2; i >= 0; i--) {
            ans[i] = ans[i] * nums[i+1] * post;
            post = nums[i+1] * post;
        }

        return ans;
    }
}
