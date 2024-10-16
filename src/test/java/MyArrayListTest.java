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

public class MyArrayListTest {

    private MyArrayList smallMAL;
    private MyArrayList bigMAL;

    @BeforeEach
    public void setup() {
        smallMAL = new MyArrayList();
        bigMAL = new MyArrayList();
    }

    // this test requires implementation of addLast and get
    @Test
    public void testMALSmallEasy() {
        smallMAL.addLast(100);
        assertEquals(100, smallMAL.get(0), "After adding 100, the element at index 0 should be 100.");

        smallMAL.addLast(101);
        assertEquals(100, smallMAL.get(0), "After adding 101, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding 101, the element at index 1 should be 101.");

        smallMAL.addLast(102);
        assertEquals(100, smallMAL.get(0), "After adding 102, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding 102, the element at index 1 should be 101.");
        assertEquals(102, smallMAL.get(2), "After adding 102, the element at index 2 should be 102.");

        smallMAL.addLast(103);
        assertEquals(100, smallMAL.get(0), "After adding 103, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding 103, the element at index 1 should be 101.");
        assertEquals(102, smallMAL.get(2), "After adding 103, the element at index 2 should be 102.");
        assertEquals(103, smallMAL.get(3), "After adding 103, the element at index 3 should be 103.");
    }

    // this test requires implementation of addLast, get, isEmpty, and size
    @Test
    public void testMALSmallSimple() {
        assertTrue(smallMAL.isEmpty(), "After being constructed, array list should be empty.");
        assertEquals(0, smallMAL.size(), "Array list should contain zero elements after being constructed.");

        smallMAL.addLast(100);
        assertFalse(smallMAL.isEmpty(), "After adding 100, array list should not be empty.");
        assertEquals(100, smallMAL.get(0), "After adding 100, the element at index 0 should be 100.");
        assertEquals(1, smallMAL.size(), "After adding 100, the array list should contain one element.");

        smallMAL.addLast(101);
        assertEquals(100, smallMAL.get(0), "After adding 101, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding 101, the element at index 1 should be 101.");
        assertEquals(2, smallMAL.size(), "After adding 101, the array list should contain two elements.");

        smallMAL.addLast(102);
        assertEquals(100, smallMAL.get(0), "After adding 102, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding 102, the element at index 1 should be 101.");
        assertEquals(102, smallMAL.get(2), "After adding 102, the element at index 2 should be 102.");
        assertEquals(3, smallMAL.size(), "After adding 102, the array list should contain three elements.");
    }

    // this test requires implementation of addLast, get, isEmpty, size, and set
    @Test
    public void testMALSmallMedium() {
        smallMAL.addLast(100);
        smallMAL.addLast(101);
        smallMAL.addLast(102);
        smallMAL.addLast(103);
        smallMAL.addLast(104); // 100, 101, 102, 103, 104
        assertFalse(smallMAL.isEmpty(), "After adding initial values, the array list should not be empty.");
        assertEquals(100, smallMAL.get(0), "After adding initial values, the element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "After adding initial values, the element at index 1 should be 101.");
        assertEquals(102, smallMAL.get(2), "After adding initial values, the element at index 2 should be 102.");
        assertEquals(103, smallMAL.get(3), "After adding initial values, the element at index 3 should be 103.");
        assertEquals(104, smallMAL.get(4), "After adding initial values, the element at index 4 should be 104.");
        assertEquals(5, smallMAL.size(), "After adding initial values, the array list should contain five elements.");

        smallMAL.set(0, 200);
        smallMAL.set(1, 201);
        smallMAL.set(2, 202);
        smallMAL.set(3, 203);
        smallMAL.set(4, 204);
        assertFalse(smallMAL.isEmpty(), "After setting values, the array list should not be empty.");
        assertEquals(200, smallMAL.get(0), "After setting values, the element at index 0 should be 200.");
        assertEquals(201, smallMAL.get(1), "After setting values, the element at index 1 should be 201.");
        assertEquals(202, smallMAL.get(2), "After setting values, the element at index 2 should be 202.");
        assertEquals(203, smallMAL.get(3), "After setting values, the element at index 3 should be 203.");
        assertEquals(204, smallMAL.get(4), "After setting values, the element at index 4 should be 204.");
        assertEquals(5, smallMAL.size(), "After setting values, the array list should contain five elements.");
    }

    // this test requires implementation of addLast, add, get, size, and remove
    @Test
    public void testMALSmallComplex() {
        smallMAL.addLast(18);
        smallMAL.addLast(45);
        smallMAL.addLast(67);
        smallMAL.addLast(73);
        smallMAL.addLast(88); // 18, 45, 67, 73, 88

        assertEquals(5, smallMAL.size());
        assertEquals(18, smallMAL.get(0));
        assertEquals(45, smallMAL.get(1));
        assertEquals(67, smallMAL.get(2));
        assertEquals(73, smallMAL.get(3));
        assertEquals(88, smallMAL.get(4));

        smallMAL.add(1, 34);
        smallMAL.add(1, 22);
        smallMAL.add(0, 9);
        smallMAL.add(8, 91);
        smallMAL.add(5, 56); // 9, 18, 22, 34, 45, 56, 67, 73, 88, 91

        assertEquals(10, smallMAL.size());
        assertEquals(9, smallMAL.get(0));
        assertEquals(18, smallMAL.get(1));
        assertEquals(22, smallMAL.get(2));
        assertEquals(34, smallMAL.get(3));
        assertEquals(45, smallMAL.get(4));
        assertEquals(56, smallMAL.get(5));
        assertEquals(67, smallMAL.get(6));
        assertEquals(73, smallMAL.get(7));
        assertEquals(88, smallMAL.get(8));
        assertEquals(91, smallMAL.get(9));

        smallMAL.remove(7); // remove 73
        smallMAL.remove(3); // remove 34
        smallMAL.remove(0); // remove 9
        smallMAL.remove(6); // remove 91
        smallMAL.remove(2); // 18, 22, 56, 67, 88

        assertEquals(5, smallMAL.size());
        assertEquals(18, smallMAL.get(0));
        assertEquals(22, smallMAL.get(1));
        assertEquals(56, smallMAL.get(2));
        assertEquals(67, smallMAL.get(3));
        assertEquals(88, smallMAL.get(4));

        smallMAL.add(5, 99);
        smallMAL.add(2, 30); // 18, 22, 30, 56, 67, 88, 99

        smallMAL.remove(4); // remove 67
        smallMAL.remove(4); // remove 88
        smallMAL.remove(0); // remove 18
        smallMAL.remove(2); // remove 56
        smallMAL.remove(0); // remove 22: 30, 99 remain

        assertEquals(2, smallMAL.size());
        assertEquals(30, smallMAL.get(0));
        assertEquals(99, smallMAL.get(1));

        smallMAL.remove(1); // remove 99
        smallMAL.remove(0); // remove 30
        assertTrue(smallMAL.isEmpty());
        assertEquals(0, smallMAL.size());
    }

    // ensure that capacity is managed properly
    @Test
    public void testMALLargeSimple() {
        int max = 100000;
        for(int i = 0; i < max; i++){
            assertEquals(i, bigMAL.size());
            bigMAL.addLast(i);
        }
        for(int i = max; i > 0; i--){
            assertEquals(i, bigMAL.size());
            bigMAL.remove(i - 1);
        }
    }

    // this test requires implementation of addLast, contains, and indexOf
    @Test
    public void testMALFinders() {
        smallMAL.addLast(21);
        smallMAL.addLast(-64);
        smallMAL.addLast(94);
        smallMAL.addLast(-72);
        smallMAL.addLast(84);
        smallMAL.addLast(-28);

        assertTrue(smallMAL.contains(21), "Contains cannot find element 21.");
        assertTrue(smallMAL.contains(-64), "Contains cannot find element -64.");
        assertTrue(smallMAL.contains(94), "Contains cannot find element 94.");
        assertTrue(smallMAL.contains(-72), "Contains cannot find element -72.");
        assertTrue(smallMAL.contains(84), "Contains cannot find element 84.");
        assertTrue(smallMAL.contains(-28), "Contains cannot find element -28.");

        assertFalse(smallMAL.contains(0), "Contains thinks it found element 0.");
        assertFalse(smallMAL.contains(-55), "Contains thinks it found element -55.");
        assertFalse(smallMAL.contains(60), "Contains thinks it found element 60.");
        assertFalse(smallMAL.contains(-38), "Contains thinks it found element -38.");
        assertFalse(smallMAL.contains(93), "Contains thinks it found element 93.");
        assertFalse(smallMAL.contains(Integer.MAX_VALUE), "Contains thinks it found a big element.");

        assertEquals(0, smallMAL.indexOf(21), "IndexOf cannot find element 21.");
        assertEquals(1, smallMAL.indexOf(-64), "IndexOf cannot find element -64.");
        assertEquals(2, smallMAL.indexOf(94), "IndexOf cannot find element 94.");
        assertEquals(3, smallMAL.indexOf(-72), "IndexOf cannot find element -72.");
        assertEquals(4, smallMAL.indexOf(84), "IndexOf cannot find element 84.");
        assertEquals(5, smallMAL.indexOf(-28), "IndexOf cannot find element -28.");

        assertEquals(-1, smallMAL.indexOf(0), "IndexOf thinks it found element 0.");
        assertEquals(-1, smallMAL.indexOf(-55), "IndexOf thinks it found element -55.");
        assertEquals(-1, smallMAL.indexOf(60), "IndexOf thinks it found element 60.");
        assertEquals(-1, smallMAL.indexOf(-38), "IndexOf thinks it found element -38.");
        assertEquals(-1, smallMAL.indexOf(93), "IndexOf thinks it found element 93.");
        assertEquals(-1, smallMAL.indexOf(Integer.MAX_VALUE), "IndexOf thinks it found a big element.");
    }

    @Test
    public void testMLLNullPointerException(){
        smallMAL.addLast(302);
        smallMAL.addLast(301);
        smallMAL.addLast(300);
        assertThrows(NullPointerException.class,
                () -> smallMAL.addLast(null),
                "Argument to addLast cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMAL.add(1, null),
                "Argument to add cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMAL.set(1, null),
                "Argument to set cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMAL.indexOf(null),
                "Argument to indexOf cannot be null.");
        assertThrows(NullPointerException.class,
                () -> smallMAL.contains(null),
                "Argument to contains cannot be null.");
    }

    // I ADDED SOME MORE TESTS SPECIFICALLY FOR ITERATORS

    @Test
    public void testIteratorBasic() {
        MyArrayList list = new MyArrayList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

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
        MyArrayList list = new MyArrayList();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorNoSuchElementException() {
        MyArrayList list = new MyArrayList();
        list.addLast(1);
        Iterator<Integer> iterator = list.iterator();
        iterator.next(); // Consume the only element
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
