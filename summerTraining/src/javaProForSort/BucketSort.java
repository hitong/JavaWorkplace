package javaProForSort;

public class BucketSort {
	public static void main(String[] args){
		int[] n = {
				1,6,4,5,9,5,1,3,5,0
		};
		n = bucketSort(n);
		
		for(int i = 0; i < n.length; i++){
			while(n[i] > 0){
				System.out.print(i + " ");
				n[i]--;
			}
		}
	}
	
	public static int[] bucketSort(int[] n){
		int[] tmp = new int[n.length];
		for(int i = 0; i < n.length; i++){
			tmp[n[i]]++;
		}
		return tmp;
	}
}
