package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GoldAccount extends RegularAccount{
	double interestRate = .05;
	public GoldAccount(double balance, int accountNumber, int customerID, String customerName) {
		super(balance, accountNumber, customerID, customerName);
	}
	public GoldAccount(int accountNumber) {
		super(accountNumber);
	}
//5% interest, can withdraw indefinitely
	
	protected void withdrawMoney() {
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the amount to be withdrawn: ");
			double takeMoney = in.nextDouble();
			this.balance = this.balance - takeMoney;
			System.out.printf("The new balance of the account is: $%.2f", this.balance);
			System.out.println();
			if(this.balance < 0)
				System.out.println("Be careful! Your account is overdrawn.");
		} catch (InputMismatchException withdrawError){
			System.out.println("Input error. Please enter a numerical value.");
		}
	}
	
	protected void applyEndOfMonth() {		//interest only applies when account is in the positive, no fees regardless
		if(this.balance >= 0)
			this.balance = (this.balance + (this.balance * interestRate));
	}
	
}
