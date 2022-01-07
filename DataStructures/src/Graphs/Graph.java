package Graphs;

import java.util.List;

public interface Graph<T> {
    public void addGraph(Graph<T> graph);
    public void removeGraph(Graph<T> graph);
    public void addEdge(T s,T e);
    public void createGraph(List<AdjNode<T>> T);
    public void DFS(T start);
}
