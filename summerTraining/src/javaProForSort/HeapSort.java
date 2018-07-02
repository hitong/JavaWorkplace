package javaProForSort;


public class HeapSort {
	public static void main(String[] args){
		int[] num = {
				9, 10 ,11 ,15 ,165, 1, 12 ,156, 1, 0, -1,-1
		};
		Heap<Integer> heap = new Heap<Integer>();
		
		for(int n: num){
			heap.add(n);
		}
		
		int times = heap.size();
		for(int i = 0; i < times; i++){
			System.out.print(heap.remove() + " ");
		}
	}
}
