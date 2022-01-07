package Streamstest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import CollectionTest.ProductWithoutComparable;

public class test {
    public static void main(String[] args) {
        List<ProductWithoutComparable> products = new ArrayList<ProductWithoutComparable>();
        products.add(new ProductWithoutComparable(3,"tony","random"));
        products.add(new ProductWithoutComparable(1,"tony","random"));
        products.add(new ProductWithoutComparable(2,"tony","random"));
        products.stream().forEach(product -> System.out.println(product.toString()));
        Comparator<ProductWithoutComparable> sortbyid;
        sortbyid = new Comparator<ProductWithoutComparable>(){

            @Override
            public int compare(ProductWithoutComparable o1, ProductWithoutComparable o2) {
                // TODO Auto-generated method stub
                int v1 = o1.getId();
                int v2 = o2.getId();
                if (v1 > v2){
                    return 1;
                }
                else if (v1 == v2){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        };
        // sorting stream by sorted;
        products.stream().sorted(sortbyid).forEach(i -> System.out.println(i.toString()));
        // converting stream to a list by using collect() method
        List<ProductWithoutComparable> sortedproducts = products.stream().sorted(sortbyid).collect(Collectors.toList());
        sortedproducts.stream().forEach(i -> System.out.println(i.toString()));
        // changing stream in place

    }
}
