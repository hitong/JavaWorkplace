package secondTest;

import java.util.ArrayList;


public class MyQueue<E> implements SimpleQueue<E>{
	private E[] list;
	private int maxSize = 10;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	MyQueue(int maxSize){
		this.maxSize = maxSize;
		list = (E[])new Object[maxSize];
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if(size >= maxSize){
			return;
		}
		
		list[tail % maxSize] =  e;
		tail++;
		size++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(size == 0){
			return null;
		}
		
		E tmp = list[head % maxSize];
		head++;
		size--;
		return tmp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public static void main(String[] args){
		MyQueue<String> q = new MyQueue<>(50);
		for(int i = 0; i < 50; i++){
			q.enqueue(i + "");
		}
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
	}
}
