package partThirteen;

public class TestRational {
	public static void main(String[] args){
		Rational one = new Rational(1 , 2) ;
		Rational two = new Rational(1 , -2) ;
		System.out.println(one.add(two));
	}
}
