package thirdTest;

public class MyStringBuffer {
	MyString ms;
	
	MyStringBuffer(String s){
		ms = new MyString(s);
	}
	
	private MyString getMyString(){
		return ms;
	}
	
	synchronized public MyStringBuffer insert(MyStringBuffer str, int pos){
		ms.insert(str.getMyString(), pos);
        return this;
	}
	
	synchronized public MyStringBuffer concat(MyStringBuffer str) {
        ms.insert(str.getMyString(), Integer.MAX_VALUE - 1);
        return this;
    }

	public void myPrint(){
		System.out.println(ms);
	}
	
	synchronized public MyStringBuffer delete(int start, int end){
		ms.delete(start, end);
		return this;
	}
}
