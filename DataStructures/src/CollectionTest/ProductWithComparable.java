package CollectionTest;

public class ProductWithComparable implements Comparable<ProductWithComparable>{
    int id;
    String name;
    String batch;
    public ProductWithComparable(int id, String name, String batch) {
        this.id = id;
        this.name = name;
        this.batch = batch;
    }
    @Override
    public int compareTo(ProductWithComparable p2) {
        // TODO Auto-generated method stub
        if (this.id == p2.id){
            return 0;
        }
        else if (this.id < p2.id){
            return -1;
        }
        else{
            return 1;
        }
    }
    public String toString(){
        return "id " + this.id + " name " + this.name + " batch" + this.batch;
    }
}
