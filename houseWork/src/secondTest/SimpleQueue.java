package secondTest;

public interface SimpleQueue <E>{
	public void enqueue(E e);
	public E dequeue();
	public boolean isEmpty();
}
