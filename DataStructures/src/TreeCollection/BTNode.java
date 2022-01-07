package TreeCollection;

public class BTNode<T> extends TNode<T> {
    T data;
    BTNode<T> left,right;
    public BTNode(T data){
        super(data);
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public String toString(){
        return "BTNode{ " + this.data + " }";
    }
}
