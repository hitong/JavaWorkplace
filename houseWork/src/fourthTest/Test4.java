package fourthTest;

import java.util.Scanner;

public class Test4 {
	public static void loop(int n){
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <=i; j++){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void rec(int n){
		if(n < 0){
			throw new IllegalArgumentException();
		}
		
		if(n == 0){
			return;
		}
		else{	
			rec(n - 1);
		}
		for(int i = 0; i < n; i++){		
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		System.out.print("请输入层数:");
		Scanner input = new Scanner(System.in);
	//	loop(input.nextInt());
		rec(input.nextInt());
		input.close();
	}
}
