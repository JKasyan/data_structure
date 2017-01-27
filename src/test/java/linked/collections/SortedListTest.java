package linked.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 1/27/2017.
 */
public class SortedListTest {
    @Test
    public void insertAscendingTest() throws Exception {
        SortedList<Integer> list = new SortedList<>();
        list.insert(20);
        list.insert(-5);
        list.insert(30);
        assertEquals(Integer.valueOf(-5), list.remove());
        assertEquals(Integer.valueOf(20), list.remove());
        assertEquals(Integer.valueOf(30), list.remove());
        assertTrue(list.isEmpty());
    }

    @Test
    public void insertDescendingTest() throws Exception {
        SortedList<Character> list = new SortedList<>(Order.DESCENDING);
        list.insert('e');
        list.insert('a');
        list.insert('d');
        System.out.println(list);
        assertEquals(Character.valueOf('e'), list.remove());
        assertEquals(Character.valueOf('d'), list.remove());
        assertEquals(Character.valueOf('a'), list.remove());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeTest() {
        SortedList<Double> list = new SortedList<>();
        list.insert(1.25);
        list.insert(1.4);
        list.insert(0.25);
        assertEquals(Double.valueOf(0.25), list.remove());
        assertEquals(Double.valueOf(1.25), list.remove());
        assertEquals(Double.valueOf(1.4), list.remove());
    }

    @Test
    public void toStringTest() {
        SortedList<Integer> list = new SortedList<>();
        list.insert(100);
        list.insert(-100);
        list.insert(0);
        list.insert(0);
        String toStringResult = list.toString();
        assertEquals("SortedList[-100, 0, 0, 100]", toStringResult);
    }
}