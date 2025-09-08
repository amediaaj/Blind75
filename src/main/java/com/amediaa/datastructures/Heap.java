package com.amediaa.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    // Constructor that builds a heap from an existing array
    public Heap(int[] arr) {
        // 1. Create an internal ArrayList to hold heap values
        this.heap = new ArrayList<>();

        // 2. Copy all elements from the input array into the heap list.
        //    At this point, 'heap' is just a raw array, not a valid heap yet.
        for (int val : arr) {
            heap.add(val);
        }

        // 3. Perform "heapify" (bottom-up construction).
        //    We start from the last non-leaf node and work backwards to the root.
        //
        //    Why start at heap.size()/2 - 1?
        //    --------------------------------
        //    - In a binary heap (array-based), all nodes after index n/2 - 1
        //      are leaf nodes (they have no children).
        //    - Leaf nodes automatically satisfy the heap property,
        //      so we only need to fix internal nodes (parents).
        //
        //    For each parent node, we call sinkDown to push it into
        //    the correct place, ensuring the heap property holds.
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            sinkDown(i);  // pushes down element at index 'i' if needed
        }

        // After this loop finishes, the entire array is a valid Max Heap.
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while(current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if(heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() -1));
        sinkDown(0);

        return maxValue;
    }

    public void sinkDown(int index) {
        int maxIndex = index;
        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() &&  heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

}
