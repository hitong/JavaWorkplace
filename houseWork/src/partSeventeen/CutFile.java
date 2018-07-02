package partSeventeen;

import java.util.*;
import java.io.*;

public class CutFile {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		String s = input.nextLine(); 
		File file = new File(s);
		System.out.println("Input the pieces of file");
		int pieces = input.nextInt();
			
		if(file.exists()){
			try(BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(file))){
				long times = 0;
				for(int i = 0; i < pieces; i++)
					try(BufferedOutputStream out = new BufferedOutputStream(
							new FileOutputStream("F:\\JavaFile\\SourceFile_" 
									+ (i + 1)  + ".dat"))){
						times = (long)(file.length() / pieces);
						while((times--) >= 0)
							out.write(in.read());
					}
			}
				
		}		
		else
			System.out.println("The file can not be cut");
		
	}
}
