package partEight;

import java.util.Scanner;

public class EightMethodForArr {
	public static double[][] initializeArray(double[][] matrix){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + matrix.length + " rows and " 
				+ matrix[0].length + " columns: ");
		for(int row = 0 ; row < matrix.length; row++){
			for(int column = 0 ; column < matrix[row].length; column++)
				matrix[row][column] = input.nextDouble();
		}
		input.close();
		return matrix;
	}
	
	public static double[][] ranInitializeArray(double[][] matrix){
		for(int row = 0; row < matrix.length; row++)
			for(int column = 0; column < matrix[row].length; column++)
				matrix[row][column] = (int)(Math.random() * 100);
		return matrix;
	}
	
	public static void out(double[][] matrix){
		for(int i = 0 ; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
		System.out.println();
	}
	
	public static double total(double[][] matrix){
		int total = 0;
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length; j++)
				total += matrix[i][j];
		return total;
	}
	
	public static double[] lineSum(double[][] matrix){
		double[] total = new double[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++)
				total[j] += matrix[j][i];
		}
		return total;
	}
	
	public static int maxLine(double[][] matrix){
		double sum = 0;
		double maxSum = 0;
		int maxIndex = 0;
		for(int i = 0; i < matrix.length; i++){
			sum = 0;
			for(int j = 0; j < matrix[i].length; j++){
				sum +=	matrix[i][j];
			}
			if(maxSum < sum){
				maxIndex = i;
				maxSum = sum;
			}
		}
		return maxIndex;
	}
	
	public static double[][] ranArr(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				int jx = (int)(Math.random() * matrix.length);
				int jy = (int)(Math.random() * matrix.length);
				double temp = matrix[i][j];
				matrix[i][j] = matrix[jx][jy];
				matrix[jx][jy] = temp;
				
			}
		}
		return matrix;
	}
}
