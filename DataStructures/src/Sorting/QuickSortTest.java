package Sorting;

import java.util.ArrayList;

public class QuickSortTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(5);
        QuickSort<Integer> qs = new QuickSort<Integer>(list);
        System.out.println(qs.array);
    }
}
