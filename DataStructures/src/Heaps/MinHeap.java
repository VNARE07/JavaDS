package Heaps;

import java.util.ArrayList;

import TreeCollection.GenericComparator;

public class MinHeap<K extends Comparable<K>,V> implements Heap<K,V> {
    ArrayList<Node<K,V>> heap = new ArrayList<Node<K,V>>(); 
    GenericComparator<K> kc = new GenericComparator<K>();
    int size = 0;
    public MinHeap(K key, V value) {
        Node<K,V> node = new Node<K,V>(key, value);
        this.heap.add(node);
        this.size = 1;
    }
    public MinHeap(){
        this.size = 0;
    }
    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub4
        Node<K,V> node = new Node<K,V>(key, value);
        if (this.size == 0){
            this.heap.add(node);
        }
        else{
            this.heap.add(node);
            this.bubble(this.size);
        }
        this.size = this.size + 1;
    }

    @Override
    public Node<K,V> remove() {
        // TODO Auto-generated method stub
        if (this.size == 0){
            return null;
        }
        else{
            this.swap(0,this.size-1);
            Node<K,V> node = this.heap.remove(this.size-1);
            this.size = this.size - 1;
            this.sink(this.size-1);
            return node;
        }
    }

    private void swap(int i, int j) {
        Node<K,V> start,end;
        start = this.heap.get(i);
        end = this.heap.get(j);
        this.heap.set(i,end);
        this.heap.set(j,start);
    }
    @Override
    public void bubble(int child) {
        // TODO Auto-generated method stub
        int par;
        Node<K,V> p,c;
        K pk,ck;
        while (true){
            if (child == 0){
                break;
            }
            else{
                if (child % 2 == 0){
                    par = (child - 1)/2;
                }
                else{
                    par = child / 2;
                }
                p = this.heap.get(par);
                c = this.heap.get(child);
                pk = this.getKey(p);
                ck = this.getKey(c);
                if (kc.comparevalues(pk,ck) > 0){
                    this.swap(par,child);
                    child = par;
                }
                else{
                    break;
                }
            }
        }
    }

    @Override
    public void sink(int limit) {
        // TODO Auto-generated method stub
        int par,left,right;
        Node<K,V> p,l,r;
        K pk,lk,rk;
        par = 0;
        while (true){
            left = (par * 2) + 1;
            right = (par * 2) + 2;
            if ((left > limit) && (right > limit)){
                break;
            }
            else if ((left < limit) && (right <= limit)){
                p = this.heap.get(par);
                l = this.heap.get(left);
                r = this.heap.get(right);
                pk = this.getKey(p);
                lk = this.getKey(l);
                rk = this.getKey(r);
                if ((kc.comparevalues(pk, lk) <= 0) && (kc.comparevalues(pk,rk) <= 0)){
                    break;
                }
                else{
                    if (kc.comparevalues(lk,rk) <= 0){
                        this.swap(left,par);
                        par = left;
                    }
                    else{
                        this.swap(par,right);
                        par = right;
                    }
                }
            }
            else if (left == limit){
                p = this.heap.get(par);
                l = this.heap.get(left);
                pk = this.getKey(p);
                lk = this.getKey(l);
                if (kc.comparevalues(pk,lk) <= 0){
                    break;
                }
                else{
                    this.swap(par,left);
                    par = left;
                }
            }
        }
    }
    @Override
    public K getKey(Node<K,V> node) {
        // TODO Auto-generated method stub
        return node.key;
    }
    @Override
    public V getValue(Node<K, V> node) {
        // TODO Auto-generated method stub
        return node.value;
    }
}
