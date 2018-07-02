package acm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tricolor {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		char[] color = {'R', 'W', 'B'};
		char[] s;
		int times;
		
		while(true){
			try{
				times = input.nextInt();
				
				break;
			}
			catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input integer");
			}
		}
		
		
		String flagColor;
		input.nextLine();
		for(int i = 0; i < times; i++){	
			flagColor = input.next();
			
			s = (flagColor).toUpperCase().toCharArray();	
			/**获取输入字符串，并将其转换成大写字母，然后转换成字符数组*/
			
			if(checkChar(s)){
				for(int j = 0; j < 3; j++){
					for(int k = 0; k < s.length; k++){
						if(color[j] == s[k]){
							System.out.print(color[j]);
						}
					}
				}
				/**通过指定字母和顺序，输出相应字母*/
				System.out.println();
			}
			else{
				System.out.println("You can only enter R, B, W ");
			}
			
		}	
		
		input.close();
	}
	
	public static boolean checkChar(char[] s){
		for(int i = 0; i < s.length; i++){
			if(s[i] != 'R' && s[i] != 'W' && s[i] != 'B'){
				return false;
			}
		}
		
		
		return true;
	}
}
