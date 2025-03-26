import java.util.Scanner;

public class prob6 {
    /**
     * Method to raise number to a power.
     * @param a - number
     * @param n - power
     * @return result of a^n
     */
    public static int power(int a, int n) {
        if (n == 0) return 1;
        else if (n == 1) return a;
        return (a * power(a, n-1));
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int a = obj.nextInt();
            int n = obj.nextInt();
            System.out.println(power(a, n));
        }
    }
}
