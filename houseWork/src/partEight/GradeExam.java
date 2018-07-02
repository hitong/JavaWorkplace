package partEight;

import java.util.Scanner;

public class GradeExam {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many the students? ");
		int students = input.nextInt();
		
		String[][] answer = new String[students][3];
		String[] correntAnswer = new String[3];
		
		for(int i = 0; i < students ; i++){
			for(int j = 0; j < 3 ; j++){
				System.out.println("Please enter number" + j + "'s answer: ");
				answer[i][j] = input.next();
				
				if(i == 0)
					correntAnswer[j]= "" + (char)('A' + Math.round((Math.random() * 3))) + 
					(char)('A' + Math.round((Math.random() * 3))) +
					(char)('A' + Math.round((Math.random() * 3))) +
					(char)('A' + Math.round((Math.random() * 3)))	;
			}	
			
		}
		
		
		System.out.println("The corrent Answer is:");
		for(int i = 0; i < 3; i++){
			System.out.print((i+1) + ". " );
			for(int j = 0; j < 4; j ++){
				boolean equa = true;
				for(int k = j - 1; k >= 0; k--){
					if( correntAnswer[i].charAt(k) == correntAnswer[i].charAt(j)){
						equa = false;
						break;
					}
				}
				if(equa)
					System.out.print(correntAnswer[i].charAt(j));
			}
			System.out.println();
		}
		
		int[] count = new int[students];
		for(int i = 0; i < students ;i++){
			
			for(int j = 0; j < 3; j++){
				boolean right = false;
				count[i] = 0;
				answer[i][j].toUpperCase();
				for(int k = 0; k < answer[i][j].length(); k++){
					for(int l = 0; l < correntAnswer[j].length(); l++)
						if(answer[i][j].charAt(k) != correntAnswer[j].charAt(l)){
							right = true;
							break;
						}
					if(right)
						break;
				}
				
				if(right)
					continue;
				
				for(int k = 0; k < correntAnswer[j].length(); k++){
					for(int l = 0; l < answer[i][j].length(); l++)
						if(answer[i][j].charAt(l) != correntAnswer[j].charAt(k)){
							right = true;
							break;
						}
					if(right)
						break;
				}
				if(right)
					continue;
				count[i]++;
			}
		}
		for(int i = 0; i < students; i++){
			System.out.println("Student " + i + "'s correct count is "	+ count[i]);
		}
	}
}
