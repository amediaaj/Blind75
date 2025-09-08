package com.amediaa.datastructures;

public class Main {

    public static void main(String[] args) {
        // Demo BST
//        BinarySearchTree myBST = new BinarySearchTree();
//
//        System.out.println("Root = " + myBST.root);
//
//        myBST.insert(47);
//        myBST.insert(21);
//        myBST.insert(76);
//        myBST.insert(18);
//        myBST.insert(52);
//        myBST.insert(82);
//
//        myBST.insert(27);
//        System.out.println(myBST.root.left.right.value);

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

        // Demo BFS
//        BinarySearchTree myBST = new BinarySearchTree();
//
//        myBST.insert(47);
//        myBST.insert(21);
//        myBST.insert(76);
//        myBST.insert(18);
//        myBST.insert(27);
//        myBST.insert(52);
//        myBST.insert(82);
//
//        System.out.println(myBST.BFS());
    }
}
