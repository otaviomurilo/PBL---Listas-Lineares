class Stack implements MethodsCollection{
    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node top;
    int size;
    Stack() {
        this.top = null;
        this.size = 0; //define o valor inicial da stack
    }

    public void stackPush(int x){ //método para adicionar um elemento
        Node element = new Node(x);
        element.next = top;
        top = element;
        System.out.printf("Element %d pushed\n", top.data);
        size++;
    }

    public int stackPop(){
        if (top == null){ // verifica se a pilha está vazia
            return -1; // pode retornar um valor negativo ou lançar uma exceção
        }
        int topData = top.data; // dado a ser retornado, uma vez que está no topo da pilha
        Node temp = top;
        top = top.next; // aponta para o próximo nó da pilha
        size--;
        return topData;
    }
    

    @Override
    public boolean isEmpty(){
        return top == null;
    }
    @Override
    public int getSize(){
        return size;
    }

}
