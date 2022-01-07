package CollectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortListWithComparator {
    public static void main(String[] args) {
        ArrayList<ProductWithoutComparable> list = new ArrayList<ProductWithoutComparable>();
        ProductWithoutComparable pwc;
        pwc = new ProductWithoutComparable(4,"a","abc");
        list.add(pwc);
        pwc = new ProductWithoutComparable(2,"a","abc");
        list.add(pwc);
        pwc = new ProductWithoutComparable(1,"a","abc");
        list.add(pwc);
        pwc = new ProductWithoutComparable(3,"a","abc");
        list.add(pwc);
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
        for (int i = 0; i < list.size(); i++) {
            pwc = list.get(i);
            System.out.println(pwc.toString());
        }
    }
}
