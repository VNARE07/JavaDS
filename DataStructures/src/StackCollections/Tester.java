package StackCollections;

public class Tester {
    public static void main(String[] args) {
        SinglyLinkedStack<String> sls = new SinglyLinkedStack<String>();
        Node<String> node = new Node<String>("A");
        sls.add(node);
        node = new Node<String>("B");
        sls.add(node);
        String str1;
        while (true){
            str1 = sls.pop();
            if (node == null){
                break;
            }
            else{
                System.out.println(node.data);
            }
        }
    }
}
