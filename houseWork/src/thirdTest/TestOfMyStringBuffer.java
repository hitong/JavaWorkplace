package thirdTest;

public class TestOfMyStringBuffer {
	public static void main(String[] args){
		MyStringBuffer msb1 = new MyStringBuffer("li hong lei ");
		MyStringBuffer msb2 = new MyStringBuffer("zhang xu hui ");
		System.out.println("连接测试: ");
		System.out.print("连接前msb1为: ");
		msb1.myPrint();
		MyStringBuffer msb3 = msb1.concat(msb2);
		System.out.println("连接后msb1为: ");
		msb1.myPrint();
		System.out.println("连接后msb3为: ");
		msb3.myPrint();
		System.out.println();
		System.out.println("插入测试: ");
		System.out.print("插入前msb1为:");
		msb1.myPrint();
		MyStringBuffer msb4 = msb1.insert(new MyStringBuffer("123"),30);
		System.out.print("插入后msb1为:");
		msb1.myPrint();
		System.out.print("插入后msb4为:");
		msb4.myPrint();
		System.out.println();
		System.out.println("删除测试: ");
		System.out.print("删除前msb1为:");
		msb1.myPrint();
		MyStringBuffer msb5 = msb1.delete(0, 10);
		System.out.print("删除后msb1为:");
		msb1.myPrint();
		System.out.print("删除后msb4为:");
		msb5.myPrint();
		System.out.println();
	}
}
