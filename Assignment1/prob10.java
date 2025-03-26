import java.util.Scanner;

public class prob10 {
    /**
     * Method to calculate the greatest common divisor of a and b.
     * @param a - first number
     * @param b - second number
     * @return Greatest common divisor of a and b
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int a = obj.nextInt();
            int b = obj.nextInt();
            System.out.println(gcd(a, b));
        }
    }
}
