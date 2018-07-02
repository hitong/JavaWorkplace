package acm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Candy {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] number = new int[3];
		
		int T;
		while(true){
			try{
				T = input.nextInt();
				break;
			}catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input integer");
			}
		}
		
		for(int i = 0; i < T; i++){
			
			for(int j = 0; j < 3; j++){
				while(true){
					try{
						number[j] = input.nextInt();
						break;
					}catch (InputMismatchException ex){
						System.out.println("Please input integer");
						input.next();
					}
					
				}
			}
			
			Candy.print(number);
			
		}
		
		input.close();
	}
	
	

	/**
	 * ͨ�������С���ǹ�ӵ����number[0]��Сè���ǹ�������number[1]��
	 * �Լ�С���ܹ��򵽵���number[2]��֮��Ĺ�ϵ�����ض�Ӧ���
	*/
	public static void print(int[] number){
		if(number[0] >= number[1]){
			System.out.println("Here is your " + number[1] + " " + 
					(number[1] > 1 ? "candies." : "candy."));
		}
		else if(number[0] + number[2] >= number[1]){
			System.out.println("I still owe you " + (number[1] - number[0]) + " " + 
					(number[2] > 1 ? "candies." : "candy."));
		}
		else{
			System.out.println("Sorry but I only have " + number[0] + " " + 
					(number[0] > 1 ? "candies." : "candy."));
		}
	}
	
}
