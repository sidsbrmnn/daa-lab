import java.util.Scanner;

public class KnapsackDynamic {
	static int w[], p[], m, n, v[][], keep[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readObjects();
		for (int i = 0; i <= m; i++)
			v[0][i] = 0;
		for (int i = 0; i <= n; i++)
			v[i][0] = 0;
		int optSoln = knapsack();
		System.out.println("Optimal solution: " + optSoln);
	}

	static void readObjects() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of objects: ");
		n = sc.nextInt();
		System.out.print("Enter max capacity of knapsack: ");
		m = sc.nextInt();
		w = new int[n + 1];
		p = new int[n + 1];
		v = new int[n + 1][m + 1];
		keep = new int[n + 1][m + 1];
		System.out.print("Enter weights: ");
		for (int i = 1; i <= n; i++)
			w[i] = sc.nextInt();
		System.out.print("Enter profits: ");
		for (int i = 1; i <= n; i++)
			p[i] = sc.nextInt();
		sc.close();
	}

	static int knapsack() {
		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= m; j++) {
				if ((w[i] <= j) && (p[i] + v[i - 1][j - w[i]] > v[i - 1][j])) {
					v[i][j] = p[i] + v[i - 1][j - w[i]];
					keep[i][j] = 1;
				} else {
					v[i][j] = v[i - 1][j];
					keep[i][j] = 0;
				}
			}
		int r = m;
		System.out.print("Items:");
		for (int i = n; i > 0; i--)
			if (keep[i][r] == 1) {
				System.out.print(" " + i);
				r = r - w[i];
			}
		System.out.println();
		return v[n][m];
	}
}
