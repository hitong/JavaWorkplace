package list;

public class MyQueue<E> {
	private MyLinkedList<E> list = new MyLinkedList<>();
	
	public void enqueue(E e) {
		list.addLast(e);
	}
	
	public E deQueue() {
		return list.removeFirst();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public String toString() {
		return "Queue" + list.toString();
	}
	
	public E get(int index) {
		return  list.get(index);
	}
}
