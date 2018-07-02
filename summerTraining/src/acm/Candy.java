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
	 * 通过输入的小狗糖果拥有数number[0]，小猫的糖果需求数number[1]，
	 * 以及小狗能购买到的数number[2]，之间的关系，返回对应语句
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
