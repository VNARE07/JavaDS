package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Graph<T> {
    public void addGraph(Graph<T> graph);
    public void removeGraph(Graph<T> graph);
    public void addEdge(T s,T e,double weight);
    public void createGraph(List<T> elist,List<Double> weights);
    public void DFS(T start);
    public HashMap<T, ArrayList<Edge<T>>> getGraph();
    public ArrayList<T> ShortestPath(T source,T destination);
}
