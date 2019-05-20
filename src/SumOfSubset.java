import java.util.Scanner;

public class SumOfSubset {
	static int n, s[], soln[], d, count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of elements: ");
		n = sc.nextInt();
		s = new int[n + 1];
		soln = new int[n + 1];
		System.out.print("Enter the set in increasing order: ");
		for (int i = 1; i <= n; i++)
			s[i] = sc.nextInt();
		System.out.print("Enter max subset value: ");
		d = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += s[i];
		sumOfSub(0, 0, sum);
		if (count == 0)
			System.out.println("No subset possible.");
		sc.close();
	}

	static void sumOfSub(int i, int weight, int total) {
		if (promising(i, weight, total) == true)
			if (weight == d) {
				count++;
				for (int j = 1; j <= n; j++)
					if (soln[j] == 1)
						System.out.print(s[j] + " ");
				System.out.println();
			} else {
				soln[i + 1] = 1;
				sumOfSub(i + 1, weight + s[i + 1], total - s[i + 1]);
				soln[i + 1] = 0;
				sumOfSub(i + 1, weight, total - s[i + 1]);
			}
	}

	static boolean promising(int i, int weight, int total) {
		return ((weight + total >= d) && (weight == d || weight + s[i + 1] <= d));
	}
}
