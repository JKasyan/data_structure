package trees;

/**
 * Created by kasyan on 2/22/17.
 */
public class Tree234<T extends Comparable> {

    private Node root;

    private static final class Node<E extends Comparable<E>> {
        Comparable[] values = new Comparable[3];
        Node[] links = new Node[4];
        Node parent;
        int size = 0;

        public void insert(E element) {
            if(size == 0) {
                values[0] = element;
            } else {
                for (int i = size - 1;i > 0;i--) {
                    Comparable<E> current = values[i];
                    int comp = current.compareTo(element);
                    if(comp > 0) {
                        values[i + 1] = element;
                        break;
                    } else {
                        values[i + 1] = values[i];
                    }
                }
            }
            size++;
        }

        boolean isFull() {
            return size == 3;
        }
    }

    public boolean insert(T element) {
        if(root == null) {
            root = new Node();
            root.insert(element);
        } else {
            Node current = root;
            while (true) {
                if(!current.isFull()) {
                    break;
                }
                for(int i = 0;i < 3;i++) {
                    if(current.values[i] != null && current.values[i].compareTo(element) > 0) {
                        current = current.links[i];
                        break;
                    }
                }
            }
            //
        }
        return true;
    }
}
