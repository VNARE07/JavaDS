package SegmentTrees;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(9);
        list.add(3);
        list.add(40);  
        MinSegmentTree<Integer> tree = new MinSegmentTree(list);
        System.out.println(tree.getMin(0,3));
    }
}
