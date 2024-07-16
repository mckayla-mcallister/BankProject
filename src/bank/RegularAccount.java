package bank;

import java.util.*;

public class RegularAccount {
	//must include balance, account number, customer name and customer ID
	protected double balance;		//uses double because it's the most precise
	private int accountNumber;
	private int customerID;
	private String customerName;
	//Regular account has interest of 6%
	//Monthly charge of 10 dollars
	//If more than in account is withdrawn, only the amount in the account is withdrawn
	//no transaction fee for regular accounts
	private double interestRate = .06;
	private int monthlyFee = 10;
	
	public RegularAccount(double balance, int accountNumber, int customerID, String customerName) {  //no empty constructor because you NEED these things to open an account.
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.customerID = customerID;
		this.customerName = customerName;
	}
	public RegularAccount(int accountNumber) {
		if(accountNumber >= 0)
			this.accountNumber = accountNumber;
		else
			System.out.println("Invalid account number.");
	}
	protected void setName(String customerName) {		//No individual get methods because it makes more sense to have a get info method with all of it
		this.customerName = customerName;
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
			}
			else {
				System.out.println("You did not enter a positive value");
			}
		} catch (InputMismatchException depositError) {
			System.out.println("Please enter a positive numerical value.");
		}
	}
	protected void withdrawMoney() {
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the amount to be withdrawn: ");
			double takeMoney = in.nextDouble();
			if(takeMoney > 0) {
				if(this.balance >= takeMoney) {
					this.balance = this.balance - takeMoney;
					System.out.printf("The new balance of the account is: $%.2f", this.balance);
					System.out.println();
				}
				else {
					System.out.printf("Error. Available balance is: $%.2f \nRemaining balance withdrawn.\n\nAmount withdrawn: $%.2f \nAmount remaining: 0.00", this.balance, this.balance);
					System.out.println();
					this.balance = 0;
				}
			}
			else
				System.out.println("Please enter a positive value.");
		} catch (InputMismatchException withdrawError){
			System.out.println("Input error. Please enter a numerical value.");
		}
		
			
		}
	protected void getInformation() {
		System.out.printf("Account Number: " + this.accountNumber + "\nAvailable Balance: $%.2f\nCustomer Name: " + this.customerName + "\nCustomer ID: " + this.customerID + "\n", this.balance);
		System.out.println();
	}
	protected void removeAccount() {
		this.balance = 0;
		this.accountNumber = 0;
		this.customerID = 0;
		this.customerName = "deleted";
	}
	protected int getAccountNumber() {		//needed this getter method to use in the search method in BankMenu
		return this.accountNumber;
	}
	public boolean equals(RegularAccount account) {
		if (this.accountNumber == account.getAccountNumber()) {
			return true;
		}
		else
			return false;
	}
	
	protected void applyEndOfMonth() {		//monthly fee applies regardless, but the interest rate only applies when money is in the account.
		if(this.balance >= 0)
			this.balance = (((this.balance) + ((this.balance)*interestRate)) - monthlyFee);
		if(this.balance < 0)
			this.balance = this.balance - monthlyFee;
	}
}
