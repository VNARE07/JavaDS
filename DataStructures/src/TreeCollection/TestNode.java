package TreeCollection;

public class TestNode<T> {
    T data,parent;
    String status;
    public TestNode(T parent,T data,String status) {
        this.data = data;
        this.parent = parent;
        this.status = status;
    }
    public TestNode(T data,String status) {
        this.data = data;
        this.status = status;
    }
    public TestNode(T data) {
        this.data = data;
    }
}
