package SegmentTrees;

public class SegNode<T> {
    Integer start,end;
    T min;
    SegNode<T> left,right;
    public SegNode(Integer start,Integer end,T min){
        this.start = start;
        this.end = end;
        this.min = min;
        this.left = null;
        this.right = null;
    }
    public SegNode(Integer start,Integer end){
        this.start = start;
        this.end = end;
        this.min = null;
        this.left = null;
        this.right = null;
    }
    public void setMin(T min){
        this.min = min;
    }
    public T getMin() {
        return this.min;
    }
    public void setStart(Integer start){
        this.start = start;
    }
    public void setEnd(Integer end){
        this.end = end;
    }
    public Integer getStart() {
        return this.start;
    }
    public Integer getEnd() {
        return this.end;
    }
    public String toString() {
        return "(" + this.start + "," + this.end + ")" + " = " + this.min;
    }
}
