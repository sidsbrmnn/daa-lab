import java.util.Random;
import java.util.Scanner;

public class MergeSort {
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
		System.out.print("\nSORTED ARRAY: ");
		for (int i = 0; i < n; i++)
			System.out.print(" " + a[i]);
		System.out.println("\nTime taken to sort: " + (stop - start));
		sc.close();
	}

	static void sort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(a, low, mid);
			sort(a, mid + 1, high);
			merge(a, low, high, mid);
		}
	}

	static void merge(int a[], int low, int high, int mid) {
		int temp[] = new int[a.length];
		int i, j, h;
		h = i = low;
		j = mid + 1;
		while ((h <= mid) && (j <= high)) {
			if (a[h] < a[j])
				temp[i++] = a[h++];
			else
				temp[i++] = a[j++];
		}

		if (h > mid)
			for (int k = j; k <= high; k++)
				temp[i++] = a[k];
		else
			for (int k = h; k <= mid; k++)
				temp[i++] = a[k];

		for (int k = low; k <= high; k++)
			a[k] = temp[k];
	}
}