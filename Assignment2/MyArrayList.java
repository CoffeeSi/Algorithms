import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList() { array = new Object[capacity]; }

    public void add(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = item;
    }

    public void set(int index, T item) {
        if (size > index && index > 0) {
            array[index] = item;
        }
    }

    public void add(int index, T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        size++;
        for (int i = 0; i < size-index; i++) {
            array[size-i] = array[size-i-1];
        }
        array[index] = item;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        size++;
        for (int i = 0; i < size; i++) {
            array[size-i] = array[size-i-1];
        }
        array[0] = item;
    }

    public void addLast(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = item;
    }

    public T get(int index) { return (T) array[index]; }

    public T getFirst() { 
        if (size == 0) { return null; }
        return (T) array[0];
    }


    public T getLast() { 
        if (size == 0) { return null; }
        return (T) array[size-1]; 
    }

    public void remove(int index) {
        if (size == 0) { return; }
        if (size > index) {
            array[index] = null;
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i+1];
            }
            size--;
        }
    }

    public void removeFirst() {
        if (size == 0) { return; }
        array[0] = null;
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) { return; }
        array[size-1] = null;
        size--;
    }

    public void sort() {
        if (size == 0) { return; }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (array[0] instanceof Integer) {
                    if ((int) array[i] < (int) array[j]) {
                        Object temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
                else if (array[0] instanceof Double) {
                    if ((double) array[i] < (double) array[j]) {
                        Object temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
                else if (array[0] instanceof Float) {
                    if ((float) array[i] < (float) array[j]) {
                        Object temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() { return array; }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        capacity = 5;
    }

    public int size() { return size; }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            System.out.print(' ');
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }

    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

}
