package partThree;

import java.util.Scanner;

public class ComputeTax {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("0-single filer, 1-married jointly or " + 
		  "qualifying widow(er), 2-married separately, 3-head of " +
		  "household)\nEnter the filing status: ");
		int status = input.nextInt();
		
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();
		
		double tax = 0;	

		if(status == 0)
		{
			tax=compute(status,income,tax);
		}
		else if(status == 1 )
		{
			tax=compute(status,income,tax);
		}
		else if(status == 2 )
		{
			tax=compute(status,income,tax);
		}
		else if(status == 3)
		{
			tax=compute(status,income,tax);
		}
		else
		{
			System.out.println("Error");
			System.exit(1);
		}
		System.out.println("Tax is " + (int)( tax * 100 ) / 100.0 );
		
		input.close();
	}

	public static double compute(int x , double income, double tax) {
		int [][]stander={
				{8350,33950,82250,171550,372950},
				{16700,67900,137050,208850,372950},
				{8350,33950,68525,104425,186475},
				{11950,45500,117450,190200,372950}
				};
		if (income <= stander[x][0])
			return tax = income * 0.10;
		else if (income <= stander[x][1])
			return tax = stander[x][0] * 0.10 + (income - stander[x][0]) * 0.15;
		else if (income <= stander[x][2])
			return tax = stander[x][0] * 0.10 + (stander[x][1] - stander[x][0]) 
			* 0.15 + (income - stander[x][1]) * 0.25;
		else if (income <= stander[x][3])
			return tax = stander[x][0] * 0.10 + (stander[x][1] - stander[x][0]) 
			* 0.15 + (stander[x][2] - stander[x][1]) * 0.25 
			+ (income - stander[x][2]) * 0.28;
		else if (income <= stander[x][4])
			return tax = stander[x][0] * 0.10 + (stander[x][1] - stander[x][0]) 
			* 0.15 + (stander[x][2] - stander[x][1]) * 0.25 + 
			(stander[x][3] - stander[x][2]) * 0.28 +
			(income - stander[x][3]) * 0.33;
		else
			return tax = stander[x][0] * 0.10 + (stander[x][1] - stander[x][0]) * 0.15 + 
			(stander[x][2] - stander[x][1])	* 0.25 + (stander[x][3] - stander[x][2]) 
			* 0.28 + (stander[x][4] - stander[x][3]) * 0.33 +
			(income - stander[x][4]) * 0.35;
	}


}
