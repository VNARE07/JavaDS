package CollectionTest;
import java.util.ArrayList;
import java.util.Collections;
public class SortListWithComparable {
    public static void main(String[] args) {
        ArrayList<ProductWithComparable> list = new ArrayList<ProductWithComparable>();
        ProductWithComparable pwc;
        pwc = new ProductWithComparable(4,"a","abc");
        list.add(pwc);
        pwc = new ProductWithComparable(2,"a","abc");
        list.add(pwc);
        pwc = new ProductWithComparable(1,"a","abc");
        list.add(pwc);
        pwc = new ProductWithComparable(3,"a","abc");
        list.add(pwc);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            pwc = list.get(i);
            System.out.println(pwc.toString());
        }
    }
}
