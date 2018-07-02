package partEleven;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount {
	public static void main(String[] args){
			
		Account George = new Account("George", 1122,1000, 0.015);	
		
		George.add('D', 30);
		George.add('D', 40);
		George.add('D', 50);
		George.add('W', 5);
		George.add('W', 4);
		George.add('W', 2);
		
		George.display();	
		
		ArrayList<Transaction> o = George.getO();
		System.out.print(o.size());
	}
}
