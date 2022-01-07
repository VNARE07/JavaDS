package SortedLinkedList;

public class tester1 {
    public static void main(String[] args) {
        LinkedListWithDups llwd = new LinkedListWithDups();
        llwd.add(3);
        llwd.add(4);
        llwd.add(5);
        llwd.add(3);
        llwd.add(2);
        llwd.add(4);
        llwd.printList();
        llwd.deleteNode(4);
        System.out.println("after deleting 4");
        llwd.printList();
        llwd.deleteNode(4);
        System.out.println("after deleting 4");
        llwd.printList();
        System.out.println(llwd.deleteNode(4));
        System.out.println("after deleting 4");
        llwd.printList();
    }
}
