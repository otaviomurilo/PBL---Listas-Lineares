public class Stack<T> implements MethodsCollection<T> {
    private Node<T> top; // referência para o topo da pilha
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0; // valor inicial da stack
    }
    
    @Override
    public void push(T data) {
        Node<T> element = new Node<>(data);
        element.next = top;
        top = element;
        size++;
    }
    @Override
    public T pop() {
        if (top == null) { // caso a pilha esteja vazia, lança uma exceção 
            throw new IllegalStateException("Stack vazia");
        }
        T topData = top.data; // Dado a ser retornado
        top = top.next; 
        size--;
        return topData;
    }

    public T peek() { // apenas visualiza o topo da pihaa
        if (top == null) {
            throw new IllegalStateException("Stack vazia");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
