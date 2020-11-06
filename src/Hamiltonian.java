import java.util.Scanner;

public class Hamiltonian {
    /**
     * A utility function to check if the vertex v can be added at index 'pos' in
     * the Hamiltonian Cycle constructed so far (stored in path[])
     *
     * @param v
     * @param graph
     * @param path
     * @param pos
     * @return
     */
    private boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    /**
     * A recursive utility function to solve hamiltonian cycle problem.
     *
     * @param graph
     * @param path
     * @param pos
     * @return
     */
    private boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        if (pos == graph.length) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < graph.length; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1)) {
                    return true;
                }

                path[pos] = -1;
            }
        }

        return false;
    }

    /**
     * A utility function to print the solution.
     *
     * @param path
     */
    private void printSolution(int[] path) {
        System.out.println("\nSolution exists.");
        for (int v : path) {
            System.out.print(v + " -> ");
        }
        System.out.println(path[0]);
    }

    /**
     * This function solves the Hamiltonian Cycle problem using Backtracking. It
     * mainly uses hamCycleUtil() to solve the problem. It returns false if there is
     * no Hamiltonian Cycle possible, otherwise return true and prints the path.
     * Please note that there may be more than one solutions, this function prints
     * one of the feasible solutions.
     *
     * @param graph
     */
    public void hamCycle(int[][] graph) {
        int[] path = new int[graph.length];
        for (int i = 1; i < path.length; i++) {
            path[i] = -1;
        }

        if (hamCycleUtil(graph, path, 1)) {
            printSolution(path);
        } else {
            System.out.println("\nSolution does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of vertices: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("If there's an edge between the following vertices, enter 1 else 0.");
        for (int i = 0; i < graph.length; i++) {
            for (int j = i; j < graph.length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }

                System.out.print(i + " and " + j + ": ");
                graph[i][j] = graph[j][i] = scanner.nextInt();
            }
        }

        Hamiltonian hamiltonian = new Hamiltonian();
        hamiltonian.hamCycle(graph);

        scanner.close();
    }
}
