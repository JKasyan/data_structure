package queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/17/17.
 */
public class QueueTest {
    @Test
    public void insert() throws Exception {
        Queue<Long> queue = new Queue<>(5);
        queue.insert(1L);
        assertEquals(Long.valueOf(1L), queue.peekFront());
    }

    @Test
    public void remove() throws Exception {
        Queue<String> queue = new Queue<>(5);
        for(int i = 0;i<5;i++) {
            queue.insert("queue" + i);
        }
        assertEquals("queue0", queue.remove());
    }

    @Test
    public void peekFront() throws Exception {
        Queue<Integer> queue = new Queue<>(5);
        for(int i = 0;i<5;i++) {
            queue.insert(i);
        }
        Integer expected = 0;
        assertEquals(expected, queue.peekFront());
        assertTrue(queue.isFull());
    }

    @Test
    public void isFull() throws Exception {
        Queue<Integer> queue = new Queue<>(5);
        for(int i = 0;i<5;i++) {
            queue.insert(i);
        }
        assertTrue(queue.isFull());
    }

    @Test
    public void isEmpty() throws Exception {
        Queue<Integer> queue = new Queue<>(5);
        assertTrue(queue.isEmpty());
    }

}