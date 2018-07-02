package partTwelve;

import java.util.*;

public class Calculator {	
	public static void main(String[] args) throws NumberFormatException{
		if (args.length != 3){
			System.out.println(
					"Usage: java Calculator operand1 operator oprand2");
			System.exit(0);
		}
		int result = 0;	
			switch(args[1].charAt(0)){
			case '+': result = Integer.parseInt(args[0]) + 
							   Integer.parseInt(args[2]);
					break;
			case '-': result = Integer.parseInt(args[0]) - 
							   Integer.parseInt(args[2]);
					break;
			case '.': result = Integer.parseInt(args[0]) * 
					           Integer.parseInt(args[2]);
			  		break;
			case '/': result = Integer.parseInt(args[0]) /
					           Integer.parseInt(args[2]);
					break;
			}	
		
		
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] +
				" = " + result);
	}
}

/**
public class Calculator {

	public static void main(String[] args){
		if (args.length != 3){
			System.out.println(
					"Usage: java Calculator operand1 operator oprand2");
			System.exit(0);
		}

		boolean flag = true;
			for(int i = 0;i < args[0].length(); i++){			
				if(args[0].charAt(i) > '9' || args[0].charAt(i) < '0' ){
					System.out.println("Wrong input: " + args[0]); 
					flag = false;
					break;
				}
			}
			
			for(int i = 0;i < args[2].length(); i++){	
				if(args[2].charAt(i) > '9' || args[0].charAt(i) < '0' ){
					System.out.println("Wrong input: " + args[2]); 
					flag = false;
					break;
				}
			}
		
		if(flag){
			int result = 0;
			switch(args[1].charAt(0)){
			case '+': result = Integer.parseInt(args[0]) + 
							   Integer.parseInt(args[2]);
					break;
			case '-': result = Integer.parseInt(args[0]) - 
							   Integer.parseInt(args[2]);
					break;
			case '.': result = Integer.parseInt(args[0]) * 
					           Integer.parseInt(args[2]);
			  		break;
			case '/': result = Integer.parseInt(args[0]) /
					           Integer.parseInt(args[2]);
					break;
			}		
			System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] +
				" = " + result);
		}
	}
}
*/