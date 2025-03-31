public interface DataStructure<T> {
    boolean isEmpty();
    int getSize();
    void push(T data);
    T pop();
    void enqueue(T data);
    T dequeue();
    @Override
    String toString();
}
