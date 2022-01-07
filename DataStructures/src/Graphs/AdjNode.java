package Graphs;

public class AdjNode<T> {
    T d,e;
    public AdjNode(T d,T e) {
        this.d = d;
        this.e = e;
    }
    public T getD() {
        return this.d;
    }
    public T getE() {
        return this.e;
    }   
}
