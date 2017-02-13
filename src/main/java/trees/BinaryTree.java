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

        @Override
        public String toString() {
            return "Node{value = " + value + " }";
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

    public T minimum() {
        Node current = root;
        while (current.leftNode != null) {
            current = current.leftNode;
        }
        return current.value;
    }

    public T maximum() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightNode;
        }
        return last.value;
    }

    public boolean delete(T key) {
        Node current = root;
        Node parent = null;
        boolean isLeft = false;
        while (!key.equals(current.value)) {
            parent = current;
            if(key.compareTo(current.value) < 0) {
                isLeft = true;
                current = current.leftNode;
            } else {
                isLeft = false;
                current = current.rightNode;
            }
            if(current == null) {
                return false;
            }
        }
        System.out.println(current.value);
        if(current.leftNode == null && current.rightNode == null) {
            if(current == root) {
                root = null;
            } else if(isLeft){
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (current.leftNode == null) {
            if(current == root) {
                root = current.rightNode;
            } else if(isLeft) {
                parent.leftNode = current.rightNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else if (current.rightNode == null) {
            if(current == root) {
              root = current.leftNode;
            } else if(isLeft) {
                parent.leftNode = current.leftNode;
            } else {
                parent.rightNode = current.leftNode;
            }
        } else {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeft) {
                parent.leftNode = successor;
            } else {
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightNode;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }
        if(successorParent != delNode.rightNode) {
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }
}
