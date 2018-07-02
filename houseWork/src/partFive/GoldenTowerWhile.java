package partFive;

import java.util.Scanner;

public class GoldenTowerWhile {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of lines:");
		int number = input.nextInt();
		
		arr(number);
	}
	

	public static void arr(int num){
		int line = 1;
		while((num--) != 0)
		{
			for(int i = line; i <= num + line; i++)
				System.out.print("   ");
			for(int j = line; j >= 1; j-- )
				System.out.printf(" %-2d", j);
			for(int k = 2; k <= line ; k++)
				System.out.printf(" %-2d", k);
			System.out.println();
			line++;
		}
		
	}
}