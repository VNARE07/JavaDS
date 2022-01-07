package Searching;

import CollectionTest.Collection;

public class BinarySearch {
    public boolean search(int[] list,int target){
        int end = list.length - 1;
        int start,mid;
        start = 0;
        while (true){
            if (end - start == 1){
                if (list[start] == target){
                    return true;
                }
                if (list[end] == target){
                    return true;
                }
                break;
            }
            else{
                mid = end - start;
                mid = mid / 2;
                mid = mid + start;
                if (list[mid] == target){
                    return true;
                }
                else if (target > list[mid]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        return false;
    }
}
