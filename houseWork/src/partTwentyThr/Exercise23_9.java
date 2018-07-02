package partTwentyThr;

import java.io.*;
import java.util.ArrayList;

public class Exercise23_9 {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		File f = new File("Exercise23_8");
		ObjectInputStream w = new ObjectInputStream(new FileInputStream(f));
		ArrayList<Integer> arr = new ArrayList<>();
		Long flag = new Long(0);
		while((flag = (Long) w.readObject()) != -1){
			if((Long)w.readObject() <= Math.pow(10, 10)){
				flag++;
			}
		}	
	}
}
