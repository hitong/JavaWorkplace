package acm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreeBitSymmetricPrime {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while(true){	
			try{
				System.out.println(test(input.nextInt()) ? "YES" : "NO");	
				/**根据test方法测试输入数据是否为三位素数，返回对应String*/
				
			}catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input a integer");
			}
				
		}	
	}
	
	/**
	 * 该方法判断输入数字是否为三位素数,是三位素数返回true，反之false
	 * @param num
	 * @return
	 */
	public static boolean test(int num){
		num = Math.abs(num);
		int temp1, temp2;
		
		temp1 = num / 100;
		temp2 = num - num / 10 * 10;
		return num > 99 && num < 1000 && temp1 == temp2;
	}
}
