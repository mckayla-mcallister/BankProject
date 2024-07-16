package bank;
import java.util.*;

public class BankMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		ArrayList<RegularAccount> regularAccountsList = new ArrayList<>();
		ArrayList<GoldAccount> goldAccountsList = new ArrayList<>();
		ArrayList<CheckingAccount> checkingAccountsList = new ArrayList<>();
		populateRegularAccounts(regularAccountsList);
		populateCheckingAccounts(checkingAccountsList);
		populateGoldAccounts(goldAccountsList);
		boolean allowInput = true;
		while (allowInput) {
			System.out.println();
			System.out.printf("%15s\n", "Bank Menu");
			System.out.println("==============================");
			System.out.println("1. Create Checking Account");
			System.out.println("2. Create Gold Account");
			System.out.println("3. Create Regular Account");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			System.out.println("6. Display Account Info.");
			System.out.println("7. Remove an Account");
			System.out.println("8. Apply end of month <Interest/Fees>");
			System.out.println("9. Display Bank Statistics");
			System.out.println("10. Exit");
			System.out.println("Please input your choice <1-10>: ");
		try{
			Scanner in = new Scanner(System.in);	
			int userInput = in.nextInt();
			if(userInput <= 10 && userInput >= 1) {
				switch(userInput) {
					case 1: 
						checkingAccountsList.add(newCheckingAccount());
						break;
					case 2: 
						goldAccountsList.add(newGoldAccount());
						break;
					case 3: 
						regularAccountsList.add(newRegularAccount());
						break;
					case 4:
						boolean allowSearchForDeposit = true;
						while(allowSearchForDeposit) {
						try {
							System.out.println("Please enter the account type.\n1. Regular Account\n2. Checking Account\n3. Gold Account \n4. Not sure");
							int accountType = in.nextInt();
							System.out.println("Please enter the account number: ");
							int searchAccountNumber = in.nextInt();			//type mismatch causes an error
							if(accountType >= 1 && accountType <= 4) {
								allowSearchForDeposit = false;
								switch(accountType) {
									case 1:
										int accountIndex = (SearchRegularAccount(regularAccountsList, searchAccountNumber));
										if(accountIndex != -1) 
											(regularAccountsList.get(accountIndex)).depositMoney();
										break;
									case 2:
										accountIndex = (SearchCheckingAccount(checkingAccountsList, searchAccountNumber));
										if(accountIndex != -1) 
											(checkingAccountsList.get(accountIndex)).depositMoney();
										break;
									case 3:
										accountIndex = (SearchGoldAccount(goldAccountsList, searchAccountNumber));
										if(accountIndex != -1) 
											(goldAccountsList.get(accountIndex)).depositMoney();
										break;
									case 4:
										accountIndex = SearchAllAccountsForIndex(regularAccountsList, checkingAccountsList, goldAccountsList, searchAccountNumber);
										if(accountIndex != -1) {
											if(isRegularAccount(regularAccountsList, accountIndex, searchAccountNumber) == true) 
												(regularAccountsList.get(accountIndex)).depositMoney();
											else if (isCheckingAccount(checkingAccountsList, accountIndex, searchAccountNumber) == true)
												(checkingAccountsList.get(accountIndex)).depositMoney();
											else if (isGoldAccount(goldAccountsList, accountIndex, searchAccountNumber) == true)
												(goldAccountsList.get(accountIndex)).depositMoney();
										}
										else {
											System.out.println("A match was not found.");
										}
										break;
								} //end of switch
							} //end of "if" statement
							} catch (InputMismatchException searchAccountType){
								System.out.println("Please enter a valid response.");
							}
						}
						break;
					case 5: 		//withdraw
						boolean allowSearchForWithdraw = true;
						while(allowSearchForWithdraw) {
							try {
								System.out.println("Please enter the account type.\n1. Regular Account\n2. Checking Account\n3. Gold Account \n4. Not sure");
								int accountType = in.nextInt();
								System.out.println("Please enter the account number: ");
								int searchAccountNumber = in.nextInt();			//type mismatch causes an error
								if(accountType >= 1 && accountType <= 4) {
									allowSearchForWithdraw = false;
									switch(accountType) {
										case 1:
											int accountIndex = (SearchRegularAccount(regularAccountsList, searchAccountNumber));
											if(accountIndex != -1) 
												(regularAccountsList.get(accountIndex)).withdrawMoney();
											break;
										case 2:
											accountIndex = (SearchCheckingAccount(checkingAccountsList, searchAccountNumber));
											if(accountIndex != -1) 
												(checkingAccountsList.get(accountIndex)).withdrawMoney();
											break;
										case 3:
											accountIndex = (SearchGoldAccount(goldAccountsList, searchAccountNumber));
											if(accountIndex != -1) 
												(goldAccountsList.get(accountIndex)).withdrawMoney();
											break;
										case 4:
											accountIndex = SearchAllAccountsForIndex(regularAccountsList, checkingAccountsList, goldAccountsList, searchAccountNumber);
											if(accountIndex != -1) {
												if(isRegularAccount(regularAccountsList, accountIndex, searchAccountNumber) == true) 
													(regularAccountsList.get(accountIndex)).withdrawMoney();
												else if (isCheckingAccount(checkingAccountsList, accountIndex, searchAccountNumber) == true)
													(checkingAccountsList.get(accountIndex)).withdrawMoney();
												else if (isGoldAccount(goldAccountsList, accountIndex, searchAccountNumber) == true)
													(goldAccountsList.get(accountIndex)).withdrawMoney();
											}
											else if(accountIndex == -1) {
												System.out.println("A match was not found.");
											}
											break;
									} //end of switch
								} //end of "if" statement
							} catch (InputMismatchException searchAccountType){
								System.out.println("Please enter a valid response.");
							}
						}	//end of allowSearch
						break;	
					case 6:			//display info
						boolean allowSearchForDisplay = true;
						while(allowSearchForDisplay) {
							try {
								System.out.println("Please enter the account type.\n1. Regular Account\n2. Checking Account\n3. Gold Account \n4. Not sure");
								int accountType = in.nextInt();
								System.out.println("Please enter the account number: ");
								int searchAccountNumber = in.nextInt();			//type mismatch causes an error
								if(accountType >= 1 && accountType <= 4) {
									allowSearchForDisplay = false;
									switch(accountType) {
										case 1:
											int accountIndex = (SearchRegularAccount(regularAccountsList, searchAccountNumber));
											if(accountIndex != -1)
												(regularAccountsList.get(accountIndex)).getInformation();;
											break;
										case 2:
											accountIndex = (SearchCheckingAccount(checkingAccountsList, searchAccountNumber));
											if(accountIndex != -1)
												(checkingAccountsList.get(accountIndex)).getInformation();
											break;
										case 3:
											accountIndex = (SearchGoldAccount(goldAccountsList, searchAccountNumber));
											if(accountIndex != -1)
												(goldAccountsList.get(accountIndex)).getInformation();
											break;
										case 4:
											accountIndex = SearchAllAccountsForIndex(regularAccountsList, checkingAccountsList, goldAccountsList, searchAccountNumber);
											if(accountIndex != -1) {
												if(isRegularAccount(regularAccountsList, accountIndex, searchAccountNumber) == true) 
													(regularAccountsList.get(accountIndex)).getInformation();
												else if (isCheckingAccount(checkingAccountsList, accountIndex, searchAccountNumber) == true)
													(checkingAccountsList.get(accountIndex)).getInformation();
												else if (isGoldAccount(goldAccountsList, accountIndex, searchAccountNumber) == true)
													(goldAccountsList.get(accountIndex)).getInformation();
											}
											break;
									} //end of switch
								} //end of "if" statement
								} catch (InputMismatchException searchAccountType){
									System.out.println("Please enter a valid response.");
								}
						}
					break;
				case 7:		//remove an account
					//step 1: search
					int accountIndex = -1;
					String typeOfAccount = "";
					boolean allowSearchForRemoval = true;
					while(allowSearchForRemoval) {
						try {
							System.out.println("Please enter the account type.\n1. Regular Account\n2. Checking Account\n3. Gold Account \n4. Not sure");
							int accountType = in.nextInt();
							System.out.println("Please enter the account number: ");
							int searchAccountNumber = in.nextInt();			//type mismatch causes an error
							if(accountType >= 1 && accountType <= 4) {
								allowSearchForRemoval = false;
								switch(accountType) {
									case 1:
										accountIndex = (SearchRegularAccount(regularAccountsList, searchAccountNumber));
										if(accountIndex != -1) {
											(regularAccountsList.get(accountIndex)).getInformation();;
											areYouSureSection(regularAccountsList, accountIndex);		//accounts list, index number
										}
										break;
									case 2:		//checking
										accountIndex = (SearchCheckingAccount(checkingAccountsList, searchAccountNumber));
										if(accountIndex != -1) {
											(checkingAccountsList.get(accountIndex)).getInformation();;
											areYouSureSection(checkingAccountsList, accountIndex);		//accounts list, index number
										}
										break;
									case 3:
										accountIndex = (SearchGoldAccount(goldAccountsList, searchAccountNumber));
										if(accountIndex != -1) {
											(goldAccountsList.get(accountIndex)).getInformation();;
											areYouSureSection(goldAccountsList, accountIndex);		//accounts list, index number
										}
										break;
									case 4:
										accountIndex = SearchAllAccountsForIndex(regularAccountsList, checkingAccountsList, goldAccountsList, searchAccountNumber);
										if(accountIndex != -1) {
											if(isRegularAccount(regularAccountsList, accountIndex, searchAccountNumber) == true) {
												if(accountIndex != -1) {
													(regularAccountsList.get(accountIndex)).getInformation();;
													areYouSureSection(regularAccountsList, accountIndex);
												}
											}
											else if (isCheckingAccount(checkingAccountsList, accountIndex, searchAccountNumber) == true) {
												if(accountIndex != -1) {
													(checkingAccountsList.get(accountIndex)).getInformation();;
													areYouSureSection(checkingAccountsList, accountIndex);
												}
											}
											else if (isGoldAccount(goldAccountsList, accountIndex, searchAccountNumber) == true) {
												if(accountIndex != -1) {
													(goldAccountsList.get(accountIndex)).getInformation();;
													areYouSureSection(goldAccountsList, accountIndex);
												}
											}
										}			
										break;
								} //end of switch
							} //end of "if" statement
							} catch (InputMismatchException searchAccountType){
								System.out.println("Please enter a valid response.");
							}
					}
					break;
				case 8:
					System.out.println("Applying end of month fees and interest...");
					applyEndOfMonthRegular(regularAccountsList);
					applyEndOfMonthChecking(checkingAccountsList);
					applyEndOfMonthGold(goldAccountsList);
					System.out.println("Applied sucessfully!");
					break;
				case 9:		//total sum of all accounts, number of zero-balance accounts, average balance of accounts, the account with largest balance
					double sum = totalSum(regularAccountsList, checkingAccountsList, goldAccountsList);
					System.out.printf("The total sum of all of the accounts of all types is: $%.2f", sum);
					System.out.println();
					numberOfNegativeAccounts(regularAccountsList, checkingAccountsList, goldAccountsList);
					averageBalance(regularAccountsList, checkingAccountsList, goldAccountsList);
					accountsMinMax(regularAccountsList, checkingAccountsList, goldAccountsList);
					break;
				case 10:
					allowInput = false;
					System.out.println("System is logging off...");
					break;
			} //end of switch
		} //end of if userInput
	} catch  (InputMismatchException improperDataType) { 
			System.out.println("Improper value was given. Please look at the options and try again.");	
	}
	} //end of continueInpu
} //end of main

		private static CheckingAccount newCheckingAccount() {
			Scanner in = new Scanner(System.in);
			System.out.println("Please input the customer name: ");
			String name = in.nextLine();
			System.out.println("Please input the customer ID: ");
			int ID = in.nextInt();
			System.out.println("Please input the account number: ");
			int accountNumber = in.nextInt();
			System.out.println("Please input the initial balance: ");
			int balance = in.nextInt();
			CheckingAccount result = new CheckingAccount(balance, accountNumber, ID, name);
			result.getInformation();
			return result;
		}
			
		private static GoldAccount newGoldAccount() {
			Scanner in = new Scanner(System.in);
			System.out.println("Please input the customer name: ");
			String name = in.nextLine();
			System.out.println("Please input the customer ID: ");
			int ID = in.nextInt();
			System.out.println("Please input the account number: ");
			int accountNumber = in.nextInt();
			System.out.println("Please input the initial balance: ");
			int balance = in.nextInt();
			GoldAccount result = new GoldAccount(balance, accountNumber, ID, name);
			result.getInformation();
			return result;
		}
		
		private static RegularAccount newRegularAccount() {
			Scanner in = new Scanner(System.in);
			System.out.println("Please input the customer name: ");
			String name = in.nextLine();
			System.out.println("Please input the customer ID: ");
			int ID = in.nextInt();
			System.out.println("Please input the account number: ");
			int accountNumber = in.nextInt();
			System.out.println("Please input the initial balance: ");
			int balance = in.nextInt();
			RegularAccount result = new RegularAccount(balance, accountNumber, ID, name);
			result.getInformation();
			return result;
		}
		
		private static int SearchRegularAccount(ArrayList<RegularAccount> regularList, int searchAccountNumber) {
			int accountIndex = -1;
			RegularAccount searchAccount = new RegularAccount(searchAccountNumber);
			for(int i = 0; i < regularList.size(); i++) {
				if(searchAccount.getAccountNumber() ==  (regularList.get(i)).getAccountNumber()) {
					accountIndex = i;
					i = regularList.size();
				}
			} //end of for loop
			if(accountIndex == -1)
				System.out.println("A match was not found.");
			return accountIndex;
		}
		
		private static int SearchCheckingAccount(ArrayList<CheckingAccount> checkingList, int searchAccountNumber) {
			int accountIndex = -1;
			CheckingAccount searchAccount = new CheckingAccount(searchAccountNumber);
			for(int i = 0; i < checkingList.size(); i++) {
				if(searchAccount.getAccountNumber() ==  (checkingList.get(i)).getAccountNumber()) {
					accountIndex = i;
					i = checkingList.size();
				}
			} //end of for loop
			if(accountIndex == -1)
				System.out.println("A match was not found.");
			return accountIndex;
		}
		
		private static int SearchGoldAccount(ArrayList<GoldAccount> goldList, int searchAccountNumber) {
			int accountIndex = -1;
			GoldAccount searchAccount = new GoldAccount(searchAccountNumber);
			for(int i = 0; i < goldList.size(); i++) {
				if(searchAccount.getAccountNumber() ==  (goldList.get(i)).getAccountNumber()) {
					accountIndex = i;
					i = goldList.size();
				}
			} //end of for loop
			if(accountIndex == -1)
				System.out.println("A match was not found.");
			return accountIndex;
		}
		
		private static int SearchAllAccountsForIndex(ArrayList<RegularAccount> regularList, ArrayList<CheckingAccount> checkingList, ArrayList<GoldAccount> goldList, int searchAccountNumber) {
			int accountIndex = -1;
			RegularAccount searchAccount = new RegularAccount(searchAccountNumber);		//I am aware that this doesn't work well when the account numbers can be the same
			for(int i = 0; i < regularList.size(); i++) {
				if(searchAccount.equals(regularList.get(i)) == true) {
					accountIndex = i;
					i = regularList.size();
				}
			}
			if(accountIndex == -1) {
				CheckingAccount searchCheckingAccount = new CheckingAccount(searchAccountNumber);		//if there were no previous matches, it searches the next list
				for(int i = 0; i < checkingList.size(); i++) {
					if(searchCheckingAccount.equals(checkingList.get(i)) == true) {
						accountIndex = i;
						i = checkingList.size();
					}
				}
			}
			if(accountIndex == -1) {
				GoldAccount searchGoldAccount = new GoldAccount(searchAccountNumber);
				for(int i = 0; i < goldList.size(); i++) {
					if(searchGoldAccount.equals(goldList.get(i)) == true) {
						accountIndex = i;
						i = goldList.size();
					}
				}
			}
			return accountIndex;
		}
		
		private static boolean isRegularAccount(ArrayList<RegularAccount> regularList, int accountIndex, int searchAccountNumber) {
			boolean isRegularAccountAnswer = false;
			if ((regularList.get(accountIndex)).getAccountNumber() == searchAccountNumber) 
				isRegularAccountAnswer = true;
			return isRegularAccountAnswer;
		}
		
		private static boolean isCheckingAccount(ArrayList<CheckingAccount> checkingList, int accountIndex, int searchAccountNumber) {
			boolean isCheckingAccountAnswer = false;
			if ((checkingList.get(accountIndex)).getAccountNumber() == searchAccountNumber) 
				isCheckingAccountAnswer = true;
			return isCheckingAccountAnswer;
		}
		
		private static boolean isGoldAccount(ArrayList<GoldAccount> goldList, int accountIndex, int searchAccountNumber) {
			boolean isGoldAccountAnswer = false;
			if ((goldList.get(accountIndex)).getAccountNumber() == searchAccountNumber) 
				isGoldAccountAnswer = true;
			return isGoldAccountAnswer;
		}
		
		private static void areYouSureSection(ArrayList accountsList, int accountIndex) {
			if(accountIndex != -1) {
				((RegularAccount) accountsList.get(accountIndex)).getInformation();;
				boolean doAreYouSureSection = true;
				while(doAreYouSureSection) {
					try {
					System.out.println("\nAre you sure you wish to delete this account?\n1. Yes\n2. No ");
					Scanner areYouSure = new Scanner(System.in);
					int response = areYouSure.nextInt();
					if(response == 1) {
						removeAccount(accountsList, accountIndex);
						doAreYouSureSection = false;
					}
					else if(response == 2) {
						System.out.println("Okay. Returning to the main menu...");
						doAreYouSureSection = false;
					}
					else
						System.out.println("Improper response was given. Please look at the options and enter a valid number.");
					} catch (InputMismatchException wrongAreYouSure) {
						System.out.println("Please look at the options and enter a numerical value.");
					}
				}
			}
		}
		
		private static void removeAccount(ArrayList accountList, int accountIndex) {
			accountList.remove(accountIndex);
			System.out.println("Account has been removed.");
		}
		
		private static void applyEndOfMonthRegular(ArrayList<RegularAccount> accountList) {
			for(int i = 0; i < accountList.size(); i++) {
				(accountList.get(i)).applyEndOfMonth();
			}
		}
		private static void applyEndOfMonthChecking(ArrayList<CheckingAccount> accountList) {
			for(int i = 0; i < accountList.size(); i++) {
				(accountList.get(i)).applyEndOfMonth();
			}
		}
		
		private static void applyEndOfMonthGold(ArrayList<GoldAccount> accountList) {
			for(int i = 0; i < accountList.size(); i++) {
				(accountList.get(i)).applyEndOfMonth();
			}
		}
		
		//total sum of all accounts, number of zero balance, average balance, the account with the largest balance
		private static double totalSum(ArrayList<RegularAccount> regularArray, ArrayList<CheckingAccount> checkingArray, ArrayList<GoldAccount> goldArray) {
			double sum = 0;
			for(int i = 0; i < regularArray.size(); i++) {
				sum = sum + regularArray.get(i).balance;
			}
			for(int i = 0; i < checkingArray.size(); i++) {
				sum = sum + checkingArray.get(i).balance;
			}
			for(int i = 0; i < goldArray.size(); i++) {
				sum = sum + goldArray.get(i).balance;
			}
			return sum;
		}
		
		private static void numberOfNegativeAccounts(ArrayList<RegularAccount> regularArray, ArrayList<CheckingAccount> checkingArray, ArrayList<GoldAccount> goldArray) {
			int total = 0;
			for(int i = 0; i < regularArray.size(); i++) {
				if(regularArray.get(i).balance < 0)
					total++;
			}
			for(int i = 0; i < checkingArray.size(); i++) {
				if(checkingArray.get(i).balance < 0)
					total++;
			}
			for(int i = 0; i < goldArray.size(); i++) {
				if(goldArray.get(i).balance < 0)
					total++;
			}
			System.out.println("The number of accounts in the negative is: " + total);
		}
		private static void averageBalance(ArrayList<RegularAccount> regularArray, ArrayList<CheckingAccount> checkingArray, ArrayList<GoldAccount> goldArray) {
			double sum = totalSum(regularArray, checkingArray, goldArray);
			int numberOfAccounts = regularArray.size() + checkingArray.size() + goldArray.size();
			double average = sum / numberOfAccounts;
			System.out.printf("The current average balance of all accounts is $%.2f", average);
			System.out.println();
		}
		private static void accountsMinMax(ArrayList<RegularAccount> regularArray, ArrayList<CheckingAccount> checkingArray, ArrayList<GoldAccount> goldArray) {	//if two accounts have the same highest value, the one that comes first is deemed the account with the highest value
			int maxIndexReg = 0;
			int minIndexReg = 0;
			int maxIndexCheck = 0;
			int minIndexCheck = 0;
			int maxIndexGold = 0;
			int minIndexGold = 0;
			int maxType = 1;
			int minType = 1;
			double maxBalance = regularArray.get(0).balance;
			double minBalance = regularArray.get(0).balance;
			
			for(int i = 0; i < regularArray.size(); i++) {
				if(regularArray.get(maxIndexReg).balance < regularArray.get(i).balance) {
					maxIndexReg = i;
					if(maxBalance < regularArray.get(i).balance)
						maxType = 1;
				}
				if(regularArray.get(minIndexReg).balance > regularArray.get(i).balance) {
					minIndexReg = i;
					if(minBalance > regularArray.get(i).balance)
						minType = 1;
				}
			}
			for(int i = 0; i < checkingArray.size(); i++) {
				if(checkingArray.get(maxIndexCheck).balance < checkingArray.get(i).balance) {
					maxIndexCheck = i;
					if(maxBalance < checkingArray.get(i).balance)
						maxType = 2;
				}
				if(checkingArray.get(minIndexCheck).balance < checkingArray.get(i).balance) {
					maxIndexCheck = i;
					if(minBalance > checkingArray.get(i).balance)
						minType = 2;
				}
			}
			for(int i = 0; i < goldArray.size(); i++) {
				if(goldArray.get(maxIndexCheck).balance < goldArray.get(i).balance) {
					maxIndexCheck = i;
					if(maxBalance < goldArray.get(i).balance)
						maxType = 2;
				}
				if(goldArray.get(minIndexCheck).balance < goldArray.get(i).balance) {
					maxIndexCheck = i;
					if(minBalance > goldArray.get(i).balance)
						minType = 2;
				}
			}
			System.out.println("This is the account with the most money:");
			if(maxType == 1) 
				regularArray.get(maxIndexReg).getInformation();
			else if(maxType == 2)
				checkingArray.get(maxIndexCheck).getInformation();
			else if(maxType == 3)
				goldArray.get(maxIndexGold).getInformation();
			
			System.out.println("This is the account with the least money: ");
			if(minType == 1)
				regularArray.get(minIndexReg).getInformation();
			else if(minType == 2)
				checkingArray.get(minIndexCheck).getInformation();
			else if(minType == 3)
				goldArray.get(minIndexGold).getInformation();
		}
		
		private static void populateRegularAccounts(ArrayList<RegularAccount> regularAccounts){
			RegularAccount regAccount1 = new RegularAccount(-47.83, 1, 1, "Han Solo");
			RegularAccount regAccount2 = new RegularAccount(150.79, 2, 2, "Luke Skywalker");
			RegularAccount regAccount3 = new RegularAccount(256.22, 3, 1, "Obi-wan Kenobi");
			RegularAccount regAccount4 = new RegularAccount(283.93, 4, 3, "Darth Vader");
			RegularAccount regAccount5 = new RegularAccount(236.95, 5, 4, "Chew Bacca");	//continuous naming convention in case of future customer object implementation
			RegularAccount regAccount6 = new RegularAccount(732.71, 6, 5, "Boba Fett");
			RegularAccount regAccount7 = new RegularAccount(238.22, 7, 6, "C 3PO");	//all people will have a first and last name
			RegularAccount regAccount8 = new RegularAccount(582.56, 8, 7, "Kylo Ren");
			regularAccounts.add(regAccount1);
			regularAccounts.add(regAccount2);
			regularAccounts.add(regAccount3);
			regularAccounts.add(regAccount4);
			regularAccounts.add(regAccount5);
			regularAccounts.add(regAccount6);
			regularAccounts.add(regAccount7);
			regularAccounts.add(regAccount8);
		}
		private static void populateCheckingAccounts(ArrayList<CheckingAccount> checkingAccounts){
			CheckingAccount checkAccount1 = new CheckingAccount(50.62, 9, 1, "Hermione Granger");
			CheckingAccount checkAccount2 = new CheckingAccount(150.79, 10, 2, "Harry Potter");
			CheckingAccount checkAccount3 = new CheckingAccount(-24.54, 11, 1, "Draco Malfoy");
			CheckingAccount checkAccount4 = new CheckingAccount(283.93, 12, 3, "Severus Snape");
			CheckingAccount checkAccount5 = new CheckingAccount(236.95, 13, 4, "Lord Voldemort");
			CheckingAccount checkAccount6 = new CheckingAccount(732.71, 14, 5, "Ron Weasley");
			CheckingAccount checkAccount7 = new CheckingAccount(238.22, 15, 6, "Albus Dumbledore");
			CheckingAccount checkAccount8 = new CheckingAccount(582.56, 16, 7, "Sorting Hat");
			checkingAccounts.add(checkAccount1);
			checkingAccounts.add(checkAccount2);
			checkingAccounts.add(checkAccount3);
			checkingAccounts.add(checkAccount4);
			checkingAccounts.add(checkAccount5);
			checkingAccounts.add(checkAccount6);
			checkingAccounts.add(checkAccount7);
			checkingAccounts.add(checkAccount8);
		}
		private static void populateGoldAccounts(ArrayList<GoldAccount> goldAccounts){
			GoldAccount goldAccount1 = new GoldAccount(50.62, 17, 1, "Frodo Baggins");
			GoldAccount goldAccount2 = new GoldAccount(150.79, 18, 2, "Samwise Gamgee");
			GoldAccount goldAccount3 = new GoldAccount(256.22, 19, 1, "Saruman theWhite");
			GoldAccount goldAccount4 = new GoldAccount(283.93, 20, 3, "Gandalf theGrey");
			GoldAccount goldAccount5 = new GoldAccount(236.95, 21, 4, "Legolas Thranduilion");
			GoldAccount goldAccount6 = new GoldAccount(732.71, 22, 5, "Aragorn Elessar");
			GoldAccount goldAccount7 = new GoldAccount(238.22, 23, 6, "Gimli sonofGloin");
			GoldAccount goldAccount8 = new GoldAccount(-226.78, 24, 7, "Smeagol Gollum");
			goldAccounts.add(goldAccount1);
			goldAccounts.add(goldAccount2);
			goldAccounts.add(goldAccount3);
			goldAccounts.add(goldAccount4);
			goldAccounts.add(goldAccount5);
			goldAccounts.add(goldAccount6);
			goldAccounts.add(goldAccount7);
			goldAccounts.add(goldAccount8);
		}
		
	}

