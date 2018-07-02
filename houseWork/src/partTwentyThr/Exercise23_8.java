package partTwentyThr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise23_8 {
	public static void main(String[] args) throws IOException{
		File f = new File("Exercise23_8");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		for(Long i = new Long(2) ; i < Math.pow(10, 10);i++){
			boolean flag = true;
			for(long j = 2; j <= Math.sqrt(i) ; j  ++){
				if(i % j == 0){
					flag = false;	
					break;
				}
			}
			
			if(flag){
				out.writeObject(i);
			}
		}
		out.close();
	}
}
