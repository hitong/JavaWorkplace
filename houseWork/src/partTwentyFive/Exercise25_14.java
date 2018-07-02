package partTwentyFive;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise25_14 <E>{
	private LinkedList<E> list = new LinkedList<>();
	Comparator<E> c = new Compare();
	
	class Compare implements Comparator<E>{
	    public int compare(E e1, E e2) {  
	        return Integer.parseInt(e1.toString()) -Integer.parseInt( e2.toString());  
	    }  
	}
	
	public void enqueue(E newObject){
		list.add(newObject);
		Collections.sort(list, c);
	}
	
	public E dequeue(){
		if(list.size() == 0){
			return null;
		}
		return list.poll();
	}
	
	public int getSize(){
		return list.size();
	}
	public static void main(String[] args){
		Exercise25_14<StringBuilder> e = new Exercise25_14<>();
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 10; i++){
			e.enqueue(new StringBuilder(in.nextLine()));
		}
		for(int i = 0; i < 10; i++)
		System.out.println(e.dequeue());
	}
}
