import java.util.Scanner;

public class prob8 {
    /**
     * Method to check is string consists only digits
     * @param s - string to check
     * @return Yes if string have obly digits.
     *         No if string have not only digits
     */
    public static String isNumber(String s, int index) {
        if (s.length() == index) return "Yes";
        char c = s.charAt(index);
        if (!('0' <= c && c <= '9')) return "No";
        return isNumber(s, index + 1);
    }
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            String s = obj.nextLine();
            System.out.println(isNumber(s, 0));
        }
    }
}
