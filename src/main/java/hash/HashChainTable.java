package hash;

/**
 * Created by kasyan on 2/26/17.
 */
public class HashChainTable<K,V> {

    private Node[] nodes = new Node[10];
    private static final double FACTOR = 0.75;
    private int size;

    private static class Node<K,V> {
        K key;
        V value;

        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hashFunction(Object object) {
        int hash = object.hashCode();
        return hash % nodes.length;
    }

    private boolean arrayIsFull() {
        return  nodes.length / size > FACTOR;
    }

    private void ensureCapacity() {
        Node[] newNodes = new Node[nodes.length << 1];
        for(int i = 0;i < nodes.length;i++) {
            if(nodes[i] != null) {

            }
        }
    }

    public V insert(K key, V value) {
        int cell = hashFunction(key);
        Node newNode = new Node(key, value);
        if(nodes[cell] == null) {
            nodes[cell] = newNode;
        } else {
            Node current = nodes[cell];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return value;
    }
}
