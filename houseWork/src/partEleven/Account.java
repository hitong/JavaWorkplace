package partEleven;

import java.util.Date;
import java.util.ArrayList;

public class Account {
	private int id = 0;
	private static double balance = 0;
	private static double annualInterestRate = 0;
	private String name;
	ArrayList<Transaction> o = new ArrayList<>();
	
	Account(){
		
	}
	
	Account(String name ,int id , double balance1 , double annualInterestRate){
		this.name = name ;
		this.id = id;
		balance = balance1;
		this.annualInterestRate = annualInterestRate;
	}

	void add(char type, double amount){
		Transaction one = new Transaction(type, amount, balance);
		o.add(one);
	}
	
	public ArrayList<Transaction> getO() {
		return o;
	}

	void display(){
		System.out.println("Name:" + name);
		for(int i = 0;i < o.size() ; i++){
			
		}
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	double depositOrWithDraw(double monny ,char type){
		if(type == 'W' && balance >= monny){
			balance = balance - monny;
			return balance;
			
		}
		else if(type == 'W' && balance < monny ){
			System.out.println(balance);
			return balance;
		}
		else {
			balance = balance + monny;
			System.out.println(balance);
			return balance;
		}		
	}
}

class NewAccount extends Account {
		private String name;
		ArrayList<Transaction> transactions;
		private int id;
		private double balance;
		public NewAccount(){
			
		}
		public NewAccount(String name, int id, double balance){
			this.name = name;
			this.id = id;
			this.balance = balance;
		}
		public String getName(){
			return name;
		}
		public int getId(){
			return id;
		}
		public double getBalance()
		{
			return balance;
		}
		
		
		
}

class Transaction {
	private char type;
	private double amount;
	private double balance;
	private String description;
	private java.util.Date date;
	public Transaction(){
		
	}
	public Transaction(char type, double amount, double balance){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		
		date = new java.util.Date();
	}
	public char getType(){
		return type;
	}
	public double getAmount(){
		return amount;
	}
	public double getBalance(){
		return balance;
	}
	public String getDescription(){
		return description;
	}
	public java.util.Date getDate(){
		return date;
	}
	
}