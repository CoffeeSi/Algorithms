import java.util.Scanner;

public class prob2 {
    /**
     * Method to calculate the average of array elements.
     * @param array - array of integers
     * @return Average number of the array
     */
    public static double average(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = obj.nextInt();
            }
            System.out.println(average(array));
        }
    }
}