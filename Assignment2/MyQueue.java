public class MyQueue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (empty()) {
            front = newNode;
            front = back;
        } else {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (empty()) {
            return null;
        } 
        T data = front.data;
        front = front.next;
        if (front == null) {
            back = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (empty()) {
            return null;
        }
        return front.data;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
