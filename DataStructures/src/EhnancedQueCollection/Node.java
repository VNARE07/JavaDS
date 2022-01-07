package EhnancedQueCollection;

public class Node<T> {
    Node<T> next;
    T data;
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    public T getData(){
        return this.data;
    }
}
