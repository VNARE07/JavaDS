package LinkedListUsingAdjenceyList;

import java.util.ArrayList;
import LinkedListUsingAdjenceyList.Node;


public class LinkedListAdj<T> {
    Node<T>[] ll;
    int head = 0;
    int tail = 0;
    int size = 0;
    ArrayList<Integer> left = new ArrayList<Integer>();
    public LinkedListAdj(int size){
        this.size = size;
        ll = new Node[size];
        for (int i = 0; i < size; i++){
            this.left.add(i);
        }        
    }
    public void addRear(T data,int next){
        if (left.size() == ll.length){
            Node<T> node = new Node<T>(data);
            this.swap();
            int pos = this.left.remove(this.left.size()-1);
            this.ll[pos] = node;
            this.head = pos;
            this.tail = pos;
        }
        else{
            Node<T> node = new Node<T>(data);
            this.swap();
            int pos = this.left.remove(this.left.size()-1);
            this.ll[pos] = node;
            Node<T> tailnode = this.ll[this.tail];
            tailnode.next = pos;
            node.prev = this.tail;
            this.tail = pos;
        }
    }
    private void swap() {
        int temp = this.left.get(0);
        this.left.set(0,this.left.get(this.left.size() - 1));
        this.left.set(this.left.size()-1,temp);
    }
    public T popFront(){
        if (this.left.size() == 0){
            return null;
        }
        else{
            Node<T> node = this.ll[this.head];
            int folindex = node.next;
            Node<T> fol = this.ll[folindex];
            fol.prev = -1;
            this.head = folindex;
            return fol.data;
        }
    }
}
