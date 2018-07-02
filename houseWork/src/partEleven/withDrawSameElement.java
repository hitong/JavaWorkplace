package partEleven;

import java.util.*;

public class withDrawSameElement {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter ten integer: ");
		ArrayList<Integer> o = new ArrayList<>();
		
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));
		o.add(new Integer(input.nextInt()));

		removeDuplicate(o);		
		System.out.print(o.toString());
		
	}
	
	
	
	public static void removeDuplicate(ArrayList<Integer> list){
		for(int i = 0; i < list.size() -1; i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i).equals(list.get(j))){
					list.remove(j);
					j--;
				}
			}
		}
	
	}
}

	