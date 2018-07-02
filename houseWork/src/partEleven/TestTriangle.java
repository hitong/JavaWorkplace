package partEleven;

import java.util.*;

import partTwelve.Calculator;
public class TestTriangle {
/**	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
				
		System.out.print("Input three sides longth:");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		Triangle triangle = new Triangle(side1, side2, side3);
		
		System.out.print("Input the color:");
		triangle.setColor(input.next());
		
		System.out.print("Do you want it fill(1.yes 2.no):");
		triangle.setFilled(input.nextInt() == 1);
		
		System.out.print("Do you want do change color(1.yes 2.no):");
		if(input.nextInt() == 1)
			triangle.setColor(input.nextLine());
		
		System.out.print("Do you want to set filled(1.yes 2.no): ");
			triangle.setFilled(input.nextInt() == 1);
			
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The getPerimeter is " + triangle.getPerimeter());
		System.out.println("The color is " + triangle.getColor());
		System.out.println("The filled is " + triangle.getFilled());
	}
	*/
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		do{
			try{
				int side1 = input.nextInt();
				int side2 = input.nextInt();
				int side3 = input.nextInt();
				Triangle triangle = new Triangle(side1, side2, side3);
			}
			catch(IllegalTriangleException ex){	
				System.out.println(ex.toString());
			}
			
		}while(true);
	}
}
