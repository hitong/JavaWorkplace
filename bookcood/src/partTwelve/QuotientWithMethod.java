package partTwelve;

import java.util.Scanner;

public class QuotientWithMethod {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		int result = quptient(number1, number2);
		
		System.out.println(number1 + " / " + 
				number2 + " is " + result);
		input.close();
	}
	
	public static int quptient(int number1, int number2){
		if(number2 == 0){
			System.out.println("Divios cannot be zero");
			System.exit(0);
		}
		
		return number1 / number2;
	}
	
}
