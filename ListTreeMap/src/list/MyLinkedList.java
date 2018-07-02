package list;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	public MyLinkedList() {
	}

	public MyLinkedList(E[] objects) {
		super(objects);
	}

	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.elements;
		}
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null) {
			tail = head;
		} else {
		}
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);

		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			E tmp = head.elements;
			head = null;
			tail = null;
			size--;
			return tmp;
		} else {
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			Node<E> tmp = tail;
			current.next = null;
			tail = current;
			size--;
			return tmp.elements;
		}
	}

	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> tmp = head;
			head = head.next;
			if(head == null) {
				tail = null;
			}
			size--;
			return tmp.elements;
		}
	}

	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node<E> tmp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = tmp;
			size++;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return false;
		}
		Node<E> tmp = head;
		for (int i = 0; i < size; i++) {
			if (e.equals(tmp.elements)) {
				return true;
			} else {
				tmp = tmp.next;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			return null;
		} else {
			Node<E> tmp = head;
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			return tmp.elements;
		}
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		Node<E> tmp = head;
		for (int i = 0; i < size; i++) {
			if (e.equals(tmp.elements)) {
				return i;
			} else {
				tmp = tmp.next;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		Node<E> tmp = head;

		int flag = -1;
		for (int i = 0; i < size; i++) {
			if (e.equals(tmp.elements)) {
				flag = i;
			} else {
			}
			tmp = tmp.next;
		}
		return flag;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node<E> tmp = current.next;
			current.next = tmp.next;
			size--;
			return tmp.elements;
		}
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			return null;
		} else {
			Node<E> tmp = head;
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			E old = tmp.elements;
			tmp.elements = e;
			return old;
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> tmp = head;
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result.append(tmp.elements.toString());
			} else {
				result.append(tmp.elements.toString() + ", ");
			}
			tmp = tmp.next;
		}

		return result.toString() + "]";
	}

	private static class Node<E> {
		E elements;

		Node<E> next;

		public Node(E element) {
			this.elements = element;
		}
	}
}
