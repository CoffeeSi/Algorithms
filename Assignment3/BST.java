package Assignment3;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int comp = key.compareTo(current.key);
            if (comp < 0) {
                if (current.left == null) {
                    current.left = new Node (key, value);
                    size++;
                    return;
                }
                current = current.left;
            } 
            else if (comp > 0) {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    size++;
                    return;
                }
                current = current.right;
            } 
            else {
                current.value = value;
                return;
            }
        }        
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int comp = key.compareTo(current.key);
            if (comp < 0) current = current.left;
            else if (comp > 0) current = current.right;
            else {
                // System.out.print((current.left != null ? current.left.key : null) + " " + 
                //                 current.key + " " + 
                //                 (current.right != null ? current.right.key : null));
                return current.value;
            }
        }
        return null;
    }

    // public void delete(K key) {
    //     delete(root, key);
    // }

    // private Node delete(Node node, K key) {
    //     if (node == null) return node;

    //     int comp = key.compareTo(node.key);
    //     if (comp < 0) node.left = delete(node.left, key);
    //     else if (comp > 0) node.right = delete(node.right, key);
    //     else {
    //         if (node.left == null) return node.right;
    //         if (node.right == null) return node.left;

    //         Node current = node.right;
    //         while (current.left != null && current.right != null) {
    //             current = current.left;
    //         }

    //         node.key = current.key;
    //         node.right = delete(node.right, current.key);
    //         size--;
    //     }
    //     return node;
    // }

    public void delete(K key) {
        Node current = root;
        Node parent = null;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            int comp = key.compareTo(current.key);

            if (comp < 0) current = current.left;
            else if (comp > 0) current = current.right;
        }

        if (current == null) return;

        if (current.left != null && current.right != null) {
            Node sucParent = current;
            Node suc = current.right;

            while (suc.left != null) {
                sucParent = suc;
                suc = suc.left;
            }

            current.key = suc.key;
            current.value = suc.value;

            key = suc.key;
            parent = sucParent;
            current = suc;
        }

        Node newNode;
        if (current.left != null) { newNode = current.left; }
        else { newNode  = current.right; }

        if (parent == null) { root = newNode; }
        else if (parent.left.equals(current)) { parent.left = newNode; }
        else { parent.right = newNode; }

        size--;
    }

    public int getSize() {
        return size;
    }

    // public void inOrder() {
    //     inOrder(root);
    // }

    // private void inOrder(Node node) {
    //     if (node == null) return;
    //     inOrder(node.left);
    //     System.out.print(node.key + " ");
    //     inOrder(node.right);
    // }

    public Iterable<Node> iterator() {
        MyArrayList<Node> nodeList = new MyArrayList<>();

        MyStack<Node> nodeStack = new MyStack<>();
        Node current = root;

        while (current != null || !nodeStack.empty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }

            current = nodeStack.pop();
            nodeList.add(current);
            current = current.right;
        }

        return nodeList;
    }

    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(10, "A");
        tree.put(5, "B");
        tree.put(15, "C");
        tree.put(12, "C");
        tree.put(18, "C");

        System.out.println(tree.getSize());

        tree.delete(12);

        System.out.println(tree.get(18));

        System.out.println(tree.getSize()); 

        for (var elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
