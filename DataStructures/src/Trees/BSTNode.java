package Trees;

public class BSTNode<T> extends BTNode<T> {
    T data;
    BSTNode<T> left,right;
    public BSTNode(T data) {
        super(data);
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public String toString(){
        if (data == null){
            return "";
        }
        return "" + this.data + "" + "in BSTNode";
    }
}
