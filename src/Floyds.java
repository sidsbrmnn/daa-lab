import java.util.Scanner;

public class Floyds {
	static int n, a[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
		floyds();
		print();
	}

	static void read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of vertices: ");
		n = sc.nextInt();
		a = new int[n + 1][n + 1];
		System.out.println("Enter cost matrix:");
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				a[i][j] = sc.nextInt();
		sc.close();
	}

	static void floyds() {
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (a[i][k] + a[k][j] < a[i][j])
						a[i][j] = a[i][k] + a[k][j];
	}

	static void print() {
		System.out.println("The all pair shortest path matrix is:");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
	}
}
