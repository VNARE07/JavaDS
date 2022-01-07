package QueCollections;

public class testque {
    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(1);
        SinglylinkedQue<Integer> slq = new SinglylinkedQue<Integer>(node);
        node = new Node<Integer>(2);
        slq.add(node);
        int val;
        val = slq.pop();
        System.out.println(val);
    }
}
