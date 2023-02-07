import java.util.LinkedList;
import java.util.List;

public class LinkedListAssignment
{
    class Node
    {
        int data;
        Node next;

        Node(int d, Node n)
        {
            this.data = d;
            this.next = n;
        }
    }

    Node head;
    Node tail;

    LinkedListAssignment(int[] data)
    {
        for (int integer : data)
        {
            add(integer);
        }
    }

    void add(int data)
    {
        if(this.head == null)
        {
            this.head = new Node(data, null);
            return;
        }

        Node curr = head;

        while(true)
        {
            if(curr.next == null)
            {
                curr.next = new Node(data, null);
                this.tail = curr.next;
                return;
            }
            curr = curr.next;
        }
    }
}
