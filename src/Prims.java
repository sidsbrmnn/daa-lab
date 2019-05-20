import java.util.Scanner;

public class Prims {
	static int n, cost[][];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		read();
		prims();
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

	static void prims() {
		int visited[] = new int[n + 1];
		int a = 0, b = 0, u = 0, v = 0, i, j, ne = 1, min, mincost = 0;
		visited[1] = 1;
		System.out.println("The edges of the minimum spanning tree are:");
		while (ne < n) {
			for (i = 1, min = 999; i <= n; i++) {
				for (j = 1; j <= n; j++) {
					if (cost[i][j] < min) {
						if (visited[i] != 0) {
							min = cost[i][j];
							a = u = i;
							b = v = j;
						}
					}
				}
			}
			if (visited[u] == 0 || visited[v] == 0) {
				System.out.println("Edge: " + ne++ + " (" + a + ", " + b + ") => Cost: " + min);
				mincost += min;
				visited[b] = 1;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.println("Minimum cost: " + mincost);
	}
}