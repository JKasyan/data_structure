package heap;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by kasyan on 2/27/17.
 */
public class PriorityQueueTest {

    @Test
    public void insertTest() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
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
    public void popTest() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        Integer[] array = new Integer[]{100, 90, 80, 30, 60, 50, 70, 20, 10, 40, 55, 45, 5};
        Arrays.stream(array).forEach(queue::insert);
        Integer pop = queue.pop();
        assertEquals(100, pop.intValue());
        assertEquals(90, queue.peek().intValue());
        Field sizeField = PriorityQueue.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        int size = (int)sizeField.get(queue);
        assertEquals(12, size);

        Field nodesField = PriorityQueue.class.getDeclaredField("nodes");
        nodesField.setAccessible(true);
        Object[] nodes = (Object[]) nodesField.get(queue);
        assertEquals(20, nodes.length);

        Field valueField = nodes[0].getClass().getDeclaredField("value");
        int i = 0;
        assertEquals(90, valueField.get(nodes[i++]));
        assertEquals(60, valueField.get(nodes[i++]));
        assertEquals(80, valueField.get(nodes[i++]));

        assertEquals(30, valueField.get(nodes[i++]));
        assertEquals(55, valueField.get(nodes[i++]));
        assertEquals(50, valueField.get(nodes[i++]));
        assertEquals(70, valueField.get(nodes[i++]));

        assertEquals(20, valueField.get(nodes[i++]));
        assertEquals(10, valueField.get(nodes[i++]));
        assertEquals(40, valueField.get(nodes[i++]));
        assertEquals(5, valueField.get(nodes[i++]));
        assertEquals(45, valueField.get(nodes[i]));
    }

    @Test
    public void ensureCapacityTest() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for(int i = 0;i < 5;i++) {
            queue.insert(i);
        }
        assertFalse(queue.isEmpty());
        Field nodesField = PriorityQueue.class.getDeclaredField("nodes");
        nodesField.setAccessible(true);
        Object[] nodes = (Object[]) nodesField.get(queue);
        assertEquals(6, nodes.length);

        Field valueField = nodes[0].getClass().getDeclaredField("value");
        int i = 0;
        assertEquals(4, valueField.get(nodes[i++]));
        assertEquals(3, valueField.get(nodes[i++]));
        assertEquals(1, valueField.get(nodes[i++]));
        assertEquals(0, valueField.get(nodes[i++]));
        assertEquals(2, valueField.get(nodes[i]));
    }

}