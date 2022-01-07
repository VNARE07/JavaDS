package Trees;

import java.util.ArrayList;

public class BTNode<T>{
    T data;
    BTNode<T> right,left;
    ArrayList<BTNode<T>> children;
    public BTNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public BTNode(){
    }
}
