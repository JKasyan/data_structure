package trees;

/**
 * Created by kasyan on 2/9/17.
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node root;

    private class Node {
        T value;
        Node leftNode;
        Node rightNode;

        Node(T value) {
            this.value = value;
        }
    }

    public T find(T element) {
        int i = 0;
        Node current = root;
        while (!current.value.equals(element)) {
            i++;
            T value = current.value;
            current = element.compareTo(value) >= 0 ? current.rightNode : current.leftNode;
            if(current == null) {
                System.out.println("null");
                return null;
            }
        }
        System.out.println("i = " + i + ", current.value = " + current.value);
        return current.value;
    }

    public void insert(T element) {
        if(root == null) {
            root = new Node(element);
            return;
        }
        Node current = root;
        while (true) {
            T value = current.value;
            if(element.compareTo(value) >= 0) {
                if(current.rightNode == null) {
                    current.rightNode = new Node(element);
                    break;
                }
                current = current.rightNode;
            } else {
                if(current.leftNode == null) {
                    current.leftNode = new Node(element);
                    break;
                }
                current = current.leftNode;
            }
        }
    }

    public void inOrder() {
        recInOrder(root);
    }

    private void recInOrder(Node node) {
        if (node != null) {
            recInOrder(node.leftNode);
            System.out.println(node.value);
            recInOrder(node.rightNode);
        }
    }
}
