package partThree;

import java.util.Scanner;;

public class TestBooleanOperators {
	public static void main(String[] args){
		//Create a Scanner
		Scanner input = new Scanner(System.in);
		
		//REceive an input
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		if (number % 2 == 0 && number % 3 == 0)
			System.out.println(number + " is divisible by 2 and 3. ");
		
		if (number % 2 == 0 || number % 3 == 0)
			System.out.println(number + " is divisible by 2 or 3. ");
		
		if (number % 3 == 0 ^ number % 2 == 0)
			System.out.println(number + " is divisible by 2 or 3. but not both");
		input.close();
	}
}
