package HashMap;

import java.util.ArrayList;
import java.util.Collection;
import TreeCollection.GenericComparator;

public class HashMap<K extends Comparable<K>,V extends Comparable<V>> implements Map<K, V>{
    ArrayList<Node<K,V>> map = new ArrayList<Node<K,V>>(2);
    GenericComparator<K> kc = new GenericComparator<K>();
    int size = 0;
    int filled = 0;
    public HashMap(K key, V value) {
        this.map = new ArrayList<Node<K,V>>(2);
        this.size = 2;
        this.filled = 0;
        this.add(key,value);
    }
    @Override
    public void add(K key, V value) {
        // TODO Auto-generated method stub
        System.out.println("key "+ key +" value "+ value + " array size "+ this.map.size());
        System.out.println(this.map);
        this.filled = this.filled + 1;
        int half = this.size/2;
        Node<K,V> node = new Node<K,V>(key, value);
        if (this.filled > half) {
            this.filled = this.filled - 1;
            this.size = this.size * 2;
            this.tableDouble(this.size);
            this.add(key, value);
        }   
        int hash = this.Hash(key);
        while (true){
            if (this.map.get(hash) == null) {
                this.map.set(hash,node);
                break;
            }
            else{
                Node<K,V> node2 = this.map.get(hash);
                if (kc.comparevalues(this.getKey(node2),key) == 0){
                    this.map.set(hash,node);
                    this.filled = this.filled - 1;
                    break;
                }
                hash = hash + 1;
                hash = hash % this.size;
            }
        }  
    }
    private void tableDouble(int size){
        ArrayList<Node<K,V>> temp = new ArrayList<Node<K,V>>(this.size);
        for (int i = 0; i < this.map.size(); i++){
            Node<K,V> node = this.map.get(i);
            if (node != null) {
                 K key = this.getKey(node);
                 int hash = this.Hash(key);
                 while (true){
                     if (temp.get(hash) != null){
                         hash = hash % this.size;
                         temp.set(hash,node);
                         break;
                     }
                     else{
                         hash = hash % this.size;
                         hash = hash + 1;
                     }
                 }
            }
        }
        this.map = temp;
    }
    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        int hash = this.Hash(key);
        int start = hash;
        Node<K,V> sol = null;
        while (true){
            if (kc.comparevalues(this.getKey(this.map.get(hash)), key) == 0){
                sol = this.map.get(hash);
                break;
            }
            else{
                hash = hash + 1;
                hash = hash % this.size;
            }
            if (hash == start){
                break;
            }
        }
        if (sol == null){
            return null;
        }
        else{
            return this.getValue(sol);
        }
    }
    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        Collection<V> c;
        Node<K,V> node;
        ArrayList<V> result = new ArrayList<V>();
        for (int i = 0; i < this.map.size();i++){
            node = this.map.get(i);
            if (node != null){
                result.add(this.getValue(node));
            }
        }
        c = result;
        return c;
    }
    @Override
    public K getKey(Node<K, V> node) {
        // TODO Auto-generated method stub
        return node.getKey();
    }
    @Override
    public V getValue(Node<K, V> node) {
        // TODO Auto-generated method stub
        return node.getValue();
    }
    @Override
    public int Hash(K key) {
        // TODO Auto-generated method stunb
        Integer i = (Integer)key;
        return i%this.size;
    }
}
