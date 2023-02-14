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
    int size;

    LinkedListAssignment(int[] data)
    {
        for (int integer : data)
        {
            size++;
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

    void remove (int index) {
        //Check if given index is inside scope of list
        if (index <= this.size) {
            //Curr & prev
            Node curr = this.head;
            Node prev = this.tail;

            //Loop over the size of list
            for (int i = 0; i < this.size; i++) {

                //Check if loop is not going out of boundaries
                if (curr.next != null) { //Maybe unnecessarily

                    //If given index is same as loop index
                    if (i == index) {
                        this.head = curr.next.next; //Set head to next, next
                        this.tail = curr.next; //Set tail to next
                        curr = null; //set node to null
                        this.size--; //Decrease size list with -1
                        return; //Close the loop
                    } else {
                        prev = curr; //Set previous to current
                        curr = head.next; //Set curr to next
                    }
                }
            }
        }
    }

    void insertAfter(int data) {
        if(this.tail == null) {
            return;
        }

        Node curr = new Node(data, null);

        while(true) {

            if(curr.next == null) {
                curr.next = this.tail.next;
                this.tail.next = curr;
                return;
            }
        }
    }
}
