package list;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	
	public int getRealSize() {
		return data.length;
	}

	public MyArrayList() {
	}

	public MyArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	public void add(int index, E e) {
		// TODO Auto-generated method stub
		ensureCapacity();
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	private void ensureCapacity() {
		if (size >= data.length) {
			@SuppressWarnings("unchecked")
			E[] newData = (E[]) (new Object[size * 2 + 1]);
			System.arraycopy(data, 0, newData, 0, data.length);
			data = newData;
		} else {
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = (E[]) new Object[INITIAL_CAPACITY];
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return true;
			} else {
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return i;
			} else {
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		for (int i = size - 1; i >= 0; i--) {
			if (e.equals(data[i])) {
				return i;
			} else {
			}
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E e = data[index];
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size--;
		return e;
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		E old = data[index];
		data[index] = e;
		return old;
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");

		for (int i = 0; i < size; i++) {
			result.append(data[i]);

			if (i < size - 1) {
				result.append(", ");
			} else {
			}
		}

		return result.toString() + "]";
	}

	@SuppressWarnings("unchecked")
	public void trimToSize() {
		if (size != data.length) {
			E[] newData = (E[]) (new Object[size]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		} else {
		}
	}
}
