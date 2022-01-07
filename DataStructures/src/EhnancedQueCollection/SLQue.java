package EhnancedQueCollection;

public class SLQue<T> implements Que<T> {
    Node<T> head,tail;
    public SLQue(T data){
        Node<T> node = new Node(data);
        this.head = node;
        this.tail = node;
    }
    public SLQue(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        Node<T> node = new Node(data);
        Node<T> cur,tail;
        cur = this.head;
        if (cur == null) {
            this.head = node;
            this.tail = node;
        }
        else{
            tail = this.tail;
            tail.next = node;
            this.tail = node;
        }
    }

    
    public Node<T> get() {
        // TODO Auto-generated method stub
        Node cur,fol;
        cur = this.head;
        if (cur == null){
            return null;
        }
        else{
            fol = cur.next;
            this.head = fol;
            return cur;
        }
    }
    @Override
    public T pop() {
        // TODO Auto-generated method stub
       Node<T> node = this.get();
       if (node == null){
           return null;
       } 
       else{
           T value = node.data;
           return value;
       }
    }
    
}
