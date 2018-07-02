package Test;

import java.io.*;
import java.util.TreeSet;


public class HelloWorld{
	@SuppressWarnings("unchecked")
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

		TreeSet<String> st = new TreeSet<String>();
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
		
		for(String d: st){
			System.out.println(d);
		}
		in.close();
	}
}