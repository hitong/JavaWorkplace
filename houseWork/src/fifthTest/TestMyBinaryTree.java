package fifthTest;

import fifthTest.MyBinaryTree.TreeNode;

public class TestMyBinaryTree {
	public static void main(String[] args){
		TreeNode<String> a = new TreeNode<String>("a");
		TreeNode<String> b = new TreeNode<String>("b");
		TreeNode<String> c = new TreeNode<String>("c");
		TreeNode<String> d = new TreeNode<String>("d");
		TreeNode<String> e = new TreeNode<String>("e");
		TreeNode<String> f = new TreeNode<String>("f");
		TreeNode<String> g = new TreeNode<String>("g");
		TreeNode<String> h = new TreeNode<String>("h");
		TreeNode<String> i = new TreeNode<String>("i");
		TreeNode<String> j = new TreeNode<String>("j");
		MyBinaryTree<String> tree = new MyBinaryTree<>(new TreeNode<String>("root", a,b));
		a.left = c;
		a.right =d;
		b.left = e;
		b.right = f;
		c.left = g;
		c.right = j;
		e.left = h;
		f.right = i;
		
		System.out.println("此树横向打印为：");
		tree.printTreeByX();
		System.out.println("此树纵向打印为：");
		tree.printTreeByY();
		System.out.println("节点总个数：" + tree.size());
		System.out.println("是否为完全二叉树：" + tree.isCompleteBinaryTree());
		System.out.println("树的高度为：" + tree.getHeight());
		
		System.out.println("---------------------------------------------------");
		System.out.println("查询子树：");
		MyBinaryTree<String> tmp = tree.search("a");
		
		System.out.println("子树横向打印为：");
		tmp.printTreeByX();
		System.out.println("子树纵向打印为：");
		tmp.printTreeByY();
		System.out.println("子树节点总个数：" + tmp.size());
		System.out.println("子树是否为完全二叉树：" + tmp.isCompleteBinaryTree());
		System.out.println("子树的高度为：" + tmp.getHeight());
	}
}	
