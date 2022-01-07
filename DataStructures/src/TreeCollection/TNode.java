package TreeCollection;

import java.util.ArrayList;

public class TNode<T> {
    T data;
    TNode<T> left,right;
    ArrayList<TNode<T>> nary;
    public TNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public TNode(){
    }
    public String toString(){
        if (this.data != null){
            return "TNode{ " + this.data + " }";
        }
        else{
            return "TNode{ " + "null" + " }";
        }
    }
}
