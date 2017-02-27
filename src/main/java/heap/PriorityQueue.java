package heap;

/**
 * Created by 1 on 2/27/2017.
 */
public class PriorityQueue<E extends Comparable<E>> {

    private Node[] nodes;
    private int size = 0;

    private static class Node<E> {
        E value;

        Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public PriorityQueue() {
        this(10);
    }

    public PriorityQueue(int size) {
        this.nodes = new Node[size];
    }

    public void insert(E el) {
        Node node = new Node(el);
        if(size == 0) {
            nodes[0] = node;
            size++;
        } else {
            nodes[size++] = node;
            int pos = size - 1;
            while(pos > 0) {
                int parentPos = (pos - 1) / 2;
                Node par = nodes[parentPos];
                Comparable<E> parentValue = (Comparable<E>)par.value;
                int comp = parentValue.compareTo(el);
                if(comp > 0) {
                    break;
                }
                nodes[pos] = nodes[parentPos];
                pos = parentPos;
            }
            nodes[pos] = node;
        }
    }

    public E pop() {
        E pop = (E)nodes[0].value;
        nodes[0] = nodes[size - 1];
        Node temp = nodes[0];
        Comparable tempValue = (Comparable)temp.value;
        int pos = 0;
        while (tempValue.compareTo(nodes[pos].value) <= 0) {
            int leftPos = 2 * pos + 1;
            Comparable left = (Comparable)nodes[leftPos].value;
            Comparable right = (Comparable)nodes[leftPos + 1].value;
            if(left.compareTo(right) > 0) {
                nodes[pos] = nodes[leftPos];
                pos = leftPos;
            } else {
                nodes[pos] = nodes[leftPos + 1];
                pos = leftPos + 1;
            }
        }
        return pop;
    }

    public E peek() {
        return (E)nodes[0].value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
