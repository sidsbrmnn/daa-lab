import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name and date of birth <name, dd/mm/yyyy>: ");
        String input = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input, "/");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.print(stringTokenizer.nextToken());
            if (stringTokenizer.hasMoreTokens()) {
                System.out.print(", ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
