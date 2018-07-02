package secondTest;

import java.util.Stack;

public class Prime {
	public static int size  = 50;
	
	public static void main(String[] args){
		Stack<Integer> s = new Stack<>();	
		int p = 0;
		
		while(s.size() < size){
			if(isPrime(p)){
				s.push(p);
			}
			p++;
		}
		
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
	}
	
	public static boolean isPrime(int p){
		if(p <= 1){
			return false;
		}
		
		for(int i= 2 ; i < p / 2; i++){
			if(p % i == 0){
				return false;
			}
		}
		
		return true;
	}
}
