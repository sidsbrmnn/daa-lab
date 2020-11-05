import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 2 numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        try {
            int result = a / b;
            System.out.println("Quotient: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot / by zero");
        }

        scanner.close();
    }
}
