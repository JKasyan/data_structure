package queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/18/17.
 */
public class PriorityQueueTest {

    @Test
    public void insert() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        queue.insert(1);
        queue.insert(5);
        queue.insert(10);
        System.out.println(queue);
    }

}