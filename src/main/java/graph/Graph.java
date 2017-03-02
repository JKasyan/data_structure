package graph;

import stack.Stack;

import java.util.function.Consumer;

/**
 * Created by 1 on 3/1/2017.
 */
public class Graph {

    private static final int MAX_VERTEX = 10;
    private Vertex[] vertexList;
    private byte[][] edgeMatrix;
    private int nVertexes;

    private class Vertex {

        char label;
        boolean wasVisited = false;

        public Vertex(char label) {
            this.label = label;
        }

        public boolean isWasVisited() {
            return wasVisited;
        }

        public void setWasVisited(boolean wasVisited) {
            this.wasVisited = wasVisited;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        edgeMatrix = new byte[MAX_VERTEX][MAX_VERTEX];
    }

    public void addVertex(char label) {
        vertexList[nVertexes++] = new Vertex(label);
    }

    public void addEdge(int i, int j) {
        edgeMatrix[i][j] = 1;
        edgeMatrix[j][i] = 1;
    }

    private int getUnvisitedVertex(int v) {
        for(int j = 0; j < nVertexes;j++) {
            if(edgeMatrix[v][j] == 1 & !vertexList[j].isWasVisited()) {
                return j;
            }
        }
        return -1;
    }

    public void dfs(Consumer<Object> consumer) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        consumer.accept(vertexList[0]);
        vertexList[0].setWasVisited(true);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if(v == -1) {
                stack.pop();
            } else {
                vertexList[v].setWasVisited(true);
                consumer.accept(vertexList[v]);
                stack.push(v);
            }
        }
    }
}
