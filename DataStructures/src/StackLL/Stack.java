package StackLL;

public class Stack<T> {
    Node<T> head;
    public Stack(T data){
        Node<T> node = new Node<T>(data);
        this.head = node;
    }
    public Stack(){
        this.head = null;
    }
    public void add(T data){
        Node<T> node = new Node<T>(data);
        if (isEmpty()){
            this.head = node;
        }
        else{
            Node<T> head = this.head;
            node.next = head;
            this.head = node;
        }
    }
    public void add(T data,String s){
        Node<T> node = new Node<T>(data,s);
        if (isEmpty()){
            this.head = node;
        }
        else{
            Node<T> head = this.head;
            node.next = head;
            this.head = node;
        }
    }
    public Node<T> pop(){
        if (isEmpty()){
            return null;
        }
        else{
            Node<T> head = this.head;
            Node<T> fol = head.next;
            this.head = fol;
            return head;
        }
    }
    private boolean isEmpty() {
        if (this.head == null){
            return true;
        }
        else{
            return false;
        }
    }
}
