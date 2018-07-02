package fifthWork;

import java.util.ArrayList;
import java.util.Stack;

public class Exercise2 {
	public static int M3(TreeNode root){
		if(root == null){
			return 0;
		}
		return M3(root.left) + M3(root.right) + 1;
	}
	
	public static void M4(TreeNode root){
		if(root == null){
			return;
		}
		M4(root.left);
		M4(root.right);
		System.out.println(root.e);
	}
	
	public static int M6(TreeNode root, int level, int k){
		if(root == null){
			return 0;
		}
		if(k == level){
			return 1;
		}
		return M6(root.left,level, k+1) + M6(root.right,level, k+1);
	}
		
	public static void M8(TreeNode root, String x){
		if(root != null){
			if(root.e.compareTo(x) == 0){
				System.out.println(root.e);
				return;
			}
			Stack<TreeNode> s = new Stack<>();
			Stack<TreeNode> c = new Stack<>();
			s.push(root);
			boolean flag = true;
			while(!s.isEmpty()){
				while(s.peek().left != null && !c.contains(s.peek().left) && flag){
					s.push(s.peek().left);
					if(s.peek().e.compareTo(x) == 0){
						flag = false;
					}
				}
				
				if(!flag){
					for(int i = 0 ; i < s.size(); i++){
						System.out.println(s.get(i).e);
					}
					break;
				}
				else{		
					if(s.peek().right == null || c.contains(s.peek().right)){
						c.add(s.pop());
				//		System.out.println(c.peek().e);
					}
					else{
						s.push(s.peek().right);
						if(s.peek().e.compareTo(x) == 0){
							flag = false;
						}
					}
				}			
			}
		}
	}
	
	public static void M9(TreeNode root){
		if(root != null){
			Stack<TreeNode> s = new Stack<>();
			Stack<TreeNode> c = new Stack<>();
			s.push(root);
			while(!s.isEmpty()){
				while(s.peek().left != null && !c.contains(s.peek().left)){
					s.push(s.peek().left);
				}
				
				if(s.peek().right == null){
					for(int i = s.size() - 1; i >= 0;i--){
						System.out.print(s.get(i).e + " ");
					}
					System.out.println();
					c.add(s.pop());
			//		System.out.println(c.peek().e);
				}
				else if(c.contains(s.peek().right)){
					c.add(s.pop());
				}
				else{
					s.push(s.peek().right);	
				}			
			}
		}
	}
	
	public static void main(String[] args){
		TreeNode t = new TreeNode("1");
		t.left = new TreeNode("2");
		t.right = new TreeNode("3");
		t.left.left = new TreeNode("4");
		t.left.right = new TreeNode("5");
		t.right.left = new TreeNode("6");
		t.right.right = new TreeNode("8");
		t.right.left.right = new TreeNode("7");
		
		//System.out.println(M6(t,2,0));
		//M8(t,"7");
		M9(t);
	}
}	

class TreeNode{
	String e = "123";
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(){
		
	}
	TreeNode(String s){
		e = s;
	}
}

