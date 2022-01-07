package Trees;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    BTNode<T> root;
    GenericComparator<T> genericcomparator = new GenericComparator<T>();
    public BinaryTree(T data){
        root = new BSTNode(data);
        System.out.println(root);
    }
    public BinaryTree(){
        root = null;
    }
    public void Triverse(BTNode<T> root){
        if (root.left != null){
            this.Triverse(root.left);
        }
        System.out.println(root.data);
        if (root.right != null){
            this.Triverse(root.right);
        }
    }
    @Override
    public void add(T parent,T value) {
        // TODO Auto-generated method stub
        BTNode<T> cur,node;
        cur = this.root;
        node = new BSTNode(value);
        if (this.root == null) {
            this.root = node;
        }
        else{
            System.out.println("New add method " + "parent " + parent + " child " + value);
            ArrayList<BTNode<T>> Stack = new ArrayList<BTNode<T>>();
            cur = this.root;
            Stack.add(cur);
            while (true){
                System.out.println(Stack);
                cur = Stack.remove(Stack.size()-1);
                System.out.println("in while loop current node cur " + cur);
                if (cur == null){
                    break;
                }
                else{
                    System.out.println("in else " + cur.data + " " + parent );
                    System.out.println("compare gc" + genericcomparator.compare(cur.data, parent));
                    if (genericcomparator.compare(cur.data, parent)){
                        System.out.println("condition matched");
                        if ((cur.left != null) && (cur.right != null)){
                            System.out.println("both child filled");
                            if (cur.left != null){
                                Stack.add(cur.left);
                            }
                            if (cur.right != null){
                                Stack.add(cur.right);
                            }
                        }
                        else{
                            if (cur.left == null){
                                cur.left = node;
                                break;
                            }
                            else{
                                cur.right = node;
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("match failed");
                        if (cur.left != null){
                            Stack.add(cur.left);
                        }
                        if (cur.right != null){
                            Stack.add(cur.right);
                        }
                    }
                }
            }
        }
    }
    @Override
    public T remove(BTNode<T> node) {
        // TODO Auto-generated method stub
        return null;
    }
}
