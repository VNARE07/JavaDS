package Searching;

public class LinearSearch {
    public boolean search(int[] list,int target){
        for (int i = 0; i < list.length; i++){
            if (list[i] == target){
                return true;
            }
        }
        return false;
    }
}
