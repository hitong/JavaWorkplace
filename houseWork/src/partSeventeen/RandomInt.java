package partSeventeen;

import java.util.*;
import java.io.*;

public class RandomInt {
	public static void main(String[] args) throws IOException{
		String s = "F:\\JavaFile\\Exercise 17_01.txt";
		File file = new File(s);
		
		
		PrintWriter in = new PrintWriter( 
				new FileWriter(s, file.exists()));
		
		for(int i = 0; i < 100; i++){
			in.print((int)(Math.random() * 100));;
			in.print(" ");
			System.out.println(i);
		}
		in.close();
		
	}
}
