package partTwelve;

import java.util.*;

public class TestArratIndexOutBoudsException {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		int[] array = new int[100];		
		for(int i = 0; i < 100; i++){
			array[i] = (int)(Math.random() * 1000);
		}
		
		
		System.out.println("Please input the array's index:");
		int index = getIndex(array);
				
		System.out.println("The result is " + array[index]);		
	
	
	}
	
	public static int getIndex(int[] array){
		int index;
		try{
			System.out.println("Input the index:");
			index = input.nextInt();
			int test = array[index];
		}
		catch(InputMismatchException ex){
			input.next();
			System.out.println("Your enter is err!!!");
			index = getIndex(array);
		}		
		catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Out of Bounds");
			index = getIndex(array);
		}		
		
		return index;
	}			
}
