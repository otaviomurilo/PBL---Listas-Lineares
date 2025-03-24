public class Queue<T> implements MethodsCollection<T> {
    private Node<T> front;  // início da fila
    private Node<T> rear;   // final da fila
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }
    @Override
    public void push(T data) {
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
    public T pop() {
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
    public String toString(){
        if (isEmpty()){
            return "Fila vazia!";
        }

        StringBuilder sb = new StringBuilder();
        Node<T> current = front; //começa pelo início da fila = primeiro elemento inserido

        while (current != null) {
            sb.append(current.data);
            if(current.next != null){
                sb.append(", ");
            } current = current.next;
        } return sb.toString();
    }
}
