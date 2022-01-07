package DoublyLinkedListWithDummyPointer;

public class Node<T> {
    public T data;
    public Node<T> next,prev;
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }   
}
