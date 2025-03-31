public class Queue<T> implements DataStructure<T> {
    private Node<T> front;  // início da fila
    private Node<T> rear;   // final da fila
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }
    @Override
    public void enqueue(T data) {
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
    @Override
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

    @Override
    public String toString() {
        if (isEmpty()) return "Fila vazia";
        
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        
        while (current != null) {
            sb.append(current.data).append(current.next != null ? ", " : "");
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public void push(T data) {
        throw new UnsupportedOperationException("método não suportado em Queue");
    }

    @Override
    public T pop() {
        throw new UnsupportedOperationException("método não suportado em Queue");
    }
    
}
