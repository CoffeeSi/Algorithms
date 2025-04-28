package Assignment3;

import java.util.Random;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[this.M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    public int hash(K key) {
        int hash = 0;
        String str = key.toString();
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (31 * hash);
        }
        return Math.abs(hash % M);
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) { 
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) 
            return null;

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }

        return head.value;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                
                if (head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;    
            }
        }
        return null;
    }

    public int lenBucket(int index) {
        int len = 0;
        HashNode<K,V> head = chainArray[index];
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(10000);

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id);
            Student value = new Student("Student" + id);

            table.put(key, value);
        }

        for (int i = 0; i < 10000; i++) {
            System.out.print(table.lenBucket(i) + " ");
        }
    }

    // public static void main(String[] args) {
    //     MyHashTable<Integer, String> table = new MyHashTable<>(100);
    //     for (int i = 0; i < 100; i++) {
    //         table.put(i, "GbG");
    //     }
    //     for (int i = 0; i < 100; i++) {
    //         System.out.print(table.lenBucket(i) + " ");
    //     }
        
    //     table.put(11, "GG");
    //     table.remove(11);
    //     table.put(12,"sss");
    //     table.put(13, "SSS");
    //     table.put(13, "GGG");
    //     System.out.println(table.getKey("GG"));
    // }
}
