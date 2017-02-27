package hash;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by kasyan on 2/25/17.
 */
public class HashTable extends AbstractHash implements Hash {

    private Node[] array;
    private Node nullNode = new Node(-1L);

    public HashTable() {
        array = new Node[maxSize];
    }

    private class Node {

        Long value;

        Node(Long value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public Long insert(Long el) {
        int hash = hashFunction(el);
        while (array[hash] != null && array[hash] != nullNode) {
            ++hash;
            hash = hash % maxSize;
        }
        array[hash] = new Node(el);
        return el;
    }

    @Override
    public boolean delete(Long el) {
        int hash = hashFunction(el);
        while (array[hash] != null ) {
            if(array[hash].value.equals(el)) {
                array[hash] = nullNode;
                return true;
            }
            ++hash;
            hash %= maxSize;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.stream(array)
                .filter(n -> n != null)
                .map(node -> node.value.toString())
                .collect(Collectors.joining(", ", "HashTable[", "]"));
    }

    @InvokeMethod
    public void method() {
        System.out.println("Method invoked!!!");
    }
}
