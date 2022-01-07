package Trees;

public class GenericComparator<T extends Comparable<T>>
{
    public boolean compare(T value1, T value2){
        if ((value1.compareTo(value2) == 0)){
            return true;
        }
        else{
            return false;
        }
    }
}
