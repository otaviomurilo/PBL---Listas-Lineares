public class Queue<T> implements MethodsCollection {
    private Node<T> front;  // início da fila
    private Node<T> rear;   // final da fila
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data) { //adiciona um elemento
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        T data = front.data; 
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;  
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
