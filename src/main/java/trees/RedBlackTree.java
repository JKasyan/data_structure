package trees;

/**
 * Created by kasyan on 2/20/17.
 */
public class RedBlackTree<T extends Comparable<T>> {

    private Node root;

    private static class Node<T> {
        T value;
        Node left;
        Node right;
        boolean isRed = true;

        Node(T value) {
            this.value = value;
        }
    }

    public boolean insert(T value) {
        Node node = new Node(value);
        if(root == null) {
            node.isRed = false;
            root = node;
        } else {

        }
        return true;
    }
}
