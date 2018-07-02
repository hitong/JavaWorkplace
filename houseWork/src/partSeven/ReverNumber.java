package partSeven;

import java.util.Scanner;

public class ReverNumber {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[] arrary = new double[10];
		
		System.out.print("Enter 10 numbers:");
		for(int i = 0; i < arrary.length; i++)
			arrary[i] = input.nextDouble();
		
		double temp = 0;
		for(int i = 0, j = arrary.length - 1; i <= j; i++,j--){
			temp = arrary[i];
			arrary[i] = arrary[j];
			arrary[j] = temp;
		}
		for(double e: arrary)
			System.out.print(e);
	}

}
