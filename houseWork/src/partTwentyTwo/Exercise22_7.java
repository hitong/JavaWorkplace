package partTwentyTwo;

import java.util.*;


public class Exercise22_7 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		HashMap<Integer,Integer> i = new HashMap<>();
		Integer tmp = 0;
		while(true){
			tmp = input.nextInt();
			if(tmp == 0){
				break;
			}
			if(i.get(tmp) != null){
				i.put(tmp, i.get(tmp)+1);
			}
			else{
				i.put(tmp, 1);
			}	 
		}
		Integer max = Collections.max( i.values());
		Set<Integer> s = i.keySet();
		for(Integer set : s){
			if(i.get(set).equals(max)){
				System.out.print(set + " ");
			}
		}
		input.close();
	}
}
