import java.util.Scanner;

public class Dijkstras {
    private static int[] computeDistanceVector(int[][] costMatrix, int source) {
        int[] distanceVector = new int[costMatrix.length];
        boolean[] visited = new boolean[costMatrix.length];

        for (int i = 0; i < costMatrix.length; i++) {
            distanceVector[i] = costMatrix[source][i];
        }
        visited[source] = true;

        for (int i = 0; i < costMatrix.length; i++) {
            int min = 999, u = 0;
            for (int j = 0; j < costMatrix.length; j++) {
                if (!visited[j] && distanceVector[j] < min) {
                    min = distanceVector[j];
                    u = j;
                }
            }

            visited[u] = true;
            for (int j = 0; j < costMatrix.length; j++) {
                if (!visited[j] && distanceVector[u] + costMatrix[u][j] < distanceVector[j]) {
                    distanceVector[j] = distanceVector[u] + costMatrix[u][j];
                }
            }
        }

        return distanceVector;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of vertices: ");
        int n = scanner.nextInt();

        int[][] costMatrix = new int[n][n];
        System.out.println("Enter cost matrix:");
        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix.length; j++) {
                costMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter source node: ");
        int source = scanner.nextInt();

        System.out.println();
        int[] distanceVector = computeDistanceVector(costMatrix, source - 1);
        for (int i = 0; i < distanceVector.length; i++) {
            System.out.print("Shortest distance from ");
            System.out.print(source + " to " + (i + 1));
            System.out.println(" is " + distanceVector[i]);
        }

        scanner.close();
    }
}
