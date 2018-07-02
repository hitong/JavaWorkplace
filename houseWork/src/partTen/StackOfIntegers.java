package partTen;

public class StackOfIntegers {
	private int[] element = new int[16];
	private int size;
	
	StackOfIntegers(){
		
	}
	
	StackOfIntegers(int capacity){
		element[size++] = capacity;
	}

	boolean empty(){
		if(size == 0)
			return true;
		else 
			return false;
	}
	
	int peek(){
		return element[size-1];
	}
	
	void push(int value){
		if(size % 16 == 0 || size != 0){
			int[] temp = new int[element.length * 2];		
			System.arraycopy(element,  0, temp, 0, element.length);
			element = temp;
		}	
		element[size++] = value;
		
	}
	
	int pop(){
		if(empty())
			System.out.println("There is't number.");
		else 
			return element[--size];
		return -271656545;
	}
	
	int getSize(){
		return size;
	}
}
