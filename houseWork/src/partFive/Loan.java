package partFive;

import java.util.Scanner;


public class Loan {
	private double balance;
	private int numberOfYears;
	private double Rate;
	
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Loan Amount:");
		double amount = input.nextDouble();
		
		System.out.print("Number of year:");
		int year = input.nextInt();
		
		System.out.print("Annual Interest Rate:");
		double rate = input.nextDouble();
		
		Loan o = new Loan(amount, year, rate);
		
		o.display();
		
	}
	public Loan(){	
	}
	
	public Loan(double balance, int numberOfYears, double Rate){
		this.balance = balance;
		this.numberOfYears = numberOfYears;
		this.Rate = Rate;
	}
	
	public void display(){
		System.out.println("Payment#\tInterest\t\tPrincipal\t      Balance");
		for( int i = 1; i <= numberOfYears * 12; i++){
			double monthlyInterestRate = Rate / (numberOfYears * 1200.0);
			double interest = balance * monthlyInterestRate ;
			double monthlyPayment = monthlyInterestRate /
					(numberOfYears * 1200.0 );
			double principal = monthlyPayment + interest;
			balance = balance - monthlyPayment;
			System.out.println(i + "\t\t" + interest +
					"\t\t" + principal + "\t\t" + balance);
		}
	}
}

