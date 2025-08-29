package com.amediaa.problems;

import java.util.List;

public class FindMin extends Problem<int[], Integer>{

    public FindMin() {
        super("153. Find Minimum in Rotated Sorted Array", List.of(new int[] {3,4,5,1,2}), List.of(1));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid;
        int min = nums[0];

        // Goal is for value at left pointer to be
        //  less than value at right pointer
        while(nums[left] > nums[right]) {

            // Set the mid and update min
            //  if mid is the new minimum
            mid = (left + right) / 2;
            min = Math.min(nums[mid], min);

            // If the value at mid pointer
            //  is less than value at left pointer
            if(nums[left] > nums[mid]) {
                // move right pointer left
                right = mid - 1;
            } else {
                // otherwise move left pointer right
                left = mid + 1;
            }
        }

        min = Math.min(nums[left], min);

        return min;
    }

    @Override
    Integer solution(int[] input) {
        return findMin(input);
    }
}
