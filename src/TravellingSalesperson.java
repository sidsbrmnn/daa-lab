import java.util.Scanner;

public class TravellingSalesperson {
    private static int calculateMinCost(int[][] costMatrix, int[] tour, int start, int n) {
        if (start == n - 2) {
            return costMatrix[tour[n - 2]][tour[n - 1]] + costMatrix[tour[n - 1]][0];
        }

        int[] temp = new int[n];
        int[] minTour = new int[n];
        int minCost = Integer.MAX_VALUE;

        for (int i = start + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = tour[j];
            }
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];

            int newCost = calculateMinCost(costMatrix, temp, start + 1, n);
            if (costMatrix[tour[start]][tour[i]] + newCost < minCost) {
                minCost = costMatrix[tour[start]][tour[i]] + newCost;
                for (int k = 0; k < n; k++) {
                    minTour[k] = temp[k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            tour[i] = minTour[i];
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of cities: ");
        int n = scanner.nextInt();

        int[][] costMatrix = new int[n][n];
        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMatrix[i][j] = scanner.nextInt();
                if (costMatrix[i][j] == 0) {
                    costMatrix[i][j] = 999;
                }
            }
        }

        int[] tour = new int[n];
        for (int i = 0; i < n; i++) {
            tour[i] = i;
        }

        int minCost = calculateMinCost(costMatrix, tour, 0, n);
        System.out.println("Minimum cost: " + minCost);

        System.out.print("Tour: ");
        for (int ele : tour) {
            System.out.print(ele + " -> ");
        }
        System.out.println(tour[0]);

        scanner.close();
    }
}
