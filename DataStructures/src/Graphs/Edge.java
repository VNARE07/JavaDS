package Graphs;
public class Edge<T> {
    T node;
    double weight;
    public Edge(T e,double weight){
        this.node = e;
        this.weight = weight;
    }
    public T getNode(){
        return this.node;
    }
    public double getWeight(){
        return this.weight;
    }
    public String toString(){
        return "Edge<T> " + this.node + " weight=" + this.weight;
    }   
}
