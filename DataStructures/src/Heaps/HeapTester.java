package Heaps;

public class HeapTester {
    public static void main(String[] args) {
        Heap<Integer,Integer> heap = new MinHeap<Integer,Integer>();
        heap.put(1,1);
        heap.put(6,2);
        heap.put(4,3);
        heap.put(5,4);
        heap.put(10,5);
        heap.put(3,4);
        Node<Integer,Integer> node;
        while (true){
            node = heap.remove();
            if (node == null){
                break;
            }
            else{
                System.out.println(node);
            }
        }
    }
}
