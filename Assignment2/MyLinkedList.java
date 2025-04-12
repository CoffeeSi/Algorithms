public class MyLinkedList<T extends Comparable<T>>{
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private static class MyNode<T> {
        T data;
        MyNode<T> next;
    
        public MyNode(T data) {
            this.data = data;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        }
        else if (index == size) {
            addLast(item);
        } 
        else {
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> currentNode = head;
            for (int i = 0; i < index-1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = head;
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T item) {
        add(item);
    } 

    public void set(int index, T item) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                currentNode.data = item;
            }
            currentNode = currentNode.next;
        }
        if (index == size) {
            tail.data = item;
        }
    }

    public T get(int index) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        }
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;   
            }
            currentNode.next = currentNode.next.next;
            if (index == size - 1) {
                tail = currentNode;
            }
        }
        size--;
    }

    public void removeFirst() {
        if (size == 0) return;
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < size-2; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            tail = currentNode;
        }
        size--;
    }

    public void sort() {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode = head;
            for (int j = 0; j < size-i-1; j++) {
                if (currentNode.data.compareTo(currentNode.next.data) > 0) {
                    T temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (object.equals(currentNode.data)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean exists(Object object) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (object.equals(currentNode.data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int size() { return size; }
}
