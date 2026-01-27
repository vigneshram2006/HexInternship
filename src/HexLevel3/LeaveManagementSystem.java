package HexLevel3;

import java.util.*;
class Employee {
    int id;
    String name;
    int leaveBalance;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.leaveBalance = 20; 
    }

    void deductLeave(int days) {
        this.leaveBalance -= days;
    }
}

class LeaveRequest {
    int empId;
    int days;
    String reason;
    String status; 

    LeaveRequest(int empId, int days, String reason) {
        this.empId = empId;
        this.days = days;
        this.reason = reason;
        this.status = "Pending";
    }
}



public class LeaveManagementSystem {

	static ArrayList<Employee> employees = new ArrayList<>();
	static ArrayList<LeaveRequest> requests = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		
		employees.add(new Employee(101, "Ravi"));
		employees.add(new Employee(102, "Anita"));

		while (true) {
			System.out.println("\n--- Employee Leave Management System ---");
			System.out.println("1. Apply Leave");
			System.out.println("2. View Leave Requests");
			System.out.println("3. Approve / Reject Leave");
			System.out.println("4. Check Leave Balance");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				applyLeave();
				break;
			case 2:
				viewRequests();
				break;
			case 3:
				processLeave();
				break;
			case 4:
				checkBalance();
				break;
			case 5:
				System.out.println("Exiting system...");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	static void applyLeave() {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = findEmployee(id);
		if (emp == null) {
			System.out.println("Employee not found");
			return;
		}

		System.out.print("Enter number of leave days: ");
		int days = sc.nextInt();
		sc.nextLine();

		if (days > emp.leaveBalance) {
			System.out.println("Not enough leave balance");
			return;
		}

		System.out.print("Enter reason: ");
		String reason = sc.nextLine();

		requests.add(new LeaveRequest(id, days, reason));
		System.out.println("Leave request submitted");
	}

	static void viewRequests() {
		if (requests.isEmpty()) {
			System.out.println("No leave requests");
			return;
		}

		for (int i = 0; i < requests.size(); i++) {
			LeaveRequest r = requests.get(i);
			System.out.println((i + 1) + ". EmpID: " + r.empId + ", Days: " + r.days + ", Reason: " + r.reason
					+ ", Status: " + r.status);
		}
	}

	static void processLeave() {
		viewRequests();
		if (requests.isEmpty())
			return;

		System.out.print("Select request number: ");
		int index = sc.nextInt() - 1;

		if (index < 0 || index >= requests.size()) {
			System.out.println("Invalid request");
			return;
		}

		LeaveRequest r = requests.get(index);
		Employee emp = findEmployee(r.empId);

		System.out.print("Approve (1) or Reject (0): ");
		int decision = sc.nextInt();

		if (decision == 1) {
			r.status = "Approved";
			emp.deductLeave(r.days);
			System.out.println("Leave approved");
		} else {
			r.status = "Rejected";
			System.out.println("Leave rejected");
		}
	}

	static void checkBalance() {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = findEmployee(id);
		if (emp == null) {
			System.out.println("Employee not found");
		} else {
			System.out.println("Leave Balance: " + emp.leaveBalance + " days");
		}
	}

	static Employee findEmployee(int id) {
		for (Employee e : employees) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}
}
