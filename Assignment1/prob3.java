import java.util.Scanner;

public class prob3 {
    /**
     * Method to find is number prime.
     * @param n - number
     * @return If number is prime
     */
    public static String isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return "Composite";
            }
        }
        return "Prime";
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            System.out.println(isPrime(n));
        }
    }
}
