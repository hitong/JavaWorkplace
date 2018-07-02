package javaProForDateStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JosephTheDeadTheProblem {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);	
		ArrayList<Integer> list;
		int people = 0;
		int save = 0;
		int number = 0;
		while(true){
			System.out.println("请输入多少个人参与此游戏:");
			people = input.nextInt();
			System.out.println("请输入报号为几的人死亡:");
			number = input.nextInt();
			System.out.println("请输入多少个人存活:");
			save = input.nextInt();
			
			if(people < save || save <= 0 || number <= 0){
				System.out.println("输入数据非法！");
				continue;
			}
			
			break;
		}
		
		list = new ArrayList<>();
		for(int i = 0; i < people; i++){
			list.add(i + 1);
		}
		int dead = 1;
		
		while(list.size() > save ){	
			Iterator<Integer> it = list.iterator();
			while(it.hasNext()){
				int tmp = it.next(); 
				if(dead++ % number == 0){
					it.remove();
					System.err.printf("第%3d个人死亡\n",tmp);
				}
				
				if(save == list.size()){
					break;
				}
			}
		}
		System.out.println("存活的有:");
		for(int i: list){
			System.out.printf("第%3d个人\n", i);
		}
		input.close();
	}
}
