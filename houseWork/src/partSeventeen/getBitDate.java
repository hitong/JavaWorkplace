package partSeventeen;

import java.io.*;
import java.util.*;

public class getBitDate {
	public static void main(String[] args) throws IOException{
		String s = "F:\\JavaFile\\Exercise 17_02.dat";
		File file = new File(s);
		try(DataOutputStream in = new DataOutputStream(
				new FileOutputStream(s, file.exists()))){
			for(int i = 0; i < 100; i++){
				in.writeInt((int)(Math.random() * 100));
			}
			
		}
	}
}
