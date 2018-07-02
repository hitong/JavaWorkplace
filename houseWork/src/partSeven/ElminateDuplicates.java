package partSeven;

import java.util.Scanner;

public class ElminateDuplicates {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] number = new int[10];
	
		System.out.print("Enter 10 number: ");
		for(int i = 0; i < 10; i++){
			number[i] = input.nextInt();
		}
		
		
		int[] newArrary = elminateDuplicates(number);
		for(int i = 0; i < newArrary.length; i++){
			System.out.print(newArrary[i] + " ");
		}
		
	}
	
	/***/
	public static int[] elminateDuplicates(int[] arrary){
		int count = 0;		
		for(int i = 0; i < arrary.length; i++){
			for(int j = 0 ; j < i; j++)
			{
				if(arrary[j] == arrary[i]){			
					count--;
					break;
				}
			}
			count++;
		}
		
		
		int[] newArrary = new int[count];
		count = 0;
		for(int i = 0; i < arrary.length; i++){
			int j = 0;
			for(; j < i; j++)
			{
				if(arrary[j] == arrary[i]){			
					break;
				}
			}
			if(i == j )
				newArrary[count++] = arrary[i];
		}
		return newArrary;
	}
}
