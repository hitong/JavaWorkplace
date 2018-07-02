package partTwentyThr;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise27_3 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter  a string s1:");
		StringBuilder s1= new StringBuilder(input.nextLine());
		System.out.print("Enter  a string s2:");
		StringBuilder s2= new StringBuilder(input.nextLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0 ; i <= s1.length() - s2.length(); i++){
			if(s1.substring(i, i + s2.length()).compareTo(s2.toString()) == 0){
				arr.add(i);
			}
		}
		for(int t: arr){
			System.out.println("match at index " + t);
		}
		input.close();
	}
}
