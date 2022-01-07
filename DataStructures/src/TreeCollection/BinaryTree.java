package TreeCollection;
import java.util.ArrayList;
import java.util.HashMap;

import EhnancedQueCollection.SLQue;
import StackLL.Node;
import StackLL.Stack;

public class BinaryTree<T extends Comparable<T>> implements Tree<T>{
    TNode<T> root;
    GenericComparator<T> gc = new GenericComparator<T>();
    public BinaryTree(T value){
        this.root = new BTNode<T>(value);
    }
    
    public BinaryTree(){
        this.root = null;
    }
    @Override
    public void add(T value) {
        // TODO Auto-generated method stub\
        TNode<T> node = new BTNode<T>(value);
        System.out.println("in add");
        if (this.root == null){
            this.root = node;
        }
        else{
            TNode<T> cur = this.root;
            SLQue<TNode<T>> que = new SLQue<TNode<T>>(cur);
            while (true){
                cur = que.pop();
                if (cur == null){
                    break;
                }
                else{
                    if ((cur.left != null) && (cur.right != null)){
                        que.add(cur.left);
                        que.add(cur.right);
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
            }
        }
    }
    @Override
    public TNode<T> remove(T value) {
        // TODO Auto-generated method stub
        Stack<TNode<T>> stack = new Stack<TNode<T>>();
        Stack<TNode<T>> upnodes = new Stack<TNode<T>>();
        stack.add(this.root,"ud");
        Node<TNode<T>> head,p;
        TNode<T> node,par,match;
        par = null;
        match = null;
        String status;
        while (true){
            head = stack.pop();
            if (head == null){
                break;
            }
            else{
                node = head.data;
                status = head.status;
                if (gc.compare(node.data,value)){
                    System.out.println("matched in remove");
                    match = node;
                    System.out.println("node matched " + match.toString());
                    p = upnodes.pop();
                    System.out.println(p);
                    par = p.data;
                    System.out.println("parent node " + par.toString());
                    break;
                }
                if (status.equals("ud")){
                    upnodes.add(node);
                    stack.add(node,"d");
                    if (node.right != null){
                        stack.add(node.right,"ud");
                    }
                    if (node.left != null){
                        stack.add(node.left,"ud");
                    }
                }
                else{
                    upnodes.pop();
                }
            }
        }
        if (match != null){
            if (par == null){
                TNode<T> succ;
                if ((match.left != null) && (match.right != null)){
                    succ = this.inorderSuccor(match);
                    succ.left = match.left;
                    succ.right = match.right;
                }
                else if ((match.left == null) || (match.right != null)){
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
                TNode<T> succ;
                if ((match.left != null) && (match.right != null)){
                    succ = this.inorderSuccor(match);
                    System.out.println("in order succ " + succ.toString());
                    succ.left = match.left;
                    succ.right = match.right;
                    if (par.left == match){
                        System.out.println("node removed and " + succ.toString() + " placaed" + " par " + par.toString());
                        par.left = succ;
                        System.out.println("test");
                        System.out.println("solve this + " + par.left.toString());
                    }
                    else{
                        par.right = succ;
                    }
                }
                else if ((match.left != null) || (match.right != null)){
                    if (match.left == null){
                        if (par.left == match){
                            par.left = match.right;
                        }
                        else{
                            par.right = match.right;
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
                    this.root = null;
                }
            }
            return match;
        }
        return null;
    }
    private TNode<T> inorderSuccor(TNode<T> match) {
        Stack<TNode<T>> stack = new Stack<TNode<T>>();
        stack.add(match,"ud");
        HashMap<TNode<T>,TNode<T>> map = new HashMap<TNode<T>,TNode<T>>();
        Node<TNode<T>> head;
        TNode<T> node,succ,par,nex;
        String status;
        succ = null;
        nex = null;
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
                        System.out.println("child " + node.right.toString() + " parent " + node.toString());
                        map.put(node.right, node);
                    }
                    stack.add(node,"d");
                    if (node.left != null){
                        stack.add(node.left,"ud");
                        System.out.println("child " + node.left.toString() + " parent " + node.toString());
                        map.put(node.left, node);
                    }
                }
                else{
                    succ = nex;
                    nex = node;
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
        TNode<T> cur = this.root;
        SLQue<TNode<T>> q = new SLQue<TNode<T>>(cur);
        while (true){
            cur = q.pop();
            System.out.println("in serach node value " + cur);
            if (cur == null){
                break;
            }
            else{
                System.out.println("in serach node value " + cur.data);
                T nodedata = cur.data;
                System.out.println(nodedata);
                if (gc.compare(nodedata,target)){
                    return true;
                }
                if (cur.left != null){
                    q.add(cur.left);
                }
                if (cur.right != null){
                    q.add(cur.right);
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
    @Override
    public void Triverse(TNode<T> node) {
        // TODO Auto-generated method stub
        if (node.left != null){
            this.Triverse(node.left);
        }
        System.out.println(node);
        if (node.right != null) {
            this.Triverse(node.right);
        }   
    }
}
