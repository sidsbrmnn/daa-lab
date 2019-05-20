import java.util.Scanner;

public class Kruskals {
	static int n, cost[][];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
		kruskals();
	}

	static void read() {
		int i, j;
		System.out.print("Enter number of vertices: ");
		n = sc.nextInt();
		cost = new int[n + 1][n + 1];
		System.out.println("Enter the adjaceny matrix:");
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++) {
				cost[i][j] = sc.nextInt();
				if (cost[i][j] == 0)
					cost[i][j] = 999;
			}
	}

	static void kruskals() {
		int a = 0, b = 0, u = 0, v = 0, i, j, ne = 1, min, mincost = 0;
		int parent[] = new int[n + 1];
		System.out.println("The edges of the minimum spanning tree are:");
		while (ne < n) {
			for (i = 1, min = 999; i <= n; i++) {
				for (j = 1; j <= n; j++) {
					if (cost[i][j] < min) {
						min = cost[i][j];
						a = u = i;
						b = v = j;
					}
				}
			}
			u = find(u, parent);
			v = find(v, parent);
			if (uni(u, v, parent) != 0) {
				System.out.println("Edge: " + ne++ + " (" + a + ", " + b + ") => Cost: " + min);
				mincost += min;
				parent[v] = u;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.println("Minimum cost: " + mincost);
	}

	static int find(int i, int parent[]) {
		while (parent[i] != 0)
			i = parent[i];
		return i;
	}

	static int uni(int i, int j, int parent[]) {
		if (i != j) {
			parent[j] = i;
			return 1;
		} else
			return 0;
	}
}