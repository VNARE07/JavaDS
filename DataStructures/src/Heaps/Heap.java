package Heaps;

public interface Heap<K extends Comparable<K>,V extends Comparable<V>> {
    public void put(K key, V value);
    public Node<K,V> remove();
    public void bubble(int child);
    public void sink(int limit);
    public K getKey(Node<K,V> node);
    public V getValue(Node<K,V> node);
}
