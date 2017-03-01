package graph;

/**
 * Created by 1 on 3/1/2017.
 */
public class Graph {

    private static final int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private byte[][] edgeMatrix;
    private int nVertexes;

    private class Vertex {
        char label;
        public Vertex(char label) {
            this.label = label;
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
}
