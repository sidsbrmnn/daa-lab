import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    private int profit, weight;
    private float ratio;

    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (float) (this.profit / this.weight);
    }

    public int getProfit() {
        return profit;
    }

    public float getRatio() {
        return ratio;
    }

    public int getWeight() {
        return weight;
    }
}

class RatioComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return (int) (o2.getRatio() - o1.getRatio());
    }
}

public class Knapsack {
    private static Scanner scanner = new Scanner(System.in);

    private Item[] items;
    private final int maxCapacity;

    public Knapsack(int count, int capacity) {
        this.items = new Item[count];
        this.maxCapacity = capacity;
    }

    public void readItems() {
        int[] weights = new int[items.length];
        System.out.print("Enter weights: ");
        for (int i = 0; i < weights.length; i++) {
            weights[i] = scanner.nextInt();
        }

        int[] profits = new int[items.length];
        System.out.print("Enter profits: ");
        for (int i = 0; i < profits.length; i++) {
            profits[i] = scanner.nextInt();
        }

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(profits[i], weights[i]);
        }
    }

    public void dynamicProgramming() {
        int[][] keep = new int[items.length + 1][maxCapacity + 1];

        for (int i = 0; i < keep.length; i++) {
            for (int w = 0; w < maxCapacity + 1; w++) {
                if (i == 0 || w == 0) {
                    keep[i][w] = 0;
                } else if (items[i - 1].getWeight() <= w) {
                    keep[i][w] = Math.max(items[i - 1].getProfit() + keep[i - 1][w - items[i - 1].getWeight()],
                            keep[i - 1][w]);
                } else {
                    keep[i][w] = keep[i - 1][w];
                }
            }
        }

        System.out.println("Total profit: " + keep[items.length][maxCapacity]);
    }

    public void greedyMethod() {
        int capacity = maxCapacity, profit = 0;
        Arrays.sort(items, new RatioComparator());

        for (Item item : items) {
            if (item.getWeight() > capacity) {
                break;
            } else {
                profit += item.getProfit();
                capacity -= item.getWeight();
            }
        }

        System.out.println("Total profit: " + profit);
    }

    public static void main(String[] args) {
        System.out.print("Enter no of items: ");
        int count = scanner.nextInt();
        System.out.print("Enter max capacity of knapsack: ");
        int capacity = scanner.nextInt();

        Knapsack knapsack = new Knapsack(count, capacity);
        knapsack.readItems();

        System.out.println("\n1. Dynamic programming\n2. Greedy method");
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                knapsack.dynamicProgramming();
                break;

            case 2:
                knapsack.greedyMethod();
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
