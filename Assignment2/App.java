public class App {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(222);
        array.add(29);
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
        System.out.println(array.exists(290));
        array.sort();
        System.out.println(array.lastIndexOf(29));
        System.out.println(array.getLast());
        array.remove(30);
        array.print();

        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(2);
        System.out.println(list.indexOf(4));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }
    }
}
