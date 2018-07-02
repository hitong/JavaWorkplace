package partTen;

import java.util.Scanner;

public class Exercise10point7 {	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Account people = new Account();
				
		while(true){
			System.out.print("Enter an id: ");
			int id = input.nextInt();
			
			if(id > people.getIdLength() || id < 0){
				System.out.println(
						"Your id is err!!! Please enter the current id");
				continue;
			}
			else {
				int choice = 0;
				while(choice != 4){
					Menu.displayMenu();			
					choice = input.nextInt();
					if (choice == 1)
						System.out.println("The balance is "
								+  people.getBalance(id));
					else if(choice == 2){
						while(true){
							boolean flag = false;
							System.out.print(
									"Enter an amount to withdraw: ");
							double amount = input.nextDouble();
							while(amount>people.getBalance(id)?false:true){
								people.WithDraw(id, amount);
								flag = true;
								break;
							}
							if(flag)
								break;
							System.out.println();
							System.out.println(
									"Sorry!You don't have enought monney");
							
						}
					}
					else if(choice == 3){
						while(true){
							System.out.print("Enter an amount to deposit: ");
							boolean flag = false;
							double amount = input.nextDouble();
							while(amount<0?false:true){
								people.Deposit(id, amount);
								flag = true;
								break;
							}
							if(flag)
								break;
							System.out.println();
							System.out.println(
									"Sorry!You can't deposit fu monney");
							
						}
					}
					else if(choice == 4){
						System.out.println();
						break;
					}
					else
						System.out.println("Your choice is err!!");
							
				}
			}
		}
	}
	
	//Display menu
	public static class Menu{
		static void displayMenu(){
			System.out.println("Main menu");
			System.out.println("1: check balance");
			System.out.println("2: withdraw");
			System.out.println("3: deposit");
			System.out.println("4: exit");
			System.out.println("Enter a choice: ");
		}
	}
	
	
}


class Account{
	Scanner input = new Scanner(System.in);
	private double[] id = new double[10];
	
	Account(){
		for(int i = 0; i < id.length; i++)
			id[i] = 100;
	}
	
	void WithDraw(int m ,double amount){
		id[m] = id[m] - amount;
	}
	
	void Deposit(int m, double amount){
		id[m] = id[m] + amount;
	}
	
	int getIdLength(){
		return id.length;
	}
	
	double getBalance(int m){
		return this.id[m];
	}
}
