package partThirteen;

import java.util.*;
public class TextMax {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Input circle1's side:");
		Circle circle1 = new Circle(input.nextDouble());
		
		System.out.println("Input circle2's side:");
		Circle circle2 = new Circle(input.nextDouble());
		
		Circle maxCircle = (Circle)(Circle.getMax(circle1, circle2)); 
		System.out.println(maxCircle.toString());
		
		System.out.println("Input retangle1's width:");
		double width1 = input.nextDouble(); 
		
		System.out.println("Input retangle1's hight:");
		double hight1 = input.nextDouble();
		
		System.out.println("Input retangle2's width:");
		double width2 = input.nextDouble();
		
		System.out.println("Input retangle2's width:");
		double hight2 = input.nextDouble();
		Retangle re1 = new Retangle(hight1, width1);
		Retangle re2 = new Retangle(hight2, width2);
		
		Retangle maxRetangle = (Retangle)Retangle.getMax(re1, re2);
		
		
		System.out.println(maxRetangle.toString());
		
	}
}
