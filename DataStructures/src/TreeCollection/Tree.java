package TreeCollection;

public interface Tree<T> {
    public void add(T value);
    public TNode remove(T target);
    public boolean search(T target);
    public TNode<T> getRoot();
    public void Triverse(TNode<T> root);
}
