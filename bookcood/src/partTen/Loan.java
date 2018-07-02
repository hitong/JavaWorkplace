package partTen;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Loan implements Serializable{
		private double annualInterestRate;
		private double numberOfYears;
		private double loanAmount;
		private transient java.util.Date loanDate;
		
		void Serializable(){
			Loan get = (Loan)this;
			get.loanDate = this.loanDate;
		}
		
		
		public Loan(){
			this(2.5 , 1 , 1000);
		}
		
		// Constract of loan with specified annual interest rate
		public Loan(double annualInterestRate , int numberOfYears , double loanAmount){
			this.annualInterestRate = annualInterestRate;
			this.numberOfYears = numberOfYears;
			this.loanAmount = loanAmount;
			loanDate = new java.util.Date();
			
		}

		// Return  annnualInerrestRate
		public double getAnnualInterestRate() {
			return annualInterestRate;
		}

		// set a new herAnnualRate
		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate;
		}

		// return the Number of years
		public double getNumberOfYears() {
			return numberOfYears;
		}

		// set the number if years
		public void setNumberOfYears(double numberOfYears) {
			this.numberOfYears = numberOfYears;
		}

		// get loan amount 
		public double getLoanAmount() {
			return loanAmount;
		}

		// set loan amount
		public void setLoanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
		}

		// Find monthly payment
		public double getMonthlyPayment(){
			double monthlyInterestRate = this.annualInterestRate / 1200;
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
			return monthlyPayment;
		}
		
		// Find total payment
		public double getTotalPayment(){
			double totalPayment = getMonthlyPayment() * numberOfYears * 12;
			return totalPayment;
		}
		
		// return loan date
		public java.util.Date getLoanDate() {
			return loanDate;
		}
}
