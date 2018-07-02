package javaProForSort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Heap<E extends Comparable<E>> {
	List<E> list;

	Heap() {
		list = new ArrayList<E>();
	}

	Heap(Collection<E> c) {
		Iterator<E> tmp = c.iterator();
		while (tmp.hasNext()) {
			add(tmp.next());
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
		if (list.isEmpty()) {
			return null;
		}

		E top = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		int currentIndex = 0;

		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			if (leftChildIndex >= list.size()) {
				break;
			}
			int maxIndex = leftChildIndex;

			if (rightChildIndex < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
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
		return top;
	}

	public int size() {
		return list.size();
	}
}
