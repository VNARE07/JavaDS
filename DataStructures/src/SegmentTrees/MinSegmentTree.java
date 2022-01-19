package SegmentTrees;

import java.util.ArrayList;
import java.util.Collection;

public class MinSegmentTree<T extends Comparable<T>> implements SegmentTrees<T>{
    SegNode<T> root;
    ArrayList<T> l;
    GenericComparator<T> gc = new GenericComparator<T>();
    Integer limit;
    public MinSegmentTree(Collection<T> list){
        this.create(list);
    }
    public MinSegmentTree(){
        this.root = null;
    }
    @Override
    public void create(Collection<T> list) {
        // TODO Auto-generated method stub
        this.l = new ArrayList<T>(list);
        this.limit = this.l.size()-1;
        Integer lim = l.size()-1;
        this.root = this.helper(0,lim);
        this.triverse(this.root);
        System.out.println("Triverse done");
        System.out.println(this.root);
    }

    public void triverse(SegNode<T> node) {
        System.out.println(node);
        if (node.left != null){
            this.triverse(node.left);
        }
        if (node.right != null){
            this.triverse(node.right);
        }
    }
    public SegNode<T> helper(Integer start, Integer end) {
        SegNode<T> left;
        SegNode<T> right;
        if (end - start == 0){
            left = null;
            right = null;
        }
        else{
            Integer mid = end - start;
            mid = mid / 2;
            mid = start + mid;
            left = this.helper(start, mid);
            right = this.helper(mid + 1, end);
        }
        if (left == null && right == null){
            SegNode<T> node = new SegNode<T>(start, end,this.l.get(start));
            node.left = left;
            node.right = right;
            return node;
        }
        else{
            T min1 = gc.getMinValue(left.getMin(), right.getMin());
            SegNode<T> node = new SegNode<T>(start, end,min1);
            node.left = left;
            node.right = right;
            return node;   
        }
    }
    @Override
    public T getMin(Integer start, Integer end) {
        // TODO Auto-generated method stub
        System.out.println("min subroutine started");
        SegNode<T> node = this.root;
        if (node.getStart() <= start && node.getEnd() >= end){
            T min1 = this.minHelper(start,end,node);
            return min1;
        }
        else{
            System.out.println("range out of range");
            return null;
        }
    }

    public T minHelper(Integer start, Integer end,SegNode<T> node) {
        T min1 = null;
        T left,right;
        System.out.println(node);
        Integer curstart = node.getStart();
        Integer curend = node.getEnd();
        if (start <= curstart && end >= curend) {
            System.out.println("value considerd = " + node.getMin());
            return node.getMin();
        }
        else if (curend < start){
            return null;
        }
        else if (end < curstart){
            return null;
        }
        else{
            if (node.left != null){
                left = this.minHelper(start, end,node.left);
            }
            else{
                left = null;
            }
            if (node.right != null){
                right = this.minHelper(start, end,node.right);
            }
            else{
                right = null;
            }
        }
        if (left == null && right == null){
            return null;
        }
        else if (left != null && right != null){
            min1 = gc.getMinValue(left,right);
        }
        else{
            if (left == null){
                min1 = right;
            }
            else{
                min1 = left;
            }
        }
        return min1;
    }
    @Override
    public SegNode<T> getRoot() {
        // TODO Auto-generated method stub
        return this.root;
    }
    
}
