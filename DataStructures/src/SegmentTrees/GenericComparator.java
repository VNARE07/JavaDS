package SegmentTrees;

public class GenericComparator<T extends Comparable<T>> {
    public T getMinValue(T v1,T v2){
        if (v1.compareTo(v2) <= 0){
            return v1;
        }
        return v2;
    }
}
