package com.amediaa.datastructures;

public class Main {

    public static void main(String[] args) {
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

        Heap myHeap = new Heap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);

        System.out.println(myHeap.getHeap());

        myHeap.remove();

        System.out.println(myHeap.getHeap());

        myHeap.remove();

        System.out.println(myHeap.getHeap());
    }
}
