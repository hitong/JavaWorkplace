package eighthTest;

import java.util.Comparator;

public class BubbleSort {
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length - 1; j++) {
				if(list[j].compareTo(list[j + 1])  > 0){
					E tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
	}
	
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length - 1; j++) {
				if(comparator.compare(list[j], list[j + 1])  > 0){
					E tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
	}
}
