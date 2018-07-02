package tictactoe;

import java.util.ArrayList;
import java.util.Stack;

public class Machine {
	int NO_BLANK = 0;
	boolean isFirst = true;
	int nextStep = -1;
	int flag = -1;
	 int[] end = {
			 123,456,789,357,159,147,258,369
	 };
	 
	 Machine(boolean isFirst){
		 this.isFirst = isFirst;
	 }
	 
	 public int index(int[] position){
		 //NegaMax(position, 9);
		 MiniMax(position, 9);
		 return nextStep;
	 }

	public int NegaMax(int[] position, int depth) {
		int value = Integer.MIN_VALUE  ;
		int bestvalue = Integer.MIN_VALUE  ;
		if(end(position) != -1|| depth == 0){
			int count = evaluation(position);
			//isFirst = !isFirst;
			//count -= evaluation(position);
			//isFirst = !isFirst;
			//System.out.print(count  + "　");
			return count;
		}
		
		for(int i = 0; i < 9; i++){
			if(position[i] == 0){
				position = MakeMove(position,i);
				value = -NegaMax(position, depth - 1);
				position = UnMove(position,i);
				
				if(value >= bestvalue){
					bestvalue = value;
					if(depth == 9){
						nextStep = i;
					}
				}
			}
		}
	//	System.out.print(bestvalue  + "　");
		
		return bestvalue;
	}
	
	 int MiniMax(int[] position, int d){
		 int bestvalue, value;
		if(end(position) != -1|| d <= 0){
			return evaluation(position);
		}
		
		if(d % 2 == 1){
			bestvalue = Integer.MAX_VALUE;
		}
		else{
			bestvalue = Integer.MIN_VALUE;
		}
		
		for(int i = 0; i < 9; i++){
			if(position[i] == 0){
				position=MakeMove(position, i);
				
				value = MiniMax(position, d-1);
//				if(d==4&&position[4]==1&&position[0]==-1&&position[8]==1&&position[2]==-1){
//					System.out.println(value);
//					this.printMap(position);
//				}
				position=UnMove(position, i);
				if(d % 2 == 1){
					if(value < bestvalue){
						bestvalue = Math.min(value, bestvalue);
						if(d == 9){
							this.nextStep = i;
						}
					}		
				}
				else{
					bestvalue = Math.max(value, bestvalue);		
				}
			}
		}
		return bestvalue;
	 }
	
	/**
	 * 移除第i个棋
	 * @param position
	 * @param i
	 * @return
	 */
	private int[] UnMove(int[]	position, int i){
		position[i] = 0;
		return position;
	}
	
	
	/**
	 * 统计棋盘中-1和1的个数，从而判断是该哪个玩家落子 1为先手，-1为后手
	 * @param position
	 * @param m
	 * @return
	 */
	private int[] MakeMove(int[] position, int m) {
		ArrayList<Integer> s1 = new ArrayList<>();
		ArrayList<Integer> s2 = new ArrayList<>();
		for(int i = 0;i < 9; i++){
			if(position[i] == 1){
				s1.add(i + 1);
			}
			else if(position[i] == -1){
				s2.add(i + 1);
			}
		}
		
		if(s1.size() > s2.size()){			
			position[m] = -1;
		}
		else{
			position[m] = 1;
		}
		return position;
	}
	
	/**
	 * @param position
	 * @return
	 */
	private int end(int[] position){
		ArrayList<Integer> s1 = new ArrayList<>();//统计先手落子情况
		ArrayList<Integer> s2 = new ArrayList<>();//统计后手落子情况
		ArrayList<Integer> s;
		for(int i = 0;i < 9; i++){
			if(position[i] == 1){
				s1.add(i + 1);
			}
			else if(position[i] == -1){
				s2.add(i + 1);
			}
		}
		
		if(s1.size() > s2.size()){
			flag = 1;
			s = s1;
		}
		else{
			flag = 0;
			s = s2;
		}
		
		/**
		 * 第一次筛选
		 */
		Stack<Integer> t = new Stack<>();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < s.size();j++){
				if((end[i] + "").contains("" + s.get(j))){//转换成字符串方便调用比较方法，免去数字转换
					t.add(end[i]);
					break;
				}
			}
		}
		
		/**
		 * 第二次筛选
		 */
		while(!t.isEmpty()){
			int tmp = t.pop();
			if(s.contains(tmp % 10)){
				if(s.contains(tmp / 100)){
					if(s.contains((tmp / 10)%10)){
						return 1;
					}
				}
			}
		}
		
		if(s1.size() + s2.size() == 9){
			flag = -1;			
			return 0;
		}
		else{
			flag = -2;	
			return -1;
		}
	}

	/**
	 * @param position
	 * @return
	 */
	private int evaluation(int[] position){	
		
			if(flag !=-1){
				if(isFirst && flag==1){
					return 10000;
				}else if(isFirst && flag==0){
					return -10000;
				}else if(!isFirst && flag==1){
					return -10000;
				}else if(!isFirst && flag==0){
					return 10000;
				}
			}
		
		return NO_BLANK;	
//
//		int count = 0;
//		int[]	tmp = new int[9];
//		System.arraycopy(position, 0, tmp, 0, 9);
//		
//		if(isFirst){
//			for(int i = 0; i < 9; i++){
//				if(tmp[i] == 0){
//					tmp[i] = 1;
//				}
//			}
//		}
//		else{
//			for(int i = 0; i < 9; i++){
//				if(tmp[i] == 0){
//					tmp[i] = -1;
//				}
//			}
//		}
//
//		for(int i = 0; i < 3; i++){
//			count+=(tmp[i]+tmp[i  + 3]+tmp[i + 6])/3;
//			count+=(tmp[0 + 3 * i]+tmp[1 + 3 * i]+tmp[2 + 3 * i])/3;
//		}
//		
//		count+= (tmp[0]+tmp[4]+tmp[8])/3;
//		count+= (tmp[2]+tmp[4]+tmp[6])/3;
//		return count;
	}
}
