package HashMap;

import java.util.ArrayList;
import java.util.Collection;

public class maptester {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>(1,"a");
        map.add(2,"b");
        map.add(3,"c");
        map.add(2,"x");
        Collection<String> c = map.values();
        ArrayList<String> a = new ArrayList<String>(c);
        System.out.println(a);
    }
}
