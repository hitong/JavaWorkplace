package partTwentyFive;
public abstract class GenericQueue<E>{
	public abstract void enqueue(E e);
	public abstract E dequeue();
	public abstract int getSize();
	public abstract String toString();
}
