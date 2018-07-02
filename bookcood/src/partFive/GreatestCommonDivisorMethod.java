package partFive;

import java.util.Scanner;

public class GreatestCommonDivisorMethod {
	public static void main(String[] args){
//		Creat a Scannner
		Scanner input = new Scanner(System.in);
		
		
//	Prompt the user to enter two integer	
		System.out.print("Enter first integer: ");
		int n1 = input.nextInt();
		System.out.print("Enter second integer: ");
		int n2 = input.nextInt();
		
		System.out.print("Enter greatest common divisor for "+
				n1 + " and " + n2 + " is " + gcd(n1,n2));	
		input.close();
	}
	
//	return the gcd of two integers
	public static int gcd(int n1, int n2){
		int gcd = 1;
		int k = 2;
		
		while (k <= n1 && k <= n2){
			if(n1 % k == 0 &&n2 % k ==0)
				gcd = k;//Update gcd
			k++	;		
		}
		return gcd; //return gcd
	}

}
