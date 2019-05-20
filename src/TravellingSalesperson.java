import java.util.Scanner;

public class TravellingSalesperson {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of cities: ");
		int n = sc.nextInt();
		int c[][] = new int[n][n];
		int tour[] = new int[n];
		System.out.println("Enter cost matrix:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				c[i][j] = sc.nextInt();
				if (c[i][j] == 0)
					c[i][j] = 999;
			}
		for (int i = 0; i < n; i++)
			tour[i] = i;
		int cost = tspdp(c, tour, 0, n);
		System.out.println("Minimum cost: " + cost);
		System.out.print("Tour: ");
		for (int i = 0; i < n; i++)
			System.out.print(tour[i] + " -> ");
		System.out.println(tour[0]);
		sc.close();
	}

	static int tspdp(int c[][], int tour[], int start, int n) {
		if (start == n - 2)
			return c[tour[n - 2]][tour[n - 1]] + c[tour[n - 1]][0];

		int temp[] = new int[n];
		int mintour[] = new int[n];
		int mincost = 999, cost;
		for (int i = start + 1; i < n; i++) {
			for (int j = 0; j < n; j++)
				temp[j] = tour[j];
			temp[start + 1] = tour[i];
			temp[i] = tour[start + 1];
			if (c[tour[start]][tour[i]] + (cost = tspdp(c, temp, start + 1, n)) < mincost) {
				mincost = c[tour[start]][tour[i]] + cost;
				for (int k = 0; k < n; k++)
					mintour[k] = temp[k];
			}
		}
		for (int i = 0; i < n; i++)
			tour[i] = mintour[i];
		return mincost;
	}
}
