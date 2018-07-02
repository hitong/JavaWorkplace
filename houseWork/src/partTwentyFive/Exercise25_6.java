package partTwentyFive;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Stack;

public class Exercise25_6 {
	public static void main(String[] args) throws  Exception{
		LinkedList<Character> s = new LinkedList<>();
		
		File f = new File(args[0]);
		if(!f.isFile()){
			System.out.println("请检查文档输入地址");
			return;
		}
		try(FileInputStream in = new FileInputStream(f)){
			while(true){
				int tmp = in.read();
				if(tmp == -1){
					break;
				}
				if(tmp == '{'  || tmp == '}' || tmp == '(' || tmp == ')' || tmp == '[' || tmp == ']'){
					s.add((char)tmp);					
				}
			}
		}
		Stack<Character> ch = new Stack<>();
		while(!s.isEmpty()){
			char c = s.poll();
			if(c == '{'  || c == '(' || c == '['){
				ch.push(c);
			}
			else{
				if(ch.size() == 0){
					System.out.println("括号不合法");
					return;
				}
				char d = ch.pop();
				if(!(c - d == 1 || c - d == 2)){
					System.out.println("括号不合法");
					return;
				}
			}
		}
		System.out.println("括号合法");
		return ;
	}
}	
