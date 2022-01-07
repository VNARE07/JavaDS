package Sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import StackLL.Node;
import StackLL.Stack;
import TreeCollection.GenericComparator;

public class QuickSort<T extends Comparable<T>>{
    ArrayList<T> array;
    GenericComparator<T> gc = new GenericComparator<T>();
    public QuickSort(Collection<T> list){
        array = new ArrayList(list);
        T p;
        if (this.array.size() == 0){
            p = null;
        }
        else{
            p = this.array.get(this.array.size() - 1);
        }
        array = this.sort(p,this.array);
    }
    public ArrayList<T> sort(T p,ArrayList<T> list){
        if (list.size() <= 1){
            return list; 
        }
        else{
            ArrayList<T> left = new ArrayList<T>();
            ArrayList<T> right = new ArrayList<T>();
            for (int i = 0; i < list.size() - 1; i++){
                if (gc.comparevalues(list.get(i),p) >= 0){
                    right.add(list.get(i));
                }
                else{
                    left.add(list.get(i));
                }
            }
            if (left.size() == 0){
                sort(null,left);
            }
            else{
                sort(left.get(left.size() - 1),left);
            }
            if (right.size() == 0){
                sort(null,right);
            }
            else{
                sort(right.get(right.size() - 1),right);
            }
            ArrayList<T> sorted = new ArrayList<T>(left);
            sorted.add(p);
            sorted.addAll(right);
            return sorted;
        }
    }
}
