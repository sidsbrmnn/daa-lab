import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.print("Enter no of elements: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("Array has:");
		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(1000);
			System.out.print(" " + a[i]);
		}
		long start = System.nanoTime();
		sort(a, 0, n - 1);
		long stop = System.nanoTime();
		System.out.print("\nSORTED ARRAY:");
		for (int i = 0; i < n; i++)
			System.out.print(" " + a[i]);
		System.out.println("\nTime taken to sort: " + (stop - start));
		sc.close();
	}

	static void sort(int a[], int low, int high) {
		if (low < high) {
			int pi = partition(a, low, high);
			sort(a, low, pi - 1);
			sort(a, pi + 1, high);
		}
	}

	static int partition(int a[], int low, int high) {
		int i = low, j = high, pivot = a[low];
		while (i < j) {
			while (a[i] <= pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i < j)
				swap(a, i, j);
		}
		a[low] = a[j];
		a[j] = pivot;
		return j;
	}

	static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
