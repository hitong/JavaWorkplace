package partSix;

import java.util.Scanner;
public class DigitalSum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
//		Prompt user to enter a number
		System.out.print("Enter a number: ");
		int n = input.nextInt();
		
		System.out.println("The sum of the digits " + n + " is " +
				sumDigits(n));
	}
	
	public static int sumDigits(long n)
	{
		int sum = 0;
		while(n!=0)	{
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}
