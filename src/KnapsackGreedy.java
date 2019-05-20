import java.util.Scanner;

class KObject {
	float w, p, r;
}

public class KnapsackGreedy {
	static int n;
	static float m;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter no of objects: ");
		n = sc.nextInt();
		KObject obj[] = new KObject[n];
		for (int i = 0; i < n; i++)
			obj[i] = new KObject();
		read(obj);
		knapsack(obj);
	}

	static void read(KObject obj[]) {
		KObject temp = new KObject();
		System.out.print("Enter max capacity of Knapsack: ");
		m = sc.nextInt();
		System.out.print("Enter weights: ");
		for (int i = 0; i < n; i++)
			obj[i].w = sc.nextFloat();
		System.out.print("Enter profits: ");
		for (int i = 0; i < n; i++)
			obj[i].p = sc.nextFloat();
		for (int i = 0; i < n; i++)
			obj[i].r = obj[i].p / obj[i].w;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - 1; j++)
				if (obj[j].r < obj[j + 1].r) {
					temp = obj[j];
					obj[j] = obj[j + 1];
					obj[j + 1] = temp;
				}
		sc.close();
	}

	static void knapsack(KObject obj[]) {
		float x[] = new float[n];
		float totalProfit = 0, u = m;
		int i;
		for (i = 0; i < n; i++)
			x[i] = 0;
		for (i = 0; i < n; i++) {
			if (obj[i].w > u)
				break;
			else {
				x[i] = 1;
				totalProfit += obj[i].p;
				u -= obj[i].w;
			}
		}
		System.out.println("i = " + i);
		System.out.print("Solution vector x[]:");
		for (i = 0; i < n; i++)
			System.out.print(" " + x[i]);
		System.out.println("\nTotal profit: " + totalProfit);
	}
}