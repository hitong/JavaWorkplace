package list;

public class MyStack<E> {
	MyArrayList<E> list = new MyArrayList<>();
	
	public void push(E e) {
		list.add(e);
	}
	
	public E pop() {
		return list.remove(list.size() - 1);
	}
	
	public int getSize() {
		return list.size();
	}
	
	public E get(int index) {
		return list.get(index);
	}
	
	public String toString() {
		return "Stack: " + list.toString();
	}
}
