package javaBasic;

public class Stack {
	private int size = 0;
	private Object[] con = new Object[10];
	
	public Stack(){
		
	}
	
	/**
	 * 添加指定对象，进入堆栈
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
	 * 该方法删除栈顶元素，并返回被删除的对象
	 * @return
	 */
	public Object pop(){
		return size > 0 ? con[--size] : null;
	}
	
	/**
	 * 清除栈中所有元素
	 */
	public void clear(){
		Object[] temp = new Object[10];
		size = 0;
		con = temp;
	}
	
	
	/**
	 * 判断该栈是否为空，非空返回true，反之返回false
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	/**
	 * 该方法判该堆栈中是否有与传入对象相同的元素，有，返回true，反之，false
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
	 * 该方法通过指定下标，删除该堆栈中的元素
	 * @param seek
	 * @return 删除成功返回true，反之false
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
	 * 该方法通过接收对象，删除在该堆栈中第一次出现的传入对象
	 * @param o
	 * @return 删除成功返回true，反之，false
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
	 * 获取栈中元素个数
	 * @return	
	 */
	public int getSize(){	
		return size;
	}
	
	/**
	 * 获取指定下标的栈元素
	 * @param index
	 * @return
	 */
	public Object get(int index){		
		return (size - 1 >= index && index >= 0) ? con[index] : null;	
	}
}
