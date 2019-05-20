import java.util.Scanner;

class Staff {
	String staffId, name, phone, salary;
	Scanner sc = new Scanner(System.in);

	void read() {
		System.out.print("Enter staff ID: ");
		staffId = sc.nextLine();
		System.out.print("Enter name: ");
		name = sc.nextLine();
		System.out.print("Enter phone: ");
		phone = sc.nextLine();
		System.out.print("Enter salary: ");
		salary = sc.nextLine();
	}

	void display() {
		System.out.printf("\n%-15s%-15s\n", "Staff ID: ", staffId);
		System.out.printf("%-15s%-15s\n", "Name: ", name);
		System.out.printf("%-15s%-15s\n", "Phone: ", phone);
		System.out.printf("%-15s%-15s\n", "Salary: ", salary);
	}
}

class Teaching extends Staff {
	String domain, pub;

	@Override
	void read() {
		super.read();
		System.out.print("Enter domain: ");
		domain = sc.nextLine();
		System.out.print("Enter publication: ");
		pub = sc.nextLine();
	}

	@Override
	void display() {
		super.display();
		System.out.printf("%-15s%-15s\n", "Domain: ", domain);
		System.out.printf("%-15s%-15s\n", "Publication: ", pub);
	}
}

class Technical extends Staff {
	String skill;

	@Override
	void read() {
		super.read();
		System.out.print("Enter skill: ");
		skill = sc.nextLine();
	}

	@Override
	void display() {
		super.display();
		System.out.printf("%-15s%-15s\n", "Skill: ", skill);
	}
}

class Contract extends Staff {
	String period;

	@Override
	void read() {
		super.read();
		System.out.println("Enter period: ");
		period = sc.nextLine();
	}

	@Override
	void display() {
		super.display();
		System.out.printf("%-15s%-15s\n", "Period: ", period);
	}
}

public class StaffDetails {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of staff: ");
		int n = sc.nextInt();

		Teaching teaching[] = new Teaching[n];
		Technical technical[] = new Technical[n];
		Contract contract[] = new Contract[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter teaching staff details:");
			teaching[i] = new Teaching();
			teaching[i].read();
		}

		for (int i = 0; i < n; i++) {
			System.out.println("Enter technical staff details:");
			technical[i] = new Technical();
			technical[i].read();
		}

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract staff details:");
			contract[i] = new Contract();
			contract[i].read();
		}

		System.out.println("\nSTAFF DETAILS");
		System.out.println("\nTEACHING STAFFS");
		for (int i = 0; i < n; i++)
			teaching[i].display();
		System.out.println("\nTECHNICAL STAFFS");
		for (int i = 0; i < n; i++)
			technical[i].display();
		System.out.println("\nCONTRACT STAFFS");
		for (int i = 0; i < n; i++)
			contract[i].display();

		sc.close();
	}
}
