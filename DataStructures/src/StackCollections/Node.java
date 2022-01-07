package StackCollections;

public class Node<T> {
    public T data;
    public T status;
    public Node<T> next;
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public Node(T data,T status) {
        this.data = data;
        this.status = status;
        this.next = null;
    }
    public String toString() {
        return "Node{ " + data + " " + status  + " }";
    }
}
