import java.util.Scanner;

public class prob5 {
    /**
     * Method to calculate the n-th element in Fibonacci sequence.
     * @param n - index of element
     * @return n-th elements in Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            System.out.println(fibonacci(n));
        }
    }
}
