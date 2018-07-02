package partThree;

import java.util.Scanner;

public class ComputeAndInterpretBMI {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter weight in pounds 
		System.out.print("Enter wight is pounds: ");
		double weight = input.nextDouble();
		
		final double KILOGRAM_PER_POUND = 0.45359237; //Constant
		final double METERS_PER_INCH = 0.0254; // Constant
		
		//Prompt the user to enter height in inches
		System.out.print("Enter the height in inches: ");
		double height = input.nextDouble();
		
		// Comput BMI
		double weightInKilograms = weight * KILOGRAM_PER_POUND;
		double heightInMeters = height * METERS_PER_INCH;
		double bmi = weightInKilograms /
				(heightInMeters * heightInMeters);
		
		//Display result
		System.out.println("BMI is " + bmi);
		if(bmi < 18.5)
			System.out.println("UnderWeight");
		else if(bmi < 25)
			System.out.println("Normal");
		else if(bmi < 30)
			System.out.println("OverWeight");
		else 
			System.out.println("Obese");
		input.close();
	}
}
