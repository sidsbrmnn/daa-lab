import java.util.Scanner;

public class Prims {
    private static int calculateMinCost(int[][] costMatrix) {
        boolean[] visited = new boolean[costMatrix.length];
        int edgeCount = 1, minCost = 0;
        visited[0] = true;

        while (edgeCount < visited.length) {
            int a = 0, b = 0, u = 0, v = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited.length; j++) {
                    if (costMatrix[i][j] < min) {
                        if (visited[i]) {
                            min = costMatrix[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if (!visited[u] || !visited[v]) {
                System.out.println("Edge: " + edgeCount++ + " (" + (a + 1) + ", " + (b + 1) + ") => " + min);
                minCost += min;
                visited[b] = true;
            }

            costMatrix[a][b] = costMatrix[b][a] = Integer.MAX_VALUE;
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of vertices: ");
        int n = scanner.nextInt();

        int[][] costMatrix = new int[n][n];
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix.length; j++) {
                costMatrix[i][j] = scanner.nextInt();
                if (costMatrix[i][j] == 0) {
                    costMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println();
        int minCost = calculateMinCost(costMatrix);
        System.out.println("Minimum cost: " + minCost);

        scanner.close();
    }
}
