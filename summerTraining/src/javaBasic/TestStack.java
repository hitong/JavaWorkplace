package javaBasic;

public class TestStack {
	public static void main(String[] args){
		Stack s = new Stack();
		
		for(int i = 0; i < Math.random() * 20 + 10; i++){
			s.add(new Complex(Math.random() * 10, Math.random() * 10));
		}
		
		System.out.println(s.getSize()  + " "+ s.pop() + " " + s.getSize());
		/**�ô�����Զ�ջ��pop����*/
		System.out.println(s.isEmpty());
		
		System.out.println(s.getSize());
		s.remove(s.get(s.getSize() - 5));
		System.out.println(s.getSize());
		/**�ô�����Զ�ջ��ɾ�����ⲿͨ���������ɾ�����ڲ�ʵ��ͨ��ָ���±�ɾ����ͬʱ����ͨ����Ӧ�±��ȡָ������Ĺ��ܹ���*/
		
		s.clear();
		System.out.println(s.getSize());
		/**�ô�����Զ�ջ���������*/
		System.out.println(s.isEmpty());
	}
}
