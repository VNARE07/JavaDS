package TreeCollection;

import java.util.ArrayList;
import java.util.HashMap;

import EhnancedQueCollection.SLQue;
import QueCollections.SinglylinkedQue;
import StackLL.Node;
import StackLL.Stack;

public class BST<T extends Comparable<T>> implements Tree<T> {
    TNode<T> root;
    GenericComparator<T> gc = new GenericComparator<T>();
    public BST(T value) {
        TNode<T> node = new BTNode<T>(value);
        this.root = node;
    }
    public BST() {
        this.root = null;
    }
    @Override
    public void add(T value) {
        // TODO Auto-generated method stub
        TNode<T> node = new BTNode<T>(value);
        if (root == null) {
            this.root = node;
        }
        else{
            this.insert(node);
        }
    }

    private void insert(TNode<T> node) {
        TNode<T> cur,left,right;
        cur = this.root;
        while (true){
            if (cur == null){
                break;
            }
            else{
                int comp = gc.comparevalues(cur.data,node.data);
                if (comp == -1 || comp == 0){
                    right = cur.right;
                    if (right == null){
                        cur.right = node;
                        break;
                    }
                    else{
                        cur = cur.right;

                    }
                }
                else if (comp == 1){
                    left = cur.left;
                    if (left == null){
                        cur.left = node;
                        break;
                    }
                    else{
                        cur = cur.left;
                    }
                }
            }
        }
    }
    @Override
    public TNode<T> remove(T target) {
        // TODO Auto-generated method stub
        TNode<T> par,match,node,succ;
        par = null;
        match = null;
        node = this.root;
        while (true){
            if (node == null){
                break;
            }
            else{
                if (gc.comparevalues(node.data,target) < 0){
                    par = node;
                    node = node.right;
                }
                else if (gc.comparevalues(node.data,target) > 0){
                    par = node;
                    node = node.left;
                }
                else{
                    match = node;
                    break;
                }
            }
        }
        if (match == null){
            System.out.println("node not found");
            return null;
        }
        else{
            if (par == null){
                if ((match.left != null) && (match.right != null)){
                    succ = this.findinorderpredessor(match.left,match);
                    succ.left = match.left;
                    succ.right = match.right;
                    this.root = succ;
                }
                else if ((match.left != null) || (match.right != null)){
                    if (match.left == null){
                        this.root = match.right;
                    }
                    else{
                        this.root = match.left;
                    }
                }
                else{
                    this.root = null;
                }
            }
            else{
                System.out.println("par " + par.toString() + " child " + match.toString());
                if ((match.left != null) && (match.right != null)){
                    succ = this.findinorderpredessor(match.left,match);
                    System.out.println("succ " + succ.toString() + " match " + match.toString() + " par " + par.toString());
                    if (succ.left == null){
                        succ.left = match.left;
                    }
                    succ.right = match.right;
                    if (par.left == match){
                        par.left = succ;
                    }
                    else{
                        par.right = succ;
                    }
                }
                else if ((match.left != null) || (match.right != null)){
                    System.out.println("in filled");
                    if (match.left == null){
                        if (par.left == match){
                            par.left = match.right;
                        }
                        else{
                            par.right = match.left;
                        }
                    }
                    else{
                        if (par.left == match){
                            par.left = match.left;
                        }
                        else{
                            par.right = match.left;
                        }
                    }
                }
                else{
                    if (par.left == match){
                        par.left = null;
                    }
                    else{
                        par.right = null;
                    }
                    System.out.println("done");
                }
            }
            return null;
        }
    }

    private TNode<T> findinorderpredessor(TNode<T> match,TNode<T> mp) {
        Stack<TNode<T>> stack = new Stack<TNode<T>>();
        stack.add(match,"ud");
        HashMap<TNode<T>,TNode<T>> map = new HashMap<TNode<T>,TNode<T>>();
        map.put(match,mp);
        Node<TNode<T>> head;
        TNode<T> node,succ,par,nex;
        nex = null;
        String status;
        succ = null;
        while (true){
            head = stack.pop();
            if (head == null){
                break;
            }
            else{
                node = head.data;
                status = head.status;
                if (status.equals("ud")){
                    if (node.right != null){
                        stack.add(node.right,"ud");
                        // System.out.println("child " + node.right.toString() + " parent " + node.toString());
                        map.put(node.right, node);
                    }
                    stack.add(node,"d");
                    if (node.left != null){
                        stack.add(node.left,"ud");
                        // System.out.println("child " + node.left.toString() + " parent " + node.toString());
                        map.put(node.left, node);
                    }
                }
                else{
                    succ = node;
                }
            }
        }
        System.out.println("succ "+succ.toString());
        par = map.get(succ);
        System.out.println("par "+par.toString());
        if (par.left == succ){
            System.out.println("child removed");
            par.left = null;
            System.out.println(par.left);
        }
        if (par.right == succ){
            par.right = null;
        }
        return succ;
    }
    @Override
    public boolean search(T target) {
        // TODO Auto-generated method stub
        TNode<T> cur;
        cur = this.root;
        while (true){
            if (cur == null){
                break;
            }
            else{
                int comp = gc.comparevalues(cur.data,target);
                if (comp == -1){
                    cur = cur.right;
                }
                else if (comp == 1){
                    cur = cur.left;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public TNode<T> getRoot() {
        // TODO Auto-generated method stub
        return this.root;
    }
    // inorder
    @Override
    public void Triverse(TNode<T> root) {
        // TODO Auto-generated method stub
        if (root.left != null){
            this.Triverse(root.left);
        }
        System.out.println(root);
        if (root.right != null){
            this.Triverse(root.right);
        }
    }
    public void postOrder(TNode<T> root) {
        // TODO Auto-generated method stub
        if (root.left != null){
            this.postOrder(root.left);
        }
        if (root.right != null){
            this.postOrder(root.right);
        }
        System.out.println(root);
    }
    public void levelOrder(TNode<T> root){
        SLQue<TNode<T>> q = new SLQue<TNode<T>>();
        q.add(root);
        TNode<T> head;
        while (true){
            head = q.pop();
            if (head == null){
                break;
            }
            else{
                System.out.println(head.data);
                if (root.left != null){
                    q.add(root.left);
                }
                else{
                    q.add(root.right);
                }
            }
        }
    }
}
