package SortedLinkedList;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkedListWithDups implements SortedLinkedList {
    Node head,tail,toadd;
    HashMap<Integer,ArrayList<Node>> map = new HashMap<Integer,ArrayList<Node>>();
    public LinkedListWithDups(int value){
        toadd = new Node(value);
        this.head = toadd;
        this.tail = toadd;
        ArrayList<Node> node = new ArrayList<Node>();
        node.add(toadd);
        map.put(value,node);
    }
    public LinkedListWithDups(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public void add(int value) {
        // TODO Auto-generated method stub
        toadd = new Node(value);
        if (map.containsKey(value)){
            ArrayList<Node> node = map.get(value);
            node.add(toadd);
        }
        else{
            ArrayList<Node> node = new ArrayList<Node>();
            node.add(toadd);
            map.put(value, node);
        }
        if (isEmpty()){
            this.head = toadd;
            this.tail = toadd;
        }
        else if(value <= this.head.data){
            Node h = this.head;
            toadd.next = h;
            h.prev = toadd;
            this.head = toadd;
        }
        else if(value >= this.tail.data){
            Node t = this.tail;
            t.next = toadd;
            toadd.prev = t;
            this.tail = toadd;
        }
        else{
            this.SearchAndAdd(value,toadd);
        }
    }
    private void SearchAndAdd(int value,Node toadd) {
        Node cur = this.head;
        Node fol;
        System.out.println(value + " in seach and add");
        while (true){
            if (cur == null){
                break;
            }
            else{
                fol = cur.next;
                if ((value >= cur.data) && (value <= fol.data)){
                    cur.next = toadd;
                    toadd.prev = cur;
                    toadd.next = fol;
                    fol.prev = toadd;
                    break;
                }
                cur = fol;
            }
        }
    }
    @Override
    public int popAscending() {
        // TODO Auto-generated method stub
        Node cur,fol;
        cur = this.head;
        if (cur == null){
            return -1;
        }
        else{
            this.deleteNode(cur.data);
            fol = cur.next;
            this.head = fol;
            return cur.data;
        }
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (this.head == null){
            return true;
        }
        else{
            return false;
        }
    }
    public void printList(){
        Node cur = this.head;
        Node fol;
        while (true){
            if (cur == null){
                break;
            }
            else{
                fol = cur.next;
                System.out.println(cur.data);
                cur = fol;
            }
        }
    }
    public boolean deleteNode(int value){
        if (this.map.containsKey(value)){
            Node prev,fol,del,l;
            ArrayList<Node> node = this.map.get(value);
            del = node.get(0);
            int last = node.size()-1;
            l = node.get(last);
            node.set(0, l);
            node.set(last,del);
            node.remove(last);
            prev = del.prev;
            fol = del.next;
            if ((prev != null) && (fol != null)){
                prev.next = fol;
                fol.prev = prev;
            }
            else if ((prev != null) || (fol != null)){
                if (prev == null){
                    fol.prev = null;
                    this.head = fol;
                }
                else{
                    prev.next = null;
                    this.tail = prev;
                }
            }
            else{
                this.head = null;
                this.tail = null;
            }
            last = node.size();
            if (last == 0){
                map.remove(del.data);
            }
            return true;
        }
        else{
            return false;
        }
    }
    
}
