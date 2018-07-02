package partFive;

import java.util.Scanner;

public class Exercise5point19 {
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
					System.out.print("     ");
				for(int k = 1 ; k <= line ; k++)
				{
					System.out.printf("%-4d " ,  (int)Math.pow(2, k - 1));
				}
				for(int l = line -1 ; l >= 1 ; l--)
				{
				System.out.printf("%-4d " , (int)Math.pow(2, l - 1));
				}
				System.out.println();
				line++;
			}
		}
}	


