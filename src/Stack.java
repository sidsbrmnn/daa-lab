import java.util.Scanner;

public class Stack {
	Scanner sc = new Scanner(System.in);
	int max, s[], top;

	Stack(int n) {
		max = n;
		s = new int[max];
		top = -1;
	}

	void push() {
		if (top == max - 1)
			System.out.println("Stack overflow.");
		else {
			System.out.print("Enter element to push: ");
			s[++top] = sc.nextInt();
		}
	}

	void pop() {
		if (top == -1)
			System.out.println("Stack underflow.");
		else
			System.out.println(s[top--] + " is popped from the stack.");
	}

	void display() {
		if (top == -1)
			System.out.println("Stack underflow.");
		else {
			System.out.println("Stack has:");
			for (int i = top; i > -1; i--)
				System.out.println(s[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter stack size: ");
		int n = sc.nextInt();
		Stack stk = new Stack(n);
		System.out.println("1. Push 2. Pop 3. Display 4. Exit");
		while (true) {
			System.out.print("Enter choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				stk.push();
				break;
			case 2:
				stk.pop();
				break;
			case 3:
				stk.display();
				break;
			case 4:
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
