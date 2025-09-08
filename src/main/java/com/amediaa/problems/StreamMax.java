package com.amediaa.problems;

import com.amediaa.datastructures.Heap;
import java.util.ArrayList;
import java.util.List;

public class StreamMax extends Problem<int[], List<Integer>>{
    /*
        This method takes two parameters as input: an array of integers nums and an integer k.
        The array nums can have both positive and negative integers and can be of any size.
        The integer k is guaranteed to be in the range of 1 to the length of the array inclusive.

        Your task is to find the kth smallest element in the array nums.
        In other words, if the elements of the array were sorted in ascending order,
            the element at the kth position (1-indexed) is the output.
    */
    public StreamMax() {
        super("Heap: Maximum Element in a Stream", List.of(
                new int[] {1, 5, 2, 9, 3, 6, 8},
                new int[] {10, 2, 5, 1, 0, 11, 6},
                new int[] {3, 3, 3, 3, 3}
        ), List.of(
                List.of(1, 5, 5, 9, 9, 9, 9),
                List.of(10, 10, 10, 10, 10, 11, 11),
                List.of(3, 3, 3, 3, 3)
        ));
    }

    private List<Integer> streamMax(int[] nums) {
        Heap heap = new Heap();
        List<Integer> output = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            heap.insert(nums[i]);
            output.add(heap.getHeap().get(0));
        }

        return output;
    }

    @Override
    List<Integer> solution(int[] input) {
        return streamMax(input);
    }
}
