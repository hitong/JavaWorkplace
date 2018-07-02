package partTwentyFive;

import java.util.Iterator;
import java.util.LinkedList;

public class Exercise25_5 <E> extends GenericQueue<E>{
	LinkedList<E> list = new LinkedList<>();
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Iterator<E> i = list.iterator();
		String tmp = "";
		while(i.hasNext()){
			tmp = tmp + "[" + i.next().toString() + "]   ";
		}
		return tmp;
	}

}
