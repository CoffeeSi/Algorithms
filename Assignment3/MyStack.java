package Assignment3;

public class MyStack<T> {
    private Node<T> top;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    } 

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (empty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (empty()) {
            return null;
        }
        return top.data;
    }

    public boolean empty() { return (top == null); }

    public int size() { return size; }
}
