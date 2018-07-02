package partFour;

import java.util.Scanner;

public class Exercise4point2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		//Promet user enter two point in degree
		System.out.print("Enter point 1 (latitude  and longtitude) in degree: ");
		double point1Latitude = input.nextDouble();
		double point1Longtitude = input.nextDouble(); 
		System.out.print("Enter point2 (latitude and longtitude) in degree: ");
		double point2Latitude = input.nextDouble();
		double point2Longtitude = input.nextDouble();
		
		double point1x = Math.toRadians(point1Latitude);
		double point1y = Math.toRadians(point1Longtitude);
		double point2x = Math.toRadians(point2Latitude);
		double point2y = Math.toRadians(point2Longtitude);
		
		System.out.print("The distance between the two points is " + 
				(6371.01 * Math.acos(Math.sin(point1x) * Math.sin(point2x) + 
				Math.cos(point1x) * Math.cos(point2x) * Math.cos(point1y - point2y))));
	}
}
