package partTwentyFive;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class Exercise25_4 {
	public static void main(String[] args) throws IOException{
		Stack<Integer> arr = new Stack<>();
		
		for(int i = 2 ; i < Integer.MAX_VALUE; i++){
			boolean flag = true;
			for(long j = 2; j <= Math.sqrt(i) ; j  ++){
				if(i % j == 0){
					flag = false;	
					break;
				}
			}		
			if(flag){
				arr.add(i);
	
				if(arr.size() == 100){
					System.out.print(i + " ");
					break;
				}
			}
		}
		for(int i = 0; i < 50; i++){
			System.out.print(arr.pop() + " ");
		}
	}
}
