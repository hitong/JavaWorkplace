package javaProForSort;

public class FastSort {
	public static void main(String[] args){
		int[] number = {
				9, 10 ,11 ,15 ,165, 1, 12 ,156, 1, 0, -1,-1
		};
		sort(number,0 , number.length - 1);
		for(int n: number){
			System.out.print(n + " ");
		}
	}
	
	static void sort(int[] number, int start, int end){
		if(start < end){
			int i = start;
			int j = end;
			int temp = number[start];
			while(end > start) {				
				while(end > start && number[end] >= temp){
					end--;
				}
				if(end > start){
					number[start] = number[end];
				}
				
				while(start < end && number[start] <= temp){
					start++;
				}
				if(start < end){
					number[end] = number[start];
				}				
			}
			number[start] = temp;
			sort(number, i, start - 1);
			sort(number, start + 1, j);	
		}				
		
	}
}
