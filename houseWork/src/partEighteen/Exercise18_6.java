package partEighteen;

public class Exercise18_6 {
	public static void main(String[] args){
		Series(10);
	}
	
	public static double Series(double t){
		if(t <= 0){
			System.out.print(0);
			return 0;
		}
		
		System.out.print((int)t + " / (" + (int)t + " + " + 1 + ") + ");
		return t / ( t + 1) + Series(t - 1); 
	}
}
