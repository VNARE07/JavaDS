package StackLL;

public class Node<T> {
    public T data;
    public String status;
    public Node<T> next;
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    public Node(T data,String status){
        this.data = data;
        this.status = status;
        this.next = null;
    }
}
