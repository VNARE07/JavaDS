package HashMap;

import java.util.function.Supplier;

public class Node<K,V> {
    K key;
    V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public Node() {
        this.key = null;
        this.value = null;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
}
