package fourthTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test3 {
	public static int max(int[] in, int i){
		if(i >= in.length || i < 0){
			throw new InputMismatchException();
		}
		
		if(i == in.length - 1){
			return in[i];
		}
		int tmp =  max(in, i+1);
		return in[i] > tmp ? in[i] : tmp ;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		while(true){
			System.out.print("请输入:");
			a.add(input.nextInt());
			System.out.println("当前最大值:" + Test3.max(Test1.getIntArray(a), 0));
		}
	}
}	
