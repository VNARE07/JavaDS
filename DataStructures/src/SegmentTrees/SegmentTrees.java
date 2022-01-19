package SegmentTrees;

import java.util.Collection;

public interface SegmentTrees<T extends Comparable<T>>{
    public void create(Collection<T> list);
    public T getMin(Integer start, Integer end);
    public SegNode<T> getRoot();
}
