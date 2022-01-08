package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Heaps.Heap;
import Heaps.MinHeap;
import Heaps.Node;
import TreeCollection.GenericComparator;

public class UndirectedGraph<T extends Comparable<T>> implements Graph<T> {
    HashMap<T,ArrayList<Edge<T>>> graph = new HashMap<T,ArrayList<Edge<T>>>();
    GenericComparator<T> gc = new GenericComparator<T>();
    public UndirectedGraph(Graph<T> graph) {
        this.graph = graph.getGraph();
    }
    public UndirectedGraph(){
    }
    @Override
    public void addGraph(Graph<T> graph) {
        // TODO Auto-generated method stub
        System.out.println("to do");
    }

    @Override
    public void removeGraph(Graph<T> graph) {
        // TODO Auto-generated method stub
        System.out.println("to do");
    }

    @Override
    public void addEdge(T s, T e,double weight) {
        // TODO Auto-generated method stub
        if (this.graph.containsKey(s)){
            ArrayList<Edge<T>> edges = this.graph.get(s);
            edges.add(new Edge<T>(e, weight));
        }
        else{
            ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
            edges.add(new Edge<T>(e, weight));
            this.graph.put(s, edges);
        }
        if (this.graph.containsKey(e)){
            ArrayList<Edge<T>> edges = this.graph.get(e);
            edges.add(new Edge<T>(s, weight));
        }
        else{
            ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
            edges.add(new Edge<T>(s, weight));
            this.graph.put(e, edges);
        }
    }


    @Override
    public void DFS(T start) {
        // TODO Auto-generated method stub
        System.out.println(graph);
        HashMap<T,Boolean> done = new HashMap<T,Boolean>();
        ArrayList<T> stack = new ArrayList<T>();
        T head,node;
        Edge<T> edge;
        stack.add(start);
        while (true){
            if (stack.size() == 0){
                break;
            }
            else{
                head = stack.remove(stack.size() - 1);
                done.put(head, true);
                System.out.println(head);
                ArrayList<Edge<T>> edges = this.graph.get(head);
                for (int i = 0; i < edges.size(); i++){
                    edge = edges.get(i);
                    node = edge.getNode();
                    if (!done.containsKey(node)){
                        stack.add(node);
                        done.put(node, true);
                    }
                }   
            }
        }
    }

    @Override
    public void createGraph(List<T> elist,List<Double> weights) {
        // TODO Auto-generated method stub
        int start = 0;
        int count = 0;
        int lim = elist.size()-1;
        T s,e;
        double weight;
        while (true){
            if (start > lim){
                break;
            }
            else{
                s = elist.get(start);
                e = elist.get(start+1);
                weight = weights.get(count);
                count = count + 1;
                start = start + 2;
                this.addEdge(s, e, weight);
            }
        }
        
    }
    @Override
    public HashMap<T, ArrayList<Edge<T>>> getGraph() {
        // TODO Auto-generated method stub
        return this.graph;
    }
    public ArrayList<T> ShortestPath(T s,T d){
        HashMap<T,Double> distance = new HashMap<T,Double>();
        ArrayList<T> keys = new ArrayList<T>(this.graph.keySet());
        HashMap<T,Boolean> done = new HashMap<T,Boolean>();
        MinHeap<Double,Gnode<T>> minHeap = new MinHeap<Double,Gnode<T>>(0.0,new Gnode<T>(s,null));
        Node<Double,Gnode<T>> head;
        Double wei,cwei;
        Gnode<T> gnode;
        T node,child,nex,p;
        Edge<T> edge;
        ArrayList<Edge<T>> edges;
        ArrayList<T> path = new ArrayList<T>();
        HashMap<T,T> par = new HashMap<T,T>(); 
        for (int i = 0; i < keys.size(); i++){
            distance.put(keys.get(i),-1.0);
        }
        while (true){
            head = minHeap.remove();
            System.out.println(head);
            if (head == null){
                break;
            }
            else{
                gnode = head.getValue();
                node = gnode.getC();
                p = gnode.getP();
                wei = head.getKey();
                System.out.println(node + ": " +wei);
                if (!done.containsKey(node)){
                    done.put(node, true);
                    edges = this.graph.get(node);
                    distance.put(node,wei);
                    par.put(node,p);
                    for (int i = 0; i <  edges.size(); i++){
                        edge = edges.get(i);
                        child = edge.getNode();
                        cwei = edge.getWeight();
                        if (!done.containsKey(child)){
                            minHeap.put(wei+cwei,new Gnode<T>(child,node));
                        }
                    }
                }
            }
        }
        System.out.println(distance);
        System.out.println(par);
        if (distance.containsKey(d)){
            if (distance.get(d) == -1.0){
                System.out.println("no path exists");
                return null;
            }
            node = d;
            while (true){
                if (node == null){
                    break;
                }
                else{
                    path.add(node);
                    node = par.get(node);
                }
            }
            return path;
        }
        else{
            System.out.println("no path exists");
        }
        return null;
    }
}    
