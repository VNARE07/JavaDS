package SortedLinkedList;

public class Tester {
    public static void main(String[] args) {
        LinkedListWithNoDups l = new LinkedListWithNoDups();
        l.add(3);
        l.add(4);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(7);
        l.add(6);
        l.printList();
        System.out.println(l.map);
        l.deleteNode(4);
        System.out.println("after deleting 4");
        l.printList();
        l.deleteNode(1);
        System.out.println("after deleting 1");
        l.printList();
        l.deleteNode(6);
        System.out.println("after deleting 6");
        l.printList();
        System.out.println(l.deleteNode(6)); // return false cannot delete this node from it;
        l.deleteNode(7);
        l.deleteNode(3);
        l.deleteNode(2);
        l.deleteNode(3);
        // while (true){
        //     cur = l.popAscending();
        //     if (cur == -1){
        //         break;
        //     }
        //     else{
        //         System.out.println(cur);
        //     }
        // }

    }
}
