package partEleven;

import java.util.*;
public class MyStack extends java.util.ArrayList {
	public Object peek() {
		return this.get(size() - 1);
	}
	
	public Object pop() {
		Object o = this.get(size() - 1);
		this.remove(size() - 1);
		return o;
	}
	
	
	public void push(Object o) {
		this.add(o);
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter five strings: ");
		String o[] = new String[5];
		MyStack mystack = new MyStack();
		
		for (int i = 0; i < 5; i++) {
			o[i] = input.next();
			mystack.push(o[i]);
		}
		
		System.out.print("The string of resever: ");
		while (!mystack.isEmpty()) {
			System.out.print(mystack.pop() + " ");
		}
	}
	
	
}