package tree;

import java.util.LinkedList;

public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;

	public BinaryTree() {
	}

	public BinaryTree(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}

	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> current = root;

		while (current != null) {
			if (current.element.compareTo(e) == 0) {
				return true;
			} else if (current.element.compareTo(e) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return false;
	}

	public boolean insert(E e) {
		if (root == null) {
			root = createNewNode(e);
		} else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				parent = current;
				if (e.compareTo(current.element) < 0) {
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					current = current.right;
				} else {
					return false;
				}
			}
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			} else {
				parent.right = createNewNode(e);
			}
		}
		size++;
		return true;
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}

	public void inorder() {
		inorder(root);
	}

	protected void inorder(TreeNode<E> root) {
		if (root == null) {
			return;
		} else {
			inorder(root.left);
			System.out.print(root.element + " ");
			inorder(root.right);
		}
	}

	public void preorder() {
		preorder(root);
	}

	protected void preorder(TreeNode<E> root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.element + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	protected void postorder(TreeNode<E> root) {
		if (root == null) {
			return;
		} else {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.element + " ");
		}
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left; 
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}

		if (current == null) {
			return false;
		} else {
		}

		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		} else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}

			current.element = rightMost.element;

			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				parentOfRightMost.left = rightMost.left;
			}
		}
		size--;
		return true;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator inorderIterator() {
		return new InorderIterator();
	}

	@SuppressWarnings("rawtypes")
	class InorderIterator implements java.util.Iterator {
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0;

		public InorderIterator() {
			inorder();
		}

		private void inorder() {
			inorder(root);
		}

		private void inorder(TreeNode<E> root) {
			if (root == null) {
				return;
			} else {
				inorder(root.left);
				list.add(root.element);
				inorder(root.right);
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (current < list.size()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return list.get(current++);
		}

		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}

		public void clear() {
			root = null;
			size = 0;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public int getWidth() {
		if (root == null)
			return 0;
		int max = 1;
		LinkedList<TreeNode<E>> ll = new LinkedList<>();
		ll.add(root);
		while (true) {
			int len = ll.size(); // 获取当前层的节点数
			if (len == 0) // 队列空，二叉树已经遍历完
				break;
			while (len > 0) {
				TreeNode<E> b = ll.poll();
				len--;
				if (b.left != null)
					ll.add(b.left);
				if (b.right != null)
					ll.add(b.right);
			}
			max = Math.max(max, ll.size());
		}
		return max;
	}

	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root;

		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				break;
			}
		}

		return list;
	}

	public static class TreeNode<E extends Comparable<E>> {
		TreeNode<E> left;
		TreeNode<E> right;
		E element;

		TreeNode(E e) {
			this.element = e;
		}
		
		public E getElement() {
			return element;
		}
		
		public TreeNode<E> getRight(){
			return right;
		}
		
		public TreeNode<E> getLeft(){
			return left;
		}
	}
}
