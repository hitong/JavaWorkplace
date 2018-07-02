package javaProForSort;

public class BubbleSort {
	public static void main(String[] args){
		int[] number = {
				1,2,3,4,5,6,7,8,9,10
		};
		for(Integer i: number){
			System.out.print(i + " ");
		}
		System.out.println();
		
		number = bubbleSort(number);
		
		for(Integer i: number){
			System.out.print(i + " ");
		}
	}
	
	public static int[] bubbleSort(int[] number){
		for(int i = 0; i < number.length - 1; i++){
			boolean flag = true;
			
			for(int j = i; j < number.length;j++){
				int temp = number[i];
				number[i] = number[j];
				number[j] = temp;
				flag = false;
			}
			
			if(flag){
				break;
			}
		}
		return number;
	}
}
