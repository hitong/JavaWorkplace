package partSeventeen;

import java.util.* ;
import java.io.*;

public class BitSum {
	public static void main(String[] args) throws IOException{
		String s = "F:\\JavaFile\\Exercise 17_02.dat";
		File file = new File(s);
		int i = 0 , sum = 0;
		
		try{
			DataInputStream in = new DataInputStream(
					new FileInputStream(file));
				in.readInt();	
			try{
				while(true){
					i = in.readInt();
					System.out.print(i + " ");
					sum += i;
				}
			}
			catch(EOFException ex){
				System.out.println("\nSum is " + sum);
			}
		}
		
		catch(FileNotFoundException ex){
			System.out.println("The file is not found");
		}
		
	}
}
