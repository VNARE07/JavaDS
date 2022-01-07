package Trees;

public interface Tree<T> {
    public void add(T parent,T value);
    public T remove(BTNode<T> node);
}
