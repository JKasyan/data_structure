package heap;

/**
 * Created by 1 on 2/27/2017.
 */
public class PriorityQueue<E extends Comparable<E>> {

    private Node[] nodes;
    private int size = 0;

    private static class Node<E> {
        E value;
        Node parent;
        Node leftChild;
        Node rightChild;

        Node(E value) {
            this.value = value;
        }
    }

    public PriorityQueue() {
        this(10);
    }

    public PriorityQueue(int size) {
        this.nodes = new Node[10];
    }

    public void insert(E el) {
        if(size == 0) {
            nodes[0] = new Node(el);
        } else {
            nodes[size++] = new Node(el);
            int i = size;
            while(i > 0) {
                int parentPos = (size - 1) / 2;
                Node par = nodes[parentPos];
                Comparable<E> parentValue = (Comparable<E>)par.value;
                if(parentValue.compareTo(el) <= 0) {
                    break;
                }
                i--;
            }
        }
    }

    private void swap() {

    }
}
