package javaBasic;

public class Stack {
	private int size = 0;
	private Object[] con = new Object[10];
	
	public Stack(){
		
	}
	
	/**
	 * ���ָ�����󣬽����ջ
	 * @param o
	 */
	public void add(Object o){		
		if(size == con.length){
			Object[] temp = new Object[size * 2];
			
			for(int i = 0; i < size; i++){
				temp[i] = con[i];
			}
			con = temp; 
		}
		
		con[size++] = o;
	}
	
	/**
	 * �÷���ɾ��ջ��Ԫ�أ������ر�ɾ���Ķ���
	 * @return
	 */
	public Object pop(){
		return size > 0 ? con[--size] : null;
	}
	
	/**
	 * ���ջ������Ԫ��
	 */
	public void clear(){
		Object[] temp = new Object[10];
		size = 0;
		con = temp;
	}
	
	
	/**
	 * �жϸ�ջ�Ƿ�Ϊ�գ��ǿշ���true����֮����false
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	/**
	 * �÷����иö�ջ���Ƿ����봫�������ͬ��Ԫ�أ��У�����true����֮��false
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		for(int i = 0; i < size; i++){
			if(con[i].equals(o))
				return true;
		}
		
		return false;
	}
	
	/**
	 * �÷���ͨ��ָ���±꣬ɾ���ö�ջ�е�Ԫ��
	 * @param seek
	 * @return ɾ���ɹ�����true����֮false
	 */
	public boolean remove(int seek){
		if(seek > size - 1 || seek < 0){
			
			return false;
		}
		else{
			size--;
			for(int i = seek; i < size; i++){
				con[i] = con[i + 1];
			}
			
			return true;
		}
		
	}
	
	/**
	 * �÷���ͨ�����ն���ɾ���ڸö�ջ�е�һ�γ��ֵĴ������
	 * @param o
	 * @return ɾ���ɹ�����true����֮��false
	 */
	public boolean remove(Object o){
		if(this.contains(o)){
			for(int i = 0; i < size; i++)
				if(this.get(i).equals(o)){
					return this.remove(i);		
			}
		}

		return false;
	}
	
	/**
	 * ��ȡջ��Ԫ�ظ���
	 * @return	
	 */
	public int getSize(){	
		return size;
	}
	
	/**
	 * ��ȡָ���±��ջԪ��
	 * @param index
	 * @return
	 */
	public Object get(int index){		
		return (size - 1 >= index && index >= 0) ? con[index] : null;	
	}
}
