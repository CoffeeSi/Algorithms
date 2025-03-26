import java.util.Scanner;

public class prob1 {
    /**
     * Method to calculate the minimal of a and b.
     * @param array - array of integers
     * @return Mininal integer of the array
     */
    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = obj.nextInt();
            }
            System.out.println(min(array));
        }
    }
}
