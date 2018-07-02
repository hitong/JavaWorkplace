package partSeven;

import java.util.Scanner;
public class FindMinNumber {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[] number = new double[10];
		
		
		System.out.print("Enter 10 number: ");
		for(int i = 0; i < 10; i++){
			number[i] = input.nextDouble();
		}
		
		System.out.print("The index of smallest element is " +
				(indexOfSmallestElement(number)+1));
	}
	
	public static int indexOfSmallestElement(double[] arrary){
		int minNumberIndex = 0;
		double minNumber = arrary[0];
		
		for (int i = 1; i < arrary.length; i++){
			if(minNumber > arrary[i]){
				minNumber = arrary[i];
				minNumberIndex = i;
			}
		}
		return minNumberIndex;
	}
}
