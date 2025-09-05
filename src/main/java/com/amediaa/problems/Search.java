package com.amediaa.problems;

import com.amediaa.common.Problem;

import java.util.Arrays;
import java.util.List;

public class Search extends Problem<SearchInput, Integer> {
    public Search() {
        super("33. Search in Rotated Sorted Array", List.of(new SearchInput(
                new int[] {4, 5, 6, 7, 0, 1, 2},
                0
        )), List.of(4));
    }

    public int search(int[] nums, int target) {
        // TODO: Rewrite so that only one loop is used.
        // i.e. No need to find sorted partition, then binary search,
        //  While(left >= right)

        int pLeft = 0;
        int pRight = nums.length-1;


        // Goal is to arrive at a sorted partition
        //  that we know the value resides in
        while(nums[pLeft] > nums[pRight]) {
            // Partion between left and right is not sorted

            int pMid = (pLeft + pRight) / 2;
            if(nums[pMid] == target) return pMid;

            if(nums[pLeft] <= nums[pMid]) {
                // We know the left side is sorted ...

                // ... and we need to check if target is within
                if(target >=nums[pLeft] && target < nums[pMid]) {
                    // Target is within
                    // Update right and proceed to binary search
                    pRight = pMid -1;
                } else {
                    // Otherwise target not in sorted partition
                    //  so update left and iterate again
                    pLeft = pMid + 1;
                }

            } else {
                // We know the righ side is sorted ...

                // ... and we need to check if target is within
                if(target <= nums[pRight] && target > nums[pMid]) {
                    // Target is within
                    // Update left and proceed to binary search
                    pLeft = pMid + 1;
                } else {
                    // Otherwise target not in sorted partition
                    //  so update right and iterate again
                    pRight = pMid - 1;
                }
            }
        }

        // Remaining partition is sorted, so execute binary search
        while(pLeft <= pRight) {
            int pMid = (pLeft + pRight) / 2;
            if(nums[pMid] == target) return pMid;

            if(target < nums[pMid]) {
                pRight = pMid-1;
            } else {
                pLeft = pMid+1;
            }
        }

        return -1;
    }

    @Override
    Integer solution(SearchInput input) {
        return search(input.getNums(), input.getTarget());
    }
}

class SearchInput {
    private int[] nums;
    private int target;

    public SearchInput(int[] nums, int target) {
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
