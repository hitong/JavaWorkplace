package Test;

public class TestNode <E>{
	static int i = 1;
	TestNode<E> head = null;
	TestNode<E> next = null;
	TestNode<E> tail = null;
	String s = "" + 123;
	public TestNode(){
		head = this;
		head.next = null;
		tail = head;
	}
	
	public TestNode(E s){
		this.s = s.toString();
	}
	
	public <E> void add(){
		tail.next = new TestNode("" + i++);
		tail = tail.next;
	}
	
	public <E> TestNode re(TestNode head){
		TestNode<E> nodeNext = null;
		TestNode<E> current = head;
	//	System.out.println(head.s + "****");
		TestNode<E> temp = null;
		
		while(true){
			nodeNext = current.next;
			if(nodeNext == null){
				current.next = temp;
				return current;
			}
			
			current.next = temp;
			temp = current;
			current = nodeNext;
		}
	}
	
	public static void main(String[] args){
		TestNode<String> s = new TestNode();
		s.add();
		s.add();
		s.add();
		s.add();
		s.add();
		s.add();
		s.add();
		s.add();
	//	s = s.re(s);
		while(s.next != null){
			System.out.println(s.s);
			s = s.next;
		}
	}
}
