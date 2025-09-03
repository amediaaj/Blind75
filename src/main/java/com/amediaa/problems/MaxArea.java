package com.amediaa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MaxArea extends Problem<int[], Integer> {
    public MaxArea() {
        super("11. Containter With Most Water", List.of(new int[] {1,8,6,2,5,4,8,3,7}), List.of(49));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;

            max = Math.max(max, area);

            if(height[left] <= height [right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }


    @Override
    Integer solution(int[] input) {
        return maxArea(input);
    }
}
