package StackCollections;

public class SinglyLinkedStack<T> implements Stack<T> {
    Node<T> head;
    public SinglyLinkedStack(Node<T> node) {
        this.head = node;   
    }
    public SinglyLinkedStack() {
        this.head = null;   
    }
    @Override
    public void add(Node<T> node) {
        // TODO Auto-generated method stub
        Node<T> current;
        current = this.head;
        if (current == null) {
            this.head = node;
        }
        else {
            node.next = current;
            this.head = node;
        }
        
    }
    @Override
    public T pop() {
        // TODO Auto-generated method stub
        Node<T> current,fol;
        current = this.head;
        if (current == null) {
            return null;
        }
        else{
            fol = current.next;
            this.head = fol;
            return current.data;
        }
    }
    public void add(T v1,T v2) {
        // TODO Auto-generated method stub
        Node<T> node = new Node<T>(v1,v2);
        Node<T> current = this.head;
        if (current == null) {
            this.head = node;
        }
        else {
            node.next = current;
            this.head = node;
        }
    }
    public Node<T> popNode() {
        // TODO Auto-generated method stub
        Node<T> current,fol;
        current = this.head;
        if (current == null) {
            return null;
        }
        else{
            fol = current.next;
            this.head = fol;
            return current;
        }
    }
}
