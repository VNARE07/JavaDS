package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Graph<Integer> graph = new UndirectedGraph<Integer>();
        ArrayList<Integer> elist = new ArrayList<Integer>();
        ArrayList<Double> weights = new ArrayList<Double>();
        elist.add(1);
        elist.add(2);
        elist.add(3);
        elist.add(4);
        elist.add(1);
        elist.add(5);
        elist.add(2);
        elist.add(3);
        elist.add(5);
        elist.add(8);
        elist.add(2);
        elist.add(5);
        elist.add(7);
        elist.add(10);
        weights.add(2.0);
        weights.add(3.0);
        weights.add(4.0);
        weights.add(5.0);
        weights.add(6.0);
        weights.add(1.0);
        weights.add(7.0);
        graph.createGraph(elist, weights);
        graph.DFS(1);
        System.out.println(graph.ShortestPath(1,10));
    }
}
