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
				/**����test�����������������Ƿ�Ϊ��λ���������ض�ӦString*/
				
			}catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input a integer");
			}
				
		}	
	}
	
	/**
	 * �÷����ж����������Ƿ�Ϊ��λ����,����λ��������true����֮false
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
