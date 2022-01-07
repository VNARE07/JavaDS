package LinkedListUsingAdjenceyList;

public class Node<T> {
    T data;
    int next,prev;
    public Node(T value,int next) {
        this.data = value;
        this.next = next;
        this.prev = -1;
    }
    public Node(T value) {
        this.data = value;
        this.next = -1;
        this.prev = -1;
    }
}
