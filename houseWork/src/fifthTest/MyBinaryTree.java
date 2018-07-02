package fifthTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree<E> {
	TreeNode<E> root = null;
	
	public MyBinaryTree(E e){
		root = new TreeNode<>(e);
	}
	
	public MyBinaryTree(TreeNode<E> t){
		this.root = t;
	}
	
	public static class TreeNode<E>{
		E element = null;
		TreeNode<E> left = null;
		TreeNode<E> right  = null;
		
		TreeNode(){
		}
		
		TreeNode(E e){
			this.element = e;
		}
		
		TreeNode(E e, TreeNode<E> left, TreeNode<E> right){
			this.element = e;
			this.left = left;
			this.right = right;
		}

		public boolean equal(TreeNode<E> t) {			
			return t.left == left && t.right == right && t.element == element;	
		}
	}
	
	public boolean isCompleteBinaryTree(){
		if(root == null){
			return false;
		}
		LinkedList<TreeNode<E>> q = new LinkedList<>();
		q.add(root);
		boolean flag = true;
		while(q != null){
			int size = q.size();	
			if(size == 0){
				break;
			}
			while(size-- > 0){
				TreeNode<E> tmp = q.poll();
				if((tmp.left == null && tmp .right != null) || (tmp.left != null) && !flag){
					return false;
				}
				
				if(tmp.left != null){
					q.add(tmp.left);
				}
				if(tmp.right != null){
					q.add(tmp.right);
					flag = true;
				}
				else{
					flag = false;
				}
			}				
		}
		return true;
	}
	
	public int size(){
		if(root == null){
			return -1;
		}
		Stack<TreeNode<E>> s = new Stack<>();
		s.add(root);
		int count = 0;
		while(!s.isEmpty()){
			TreeNode<E> tmp = s.pop();
			count++;
			if(tmp.right != null){
				s.push(tmp.right);
			}
			if(tmp.left != null){
				s.push(tmp.left);
			}
		}
		return count;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyBinaryTree<E> search(E e){
		if(root == null){
			return null;
		}
		Stack<TreeNode<E>> s = new Stack<>();
		s.add(root);
		while(!s.isEmpty()){
			TreeNode<E> tmp = s.pop();
			if(tmp.element.equals(e)){
				return new MyBinaryTree(tmp);
			}
			
			if(tmp.right != null){
				s.add(tmp.right);
			}
			if(tmp.left != null){
				s.add(tmp.left);
			}
			
		}
		return null;
	}
	
	private int height(TreeNode<E> root, int max){
		if(root == null){
			return 0;
		}
		
		int max1 = height(root.left,max + 1) + 1;
		int max2 = height(root.right, max + 1) + 1;
		return max1 > max2 ? max1 : max2;
	}
	
	public int getHeight(){
		return height(root, 0);
	}
	
	public void printTreeByY(){
		Queue<TreeNode<?>> level = new LinkedList<>();
		level.add(root);
		int height = this.getHeight();
		int max = (int)Math.pow(2, height);
		print(level, 0, height, max);
	}
	
	private static void print(Queue<TreeNode<?>> level, int levelIndex, int height, int maxnode){
		if(levelIndex > height){
			return;
		}
		Queue<TreeNode<?>> nextLevel = new LinkedList<TreeNode<?>>();
		int maxCount = maxnode * 2 + 1;
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
			TreeNode<?> node = level.poll();
			if(node.element != null){
				System.out.print(node.element);
			}
			else{
				System.out.print("-");
			}
			if(node.left != null){
				nextLevel.add(node.left);
			}
			else{
				nextLevel.add(new TreeNode<Character>());
			}
			
			if(node.right != null){
				nextLevel.add(node.right);
			}
			else{
				nextLevel.add(new TreeNode<Character>());
			}
			
			for(int i = 0; i < interval; i++){
				System.out.print(" ");
			}
		}
		System.out.println();
		print(nextLevel, levelIndex + 1, height, maxnode);
	}
	
	public void printTreeByX(){
		easyPrint(root, 0);
	}
	
	private static void easyPrint(TreeNode<?> root, int level){
		if(root == null){
			return;
		}
		
		easyPrint(root.right, level + 1);
		for(int i = 0; i < level; i++){
			System.out.print("   ");
		}
		if(level != 0){
			System.out.print("--");
		}
		
		System.out.println(root.element);
		easyPrint(root.left, level + 1);
	}
}