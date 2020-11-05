import java.util.Scanner;

class Staff {
    protected Scanner scanner;
    protected String id, name, phone, salary;

    public Staff() {
        scanner = new Scanner(System.in);
    }

    public void read() {
        System.out.print("Enter staff ID: ");
        id = scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter phone: ");
        phone = scanner.nextLine();
        System.out.print("Enter salary: ");
        salary = scanner.nextLine();
    }

    public void display() {
        System.out.printf("\n%-15s%-15s\n", "Staff ID: ", id);
        System.out.printf("%-15s%-15s\n", "Name: ", name);
        System.out.printf("%-15s%-15s\n", "Phone: ", phone);
        System.out.printf("%-15s%-15s\n", "Salary: ", salary);
    }
}

class Teaching extends Staff {
    private String domain, publications;

    @Override
    public void read() {
        super.read();
        System.out.print("Enter domain: ");
        domain = scanner.nextLine();
        System.out.print("Enter publications: ");
        publications = scanner.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-15s%-15s\n", "Domain: ", domain);
        System.out.printf("%-15s%-15s\n", "Publications: ", publications);
    }
}

class Technical extends Staff {
    private String skill;

    @Override
    public void read() {
        super.read();
        System.out.print("Enter skill: ");
        skill = scanner.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-15s%-15s\n", "Skill: ", skill);
    }
}

class Contract extends Staff {
    private String period;

    @Override
    public void read() {
        super.read();
        System.out.println("Enter period: ");
        period = scanner.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-15s%-15s\n", "Period: ", period);
    }
}

public class StaffDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of teaching staff: ");
        Teaching[] teachings = new Teaching[scanner.nextInt()];
        for (Teaching teaching : teachings) {
            System.out.println("Enter teaching staff details:");
            teaching = new Teaching();
            teaching.read();
        }

        System.out.print("Enter no of technical staff: ");
        Technical[] technicals = new Technical[scanner.nextInt()];
        for (Technical technical : technicals) {
            System.out.println("Enter technical staff details:");
            technical = new Technical();
            technical.read();
        }

        System.out.print("Enter no of contract staff: ");
        Contract[] contracts = new Contract[scanner.nextInt()];
        for (Contract contract : contracts) {
            System.out.println("Enter contract staff details:");
            contract = new Contract();
            contract.read();
        }

        System.out.println("\nTEACHING STAFFS");
        for (Teaching teaching : teachings) {
            teaching.display();
        }
        System.out.println("\nTECHNICAL STAFFS");
        for (Technical technical : technicals) {
            technical.display();
        }
        System.out.println("\nCONTRACT STAFFS");
        for (Contract contract : contracts) {
            contract.display();
        }

        scanner.close();
    }
}
