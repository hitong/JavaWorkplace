package javaBasic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestComplex {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Enter the first complex number: ");
		Complex c1 = TestComplex.createComplex();
		
		System.out.print("Enter the second complx number: ");
		Complex c2 = TestComplex.createComplex();
		
		
		System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
		System.out.println(c1 + " - " + c2 + " = " + c1.substruct(c2));
		System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
		System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
		System.out.println("|" + c1 + "|" + " = " + c1.abs());
	}
	
	
	/**
	 * 输入两个Double类数据，用于创建并返回Complex对象
	 * @return
	 */
	public static Complex createComplex(){
		double[] number = new double[2];
		
		for(int i = 0; i < 2; i++){
			while(true){
				try{
				number[i] = input.nextDouble();
				break;
				}catch(InputMismatchException ex){
					input.next();
					System.out.println("Please input a double");
				}
			}
		}
		
		return	new Complex(number[0], number[1]);
	}
}	
