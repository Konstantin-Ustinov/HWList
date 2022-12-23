import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyListIntegerImplTest {

    MyListIntegerImpl out;

    @BeforeEach
    void setUp() {
        out = new MyListIntegerImpl(1, 2);
    }

    @Test
    void add() {
        assertEquals(3, out.add(3));
        assertThrows(IllegalArgumentException.class, () -> out.add(null));
    }

    @Test
    void testAdd() {
        assertEquals(3, out.add(1, 3));
        assertThrows(IllegalArgumentException.class, () -> out.add(1, null));
        assertThrows(IllegalArgumentException.class, () -> out.add(5, 3));
    }

    @Test
    void set() {
        assertEquals(3, out.set(1, 3));
        assertThrows(IllegalArgumentException.class, () -> out.set(1, null));
        assertThrows(IllegalArgumentException.class, () -> out.set(5, 3));
    }

    @Test
    void remove() {
        assertEquals(2, out.remove(1));
        assertThrows(IllegalArgumentException.class, () -> out.remove(5));
    }

    @Test
    void testRemove() {
        Integer expected = 2;
        assertEquals(expected, out.remove(expected));
        assertThrows(IllegalArgumentException.class, () -> out.remove(null));
    }

    @Test
    void contains() {
        assertTrue(out.contains(2));
        assertFalse(out.contains(5));
        assertThrows(IllegalArgumentException.class, () -> out.contains(null));
    }

    @Test
    void indexOf() {
        assertEquals(1, out.indexOf(2));
        assertEquals(-1, out.indexOf(5));
        assertThrows(IllegalArgumentException.class, () -> out.indexOf(null));
    }

    @Test
    void lastIndexOf() {
        assertEquals(1, out.lastIndexOf(2));
        assertEquals(-1, out.lastIndexOf(5));
        assertThrows(IllegalArgumentException.class, () -> out.lastIndexOf(null));
    }

    @Test
    void get() {
        assertEquals(2, out.get(1));
        assertThrows(IllegalArgumentException.class, () -> out.get(5));
    }

    @Test
    void testEquals() { // почему этот тест проваливается?
        MyListIntegerImpl test1 = new MyListIntegerImpl(1, 2);
        MyListIntegerImpl test2 = new MyListIntegerImpl(1, 2, 3);
        System.out.println(Arrays.toString(out.toArray()));
        System.out.println(Arrays.toString(test1.toArray()));
        assertTrue(out.equals(test1));
        assertFalse(out.equals(test2));
        assertThrows(IllegalArgumentException.class, () -> out.equals(null));
    }

    @Test
    void size() {
        assertEquals(2, out.size());
    }

    @Test
    void isEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
        Integer[] test = new Integer[]{1, 2};
        assertArrayEquals(test, out.toArray());
    }

    @Test
    void sortSelection() {
        Integer[] test = new Integer[]{2, 3};
        out.set(0, 3);
        out.sortSelection();
        assertArrayEquals(test, out.toArray());
    }
}