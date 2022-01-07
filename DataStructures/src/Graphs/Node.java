package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    T data;
    List<T> adjlist = new ArrayList<T>();
    public Node(T data,T neibours) {
        this.data = data;
        adjlist.add(neibours);
    } 
}
