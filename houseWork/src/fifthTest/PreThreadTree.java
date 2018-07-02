package fifthTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreThreadTree<T> {
	Node<T> root;
	Node<T> head;
	
	public PreThreadTree(T element){
		this(element, null, null);
	}
	
	public PreThreadTree(T element, PreThreadTree<T> left,PreThreadTree<T> right){
		Node<T> l = null, r = null;
		if(left != null){
			l = left.getRoot();
		}
		if(right != null){
			r = right.getRoot();
		}
		root = new Node<T>(element, l, r);
		reset(root);
		createThread()	;
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	public Node<T> getRoot(){
		return root;
	}
	
	public void reset(Node<T> node){
		if(node == null){
			return;
		}
		if(node.isLeftThread){
			node.isLeftThread = false;
			node.left = null;
		}
		else{
			reset(node.left);
		}
		if(node.isRightThread){
			node.isRightThread = false;
			node.right = null;
		}
		else{
			reset(node.right);
		}
	}
	
	private void createThread(){
		head = new Node<T>(null,root,null);
		Stack<Node<T>> s = new Stack<>();
		thread(s, head, root);
	}
	
	private void thread(Stack<Node<T>> stack, Node<T> pre, Node<T> node){
		if(!node.isRightThread){
			if(node.right != null){
				stack.push(node.right);
			}
			else{
				node.isRightThread = true;
				if(!node.isLeftThread && node.left != null){
					node.right = node.left;
				}
				else if(!stack.isEmpty()){
					node.right = stack.peek();
				}
				else{
					node.right = head;
					head.isRightThread = true;
					head.right = node;
				}
			}
		}
		
		if(!node.isLeftThread){
			if(node.left != null){
				thread(stack, node, node.left);
			}
			else{
				node.isLeftThread = true;
				node.left = pre;
				if(!stack.isEmpty()){
					thread(stack, node, stack.pop());
				}
			}
		}
	}
	
	public int height(){
		return height(root);
	}
	
	private static int height(Node<?> node){
		int left = -1, right = -1;
		if(!node.isLeftThread){
			left = height(node.left);
		}
		if(!node.isRightThread){
			right = height(node.right);
		}
		return left > right ? left + 1 : right + 1;
	}
	
	public void print(){
		Queue<Node<?>> level = new LinkedList<>();
		level.add(root);
		int height = this.height();
		int max = (int)Math.pow(2, height);
		print(level, 0, height, max);
	}
	
	private static void print(Queue<Node<?>> level, int levelIndex, int height, int maxnode){
		if(levelIndex > height){
			return;
		}
		Queue<Node<?>> nextLevel = new LinkedList<Node<?>>();
		int maxCount = maxnode * 2 - 1;
		int nodecount = (int)(Math.pow(2, levelIndex));
		int pre = (int)(Math.pow(2, height - levelIndex) - 1);
		int intervaltotal = maxCount - nodecount  - 2 * pre;
		int intervalcount = nodecount - 1;
		int interval = 0;
		if(intervalcount != 0 && intervaltotal > 0){
			interval = intervaltotal / intervalcount;
		}
		for(int i = 0; i < pre; i++){
			System.out.print(" ");
		}
		while(!level.isEmpty()){
			Node<?> node = level.poll();
			if(node.value != null){
				System.out.print(node.value);
			}
			else{
				System.out.print("-");
			}
			if(!node.isLeftThread && node.left != null){
				nextLevel.add(node.left);
			}
			else{
				nextLevel.add(new Node<Character>());
			}
			
			if(!node.isRightThread && node.right != null){
				nextLevel.add(node.right);
			}
			else{
				nextLevel.add(new Node<Character>());
			}
			for(int i = 0; i < interval; i++){
				System.out.print(" ");
			}
		}
		System.out.println();
		print(nextLevel, levelIndex + 1, height, maxnode);
	}
	
	
	public static class Node<T>{
		public T value;
		public Node<T> left;
		public Node<T> right;
		public Node<T> pre;
		public boolean isLeftThread = false;
		public boolean isRightThread =false;
		
		public Node()	{
			this(null);
		}
		
		public Node(T t){
			this(t, null, null);
		}
		
		public Node(T t, Node<T> left, Node<T> right){
			this.value = t;
			if(left != null){
				left.pre = this;
			}
			this.left = left;
			if(right != null){		
				right.pre = this;
			} 
			this.right = right;
		}
		
		public Node<T> previous(){
			if(isLeftThread){
				return left;
			}
			if(pre.left == this){
				return pre;
			}
			if(pre.isLeftThread){
				return pre;
			}
			return temp(pre.left);
		}
		
		private Node<T> temp(Node<T> node){
			if(!node.isRightThread){
				return temp(node.right);
			}
			if(!node.isLeftThread){
				return temp(node.left);
			}
			return node;	
		}
		
		public Node<T> next(){
			if(!isLeftThread){
				return this.left;
			}
			return this.right;
		}
	}
}
