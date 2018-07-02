package partEight;

import java.util.Scanner;
public class Exercise8point2 {
	public static void main(String[] args){	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a 4*4 matrix row by row");
		double[][] matrix = new double[4][4];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4 ; j++){
				matrix[i][j] = input.nextDouble();
			}
		}
		System.out.print("Sum of the elements in the major diagonal is " + 
				sumMajprDiagonal(matrix));
		
	}
	

	
	public static double sumMajprDiagonal(double[][] m){
		double sum = 0;
		for(int i = 0 ; i < m.length ; i++){
			for(int j = 0 ; j < m[i].length ; j++){
				if( i == j)
					sum += m[i][j];
			//	else if(i == m[i].length - j)
			//		sum += m[i][j];
				
			}
	
		}
		return sum;
	}
}
