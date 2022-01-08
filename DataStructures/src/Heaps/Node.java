package Heaps;

public class Node<K,V> {
    K key;
    V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public String toString() {
        return "key " + key + " value " + value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
}
