package CircularDoublyLinkedList;

public class tester {
    public static void main(String[] args) {
        CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
        cll.add(1);
        cll.add(2);
        System.out.println(cll.pop());
        System.out.println(cll.pop());
        System.out.println(cll.pop());
        cll.add(3);
        System.out.println(cll.pop());
        System.out.println(cll.pop());
    }
}
