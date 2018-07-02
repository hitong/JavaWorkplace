package partSeven;

import java.util.Scanner;

public class NumberTimes {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number from 1 to 100( 0 is the sign of the end): ");
		int[] number = new int[101];
		while(true){
			number[input.nextInt()]++;
			if(number[0] != 0)
				break;
		}
		for(int i = 1; i < 101; i++)
			if(number[i] > 1)
				System.out.println(i + " occurs " + number[i] + " times ");
			else if(number[i] ==1)
				System.out.println(i + " occurs " + number[i] + " time ");
	}
}
