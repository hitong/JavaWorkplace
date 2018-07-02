package partSix;

public class TestCredCard {
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer:"
				);

		long number = input.nextLong();
	
		System.out.println(number + " is " +
				(CreditCard.isValid(number)?"valid":"invalid"));
		
	}
	
}
