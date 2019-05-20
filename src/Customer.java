import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name and DoB in the format <name, DD/MM/YYYY>: ");
		String name = sc.nextLine();
		StringTokenizer st = new StringTokenizer(name, "/");
		int count = st.countTokens();
		for (int i = 1; i <= count && st.hasMoreTokens(); i++) {
			System.out.print(st.nextToken());
			if (i < count)
				System.out.print(", ");
		}
		System.out.println();
		sc.close();
	}
}
