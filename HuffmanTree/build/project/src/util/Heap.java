package util;

import java.util.ArrayList;

/**
 * 用于Huffman树的构建的Heap
 * 
 * @author Supertong
 *
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list = new ArrayList<>();

	public Heap() {
	}

	public Heap(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	public void add(E e) {
		list.add(e);
		int currentIndex = list.size() - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E tmp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, tmp);
			} else {
				break;
			}
			currentIndex = parentIndex;
		}
	}

	public E remove() {
		if (list.size() == 0) {
			return null;
		}

		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;

			if (left >= list.size()) {
				break;
			}
			int maxIndex = left;

			if (right < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(right)) < 0) {
					maxIndex = right;
				}
			}

			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E tmp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, tmp);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}
		return removedObject;
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
