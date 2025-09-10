package com.amediaa.problems;

import com.amediaa.datastructures.Heap;

import java.util.Arrays;
import java.util.List;

public class FindKthSmallest extends Problem<FindKthSmallest.FindKthSmallestInput, Integer> {
    /*
        This method takes two parameters as input: an array of integers nums and an integer k.
        The array nums can have both positive and negative integers and can be of any size.
        The integer k is guaranteed to be in the range of 1 to the length of the array inclusive.

        Your task is to find the kth smallest element in the array nums.
        In other words, if the elements of the array were sorted in ascending order,
            the element at the kth position (1-indexed) is the output.
    */

    public FindKthSmallest() {
        super("Heap: Kth Smallest Element in an Array", List.of(
                new FindKthSmallestInput(
                        new int[] {7, 10, 4, 3, 20, 15},
                        3
                )
        ), List.of(7));
    }

    private int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();

        for(int num : nums) {
            heap.insert(num);
            if(heap.getHeap().size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }

    @Override
    Integer solution(FindKthSmallestInput input) {
        return findKthSmallest(input.getNums(), input.getK());
    }

    public static class FindKthSmallestInput {
        private int[] nums;
        private int k;

        public FindKthSmallestInput(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }

        public int[] getNums() {
            return nums;
        }

        public int getK() {
            return k;
        }

        @Override
        public String toString() {
            return String.format("{ nums: %s, k: %d }", Arrays.toString(nums), k);
        }
    }
}
