import java.util.Scanner;

public class Dijkstras {
	static Scanner sc = new Scanner(System.in);
	static int n, cost[][], dist[], source;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter no of nodes: ");
		n = sc.nextInt();
		cost = new int[n + 1][n + 1];
		System.out.println("Enter cost matrix:");
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				cost[i][j] = sc.nextInt();
		System.out.print("Enter source node: ");
		source = sc.nextInt();
		dijkstras();
		for (int i = 1; i <= n; i++)
			System.out.println("Shortest distance from " + source + " to " + i + " is " + dist[i]);
	}

	static void dijkstras() {
		int visited[] = new int[n + 1];
		dist = new int[n + 1];
		int min, u = 0;
		for (int i = 1; i <= n; i++) {
			dist[i] = cost[source][i];
			visited[i] = 0;
		}
		visited[source] = 1;
		for (int i = 0; i < n; i++) {
			min = 999;
			for (int j = 1; j <= n; j++)
				if (visited[j] == 0 && dist[j] < min) {
					min = dist[j];
					u = j;
				}
			visited[u] = 1;
			for (int j = 1; j <= n; j++)
				if (visited[j] == 0 && (dist[u] + cost[u][j]) < dist[j])
					dist[j] = dist[u] + cost[u][j];
		}
	}
}
