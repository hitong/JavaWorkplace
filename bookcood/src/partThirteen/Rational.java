package partThirteen;

@SuppressWarnings("serial")
public class Rational extends Number
		implements Comparable<Rational> {
	private long numerator = 0;
	private long denominator = 1;
	
	public Rational(){
		this(0 , 1);
	}
	
	public Rational(long numrator, long denominator){
		long gcd = gcd(numrator , denominator);
		this.numerator = ((denominator > 0) ? 1 : -1) 
				* numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
		
	}
	
	
	private static long gcd(long n, long d){
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for(int k = 1; k <= n1; k++){
			if(n1 % k == 0 && n2 % k ==0){
				gcd = k;
			}
		}
		
		return gcd;
	}
	
	
	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public Rational add(Rational secoundRational){
		long n = numerator * secoundRational.getDenominator() + 
				denominator * secoundRational.getNumerator();
		long d = numerator * secoundRational.getNumerator() + 
				denominator * secoundRational.getNumerator();
		
		return new Rational(n ,d );
	}
	
	public Rational sub(Rational secondRational){
		long n = numerator * secondRational.getDenominator() - 
				denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator() -
				numerator * secondRational.getNumerator();
		
		return new Rational(n , d);
		
	}
	
	public Rational div(Rational secondRational){
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.getDenominator();
		
		return new Rational(n , d);
		
	}
	
	public Rational mul(Rational secondRational){
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getNumerator();
		
		return new Rational(n , d);
		
	}
	
	public String toString(){
		if(denominator == 1)
			return numerator +"";
		else
			return numerator + " " + denominator;
	}
	
	public boolean equals(Object other){
		if((this.sub((Rational)other).getNumerator()) == 0)
				return true;
		else 
			return false;
	}
	
	public int intValue(){
		return (int)doubleValue();
	}
	
	public float floatValue(){
		return (float)doubleValue();
	}
	
	public double doubleValue(){
		return numerator * 1.0 / denominator;
	}
	
	public long longValue(){
		return (long)doubleValue();
	}
	
	public int compareTo(Rational o){
		if(this.sub(o).getNumerator() > 0)
			return 1;
		else if(this.sub(o).getNumerator() == 0) 
			return 0;
		else
			return -1;
	}
		
}

