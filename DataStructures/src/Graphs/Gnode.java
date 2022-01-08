package Graphs;

public class Gnode<T extends Comparable<T>> {
    T p = null;
    T c;
    public Gnode(T c,T p) {
        this.p = p;
        this.c = c;
    }
    public T getP() { return p; }
    public T getC() { return c; }
}
