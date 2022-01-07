package DoublyLinkedListWithDummyPointer;

public class DoublyLinkedListWithDummyPointer<T> {
    Node<T> head,tail;
    public DoublyLinkedListWithDummyPointer(T value) {
        Node<T> dummy = new Node<T>();
        Node<T> node = new Node<T>(value);
        this.head = dummy;
        this.tail = dummy;
        this.head.next = node;
        this.head.prev = node;
        node.prev = dummy;
        node.next = dummy;
    }
    public DoublyLinkedListWithDummyPointer() {
        Node<T> dummy = new Node<T>();
        this.head = dummy;
        this.tail = dummy;
        this.head.next = dummy;
        this.head.prev = dummy;
    }
    public void addRear(T value){
        Node<T> head,nex;
        head = this.head;
        nex = head.next;
        Node<T> node = new Node<T>(value);
        if (head == nex){
            head.next = node;
            head.prev = node;
            node.prev = head;
            node.next = head;
        }
    }
    public T remove(T value){
        Node<T> cur = this.head;
        cur = cur.next;
        T result = null;
        while (true){
            if (cur == this.tail){
                break;
            }
            else{
                if (cur.data == value){
                    Node<T> prev = cur.prev;
                    Node<T> nex = cur.next;
                    prev.next = nex;
                    nex.prev = prev;
                    result = cur.data;
                    break;
                }
            }
        }
        return result;
    }
}
