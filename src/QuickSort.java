import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private static int partition(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return j;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter no of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000);
        }

        long startTime = System.nanoTime();
        sort(arr, 0, n - 1);
        long stopTime = System.nanoTime();

        System.out.println("Time taken to sort: " + (stopTime - startTime));

        scanner.close();
    }
}
