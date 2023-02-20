package org.example;

public class tree {

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

    static Node root;
    static Node temp = root;

    static void inorder(Node temp) {

        if (temp == null) {
            return;
        }

        inorder(temp.left);
        System.out.println(temp.data + " ");
        inorder(temp.right);

    }

}
