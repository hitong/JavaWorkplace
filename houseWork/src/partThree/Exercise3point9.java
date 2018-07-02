package partThree;

import java.util.Scanner;

public class Exercise3point9 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//Prompt user enter the number
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		String integer = input.next();
		
		int digitInteger = Integer.parseInt(integer);
		int sum = 0;
		for(int i = 9; i >= 1; i--){
			sum = (digitInteger % 10 * i) + sum;
			digitInteger = digitInteger / 10;
		}
		int lastNumber = sum % 11;
		if(lastNumber == 10)
			System.out.println("The ISBN-10 number is " + integer + "X");
		else
			System.out.println("The ISBN-10 number is " + integer + lastNumber);
	}
}
