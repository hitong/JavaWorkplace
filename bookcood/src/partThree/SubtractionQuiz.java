package partThree;

import java.util.Scanner;

public class SubtractionQuiz {
	public static void main(String[] args){
		//1. Generate two random single-digit integers
		int number1 = (int)(Math.random() * 10);
		int number2 = (int)(Math.random() * 10);
		
		//2. If number1 < number2, swap number1 with number2
		if(number1 < number2){
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		
		//3. Prompt the student to answe "What is number1 - number2?
		System.out.print(
				"Whar is " + number1 +" - " + number2 + " ? ");
		Scanner input = new Scanner(System.in);
		int anser = input.nextInt();
		
		//4. Grade the answe and display the result
		if( anser == number1 - number2){
			System.out.println("Your anser is current!");
		}
		else {
			System.out.println("Your anser is wrong!");
			System.out.println(number1 + " - " + number2 + " = " +
					(number1 - number2));
			
		}
		input.close();
	}
}
