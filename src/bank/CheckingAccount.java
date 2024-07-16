package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingAccount extends RegularAccount {
private int numberOfTransactions = 0;
private int numberOfFreeTransactions = 2;
private double transactionCharge = 3;



	public CheckingAccount(double balance, int accountNumber, int customerID, String customerName) {
		super(balance, accountNumber, customerID, customerName);
	}
	public CheckingAccount(int accountNumber) {
		super(accountNumber);
	}
	
	protected void depositMoney() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the amount to be deposited: ");
			double addMoney = in.nextDouble();
			if(addMoney >= 0) {
				this.balance  = this.balance + addMoney;
				System.out.printf("The new balance is: %.2f", this.balance);
				System.out.println();
				numberOfTransactions++;
			}
			else
				System.out.println("Please enter a positive value");
		} catch (InputMismatchException depositError) {
			System.out.println("Please enter a positive numerical value.");
		}
	}
	
	protected void withdrawMoney() {
		try{
			this.getInformation();
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the amount to be withdrawn: ");
			double takeMoney = in.nextDouble();
				
			if(this.balance >= (takeMoney)) 
				this.balance = this.balance - (takeMoney);
			else {
				takeMoney = this.balance;
				System.out.println("Error! Amount attempted to be withdrawn is more than what is available.");
				this.balance = 0;
			}
			System.out.printf("Amount withdrawn: $%.2f", takeMoney);
			System.out.println();
			System.out.printf("Amount remaining: $%.2f", this.balance);
			System.out.println();
			this.numberOfTransactions++;
		} catch (InputMismatchException withdrawError) {
			System.out.println("Please enter a numerical value to withdraw");
		}
	}
	protected void applyEndOfMonth() {
		if (this.numberOfTransactions >= this.numberOfFreeTransactions) {	// no fees if the number of transactions did not exceed the max number of free ones
			double monthlyTransactionFees = (((this.numberOfTransactions + 1) - this.numberOfFreeTransactions) * this.transactionCharge);
			this.balance = (this.balance - monthlyTransactionFees);
		}
		this.numberOfTransactions = 0;
	}
}
