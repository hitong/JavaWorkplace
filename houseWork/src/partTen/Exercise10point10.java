package partTen;

public class Exercise10point10 {
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		Queue queue = new Queue();
		System.out.print("Enter the test number(1-21):");
		for(int i = 0; i < 21; i ++){
			int one = input.nextInt();
			queue.enqueue(one);
		}
		
//		while(queue.getSize()>=0)
//			System.out.println(queue.dequeue());
		
		while(!queue.empty())
			System.out.println(queue.dequeue());
	}
}

class Queue{
	private int[] element;
	private int size = 0;
	
	Queue(){
		element = new int[8];
	}
	
	void enqueue(int v){
		if(size % 8 == 0 && size != 0){
			int[] element = new int[2 * size];
			for(int i = 0; i < size ; i++)
				element[i] = this.element[i];
			this.element = element;
		}
		
		this.element[size] = v;
		size++;
	}
	
	int dequeue(){
		size--;
		int temp = element[0];
		for(int i = 0;i < size; i++){
			element[i] = element[i+1];
		}
		return temp;
	}
	
	boolean empty(){
		if(size == 0 )
			return true;
		else
			return false;
	}
	
	int getSize(){
		return size-1;
	}
}
