package thirdTest;

public class MyString {
	private int  count = 0;
	private char[] c;
	
	MyString(String s){
		count = s.length();
		c = new char[count];
		s.getChars(0, count, c, 0);
	} 
	
	public boolean compare(MyString ms1){
		if(compareTo(ms1) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public MyString replace(int start, MyString ms1, MyString ms2){
		if(ms1 == null || ms2 == null){
			throw new NullPointerException();
		}
		if(start < 0 || start >= count){
			throw new IndexOutOfBoundsException(String.valueOf(start));
		}
		MyString ms = this;
		if(ms1.length() == 0){
			return ms;
		}
		int index;
		while((index = ms.indexOfBf(ms1, start)) != -1){
			ms = ms.delete(index, index + ms1.length());
			ms = ms.insert(ms2, index);
			start = index + ms2.length();
		}
		return ms;
	}
	
	public MyString delete(int start, int end){
		if(start > end || start < 0 || end > count){
			throw new StringIndexOutOfBoundsException(start);
		}
		char[] tmp = new char[count - (end - start)];
		System.arraycopy(c, 0, tmp, 0, start);
		System.arraycopy(c, end, tmp, start, count - end);
		c = tmp;
		count = tmp.length;
		return this;
	}
	
	public MyString insert(MyString ms, int index){
		if(index < 0){
			throw new StringIndexOutOfBoundsException(index);
		}
		if(index > count){
			index = count;
		}
		
		int t = ms.length() + count;
		char[] tmp = new char[t];
		System.arraycopy(c, 0, tmp, 0, index);
		System.arraycopy(ms.toString().toCharArray(), 0, tmp, index, ms.length());
		System.arraycopy(c, index, tmp, index + ms.length(), this.length() - index);
		count = tmp.length;
		c = tmp;
		return this;
	}
	
	public int indexChar(char ch){
		return indexChar(ch, 0);
	}
	
	public int indexChar(final int ch, final int start){
		if(start < 0 || start >= count){
			throw new IndexOutOfBoundsException(String.valueOf(start));
		}
		for(int i = start; i < count; i++){
			if(charAt(i) == ch){
				return i;
			}
		}
		return -1;
	}
	
	public char charAt(int i){
		if(i >= count || i < 0){
			throw new IndexOutOfBoundsException(String.valueOf(i));
		}
		return c[i];
	}
	
	public int length(){
		return count;
	}

	public int indexOfBf(MyString ms, int start) {
		if(start >= this.length()){
			return -1;
		}
		int i = start;
		int j = 0;
		
		while (i < this.length() && j < ms.length()) {
			if (ms.charAt(j) == charAt(i)) 
			{
				i++; 
				j++;
			} 
			else 
			{
				i = i - j + 1; 
				j = 0; 
			}
		}

		if (j >= ms.length())
			return (i - ms.length()); 
		return (-1);
	}
	
	/**
	 * 
	 * @param ms
	 * @return
	 */
	private int compareTo(MyString ms){
		int tmp = 0;	
		while(tmp < ms.length() && tmp < count){
			if(c[tmp] > ms.charAt(tmp)){
				return 1;
			}
			else if(c[tmp] < ms.charAt(tmp)){
				return -1;
			}
			tmp++;
		}
		if(count < ms.length())
			return -1;
		if(count == ms.length()){
			return 0;
		}
		return 1;
	}
	
	public String toString(){
		return new String(c);
	}
}
