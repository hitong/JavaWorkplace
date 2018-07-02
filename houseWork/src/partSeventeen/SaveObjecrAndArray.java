package partSeventeen;

import java.util.*;
import java.io.*;

public class SaveObjecrAndArray {
	public static void main(String[] args) throws IOException{
		String s = "F:\\JavaFile\\Exercise 17_05.txt";
		File file = new File(s);
		int[] arr = {1, 2, 3, 4, 5};
		
		try(ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(file, file.exists()))){
			out.writeObject(arr);
			out.writeObject(new Date());
			out.writeDouble(2.5);
		}
		
		
	}
}
