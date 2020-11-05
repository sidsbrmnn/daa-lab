import java.util.Scanner;

public class Stack {
    private int size, top;
    private int[] items;

    public Stack(int size) {
        this.top = -1;
        this.size = size;
        this.items = new int[size];
    }

    public void push(int value) throws Exception {
        if (top == size - 1) {
            throw new Exception("stack is full");
        }

        items[++top] = value;
    }

    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("stack is empty");
        }

        return items[top--];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stach has:");
            for (int i = top; i > -1; i--) {
                System.out.println(items[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        System.out.println("\n1. Push\n2. Pop\n3. Display\n4. Exit");
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int value = scanner.nextInt();
                    try {
                        stack.push(value);
                        System.out.println(value + " pushed to stack");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        value = stack.pop();
                        System.out.println(value + " popped from stack");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3:
                    stack.display();
                    break;

                case 4:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
