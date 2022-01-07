package HashMap;

import java.util.Collection;

public interface Map<K extends Comparable<K>, V extends Comparable<V>>{
    public void add(K key, V value);
    public V get(K key);
    public Collection<V> values();
    public K getKey(Node<K,V> node);
    public V getValue(Node<K,V> node);
    public int Hash(K key);
}
