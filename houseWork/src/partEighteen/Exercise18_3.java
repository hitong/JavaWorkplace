package partEighteen;

import java.util.Scanner;

public class Exercise18_3 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		System.out.println(gcd(m, n) + " ");
		input.close();
	}
	
	public static int gcd(int m, int n){
		int  t = 0;
		if(m % n == 0){
			return n;
		}
		else{
			t= gcd(n, n % m);
		}
		return t;
	}
}
