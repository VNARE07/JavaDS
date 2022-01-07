package CollectionTest;

public class ProductWithoutComparable {
    int id;
    String name;
    String batch;
    public ProductWithoutComparable(int id, String name, String batch) {
        this.id = id;
        this.name = name;
        this.batch = batch;
    }
    public String toString(){
        return "id " + this.id + " name " + this.name + " batch " + this.batch;
    }
    public Integer getId() {
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
}
