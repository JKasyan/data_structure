package linked.collections;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/27/17.
 */
public class DoubleLinkedListTest {

    @Test
    public void isEmptyTest() throws Exception {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        assertTrue(doubleLinkedList.isEmpty());
        doubleLinkedList.insertFirst(1);
        doubleLinkedList.deleteKey(1);
        assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    public void deleteKeyTest() {
        DoubleLinkedList<Long> list = new DoubleLinkedList<>();
        list.insertFirst(1L);
        list.insertFirst(22L);
        assertEquals(Long.valueOf(1L), list.deleteKey(1L));
        assertNull(list.deleteKey(1L));
        assertEquals(Long.valueOf(22L), list.deleteKey(22L));
        assertTrue(list.isEmpty());
    }
}