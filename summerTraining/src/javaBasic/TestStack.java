package javaBasic;

public class TestStack {
	public static void main(String[] args){
		Stack s = new Stack();
		
		for(int i = 0; i < Math.random() * 20 + 10; i++){
			s.add(new Complex(Math.random() * 10, Math.random() * 10));
		}
		
		System.out.println(s.getSize()  + " "+ s.pop() + " " + s.getSize());
		/**该代码测试堆栈的pop功能*/
		System.out.println(s.isEmpty());
		
		System.out.println(s.getSize());
		s.remove(s.get(s.getSize() - 5));
		System.out.println(s.getSize());
		/**该代码测试堆栈的删除，外部通过传入对象删除，内部实现通过指定下标删除，同时测试通过相应下标获取指定对象的功能功能*/
		
		s.clear();
		System.out.println(s.getSize());
		/**该代码测试堆栈的清除功能*/
		System.out.println(s.isEmpty());
	}
}
