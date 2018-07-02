package partSevent;

import java.io.*;

public class TestobjectOutputStream {
	public static void main(String[] args) throws IOException{
		try(ObjectOutputStream output = 
				new ObjectOutputStream(new FileOutputStream("Object.dat"))){
			output.writeUTF("Jone");
			output.writeDouble(85.5);
			output.writeObject(new java.util.Date());
		}
		
		
	}
}
