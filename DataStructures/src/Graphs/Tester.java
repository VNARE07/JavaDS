package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Graph<Integer> graph = new UndirectedGraph<Integer>();
        List<AdjNode<Integer>> list = new ArrayList<AdjNode<Integer>>();
        AdjNode<Integer> adj = new AdjNode<Integer>(1,2);
        list.add(adj);
        adj = new AdjNode<Integer>(2,3);
        list.add(adj);
        adj = new AdjNode<Integer>(1,4);
        list.add(adj);
        adj = new AdjNode<Integer>(2,4);
        list.add(adj);
        graph.createGraph(list);
        graph.DFS(1);
    }
}
