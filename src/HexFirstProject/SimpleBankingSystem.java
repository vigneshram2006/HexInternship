package HexFirstProject;

import java.util.*;

class BankAccount {
	double balance = 0;

	public void checkBalance() {
		System.out.printf("Your Current Balance is: %.2f%n" , balance);

	}

	public void depositAmount(double amount) {
		if (amount < 0) {
			System.out.println("Amount can't be negative.");
		}
		balance += amount;
		System.out.println("Amount deposited successfully!");
	}

	public void withdrawAmount(double amount) {
		if (amount < 0) {
			System.out.println("Amount cant be negative.");
		}
		if (amount > balance) {
			System.out.println("Insufficient Balance!");
		}
		balance -= amount;
		System.out.println("Amount Withdrawn successfully!");
	}
}

class Customer {
	int age;
	String name;
	String phoneNumber;

	Customer(int age, String phoneNumber, String name) {
		this.age = age;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void createAccount(int age, String phoneNumber, String name) {
		System.out.println("Account created Successfully!");
	}
}

public class SimpleBankingSystem {

	public static void main(String[] args) {

		BankAccount bk = new BankAccount();
		Scanner scan = new Scanner(System.in);
		System.out.println("******************************");
		System.out.println("Welcome to Banking Application");
		System.out.println("******************************");
		System.out.println("Create Account");
		System.out.print("Enter your name:");
		String name = scan.nextLine();
		System.out.print("Enter your age: ");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter your ph.No:");
		String phoneNumber = scan.nextLine();
		Customer nc = new Customer(age, phoneNumber, name);
		boolean flag=true;

		while (flag) {
			System.out.println();
			System.out.println("******************************");
			System.out.println("Welcome to Banking Application");
			System.out.println("******************************");
			System.out.println("1.Show Balance");
			System.out.println("2.Deposit Amount");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Exit");
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();

			switch (choice) {
			case 1 -> bk.checkBalance();
			case 2 -> {
				System.out.print("Enter amount to be deposited:");
				double amount = scan.nextDouble();
				bk.depositAmount(amount);
			}
			case 3 -> {
				System.out.print("Enter amount to be withdrawn: ");
				double amount = scan.nextDouble();
				bk.withdrawAmount(amount);
			}
			case 4 ->flag=false;
			default -> System.out.println("Enter valid option!");
			}

		}
		System.out.println("**************************");
		System.out.println("Thankyou Have a great day!");
		System.out.println("**************************");

	}
}
