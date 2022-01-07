package QueCollections;

public class Node<T> {
    T data;
    public Node<T> next;
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    public T getData(){
        return this.data;
    }
}
