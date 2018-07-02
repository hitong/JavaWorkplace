package partFive;

import java.util.Scanner;

public class Exercise5point21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Loan Amount: ");
		int monney = input.nextInt();
		System.out.print("Number of Years: ");
		int year = input.nextInt();
		System.out.println("Interest Rate    Monthly Payment    Total Payment");
		for(double i = 5 ; i <= 8 ; i += 0.125){
			System.out.printf("%1.3f            ",i);
			double monthlyPayment = (monney * i / 1200) / (1 - (1 / Math.pow((1 + i / 1200) , 12 * year)));
			System.out.printf("%1.2f", monthlyPayment);
			String number2 = "" + monthlyPayment;
			space(number2,"Monthly Payment");
			System.out.printf("%1.2f\n", monthlyPayment * year * 12);
		}
	}
	
	
	public static void space(String num,String s){
		int m = s.length() + 4 - num.length(); 
		while((m--) > 0)
			System.out.print(" ");
	}
}
