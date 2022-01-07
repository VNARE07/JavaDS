package CircularDoublyLinkedList;

import DoublyLinkedListWithDummyPointer.Node;

public class CircularLinkedList<T> implements CircularLiinkedList<T> {
    Node<T> dummy,head,tail;
    public CircularLinkedList(T value){
        dummy = new Node<T>();
        Node<T> node = new Node<T>(value);
        this.head = node;
        this.tail = node;
        dummy.next = this.head;
        dummy.prev = this.tail;
        this.head.prev = this.dummy;
        this.tail.next = this.dummy;
    }
    public CircularLinkedList(){
        dummy = new Node<T>();
        this.head = null;
        this.tail = null;
        this.dummy.next = this.dummy;
        this.dummy.prev = this.dummy;
    }
    @Override
    public void add(T value) {
        // TODO Auto-generated method stub
        if (this.isEmpty()) {
            Node<T> node = new Node<T>(value);
            this.head = node;
            this.tail = node;
            dummy.next = this.head;
            dummy.prev = this.tail;
            this.head.prev = this.dummy;
            this.tail.next = this.dummy;
        }
        else{
            Node<T> tail = this.tail;
            Node<T> node = new Node<T>(value);
            tail.next = node;
            node.prev = tail;
            this.tail = node;
            dummy.prev = this.tail;
            this.tail.next = this.dummy;
        }
    }

    private boolean isEmpty() {
        if ((this.dummy.next == this.dummy) && (this.dummy.prev == this.dummy)) {
            this.head = null;
            this.tail = null;
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (this.isEmpty()){
            return null;
        }
        else{
            Node<T> head,fol;
            head = this.head;
            fol = head.next;
            this.head = fol;
            fol.prev = this.dummy;
            this.dummy.next = fol;
            return head.data;
        }
    }
    
}
