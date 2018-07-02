package partTwelve;

import java.util.*;

public class TestMismatchException {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){	
		int a = getNumber();
		int b = getNumber();
		
		System.out.println("The sum of " + a + " + " + b + " is " + (a+b) );
		
	}
		
		public static int getNumber(){
			int number;
			try{
				System.out.println("Input a integer number:");
				number = input.nextInt();
			}
			catch(InputMismatchException ex){
				input.next();
				System.out.println("Your enter is err!!!");
				number = getNumber();
			}		
			
			return number;
		}
}

