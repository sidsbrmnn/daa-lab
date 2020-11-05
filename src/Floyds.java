import java.util.Scanner;

public class Floyds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of vertices: ");
        int n = scanner.nextInt();

        int[][] costMatrix = new int[n][n];
        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix.length; j++) {
                for (int k = 0; k < costMatrix.length; k++) {
                    if (costMatrix[j][i] + costMatrix[i][k] < costMatrix[j][k]) {
                        costMatrix[j][k] = costMatrix[j][i] + costMatrix[i][k];
                    }
                }
            }
        }

        System.out.println("The all-pairs shortest paths matrix is:");
        for (int[] row : costMatrix) {
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
