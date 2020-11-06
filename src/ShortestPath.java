import java.util.Scanner;

public class ShortestPath {
    /**
     * A utility function to find the vertex with minimum distance value, from the
     * set of vertices not yet included in shortest path tree.
     *
     * @param dist
     * @param set
     * @return
     */
    private int minDistance(int[] dist, boolean[] set) {
        int index = -1, min = Integer.MAX_VALUE;

        for (int v = 0; v < dist.length; v++) {
            if (!set[v] && dist[v] <= min) {
                min = dist[v];
                index = v;
            }
        }

        return index;
    }

    /**
     * A utility function to print the constructed distance array.
     *
     * @param dist
     */
    private void printSolution(int[] dist) {
        System.out.println("\nVertex\tDistance");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    /**
     * Function that implements Dijkstra's single source shortest path algorithm for
     * a graph represented using adjacency matrix representation.
     *
     * @param graph
     * @param source
     */
    public void dijkstra(int[][] graph, int source) {
        int[] dist = new int[graph.length];
        boolean[] set = new boolean[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != source) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minDistance(dist, set);
            set[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (!set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
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
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter source node: ");
        int source = scanner.nextInt();

        ShortestPath shortestPath = new ShortestPath();
        shortestPath.dijkstra(graph, source);

        scanner.close();
    }
}
