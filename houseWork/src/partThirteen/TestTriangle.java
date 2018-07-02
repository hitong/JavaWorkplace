package partThirteen;

import java.util.*;



public class TestTriangle {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input three sides longth:");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		System.out.print("Input the color:");
		String color = input.next();
		
		System.out.print("Do you want it fill:");
		boolean filled = input.nextBoolean();
		
		Triangle triangle = new Triangle(side1, side2, side3 , color , filled);
		System.out.println(triangle.toString());
			
	}
}
