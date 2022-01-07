package Trees;

public class BinaryTreeTester {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
        bt.add(1,2);
        bt.add(1,3);
        bt.add(2,4);
        System.out.println(bt.root);
        System.out.println(bt.root.left);
        System.out.println("print");
        bt.Triverse(bt.root);
    }
}
