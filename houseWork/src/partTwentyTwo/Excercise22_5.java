package partTwentyTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Excercise22_5 {
	public static void main(String[] args) throws Exception{
		File f = new File(args[0]);
		if(!f.isFile()){
			System.out.println("文件地址有误");
			return;
		}
		BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(f));
		String s = "";
		int t = -1;

		ArrayList<String> st = new ArrayList<String>();
		while(true){
			t = in.read();
			if((t <= 'z' && t >= 'a') || (t <= 'Z' && t >= 'A') ){
				s = s + (char)t;	
			}
			else{
				if(s != ""){
					st.add(s);
				}
				if(t == -1){
					break;
				}
				s = "";
			}		
		}
		Collections.sort(st);
		for(String d: st){
			System.out.println(d);
		}
	}
}	
