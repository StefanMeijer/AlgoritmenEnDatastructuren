package com.example.eindopdracht.datastructures.LinkedList;

import java.util.ArrayList;

public class LinkedList<T>
{
    private Node<T> head;

    public LinkedList()
    {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node<T> current = head;
            while (current.getNext() != null)
            {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void delete(T data)
    {
        if (head == null)
        {
            return;
        }
        if (head.getData() == data)
        {
            head = head.getNext();
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null && current.getNext().getData() != data)
        {
            current = current.getNext();
        }
        if (current.getNext() != null)
        {
            current.setNext(current.getNext().getNext());
        }
    }

    public ArrayList<T> displayableView() {
        Node<T> current = head;
        ArrayList<T> list = new ArrayList<>();
        while (current != null)
        {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
