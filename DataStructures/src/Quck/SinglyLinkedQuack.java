package Quck;

public class SinglyLinkedQuack<T> implements Quack<T> {
    DLNode<T> head,tail;
    public SinglyLinkedQuack(T data){
        DLNode<T> node  = new DLNode<T>(data);
        this.head = node;
        this.tail = node;
    }
    public SinglyLinkedQuack(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public void addHead(T data) {
        // TODO Auto-generated method stub
        DLNode<T> cur;
        DLNode<T> node  = new DLNode<T>(data);
        cur = this.head;
        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
        }
        else{
            node.next = cur;
            cur.prev = node;
            this.head = node;
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
    @Override
    public void addTail(T data) {
        // TODO Auto-generated method stub
        DLNode<T> node  = new DLNode<T>(data);
        DLNode<T> curtail;
        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
        }
        else{
            curtail = this.tail;
            curtail.next = node;
            node.prev = curtail;
            this.tail = node;
        }
    }

    @Override
    public T popHead() {
        // TODO Auto-generated method stub
        DLNode<T> curhead = this.getHead();
        if (curhead == null){
            return null;
        }
        else{
            T data = curhead.data;
            return data;
        }
    }

    @Override
    public T popTail() {
        // TODO Auto-generated method stub
        DLNode<T> curtail = this.getTail();
        if (curtail == null){
            return null;
        }
        else{
            T data = curtail.data;
            return data;
        }
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }
    public DLNode<T> getHead(){
        if (this.isEmpty()){
            return null;
        }
        else{
            DLNode<T> cur,fol,curprev;
            cur = this.head;
            curprev = cur.prev;
            fol = cur.next;
            cur.next = null;
            this.head = fol;
            if (fol != null){
                fol.prev = curprev;
            }
            return cur;
        }
    }
    public DLNode<T> getTail(){
        if (this.isEmpty()){
            return null;
        }
        else{
            DLNode<T> curtail,tailprev;
            curtail = this.tail;
            tailprev = curtail.prev;
            if (tailprev == null){
                this.head = null;
            }
            else{
                this.tail = tailprev;
                tailprev.next = null;
            }
            return curtail;
        } 
    }
}
