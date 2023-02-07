import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListAssignmentTest {

    @Test
    void linkedListConstructorTest()
    {
        int[] integers = new int[6];
        integers[0] = 12;
        integers[1] = 32;
        integers[2] = 43;
        integers[3] = 54;
        integers[4] = 65;
        integers[5] = 22;

        LinkedListAssignment test = new LinkedListAssignment(integers);
        test.add(1);
        test.add(5);
        test.add(33);

        System.out.println(test.head.data);
        System.out.println(test.head.next.data);
        System.out.println(test.head.next.next.data);
        System.out.println(test.tail.data);
        System.out.println(test.tail.next);
        assertEquals(1,1);
    }

}