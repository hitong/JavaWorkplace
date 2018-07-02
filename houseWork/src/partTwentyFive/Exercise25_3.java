package partTwentyFive;

public class Exercise25_3<E> {
	int size = 0;
	Node head = null;
	Node tail = null;
	public class Node {
		Object elements;
		Node next;
		Node previous;
		public Node(Object o){
			this.elements = o;
		}
		public Node(Node pre, Node next, Object o) {
			this.elements = o;
			this.previous = pre;
			this.next = next;
			pre.next = this;
			next.previous = this;
		}
	}
	
	public void add(Object elements, int index){
		if(size == 0){
			head = new Node(elements);
			tail = head;
			head.next = tail;
			tail.previous = head;
			size++;
			return;
		}
		
		if(index == 0){
			Node tmp = new Node(null, head, elements);
			head = tmp;
			size++;	
			return;			
		}
		
		if(index >= size || index < 0){
			Node tmp = new Node(tail, null, elements);
			tail = tmp;
			size++;
			return;
		}
		
		Node tmp = head;
		for(int i = 0; i < index-1 ; i++){
			tmp = tmp.next;
		}
		new Node(tmp, tmp.next, elements);
		size++;
	}
	
	public E remove(int index){
		if(index < 0 || index >= size){
			return null;
		}
		Node tmp;
		if(index == 0){
			tmp = head;
			head = head.next;
			head.previous = null;
			size--;
			return (E)tmp.elements;
		}
		
		if(index == size - 1){
			tmp = tail;
			tail = tail.previous;
			tail.next =  null;
			size--;
			return (E)tmp.elements;
		}
		
		tmp = head;
		for(int i = 0; i < index - 1; i++){
			tmp = tmp.next;
		}
		Node tmp2 = tmp.next;
		tmp.next = tmp2.next;
		tmp2.next.previous = tmp;
		size--;
		return (E)tmp2.elements;
	}
}
