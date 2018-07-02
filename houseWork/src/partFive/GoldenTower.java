package partFive;

import java.util.Scanner;

public class GoldenTower {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of lines:");
		int number = input.nextInt();
		
		arr(number);
	}
	
	public static void arr(int num){
		int line = 1;
		for(int i = 1 ; i <= num ; i++ )
		{
			
			for(int j = num - i ; j > 0 ; j-- )
				System.out.print("   ");
			for(int k = line ; k > 0 ; k--)
			{
				System.out.printf("%2d " , k);
			}
			for(int l = 2 ; l <= line ; l++)
			{
				System.out.printf("%2d " , l);
			}
			System.out.println();
			line++;
		}
		
	}
}
