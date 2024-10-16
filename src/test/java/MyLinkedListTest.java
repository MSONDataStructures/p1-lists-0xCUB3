import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListTest {

    private MyLinkedList smallMLL;
    private MyLinkedList bigMLL;

    @BeforeEach
    public void setup() {
        smallMLL = new MyLinkedList();
        bigMLL = new MyLinkedList();
    }

    // this test requires implementation of addFirst and get
    @Test
    public void testSmallEasyMLL() {
        smallMLL.addFirst(100);
        assertEquals(100, smallMLL.get(0), "After adding 100, the element at index 0 should be 100.");

        smallMLL.addFirst(101);
        assertEquals(100, smallMLL.get(1), "After adding 101, the element at index 1 should be 100.");
        assertEquals(101, smallMLL.get(0), "After adding 101, the element at index 0 should be 101.");

        smallMLL.addFirst(102);
        assertEquals(100, smallMLL.get(2), "After adding 102, the element at index 2 should be 100.");
        assertEquals(101, smallMLL.get(1), "After adding 102, the element at index 1 should be 101.");
        assertEquals(102, smallMLL.get(0), "After adding 102, the element at index 0 should be 102.");

        smallMLL.addFirst(103);
        assertEquals(100, smallMLL.get(3), "After adding 103, the element at index 3 should be 100.");
        assertEquals(101, smallMLL.get(2), "After adding 103, the element at index 2 should be 101.");
        assertEquals(102, smallMLL.get(1), "After adding 103, the element at index 1 should be 102.");
        assertEquals(103, smallMLL.get(0), "After adding 103, the element at index 0 should be 103.");
    }

    // this test requires implementation of addFirst, get, isEmpty, and size
    @Test
    public void testSmallSimpleMLL() {
        assertTrue(smallMLL.isEmpty(), "After being constructed, linked list should be empty.");
        assertEquals(0, smallMLL.size(), "Linked list should contain zero elements after being constructed.");

        smallMLL.addFirst(100);
        assertFalse(smallMLL.isEmpty(), "After adding 100, linked list should not be empty.");
        assertEquals(100, smallMLL.get(0), "After adding 100, the element at index 0 should be 100.");
        assertEquals(1, smallMLL.size(), "After adding 100, the linked list should contain one element.");

        smallMLL.addFirst(101);
        assertEquals(100, smallMLL.get(1), "After adding 101, the element at index 1 should be 100.");
        assertEquals(101, smallMLL.get(0), "After adding 101, the element at index 0 should be 101.");
        assertEquals(2, smallMLL.size(), "After adding 101, the linked list should contain two elements.");

        smallMLL.addFirst(102);
        assertEquals(100, smallMLL.get(2), "After adding 102, the element at index 2 should be 100.");
        assertEquals(101, smallMLL.get(1), "After adding 102, the element at index 1 should be 101.");
        assertEquals(102, smallMLL.get(0), "After adding 102, the element at index 0 should be 102.");
        assertEquals(3, smallMLL.size(), "After adding 102, the linked list should contain three elements.");
    }

    // this test requires implementation of addFirst, get, isEmpty, size, and set
    @Test
    public void testSmallMediumMLL() {
        smallMLL.addFirst(104);
        smallMLL.addFirst(103);
        smallMLL.addFirst(102);
        smallMLL.addFirst(101);
        smallMLL.addFirst(100);
        assertFalse(smallMLL.isEmpty(), "After adding initial values, the linked list should not be empty.");
        assertEquals(100, smallMLL.get(0), "After adding initial values, the element at index 0 should be 100.");
        assertEquals(101, smallMLL.get(1), "After adding initial values, the element at index 1 should be 101.");
        assertEquals(102, smallMLL.get(2), "After adding initial values, the element at index 2 should be 102.");
        assertEquals(103, smallMLL.get(3), "After adding initial values, the element at index 3 should be 103.");
        assertEquals(104, smallMLL.get(4), "After adding initial values, the element at index 4 should be 104.");
        assertEquals(5, smallMLL.size(), "After adding initial values, the linked list should contain five elements.");

        smallMLL.set(0, 200);
        smallMLL.set(1, 201);
        smallMLL.set(2, 202);
        smallMLL.set(3, 203);
        smallMLL.set(4, 204);
        assertFalse(smallMLL.isEmpty(), "After setting values, the linked list should not be empty.");
        assertEquals(200, smallMLL.get(0), "After setting values, the element at index 0 should be 200.");
        assertEquals(201, smallMLL.get(1), "After setting values, the element at index 1 should be 201.");
        assertEquals(202, smallMLL.get(2), "After setting values, the element at index 2 should be 202.");
        assertEquals(203, smallMLL.get(3), "After setting values, the element at index 3 should be 203.");
        assertEquals(204, smallMLL.get(4), "After setting values, the element at index 4 should be 204.");
        assertEquals(5, smallMLL.size(), "After setting values, the linked list should contain five elements.");
    }

    // this test requires implementation of addFirst, add, get, size, and remove
    @Test
    public void testSmallComplexMLL() {
        smallMLL.addFirst(88);
        smallMLL.addFirst(73);
        smallMLL.addFirst(67);
        smallMLL.addFirst(45);
        smallMLL.addFirst(18); // 18, 45, 67, 73, 88

        assertEquals(5, smallMLL.size());
        assertEquals(18, smallMLL.get(0));
        assertEquals(45, smallMLL.get(1));
        assertEquals(67, smallMLL.get(2));
        assertEquals(73, smallMLL.get(3));
        assertEquals(88, smallMLL.get(4));

        smallMLL.add(1, 34); // 18, *34*, 45, 67, 73, 88
        smallMLL.add(1, 22); // 18, *22*, 34, 45, 67, 73, 88
        smallMLL.add(0, 9); // *9*, 18, 22, 34, 45, 67, 73, 88
        smallMLL.add(8, 91); // 9, 18, 22, 34, 45, 67, 73, 88, *91*
        smallMLL.add(5, 56); // 9, 18, 22, 34, 45, *56*, 67, 73, 88, 91

        assertEquals(10, smallMLL.size());
        assertEquals(9, smallMLL.get(0));
        assertEquals(18, smallMLL.get(1));
        assertEquals(22, smallMLL.get(2));
        assertEquals(34, smallMLL.get(3));
        assertEquals(45, smallMLL.get(4));
        assertEquals(56, smallMLL.get(5));
        assertEquals(67, smallMLL.get(6));
        assertEquals(73, smallMLL.get(7));
        assertEquals(88, smallMLL.get(8));
        assertEquals(91, smallMLL.get(9));

        smallMLL.remove(7); // 9, 18, 22, 34, 45, 56, 67, x73x, 88, 91
        smallMLL.remove(3); // 9, 18, 22, x34x, 45, 56, 67, 88, 91
        smallMLL.remove(0); // x9x, 18, 22, 45, 56, 67, 88, 91
        smallMLL.remove(6); // 18, 22, 45, 56, 67, 88, x91x
        smallMLL.remove(2); // 18, 22, 56, 67, 88

        assertEquals(5, smallMLL.size());
        assertEquals(18, smallMLL.get(0));
        assertEquals(22, smallMLL.get(1));
        assertEquals(56, smallMLL.get(2));
        assertEquals(67, smallMLL.get(3));
        assertEquals(88, smallMLL.get(4));

        smallMLL.add(5, 99); // 18, 22, 56, 67, 88, *99*
        smallMLL.add(2, 30); // 18, 22, *30*, 56, 67, 88, 99

        assertEquals(67, smallMLL.remove(4)); // 18, 22, 30, 56, x67x, 88, 99
        assertEquals(88, smallMLL.remove(4)); // 18, 22, 30, 56, x88x, 99
        assertEquals(18, smallMLL.remove(0)); // x18x, 22, 30, 56, 99
        assertEquals(56, smallMLL.remove(2)); // 22, 30, x56x, 99
        assertEquals(22, smallMLL.remove(0)); // x22x, 30, 99

        assertEquals(2, smallMLL.size());
        assertEquals(30, smallMLL.get(0));
        assertEquals(99, smallMLL.get(1));

        smallMLL.remove(1); // remove 99
        smallMLL.remove(0); // remove 30
        assertTrue(smallMLL.isEmpty());
        assertEquals(0, smallMLL.size());
    }

    @Test
    public void testLargeMLL() {
        //int max = 10000;
        int max = 5;
        for(int i = 0; i < max; i++){
            assertEquals(i, bigMLL.size());
            bigMLL.add(i, i);
        }
        for(int i = max; i > 0; i--){
            assertEquals(i, bigMLL.size());
            assertEquals(i - 1, bigMLL.remove(i - 1));
        }
        for(int i = 0; i < max; i++){
            assertEquals(i, bigMLL.size());
            bigMLL.addFirst(i);
        }
        bigMLL.clear();
        assertTrue(bigMLL.isEmpty());
        assertEquals(0, bigMLL.size());
    }

    // this test requires implementation of addFirst, contains, and indexOf
    @Test
    public void testFindersMLL() {
        smallMLL.addFirst(21);
        smallMLL.addFirst(-64);
        smallMLL.addFirst(94);
        smallMLL.addFirst(-72);
        smallMLL.addFirst(84);
        smallMLL.addFirst(-28); // -28, 84, -72, 94, -64, 21

        assertEquals(6, smallMLL.size());
        assertEquals(0, smallMLL.indexOf(-28), "IndexOf cannot find element 21.");
        assertEquals(1, smallMLL.indexOf(84), "IndexOf cannot find element -64.");
        assertEquals(2, smallMLL.indexOf(-72), "IndexOf cannot find element 94.");
        assertEquals(3, smallMLL.indexOf(94), "IndexOf cannot find element -72.");
        assertEquals(4, smallMLL.indexOf(-64), "IndexOf cannot find element 84.");
        assertEquals(5, smallMLL.indexOf(21), "IndexOf cannot find element -28.");

        assertEquals(-1, smallMLL.indexOf(0), "IndexOf thinks it found element 0.");
        assertEquals(-1, smallMLL.indexOf(-55), "IndexOf thinks it found element -55.");
        assertEquals(-1, smallMLL.indexOf(60), "IndexOf thinks it found element 60.");
        assertEquals(-1, smallMLL.indexOf(-38), "IndexOf thinks it found element -38.");
        assertEquals(-1, smallMLL.indexOf(93), "IndexOf thinks it found element 93.");
        assertEquals(-1, smallMLL.indexOf(Integer.MAX_VALUE), "IndexOf thinks it found a big element.");

        assertTrue(smallMLL.contains(21), "Contains cannot find element 21.");
        assertTrue(smallMLL.contains(-64), "Contains cannot find element -64.");
        assertTrue(smallMLL.contains(94), "Contains cannot find element 94.");
        assertTrue(smallMLL.contains(-72), "Contains cannot find element -72.");
        assertTrue(smallMLL.contains(84), "Contains cannot find element 84.");
        assertTrue(smallMLL.contains(-28), "Contains cannot find element -28.");

        assertFalse(smallMLL.contains(0), "Contains thinks it found element 0.");
        assertFalse(smallMLL.contains(-55), "Contains thinks it found element -55.");
        assertFalse(smallMLL.contains(60), "Contains thinks it found element 60.");
        assertFalse(smallMLL.contains(-38), "Contains thinks it found element -38.");
        assertFalse(smallMLL.contains(93), "Contains thinks it found element 93.");
        assertFalse(smallMLL.contains(Integer.MAX_VALUE), "Contains thinks it found a big element.");
    }

    @Test
    public void testNullPointerExceptionMLL(){
        smallMLL.addFirst(302);
        smallMLL.addFirst(301);
        smallMLL.addFirst(300);
        assertThrows(NullPointerException.class,
                () -> smallMLL.addFirst(null),
                "Argument to addFirst cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMLL.add(1, null),
                "Argument to add cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMLL.set(1, null),
                "Argument to set cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMLL.indexOf(null),
                "Argument to indexOf cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMLL.contains(null),
                "Argument to contains cannot be null.");
    }

    // I ADDED MORE TESTS SPECIFICALLY FOR ITERATORS

    @Test
    public void testIteratorBasic() {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorEmptyList() {
        MyLinkedList list = new MyLinkedList();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorNoSuchElementException() {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);
        Iterator<Integer> iterator = list.iterator();
        iterator.next(); // Consume the only element
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
