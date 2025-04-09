public class MyLinkedList<T>{
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<T>(item);
        if (head == null) {
            head = newNode;
        } else {
            MyNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void set(int index, T item) {
        MyNode<T> currentNode = new MyNode<T>(item);
        for (int i = 0; i < length; i++) {
            if (i == index) {
                head.data = currentNode.data;
            }
            head = head.next;
        }
    }

    public T get(int index) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void remove(int index) {
        MyNode<T> currentNode = head;
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;   
            }
            currentNode.next = currentNode.next.next;
            if (index == length - 1) {
                tail = currentNode;
            }
        }
        length--;
    }

    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < length; i++) {
            if (object.equals(currentNode.data)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean exists(Object object) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < length; i++) {
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
        length = 0;
    }
    
    public int size() { return length; }
}
