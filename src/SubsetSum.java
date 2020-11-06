import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    private static Scanner scanner = new Scanner(System.in);

    private boolean[][] dp;
    private int[] set;
    private int sum;

    public SubsetSum(int n) {
        this.set = new int[n];
    }

    public void readData() {
        System.out.print("Enter the elements: ");
        for (int i = 0; i < set.length; i++) {
            set[i] = scanner.nextInt();
        }
        Arrays.sort(set);

        System.out.print("Enter sum: ");
        sum = scanner.nextInt();
    }

    private void printSubsets(int i, int sum, ArrayList<Integer> path) {
        if (i == 0 && sum != 0 && dp[0][sum]) {
            path.add(set[i]);
            System.out.println(path);
            path.clear();
            return;
        }

        if (i == 0 && sum == 0) {
            System.out.println(path);
            path.clear();
            return;
        }

        if (dp[i - 1][sum]) {
            printSubsets(i - 1, sum, new ArrayList<>(path));
        }

        if (sum >= set[i] && dp[i - 1][sum - set[i]]) {
            path.add(set[i]);
            printSubsets(i - 1, sum - set[i], path);
        }
    }

    public void findAll() {
        dp = new boolean[set.length][sum + 1];

        for (int i = 0; i < set.length; i++) {
            dp[i][0] = true;
        }

        if (set[0] <= sum) {
            dp[0][set[0]] = true;
        }

        for (int i = 1; i < set.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = set[i] <= j ? dp[i - 1][j] || dp[i - 1][j - set[i]] : dp[i - 1][j];
            }
        }

        if (!dp[set.length - 1][sum]) {
            System.out.println("No subset found with the given sum.");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        printSubsets(set.length - 1, sum, path);
    }

    public static void main(String[] args) {
        System.out.print("Enter no of elements: ");
        int n = scanner.nextInt();

        SubsetSum subsetSum = new SubsetSum(n);
        subsetSum.readData();
        subsetSum.findAll();
    }
}
