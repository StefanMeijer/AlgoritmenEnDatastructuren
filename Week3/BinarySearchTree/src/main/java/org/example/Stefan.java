package org.example;

public class Stefan {
    static Node root;

    static class Node {

        int data;

        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * Binary search tree
     * Uses Level Order traversal strategy
     */
    public void insert(Node current, int data) {
        if (root == null) { //If root is empty, create new one
            root = new Node(data);
        } else {
            if (data < current.data) { // if given value is smaller then current
                if (current.left != null) { //if not null
                    insert(current.left, data);
                } else { //If the left side is empty, insert with new node
                    current.left = new Node(data);
                }
            } else { //Value = bigger then current.value
                if (current.right != null) {// if not null
                    insert(current.right, data);
                } else { //If the right side is empty, insert with new node
                    current.right = new Node(data);
                }
            }
        }
    }
}
