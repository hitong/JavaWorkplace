package partSeventeen;

import java.io.*;
import java.util.Scanner;

public class Exercise17_09 {
	public static void main(String[] args) throws IOException{
		try(RandomAccessFile inout = 
				new RandomAccessFile("address.dat", "rw")){
			
		}
	}
}

class Oprater{
	
	public static void Add(RandomAccessFile inout, String information) throws IOException
		{	
		inout.writeChars(information);
		
	}
	
	public static String First(RandomAccessFile inout)
		throws IOException{
		inout.seek(0);
		return inout.readUTF();
	}
	
	public static String Next(RandomAccessFile inout)
			throws IOException{
		return inout.readUTF();
	}
	
	public static void Previous(){	
	}
	
	public static String Last(RandomAccessFile inout)
			throws IOException{
		if(inout.length() != 0){
			inout.seek(inout.length() - 91);
			return inout.readUTF();
		}
		else
			return "null";
	}
	
	public static void Update(){
		
	}
}
