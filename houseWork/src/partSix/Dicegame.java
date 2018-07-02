package partSix;


public class Dicegame {
	private int dice1 = 0;
	private int dice2 = 0;
	private int time = 0;
	private int sum = 0;
	private int temp = 0; 
	private int flag = 0; //1 win 2 lost 3 nature
	private int runTimes = -1; // for 6 point 32
	private int winTimes = 0;
	
	
	Dicegame(){
		dice1 = (int) Math.ceil(5 * Math.random()) + 1;
		dice2 = (int) Math.ceil(5 * Math.random()) + 1;
		sum = dice1 + dice2;
		compute();		
	}
	
	Dicegame(int runTimes){
		if(Cheak(runTimes)){
			dice1 = (int) Math.ceil(5 * Math.random()) + 1;
			dice2 = (int) Math.ceil(5 * Math.random()) + 1;
			sum = dice1 + dice2;
			this.runTimes = runTimes;
			compute();
		}
		
	}
	
	private boolean Cheak(int runTimes){
		if(runTimes <= 0){
			System.out.println("You number is err!");
			return false;
		}
		else
			System.out.println("The project start to run\n");
		return true;
	}
	
	
	private void compute(){
		time++;
		if(time <= 1)
			if(sum == 7|| sum == 11){
				flag = 1;
				display();
			}
			else if(sum == 2 || sum == 3 || sum == 12){
				flag = 2;
				display();
			}
			else {
				flag = 3;	
				temp = sum;
				display();
			}
		
		
		while(time >= 1 || runTimes > 0){
			time++;
			dice1 = (int) Math.ceil(5 * Math.random()) + 1;
			dice2 = (int) Math.ceil(5 * Math.random()) + 1;
			sum = dice1 + dice2;
			
			if(sum == temp){
				flag = 1;
				display();
			}
			else if(sum == 7){
				flag = 2;
				display();
			}
			else{
				flag = 3;
				display();
			}				
		}
	}
	
	
	private void display(){
		System.out.println("You rolled " + dice1 + " + " +
				dice2);
		if(flag == 1){
			System.out.println("You win\n");
			time = 0;
			winTimes++;
			runTimes--;
		}
		else if ( flag == 2){
			System.out.println("You lost\n");
			time = 0;
			runTimes--;
		}
		else if(time == 1){
			temp = sum;
			System.out.println("point is " + temp);
		}
		
		if(runTimes == 0)
			System.out.println("You all win " + winTimes + " times");
	}
	
	
}
