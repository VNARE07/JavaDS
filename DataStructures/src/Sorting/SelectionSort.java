package Sorting;

import java.util.ArrayList;
import java.util.Collection;

import TreeCollection.GenericComparator;


public class SelectionSort<T extends Comparable<T>> {
    ArrayList<T> array;
    GenericComparator gc = new GenericComparator();
    public SelectionSort(Collection<T> list){
        this.array = new ArrayList<T>(list);
    }
    public void sort(){
        T min;
        int pos;
        for (int i = 0; i < this.array.size(); i++){
            min = this.array.get(i);
            pos = i;
            for (int j = i; j < this.array.size(); j++){
                System.out.println(min + " " + this.array.get(j));
                if (gc.comparevalues(min,this.array.get(j)) > 0){
                    min = this.array.get(j);
                    pos = j;
                }
            }
            System.out.println("index " + i + " min "+min);
            this.swap(i,pos);
            System.out.println(this.array);
        }
    }
    private void swap(int i, int j) {
        T v1 = this.array.get(i);
        T v2 = this.array.get(j);
        this.array.set(j,v1);
        this.array.set(i,v2);
    }
    public void display(){
        System.out.println(this.array);
    }
}
