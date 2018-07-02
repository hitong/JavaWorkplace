package eighthTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort{
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		Heap<E> heap = new Heap<>();
		
		for(int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for(int i = list.length - 1; i >= 0 ;i--) {
			list[i] = heap.remove();
		}
	}
	
	public static <E> 	void heapSort(E[] list, Comparator<? super E> comparator) {
		PriorityQueue<E> p = new PriorityQueue<>(comparator);//底层数据结构为最小堆
		
		for(int i = 0; i < list.length; i++) {
			p.add(list[i]);
		}
		
		for(int i = list.length - 1; i >= 0; i--) {
			list[i] = p.remove();
		}
	}
}
