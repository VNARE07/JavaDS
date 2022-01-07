package TreeCollection;

public class BSTTester {
    public static void main(String[] args) {
        Tree<Integer> bst = new BST<Integer>(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(0);
        bst.Triverse(bst.getRoot());
        System.out.println("remove");
        bst.remove(2);
        bst.remove(1);
        bst.remove(4);
        System.out.println("remove complete"); 
        System.out.println(bst.getRoot());
        System.out.println("triversal after removoing");
        bst.Triverse(bst.getRoot());
    }
}
