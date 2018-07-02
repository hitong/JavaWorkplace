package partTwentyThr;

import java.util.*;


public class Exercise23_5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a seriese of numbers ending with 0:");
		ArrayList<Integer> list = new ArrayList<>();
		while(true){
			list.add(input.nextInt());
			if(list.get(list.size() - 1) == 0){
				break;
			}
		}
		Iterator<Integer> it = list.iterator();
		int flag = 0, times1 = 0;
		int times2 = 0;
		int index = -1;
		ArrayList<Integer> arr = new ArrayList<>();
		while(it.hasNext()){
			index++;
			int tmp = it.next();
			if(flag == tmp){
				times1++;
			}
			else{
				flag = tmp;
				if(times2 == times1){
					arr.add(index - times2 - 1);
				}
				else if(times2 < times1){
					times2 = times1;
					arr.clear();
					arr.add(index - times2 - 1);
				}
				times1 = 0;
			}
		}
		
		System.out.println("The longest same number sequence starts at index");
		for(int d:arr){
			System.out.print(d + " ");
		}
		System.out.print(" with " + times2 + " valuse of ");
		for(int d:arr){
			System.out.print(list.get(d) + " ");
		}
		input.close();
	}
}
