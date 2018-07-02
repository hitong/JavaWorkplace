package partSeven;

import java.util.Scanner;

public class Average {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[] number = new double[10];
		
		System.out.print("Enter 10 number:");
		for(int i = 0; i < number.length; i++ ){
			number[i] = input.nextDouble();
		}
		
		System.out.println("The average of the array is " + average(number));
	}
	public static int average(int[] array){
		int sum = 0;
		for(int i = 0; i < array.length ; i++){
			sum += array[i] ; 		
		}
		return sum / array.length ;
	}
	
	public static double average(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length ; i++){
			sum += array[i] ; 		
		}
		return sum / array.length ;
	}
}
