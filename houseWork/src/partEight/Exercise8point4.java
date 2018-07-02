package partEight;

import java.util.Scanner;

public class Exercise8point4 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String[] day = {"Su" , " M" , " T", " W", "Th" , " F" , "Sa"};
		System.out.print("How many emplyees: ");
		int emplyee = input.nextInt();
		
		
		double[][] matrix = new double[emplyee][7];
		for(int i = 0; i < emplyee; i++){
			for(int j = 0; j < 7 ; j++){
				System.out.print("Enter the emplyee" + i + " " + day[j] + 
						"'s hours:");
				matrix[i][j] = input.nextDouble();
			} 
		}
		
		
		for(int i = 0; i < "employee 0  ".length(); i++)
			System.out.print(" ");
		
		for(int i = 0; i < 7; i++)
			System.out.print("  " + day[i]);
		
		System.out.println();
		
		for(int i = 0; i < emplyee; i++){
			System.out.print("Employee " + i + "  " );
			for(int j = 0; j < 7 ; j++)
				System.out.printf("  %2.0f", matrix[i][j]);
			
			
			System.out.println();
		}
		
	}
}
