import java.util.Scanner;

public class Student {
    private String usn, name, branch, phone;

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter branch: ");
        branch = scanner.nextLine();
        System.out.print("Enter phone number: ");
        phone = scanner.nextLine();
        scanner.close();
    }

    public void display() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", usn, name, branch, phone);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of students: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].read();
        }

        System.out.printf("%-20s%-20s%-20s%-20s\n", "USN", "Name", "Branch", "Phone Number");
        for (Student student : students) {
            student.display();
        }

        scanner.close();
    }
}
