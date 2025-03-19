public class Queue implements MethodsCollection {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node front;  // início da fila
    Node rear;   //final da fila
    int size;
    @Override
    public boolean isEmpty(){
        return front == null;
    }
    @Override
    public int getSize(){
        return size;
    }
}
