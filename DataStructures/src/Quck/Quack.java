package Quck;

public interface Quack<T> {
    public void addHead(T data);
    public void addTail(T data);
    public T popHead();
    public T popTail();
    public boolean hasNext();
}