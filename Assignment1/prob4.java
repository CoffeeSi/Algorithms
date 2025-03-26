import java.util.Scanner;

public class prob4 {
    /**
     * Method to find the factorial of an number.
     * @param n - number
     * @return The factorial of the given number
     */
    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            System.out.println(factorial(obj.nextInt()));
        }
    }
}
