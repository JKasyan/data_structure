package heap;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/27/17.
 */
public class PriorityQueueTest {

    @Test
    public void insertTest() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //new Integer[]{100, 90, 80, 30, 60, 60, 50, 70, 20, 10, 40, 55, 45, 5};
        Integer[] array = new Integer[]{56, 20, 10, 30};
        Arrays.stream(array).forEach(queue::insert);
        Integer max = queue.peek();
        assertEquals(56, max.intValue());
        Field nodesField = PriorityQueue.class.getDeclaredField("nodes");
        nodesField.setAccessible(true);
        Object[] nodes = (Object[]) nodesField.get(queue);
        assertEquals(10, nodes.length);
        assertEquals(56, nodes[0].getClass().getDeclaredField("value").get(nodes[0]));
        assertEquals(30, nodes[0].getClass().getDeclaredField("value").get(nodes[1]));
        assertEquals(10, nodes[0].getClass().getDeclaredField("value").get(nodes[2]));
        assertEquals(20, nodes[0].getClass().getDeclaredField("value").get(nodes[3]));
    }

    @Test
    public void popTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer[] array = new Integer[]{56, 20, 10, 30};
        Arrays.stream(array).forEach(queue::insert);
        Integer pop = queue.pop();
        assertEquals(56, pop.intValue());
    }

}