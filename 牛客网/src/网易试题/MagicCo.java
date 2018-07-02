package 网易试题;

import java.util.Scanner;
import java.util.Stack;

public class MagicCo {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		System.out.println(getRes(n));
//		Stack<Integer> s = new Stack<>();
//		get(0, n, s);
//		StringBuilder string = new StringBuilder();
//		for(int i = 0; i < s.size();i++){
//			string.append(s.get(i));
//		}
//		System.out.println(string.toString());
		input.close();
	}
	
	public static String getRes(int gol){
		StringBuilder s = new StringBuilder();
		while(gol != 0){
			if((gol - 1) / 2 == (gol - 1) * 1.0 / 2){
				s.append(1);
				gol = (gol - 1) / 2;
			} else {
				gol = (gol - 2) / 2;
				s.append(2);
			}
		}
		return s.reverse().toString();
	}
	
	public static boolean get(int num, int flag,Stack<Integer> s){
		if(num > flag){
			return false;
		} else if(num == flag){
			return true;
		} else {
			s.push(1);
			if(get(num * 2 +1, flag, s)){
				return true;
			}
			s.pop();
			
			s.push(2);
			if(get(num * 2 +2, flag, s)){
				return true;
			}
			s.pop();
			return false;
		}
	}
}
