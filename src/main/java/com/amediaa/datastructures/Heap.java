package com.amediaa.datastructures;

import com.amediaa.common.Demo;

import java.util.ArrayList;
import java.util.List;

public class Heap implements Demo {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    // "Heapify" constructor
    public Heap(int[] arr) {
        this.heap = new ArrayList<>();

        for (int val : arr) {
            heap.add(val);
        }

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            sinkDown(i);
        }
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

    @Override
    public void execute() {
        // Demo Heap
        Heap myHeap = new Heap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);

        System.out.println(myHeap.getHeap());

        myHeap = new Heap(new int[] {65, 80, 75, 55, 95, 50, 60});

        System.out.println(myHeap.getHeap());
    }
}
