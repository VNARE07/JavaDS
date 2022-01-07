package Sorting;
import java.util.ArrayList;
import java.util.Collection;
import TreeCollection.GenericComparator;

public class BubbleSort<T extends Comparable<T>>{
    ArrayList<T> array;
    GenericComparator<T> gc = new GenericComparator<T>();
    public BubbleSort(Collection<T> list){
        this.array = new ArrayList<T>(list);
    }
    public void sort(){
        for (int i = 0; i < array.size()-1; ++i){
            for (int j = 0; j < array.size()-1; ++j){
                if (gc.comparevalues(array.get(j), array.get(j+1)) > 0){
                    this.swap(j,j+1);
                }
            }
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
