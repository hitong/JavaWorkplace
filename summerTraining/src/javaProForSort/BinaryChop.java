package javaProForSort;

public class BinaryChop {
	public static void main(String[] args){
		int[] number = {
				1,2,3,4,5,6,7,8,9,10
		};
		System.out.println(binaryChop(number, 6));		
	}
	
	public static int binaryChop(int[] number, int seek){
		int max = number.length - 1;
		int min = 0;
		int mid = max / 2;
		while(true){
			if(number[mid] < seek){
				min = mid + 1;
				mid = (max + min) / 2;
			}
			else if(number[mid] > seek){
				max = mid - 1;
				mid = (max + min) / 2;
			}
			else if(number[mid] == seek){
				return mid;
			}
			else{
				return -1;
			}
		}
	}
}
