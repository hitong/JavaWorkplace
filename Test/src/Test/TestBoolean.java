package Test;

public class TestBoolean {
	public static void main(String[] args){
		var c = 123;
		System.out.println(c);
		c = 3123123;
		System.out.println(c);
		int t = 0;
		boolean b = false;
		int[][] tb = new int[11][22];
		TestBoolean.test(t, b, tb);
		System.out.println(t + " " + b + " " + tb[0][0] + " " + tb.length);
	}
	
	private static void test(int t, boolean b, int[][] tb){
		t++;
		b = !b;
		tb[0][0] = 1;
		System.out.println(t + " " + b);
	}
}
