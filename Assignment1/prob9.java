import java.util.Scanner;

public class prob9 {
    /**
     * Method to calculate the binomial coefficient of n and k.
     * @param n - total number
     * @param b - number of items chosen from the total
     * @return Binomial coefficient of n and k
     */
    public static int coefficient(int n, int k) {
        if (k == 0 || n == k) return 1;
        return coefficient(n-1, k-1) + coefficient(n-1, k);
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            int k = obj.nextInt();
            System.out.println(coefficient(n, k));
        }
    }
}
