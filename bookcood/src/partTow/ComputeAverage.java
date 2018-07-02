package partTow;

import java.util.Scanner;

public class ComputeAverage {
	public static void main(String[] args){
		//Create a Scanner Object 
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter three numers
		System.out.print("Enter three numbers:");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		//Compute the aveage
		double average = ( number1 + number2 + number3 ) / 3;
		
		//Display the results;
		System.out.print("The average of " + number1 + " " + number2 + " " +number3 
				+" is " + average );
		
		
		input.close();
	}

}
