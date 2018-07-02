package partNine;

import java.util.Date;

public class Exercise9point7 {
	public static void main(String[] args){
		Account Id = new Account(1122,20000,0.045);
		Id.withDraw(2500);
		Id.deposit(3000);
		System.out.print(
				"The balance is " + Id.getBalance() +" \n" +
				"The monthly interset rate is " + Id.getMonthlyInterestRate() + "\n" +
				"The Date is " + Id.dateCreated);	
		
	}
	
}


class Account {
	private int id = 0;
	private double balance = 0;
	private static double annualInterestRate = 0;
	Date dateCreated = new Date();

	
	Account(int id , double balance , double annualInterestRate){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	int getId(){
		return id;
	}
	
	void setId(int id){
		this.id = id;
	}
	
	double getBalance(){
		return balance;
	}
	
	void setBalance(double balance){
		this.balance = balance;
	}
	
	double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	double getMonthlyInterestRate(){
		return annualInterestRate / 12.0;
	}
	
	boolean withDraw(double monny){
		if(monny > balance){
			return false;
		}
		else{
			balance = balance - monny;
			return true;
		}
	}
	
	boolean deposit(double monny){
		balance = monny + balance;
		return true;
	}
}