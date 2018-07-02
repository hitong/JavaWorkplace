package tree;

import java.util.ArrayList;

public class TestMyTree {
	public static void main(String[] args) {
		BinaryTree<String> tree= new BinaryTree<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.println();
		System.out.print("Postorder (sorted): ");
		tree.postorder();System.out.println();
		System.out.print("Preorder (preorder): ");
		tree.preorder();System.out.println();
		ArrayList<BinaryTree.TreeNode<String>> path = tree.path("Peter");
		for(int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i).element + " ");
		}System.out.println();
		System.out.println(tree.getSize());
		Integer[] number = {2,4,3,1,8,5,6,7};
		BinaryTree<Integer> t = new BinaryTree<>(number);
		System.out.print("\nInorder (sorted): ");
		t.delete(1);
		t.inorder();System.out.println();
	}
}
