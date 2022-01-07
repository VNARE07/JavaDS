package Sorting;

import java.util.ArrayList;
import java.util.Collection;

import StackCollections.Node;
import StackCollections.SinglyLinkedStack;
import TreeCollection.GenericComparator;

public class MergeSortIterative<T extends Comparable<T>> {
    ArrayList<Integer> alist;
    GenericComparator gc = new GenericComparator();
    public MergeSortIterative(Collection<Integer> list){
        this.alist = new ArrayList<Integer>(list);
    }
    public void sort(){
        SinglyLinkedStack<String> stack = new SinglyLinkedStack<String>();
        int l = alist.size()-1;
        String inp = "0," + l;
        Node<String> tn = new Node<String>(inp,"ud");
        stack.add(tn);
        String s;
        while (true){
            tn = stack.popNode();
            System.out.println(tn);
            if (tn == null){
                break;
            }
            else{
                inp = tn.data;
                s = tn.status;
                // int start = Integer.parseInt(inp.substring(0, 1));
                // int end = Integer.parseInt(inp.substring(2));
                String[] tokens = inp.split(",");
                int[] nums = new int[tokens.length];
                for(int x=0; x<tokens.length; x++)
                    nums[x] = Integer.parseInt(tokens[x]);
                int start = nums[0];
                int end = nums[1];
                int dif = end - start;
                if (s.equals("ud")){
                    stack.add(inp,"d");
                    if (dif <= 1){
                        // System.out.println(start + " " + end);
                    }
                    else{
                        int mid = end - start;
                        mid = mid / 2;
                        mid = start + mid;
                        inp = Integer.toString(mid+1) + "," + Integer.toString(end);
                        stack.add(inp,"ud");
                        inp = Integer.toString(start) + "," + Integer.toString(mid);
                        stack.add(inp,"ud");
                    }
                }
                else{
                    int total = end - start + 1;
                    int count = 0;
                    if (dif == 0){
                        // System.out.println(start + " " + end);
                    }
                    else{
                        ArrayList<Integer> l1 = new ArrayList<Integer>();
                        int mid = end - start;
                        mid = mid / 2;	
                        mid = start + mid;
                        int lstart,lend,rstart,rend;
                        lstart = start;
                        lend = mid;
                        rstart = mid + 1;
                        rend = end;
                        int k = lstart;
                        System.out.println(lstart + " " + rend);
                        // System.out.println(lstart + " " + lend + " " + rstart + " " + rend + " " +total);
                        for (int i = 0; i <= total;i++ ){
                            if ((lstart <= lend) && (rstart <= rend)){
                                if (alist.get(lstart) <= alist.get(rstart)){
                                    l1.add(alist.get(lstart));
                                    lstart = lstart + 1;
                                }
                                else{
                                    l1.add(alist.get(rstart));
                                    rstart = rstart + 1;
                                }
                            }
                            else if ((lstart > lend) && (rstart <= rend)){
                                l1.add(alist.get(rstart));
                                rstart = rstart + 1;
                            }
                            else if ((lstart <= lend) && (rstart > rend)){
                                l1.add(alist.get(lstart));
                                lstart = lstart + 1;
                            }
                        }
                        count = 0;
                        //System.out.println("this is l1 "+l1);
                        for (int i = k; i <= rend;i++){
                            alist.set(i,l1.get(count));
                            count = count + 1;
                        }
                        // System.out.println("this is alist " + alist);
                    }
                }
            }
        }
    }
}
