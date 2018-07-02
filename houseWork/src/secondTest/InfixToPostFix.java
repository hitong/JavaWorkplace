package secondTest;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {
	public static void main(String[] args){
	//	String test = "2 * ( 1 + 3 )";
		String test = "( -1 + -3 ) * -2";
		System.out.println(infixToPostFix(test));
	}
	
	public static String infixToPostFix(String expression){
		Scanner input = new Scanner(expression);
		StringBuilder sth = new StringBuilder();
		Stack<Character> s = new Stack<>();
		while(input.hasNext()){
			String tmp = input.next();
			if(tmp.compareTo("0") >= 0 || tmp.length() > 1){
				sth.append(tmp + " ");
				continue;
			}
			if(tmp.compareTo("(") == 0){
				s.push('(');
				continue;
			}
			if(tmp.compareTo(")") == 0){
				while(s.peek() != '('){
					sth.append(s.pop() + " ");
				}
				s.pop();
				continue;
			}
			while(true){
				char ch = tmp.charAt(0);				
				if(ch == '+' || ch == '-'){
					while(!s.isEmpty() && s.peek() != '+' && s.peek() != '-'  && s.peek() != '('){
						sth.append(s.pop() + " ");
					}
					s.push(ch);
					break;
				}
				else{
					s.push(ch);
					break;
				}
			}
		}
		while(!s.isEmpty()){
			sth.append(s.pop() + " ");
		}
		
		input.close();
		return sth.toString();
	}
}
