package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Col {
	 int[]  m = new int[9];//用与存储棋局信息
	 int tr = 0; //记录游戏步数
	 Machine machine;
	 int[] end = {
			 123,456,789,357,159,147,258,369
	 };//游戏胜利条件
	 
	 Col(boolean isFirst){
		 machine = new Machine(!isFirst);
	 }
	
	 /**
	  * 先手为1
	  * @param x
	  * @return
	  */
	public  int inPut(int x){
		if(tr >= 9){
			System.err.println("游戏已结束");
			return 1;
		}

		if(x > 9 || x < 0 || m[x - 1] != 0){
			System.out.println("输入非法");
			System.err.println(x);
			return 0;
		}
		
		if(tr++ % 2 == 0){
			m[x - 1] = 1;
		}
		else{
			m[x - 1] = -1;		
		}
		
		int tmp = end();
		if(tmp == 1){
			if(tr % 2 == 0){
				System.out.println("后手胜");
				printMap();
				return 1;
			}
			else{
				System.out.println("先手胜");
				printMap();
				return 1;
			}
		}
		else if(tmp == 0){
			System.out.println("和棋");
			printMap();
			return 1;
		}
		else{		
			printMap();		
			return -1;
		}
	}
	
	/**
	 * 重新开始
	 */
	public void reStart(){
		m = new int[9];
		tr = 0;
	}
	
	/**
	 * 
	 * 棋局是否结束
	 * 
	 * return -1； 棋局未结束
	 * return 0； 和棋
	 * return 1； 有胜负结果
	*
	 * */
	private int end(){
		ArrayList<Integer> s1 = new ArrayList<>();
		ArrayList<Integer> s2 = new ArrayList<>();
		ArrayList<Integer> s;
		for(int i = 0;i < 9; i++){
			if(m[i] == 1){
				s1.add(i + 1);
			}
			else if(m[i] == -1){
				s2.add(i + 1);
			}
		}
		
		if(s1.size() > s2.size()){
			s = s1;
		}
		else{
			s = s2;
		}
		
		Stack<Integer> t = new Stack<>();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < s.size();j++){
				if((end[i] + "").contains("" + s.get(j))){
					t.add(end[i]);
					break;
				}
			}
		}
		
		while(!t.isEmpty()){
			int tmp = t.pop();
			if(s.contains(tmp % 10)){
				if(s.contains(tmp / 100)){
					if(s.contains((tmp / 10)%10)){
						System.out.println(tmp);
						return 1;
					}
				}
			}
		}
		
		if(tr == 9){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	/**
	 * 输出棋局
	 */
	public  void printMap(){
		System.out.println("---------");
		for(int i = 0; i < 9; i++){
			switch(m[i]){
			case 1:System.out.print(" o ");break;
			case -1:System.out.print(" x ");break;
			case 0:System.out.print(" - ");break;
			default:break;
			}
			if((i + 1) % 3 == 0){
				System.out.println();
			}
		}
		System.out.println("---------");
	}
	
	/**
	 * 主功能测试函数
	 * @param args
	 */
	public static void main(String[] args){	
		Scanner input = new Scanner(System.in);
		System.out.println("1.人先手\n2.机器先手\n3.人人对战");
		Col c ;
		int tmp = input.nextInt();
		if(tmp == 1){
			c = new Col(false);
			c.printMap();
			while(true){
				if( c.inPut(input.nextInt()) != -1 || c.inputByMachine() != -1){
					break;
				}
			}
		}
		else if(tmp == 2){
			c = new Col(true);		
			while(true){
				if(c.inputByMachine() != -1 || c.inPut(input.nextInt()) != -1){
					break;
				}
			}
		}
		else{
			c = new Col(true);		
			c.printMap();
			while(true){
				if(c.inPut(input.nextInt()) != -1 || c.inPut(input.nextInt()) != -1){
					break;
				}
			}
		}
		input.close();
	}

	public int inputByMachine() {
		return this.inPut(machine.index(m) + 1);
	}
}
