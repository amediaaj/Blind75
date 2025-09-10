package com.amediaa.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TODO: implement remove
public class BinarySearchTree {
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
        Node currentNode = root;

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        // Add the entire node to queue
        queue.add(currentNode);

        while(queue.size() > 0) {
            currentNode = queue.remove();
            // Add the node value to results
            results.add(currentNode.value);

            if(currentNode.left != null) {
                // Add the entire node to queue
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                // Add the entire node to queue
                queue.add(currentNode.right);
            }
        }

        return results;
    }
}
