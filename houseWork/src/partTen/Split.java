package partTen;

public class Split {
	public static void main(String[] args){
		java.util.Scanner input  = new java.util.Scanner(System.in);
		
		String[] string = split(input.next(),input.next()); 
		for(int i = 0; i< string.length; i++){
			System.out.println(string[i]);
		}
	}
	
	public static String[] split(String s, String regex){
		String[] newString = new String[s.length()];
		
	
		char[] newS = s.toCharArray();
		char[] newRegex = regex.toCharArray();
		int number = 0 ;
		int temp = 0;
	
		
		
		for(int i = 0;i < s.length(); i++){
			boolean flag = true;
			for(int j = 0 ; j < newRegex.length; j++){
				
				if(newS[i] == newRegex[j]){
					if(i==0){
						newString[temp] = newS[i] + "";
					}
					else{
						newString[++temp] = newS[i] + "";						
					}
					number = 0;
				    flag = false;
					break;
				}		
			}
			if(flag)
				if(number == 0){
					if(i != 0)
						temp++;
					newString[temp] =  newS[i] + "";
					number++;			
				}
				else{
					newString[temp] = newString[temp] + newS[i] ;
					number++;
				}
		}
		
		String[] newString2 = new String[temp + 1];
		for(int i = 0; i < temp + 1; i++){
			newString2[i] = newString[i].substring(0);
		}
		
		
		return newString2;
	}
}
