package fourthTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {
	public static int mul(int[] in, int i){
		if(i >= in.length || i < 0){
			throw new InputMismatchException();
		}
		
		if(i == in.length - 1){
			return in[i];
		}
		return in[i] * mul(in,i + 1);
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		while(true){
			System.out.print("请输入:");
			a.add(input.nextInt());
			System.out.println("当前计算结果:" + Test2.mul(Test1.getIntArray(a), 0));
		}
	}
}	
