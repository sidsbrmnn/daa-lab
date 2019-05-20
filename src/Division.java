import java.util.Scanner;

public class Division {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 2 numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		try {
			int result = a / b;
			System.out.println("Quotient: " + result);
		} catch (ArithmeticException e) {
			System.out.println("EXCEPTION CAUGHT: Enter a non-zero divisor.");
		}
		sc.close();
	}
}
