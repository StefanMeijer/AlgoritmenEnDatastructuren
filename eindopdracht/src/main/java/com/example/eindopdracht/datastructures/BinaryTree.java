package com.example.eindopdracht.datastructures;

import java.util.ArrayList;
import java.util.List;

class TreeNode<T extends Comparable<T>> {
    T data;
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;

    public TreeNode(T data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        this.root = insertNode(this.root, data);
    }

    private TreeNode<T> insertNode(TreeNode<T> root, T data) {
        if (root == null) {
            return new TreeNode<T>(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.leftNode = insertNode(root.leftNode, data);
        } else {
            root.rightNode = insertNode(root.rightNode, data);
        }

        return root;
    }

    public boolean search(T data) {
        return searchNode(this.root, data);
    }

    private boolean searchNode(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (root.data.compareTo(data) == 0) {
            return true;
        } else if (data.compareTo(root.data) < 0) {
            return searchNode(root.leftNode, data);
        } else {
            return searchNode(root.rightNode, data);
        }
    }

    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderTraversalNode(this.root, result);
        return result;
    }

    private void inorderTraversalNode(TreeNode<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        inorderTraversalNode(root.leftNode, result);
        result.add(root.data);
        inorderTraversalNode(root.rightNode, result);
    }

    public ArrayList<T> sort() {
        ArrayList<T> sortedList = new ArrayList<>();
        if (root != null) {
            quickSort(sortedList, root);
        }
        return sortedList;
    }

    private void quickSort(List<T> list, TreeNode<T> node) {
        if (node.leftNode != null) {
            quickSort(list, node.leftNode);
        }
        list.add(node.data);
        if (node.rightNode != null) {
            quickSort(list, node.rightNode);
        }
    }

    // Method to sort the elements using QuickSort algorithm
    public void quickSort() {
        if (root != null) {
            quickSort(root);
        }
    }

    private void quickSort(TreeNode<T> node) {
        if (node.leftNode != null) {
            quickSort(node.leftNode);
        }
        if (node.rightNode != null) {
            quickSort(node.rightNode);
        }
        List<T> smaller = new ArrayList<>();
        List<T> equal = new ArrayList<>();
        List<T> larger = new ArrayList<>();
        TreeNode<T> current = node;
        T pivot = current.data;
        equal.add(pivot);
        while (current.leftNode != null) {
            current = current.leftNode;
            T data = current.data;
            if (data.compareTo(pivot) < 0) {
                smaller.add(data);
            } else if (data.compareTo(pivot) > 0) {
                larger.add(data);
            } else {
                equal.add(data);
            }
        }
        current = node;
        while (current.rightNode != null) {
            current = current.rightNode;
            T data = current.data;
            if (data.compareTo(pivot) < 0) {
                smaller.add(data);
            } else if (data.compareTo(pivot) > 0) {
                larger.add(data);
            } else {
                equal.add(data);
            }
        }
        List<T> newList = new ArrayList<>();
        newList.addAll(smaller);
        newList.addAll(equal);
        newList.addAll(larger);
        node.leftNode = null;
        node.rightNode = null;
        for (T data : newList) {
            insert(data);
        }
    }
}
