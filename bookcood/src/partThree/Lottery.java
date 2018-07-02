package partThree;

import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {
		//Create a Scanner
		Scanner input = new Scanner(System.in);
		
		//Generate a lottery number
		int lottery = (int)(Math.random() * 100);
		System.out.print("Enter your lottery pick (two digits): ");
		int guess = input.nextInt();
		
		//Prompt the user to enter a guess
		int lotteryDigit1 = lottery / 10;
		int lotteryDigit2 = lottery % 10;
		
		//Get digit from guess 
		int guessDigit1 = guess / 10;
		int guessDigit2 = guess % 10;
		
		System.out.println("The lottery number is " + lottery);
		
		// Check the guess
		if (guess == lottery)
			System.out.println("Exact match: Your win $10,000");
		else if (guessDigit2 == lotteryDigit1
				&& guessDigit1 == lotteryDigit2)
			System.out.println("Match all digits: you win $3,000");
		else if (guessDigit1 == lotteryDigit1
			|| guessDigit2 == lotteryDigit2
			|| guessDigit1 == lotteryDigit2
			|| guessDigit2 == lotteryDigit1)
			System.out.println("Match one digits: you win $1,000");
		else 
			System.out.println("Sorry, no match");
		
		input.close();
	}

}
