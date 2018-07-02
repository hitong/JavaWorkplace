package partTwelve;

import java.util.Scanner;


public class QuotientWithException {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		
		
		try{
			int result = quptient(number1, number2);
			System.out.println(number1 + " / " + 
				number2 + " is " + result);
		}
		catch(ArithmeticException ex){
			System.out.println("Exception: an integer " + 
					number1 + " cannot be divided by zero");
		}
		
		System.out.println("Exception is continues . . .");
		input.close();
	}
	
	public static int quptient(int number1, int number2){
		if(number2 == 0)
			throw new ArithmeticException("Divisor cannot be zero");
	
		return number1 / number2;
	}
}
