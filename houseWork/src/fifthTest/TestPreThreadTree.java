package fifthTest;

import fifthTest.PreThreadTree.Node;

public class TestPreThreadTree {
	public static void main(String[] args){
		PreThreadTree<Character> a,b,c,d,e,f,g,h,i,j,k;
		k = new PreThreadTree<>('k');
		g = new PreThreadTree<>('G',k,null);
		e = new PreThreadTree<>('E', g, null);
		d = new PreThreadTree<>('D');
		b = new PreThreadTree<>('B', d, e);
		h = new PreThreadTree<>('H');
		f= new PreThreadTree<>('F', null, h);
		c = new PreThreadTree<>('C', f, null);
		a = new PreThreadTree<>('A', b, c);
		a.print();
		
		System.out.print("正向前序遍历结果为：");
		Node<Character> head = a.getHead();
		
		for(Node<Character> node = head.left; !head.equals(node); node = node.next()){
			System.out.print(node.value + " ");
		}
		
		System.out.println();
		System.out.print("逆向前序遍历结果为：");
		for(Node<Character> node = head.right; !head.equals(node);node = node.previous()){
			System.out.print(node.value + " ");
		}
		
		System.out.println("\n=========================================");
		
		h = new PreThreadTree<>('H');
		i = new PreThreadTree<>('I');
		j = new PreThreadTree<>('J');
		d = new PreThreadTree<>('D', h, i);
		e = new PreThreadTree<>('E', j, null);
		f= new PreThreadTree<>('F');
		g = new PreThreadTree<>('G');
		b = new PreThreadTree<>('B',d,e);
		c = new PreThreadTree<>('C', f, g);
		a = new PreThreadTree<>('A', b, c); 
		
		a.print();
		
		System.out.print("正向前序遍历结果为：");
		head = a.getHead();
		
		for(Node<Character> node = head.left; !head.equals(node); node = node.next()){
			System.out.print(node.value + " ");
		}
		
		System.out.println();
		System.out.print("逆向前序遍历结果为：");
		for(Node<Character> node = head.right; !head.equals(node);node = node.previous()){
			System.out.print(node.value + " ");
		}
	}
}
