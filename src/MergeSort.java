import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    private static void merge(int[] arr, int low, int high, int mid) {
        int[] temp = new int[arr.length];
        int i = low, j = mid + 1, count = low;

        while (i <= mid && j <= high) {
            temp[count++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[count++] = arr[i++];
        }

        while (j <= high) {
            temp[count++] = arr[j++];
        }

        for (int k = low; k <= high; k++) {
            arr[k] = temp[k];
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, high, mid);
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
