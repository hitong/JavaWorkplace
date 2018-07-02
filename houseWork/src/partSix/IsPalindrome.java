package partSix;

import java.util.Scanner;

public class IsPalindrome {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: " );
		int number = input.nextInt();
		
		
		if(isPalindrome(number))
			System.out.println("The number of " + number + " is a palindrome!");
		else
			System.out.println("The number of " + number + " is not a palindrome!");
		
	}
				
	public static boolean isPalindrome(int number){
		int number2 = reverse(number);
		if(number == number2)
			return true;
		else 
			return false;
			
	}
		
	public static int reverse(int number){
		int number2 = 0;
		while(number != 0 ){
			number2 = number % 10 + number2 * 10;
			number = number / 10;
		}			
		return number2;
	}
	
}
