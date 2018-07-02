package javaProForSort;

public class MergeSort {
	public static void main(String[] args){
		int[] n = {
				4,5,6,1,2,3,7,9,8,11,10
		};
		
		mergeSort(n);
		
		for(int i: n){
			System.out.print(i + " ");
		}
	}
	
	public static void mergeSort(int[] list){
		if(list.length > 1){
			int[] left = new int[list.length / 2];
			int[] right = new int[list.length - list.length / 2];
			System.arraycopy(list, 0, left, 0, left.length);
			System.arraycopy(list, left.length, right, 0, right.length);
			
			mergeSort(left);
			mergeSort(right);
			
			int[] tmp = merge(left, right);
			System.arraycopy(tmp, 0, list, 0, tmp.length);
		}
	}
	
	public static int[] merge(int[] list1, int[] list2){
		int[] tmp = new int[list1.length + list2.length];
		
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while(current1 < list1.length && current2 < list2.length){
			if(list1[current1] < list2[current2]){
				tmp[current3++] = list1[current1++];
			}
			else{
				tmp[current3++] = list2[current2++];
			}
		}
		
		while(current1 < list1.length){
			tmp[current3++] = list1[current1++];
		}
		
		while(current2 < list2.length){
			tmp[current3++] = list2[current2++];
		}
		for(int i:  tmp){
			System.out.print(i + " ");
		}
		System.out.println();
		return tmp;
	}
}
