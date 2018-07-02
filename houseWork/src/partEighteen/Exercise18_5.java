package partEighteen;

public class Exercise18_5 {
	public static void main(String[] args){
		System.out.println(Series(10));
	}
	
	public static double Series(double t){
		if(t <= 0){
			return 0;
		}
	
		return t / ( 2 * t + 1) + Series(t - 1);
	}
}
