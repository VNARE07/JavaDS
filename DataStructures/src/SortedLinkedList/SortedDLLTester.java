package SortedLinkedList;

public class SortedDLLTester {
    public static void main(String[] args) {
        SortedDLL ll = new SortedDLL(1);
        ll.add(3);
        ll.add(5);
        ll.add(4);
        ll.add(2);
        Node cur;
        System.out.println("printlist");
        while (true){
            cur = ll.pop();
            if (cur == null){
                break;
            }
            else{
                System.out.println(cur.data);
            }
        }
    }
}
