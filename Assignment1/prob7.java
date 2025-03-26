import java.util.Scanner;

public class prob7 {
    /**
     * Method to reverse an array.
     * @param n - array length
     * @param obj - Scanner obj
     * @return Reversed array
     */
    public static void reverse(int n, Scanner obj) {
        if (n ==  0) return;
        int elem = obj.nextInt();
        reverse(n - 1, obj);
        System.out.print(elem + " ");
    }
    
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            int n = obj.nextInt();
            reverse(n, obj);
        }
    }
}
