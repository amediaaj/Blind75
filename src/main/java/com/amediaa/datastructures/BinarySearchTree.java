package com.amediaa.datastructures;

import com.amediaa.common.Demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TODO: implement remove
public class BinarySearchTree implements Demo {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while(true) {
            if (newNode.value == temp.value) return false;

            if(newNode.value < temp.value) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        while(temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public List<Integer> BFS() {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> results = new ArrayList<>();

        Node currentNode = root;
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }

    public List<Integer> DFSPreOrder() {
        List<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return results;
    }

    public List<Integer> DFSPostOrder() {
        List<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);

        return results;
    }

    public List<Integer> DFSInOrder() {
        List<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return results;
    }

    @Override
    public void execute() {
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

        // Demo BFS
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println(myBST.BFS());
        System.out.println(myBST.DFSPreOrder());
        System.out.println(myBST.DFSPostOrder());
        System.out.println(myBST.DFSInOrder());
    }
}
