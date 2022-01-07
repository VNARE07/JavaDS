package QueCollections;

public class SinglylinkedQue <T> implements Que<T> {
    Node<T> head,tail;
    public SinglylinkedQue(Node<T> node){
        this.head = node;
        this.tail = node;
    }
    public SinglylinkedQue(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public void add(Node<T> node) {
        // TODO Auto-generated method stub
        Node<T> current,tail;
        current = this.head;
        if (current == null){
            this.head = node;
            this.tail = node;
        }
        else{
            tail = this.tail;
            tail.next = node;
            this.tail = node;
        }
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        Node<T> current,fol;
        current = this.head;
        if (current == null){
            return null;
        }
        else{
            fol = current.next;
            this.head = fol;
            return current.data;
        }
    }
    
}
