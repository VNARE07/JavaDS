package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import TreeCollection.GenericComparator;

public class UndirectedGraph<T extends Comparable<T>> implements Graph<T> {
    HashMap<T,ArrayList<T>> graph = new HashMap<T,ArrayList<T>>();
    GenericComparator<T> kc = new GenericComparator<T>();
    public UndirectedGraph() {

    }
    @Override
    public void addGraph(Graph<T> graph) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeGraph(Graph<T> graph) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addEdge(T s, T e) {
        // TODO Auto-generated method stub
        if (this.graph.containsKey(s)){
            boolean bol = true;
            for (T t : this.graph.get(s)){
                if (kc.comparevalues(t,e) == 0){
                    bol = false;
                }
            }
            if (bol){
                this.graph.get(s).add(e);
            }
        }   
        else{
            ArrayList al = new ArrayList<T>();
            al.add(e);
            this.graph.put(s,al);
        }
        if (!this.graph.containsKey(e)){
            ArrayList<T> al1 = new ArrayList<T>();
            this.graph.put(e,al1);
        }
    }

    @Override
    public void createGraph(List<AdjNode<T>> list) {
        // TODO Auto-generated method stub
        T s,e;
        for (int i = 0; i < list.size();i++){ 
            AdjNode<T> node = list.get(i);
            s = node.getD();
            e = node.getE();
            this.addEdge(s, e);
        }
    }
    public void DFS(T start){
        HashMap<T,Boolean> done = new HashMap<T,Boolean>();
        ArrayList<T> stack = new ArrayList<T>();
        stack.add(start);
        T data,nei;
        while (true){
            if (stack.size() == 0){
                break;
            }
            else{
                data = stack.remove(stack.size()-1);
                if (done.containsKey(data)){
                    System.out.println("node visited");
                }
                else{
                    System.out.println(data);
                    done.put(data,true);
                    ArrayList<T> al = this.graph.get(data);
                    for (int i = 0;i < this.graph.get(data).size();i++){
                        nei = al.get(i);
                        if (done.containsKey(nei)){
                            System.out.println("neibour is vsieted");
                        }
                        else{
                            stack.add(nei);
                            done.put(data,true);
                        }
                    }
                }
            }
        }
    }
    
}
