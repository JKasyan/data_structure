package graph;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by 1 on 3/2/2017.
 */
public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);// A -> B
        graph.addEdge(1, 3);// B -> D
        graph.addEdge(0, 2);// A -> C
        graph.addEdge(0, 3);// A -> D
    }

    @Test
    public void testInstanceGraph() throws Exception {
        Field edgeMatrixField = Graph.class.getDeclaredField("edgeMatrix");
        edgeMatrixField.setAccessible(true);
        byte[][] edgeMatrix = (byte[][]) edgeMatrixField.get(graph);

        assertArrayEquals(new byte[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, edgeMatrix[0]);
        assertArrayEquals(new byte[]{1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, edgeMatrix[1]);
        assertArrayEquals(new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, edgeMatrix[2]);
        assertArrayEquals(new byte[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, edgeMatrix[3]);
    }

    @Test
    public void dfsTest() throws Exception {
        graph.dfs(System.out::println);
    }

}