package Sorting;

import java.util.ArrayList;

public class BubbleSortTest {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.add(2);
        // BubbleSort<Integer> bs = new BubbleSort<Integer>(a);
        // bs.sort();
        // bs.display();
        SelectionSort<Integer> ss = new SelectionSort<Integer>(a);
        ss.sort();
        ss.display();
    }
}
