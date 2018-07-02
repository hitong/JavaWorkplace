package partTwentyFive;

import java.util.Scanner;

public class Exercise25_10 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
			System.out.println(in.next());
		infixToPostfix(in.next());
	}
	
	public static String infixToPostfix(String expression){
		return "";
	}
}
