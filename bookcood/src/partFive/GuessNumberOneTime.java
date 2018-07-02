package partFive;

import java.util.Scanner;

public class GuessNumberOneTime {
	public static void main(String[] args){
		//Generate a random number to be guessed
		int number = (int)(Math.random() * 101);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Guess a magic number bewteen 0 and 100");
		
		//Prompt the user to guess the number
		System.out.print("\nEnter your guess:");
		int guess = input.nextInt();
		
		if(guess == number)
			System.out.println("Yes, the number is " + guess);
		else if(guess > number)
			System.out.println("Your number is too high");
		else 
			System.out.println("Your number is too low");
		input.close();
	}
}
