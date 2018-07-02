package partSix;

public class TestDicegame {
	public static void main(String[] args){
		System.out.print("Enter your choise\n" 
				+ "0. enter 0 for run the project one time\n"
				+ "1. enter 1 for the project run any times that you wanna\n");
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		
		int choise = input.nextInt();
		while(true){
			if(choise == 0){
				new Dicegame();
				break;
			}
			else if(choise == 1){
				System.out.print("Please enter the project run times: "
						);	
				new Dicegame(input.nextInt());
				break;
			}
			else
				System.out.println("You choice is err!!Please input argin");
			choise = input.nextInt();
		}
		
	}
}
