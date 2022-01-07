package TreeCollection;

public class GenericComparator<T extends Comparable<T>>
{
    public boolean compare(T value1, T value2){
        System.out.println("in comparable " + value1 + " " + value2);
        if ((value1.compareTo(value2) == 0)){
            return true;
        }
        else{
            return false;
        }
    }

    public int comparevalues(T data, T data2) {
        return data.compareTo(data2);
    }
}
