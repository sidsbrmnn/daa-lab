import java.util.Scanner;

public class Student {
	String usn, name, branch, phone;

	void read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter USN: ");
		usn = sc.nextLine();
		System.out.print("Enter name: ");
		name = sc.nextLine();
		System.out.print("Enter branch: ");
		branch = sc.nextLine();
		System.out.print("Enter phone: ");
		phone = sc.nextLine();
		sc.close();
	}

	void display() {
		System.out.printf("%-20s%-20s%-20s%-20s\n", usn, name, branch, phone);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int n = sc.nextInt();
		Student s[] = new Student[n];
		for (int i = 0; i < n; i++) {
			s[i] = new Student();
			s[i].read();
		}
		System.out.printf("%-20s%-20s%-20s%-20s\n", "USN", "Name", "Branch", "Phone");
		for (int i = 0; i < n; i++)
			s[i].display();
		sc.close();
	}
}
