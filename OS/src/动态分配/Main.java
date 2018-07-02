package 动态分配;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入空间总长度");
		int allLongth = input.nextInt();
		ArrayList<Depart> departs = new ArrayList<Depart>();
		departs.add(new Depart(0,0,allLongth,0));
		while(true){
			System.out.println("请选择功能"
					+ "1.申请内存"
					+ "2.收回内存"
					+ "3.退出");
			int s = input.nextInt();
			switch(s){
			case 1:
				System.out.println("请输入进程大小");
				if(Utils.apply(departs, input.nextInt())){
					System.out.println("申请成功");
				} else{
					System.out.println("申请失败");
				}
				break;
			case 2:
				System.out.println("请输入分区号");
				Utils.relise(departs, input.nextInt());
				break;
			case 3:
				input.close();
				System.exit(1);
			}
			for(Depart depart:departs){
				System.out.println(depart);
			}
		}
	}
}
