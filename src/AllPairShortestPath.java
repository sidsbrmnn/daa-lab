import java.util.Scanner;

public class AllPairShortestPath {
    /**
     * A utility function to print the constructed shortest distance matrix.
     *
     * @param dist
     */
    private void printSolution(int[][] dist) {
        System.out.println("\nThe following matrix shows the shortest distances between every pair of vertices.");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Function to construct and print the shortest distance matrix for a graph
     * represented using adjacency matrix representation.
     *
     * @param graph
     */
    public void floydWarshall(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of vertices: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        AllPairShortestPath allPairShortestPath = new AllPairShortestPath();
        allPairShortestPath.floydWarshall(graph);

        scanner.close();
    }
}
