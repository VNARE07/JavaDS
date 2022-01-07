package CollectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MapTester {
    public static void main(String[] args) {
        HashMap<Integer,ProductWithoutComparable> map = new HashMap<Integer,ProductWithoutComparable>();
        ProductWithoutComparable pwc;
        pwc = new ProductWithoutComparable(4,"a","abc");
        map.put(4, pwc);
        pwc = new ProductWithoutComparable(2,"a","abc");
        map.put(2, pwc);
        pwc = new ProductWithoutComparable(1,"a","abc");
        map.put(1, pwc);
        pwc = new ProductWithoutComparable(3,"a","abc");
        map.put(3, pwc);
        Collection<ProductWithoutComparable> values = map.values();
        // this map.values retunrns a colection not a set or any other thing
        // so now we can convert a collection into a arraylist beacuse array list has a constructors
        // which can convert any collection into an array list
        // and this same array list is reffered by a list of type ProductWithoutComparable 
        // now we can sort this collection by the comparator and compare method
        // note we can convert any collection into a list or arraylist using array list constructor
        List<ProductWithoutComparable> list = new ArrayList<ProductWithoutComparable>(values);
        System.out.println("before removing 4");
        list.forEach(i -> System.out.println(i.toString()));
        Iterator<ProductWithoutComparable> iterator = values.iterator();
        while (iterator.hasNext()){
            pwc = iterator.next();
            if (pwc.id == 4){
                iterator.remove();
            }
        } 
        System.out.println("aftwer deketing 4");
        values = map.values();
        list = new ArrayList<ProductWithoutComparable>(values);
        Set<Integer> set = map.keySet();
        List<Integer> list1 = new ArrayList<Integer>(set);
        Comparator<ProductWithoutComparable> sortbyid;
        sortbyid = new Comparator<ProductWithoutComparable>(){
            @Override
            public int compare(ProductWithoutComparable o1, ProductWithoutComparable o2) {
                // TODO Auto-generated method stub
                Integer id1,id2;
                id1 = o1.getId();
                id2 = o2.getId();
                return id1.compareTo(id2);
            }
        };
        Collections.sort(list,sortbyid);
        Collections.sort(list1);
        for (int i = 0; i < list.size(); i++) {
            pwc = list.get(i);
            System.out.println(list1.get(i) + "sorted list1");
            System.out.println(pwc.toString());
        }
    }
}
