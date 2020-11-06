import java.util.Scanner;

public class MinimumSpanningTree {
    /**
     * A utility function to find the vertex with minimum key value, from the set of
     * vertices not yet included in minimum spanning tree.
     *
     * @param key
     * @param set
     * @return
     */
    private int minKey(int[] key, boolean[] set) {
        int index = -1, min = Integer.MAX_VALUE;

        for (int v = 0; v < key.length; v++) {
            if (!set[v] && key[v] < min) {
                min = key[v];
                index = v;
            }
        }

        return index;
    }

    /**
     * A utility function to print the constructed minimum spanning tree stored in
     * parent[].
     *
     * @param parent
     * @param graph
     */
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("\nEdge\tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    /**
     * Function to construct and print the minimum spanning tree for a graph
     * represented using adjacency matrix representation.
     *
     * @param graph
     */
    public void prim(int[][] graph) {
        int[] key = new int[graph.length];
        int[] parent = new int[graph.length];
        boolean[] set = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            key[i] = Integer.MAX_VALUE;
            set[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minKey(key, set);
            set[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && !set[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
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

        MinimumSpanningTree minimumSpanningTree = new MinimumSpanningTree();
        minimumSpanningTree.prim(graph);

        scanner.close();
    }
}
