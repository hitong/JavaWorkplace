package thirdTest;

public class TestMyString {
	public static void main(String[] args){
		MyString ms1 = new MyString("sdasdad");
		MyString ms2 = new MyString("sd");
		MyString ms3 = new MyString("12a31s65");
		System.out.println(ms1.compare(ms1));
		System.out.println(ms2.compare(ms3));
		
		ms1.replace(0, ms2, ms3);
		System.out.println(ms1);
		
		System.out.println(ms1.charAt(8));		
	}
}
