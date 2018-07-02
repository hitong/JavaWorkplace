package javaProForSort;

public class ShellSort {
	public static void main(String[] args){
		int[] number = {
				9, 10 ,11 ,15 ,165, 1, 12 ,156, 1, 0, -1,-1
		};
		for(int n: number){
			System.out.print(n + " ");
		}
		System.out.println();
		sort(number);
		for(int n: number){
			System.out.print(n + " ");
		}
		
	}
	
	static void sort(int[] number){
		int l = number.length;
		while(l != 0){
			l = l / 2;		
			for(int i = 0; i < l; i++){			
				for(int j = i + l; j < number.length; j += l){
					int temp = number[j];				
					int k;
					for(k = j - l; k > -1; k = k - l){
						if(number[k] > temp){
							 number[k + l] = number[k];
						}
						else 
							break;						
					}					
					number[k + l] = temp;
				}
			}
		}
	}
}
