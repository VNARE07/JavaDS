package TreeCollection;

public class BinaryTreeTester {
    public static void main(String[] args) {
        Tree<Integer> bt = new BinaryTree<Integer>(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.Triverse(bt.getRoot());
        System.out.println("triverse complete");
        System.out.println(bt.search(3));
        System.out.println("search complete");
        System.out.println(bt.remove(2));
        System.out.println("new");
        bt.Triverse(bt.getRoot());
    }
}
