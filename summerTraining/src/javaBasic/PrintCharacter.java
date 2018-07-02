package javaBasic;

public class PrintCharacter {
	public static void main(String[] args){
		printChars('1', 'Z', 10);	
	}
	
	public static void printChars(char ch1, char ch2, int numberPerLine){
		for(int i = (int)ch1; i <= (int)ch2; i++){
			if((i - (int)ch1 + 1) % numberPerLine == 0){
				System.out.println((char)i);
			}
			else 
				System.out.print((char)i);
		}
	}
}
