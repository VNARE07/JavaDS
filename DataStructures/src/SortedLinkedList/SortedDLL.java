package SortedLinkedList;

public class SortedDLL implements SortedLinkedList {
    Node head,tail;
    public SortedDLL(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
    }
    public SortedDLL(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public void add(int value) {
        // TODO Auto-generated method stub
        Node node = new Node(value);
        if (isEmpty()){
            this.head = node;
            this.tail = node;
        }
        else{
            this.searchAndAdd(value);
        }
        System.out.println("added");
    }
    public boolean search(int target){
        Node cur = this.head;
        boolean bol = false;
        while (true){
            if (cur == null){
                break;
            }
            else{
                if (cur.data == target){
                    bol = true;
                    break;
                }
                else{
                    cur = cur.next;
                }
            }
        }
        return bol;
    }
    private void searchAndAdd(int value) {
        Node chead,ctail,fol;
        chead = this.head;
        ctail = this.tail;
        Node node = new Node(value);
        if (value <= chead.data){
            this.head = node;
            node.next = chead;
            chead.prev = node;
        }
        if (value >= ctail.data){
            this.tail = node;
            node.prev = ctail;
            ctail.next = node;
        }
        else{
            Node cur = this.head;
            Node prev = null;
            while (true){
                System.out.println(cur.data);
                if (value > cur.data){
                    prev = cur;
                    cur = cur.next;
                }
                else{
                    prev.next = node;
                    node.prev = prev;
                    node.next = cur;
                    cur.prev = node;
                    break;
                }
            }
        }
    }
    @Override
    public int popAscending() {
        // TODO Auto-generated method stub
        if (this.isEmpty()){
            return -1;
        }
        else{
            Node cur,fol;
            cur = this.head;
            fol = cur.next;
            if (fol != null){
                fol.prev = null;
            }
            this.head = fol;
            return cur.data;
        }
    }
    public Node pop() {
        // TODO Auto-generated method stub
        if (this.isEmpty()){
            return null;
        }
        else{
            Node cur,fol;
            cur = this.head;
            fol = cur.next;
            if (fol != null){
                fol.prev = null;
            }
            this.head = fol;
            return cur;
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
    
}
