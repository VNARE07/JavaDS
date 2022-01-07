package Quck;

public class tester {
    public static void main(String[] args) {
        SinglyLinkedQuack<Integer> slq = new SinglyLinkedQuack<Integer>();
        slq.addHead(1);
        slq.addHead(2);
        slq.addTail(3);
        slq.addTail(4);
        System.out.println(slq.popHead());
        System.out.println(slq.popHead());
        System.out.println(slq.popTail());
        System.out.println(slq.popTail());
        System.out.println(slq.popTail());
        System.out.println(slq.popHead());
        slq.addTail(5);
        System.out.println(slq.popHead());

    }
}
