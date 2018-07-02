package partThirteen;

public class Exercise13point17 {
	public static void main(String[] args) throws CloneNotSupportedException{
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		
		System.out.print("Enter the fitst complex number:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		System.out.print("Enter the fitst complex number:");
		double c = input.nextDouble();
		double d = input.nextDouble();
		
		Complex first = new Complex(a, b);
		Complex second = new Complex(c, d);
		
		System.out.println("(" + first.toString() +
				") + " + "(" + second.toString() + 
				") " + " = " + 
				first.add(second));
		System.out.println("(" + first.toString() +
				") - " + "(" + second.toString() + 
				") " + " = " + 
				first.substract(second));
		System.out.println("(" + first.toString() +
				") * " + "(" + second.toString() + 
				") " + " = " + 
				first.multiply(second));
		System.out.println("(" + first.toString() +
				") / " + "(" + second.toString() + 
				") " + " = " + 
				first.divide(second));
		System.out.println("|(" + first.toString() + 
				")|" + " = " + first.absolute());
	}
}


class Complex implements Cloneable{
	private double realPart;
	private double imaginaryPart;
	
	Complex(){
		realPart = 0;
		imaginaryPart = 0; 
	}
	
	Complex(double realPart){
		this.realPart = realPart;
		this.imaginaryPart = 0; 
	}
	
	Complex(double realPart, double imaginaryPart){
		 this.realPart = realPart;
		 this.imaginaryPart = imaginaryPart;
	}
	
	public String add(Complex o) throws CloneNotSupportedException {
		Complex prisent = (Complex) this.clone();		
		prisent.setRealPart(prisent.getRealPart() +	o.getRealPart());
		prisent.setImaginaryPart(prisent.getImaginaryPart() 
				+ o.getImaginaryPart());		
		return prisent.toString();
	}
	
	public String substract(Complex o) throws CloneNotSupportedException{
		Complex prisent = (Complex) this.clone();		
		prisent.setRealPart(prisent.getRealPart() -	o.getRealPart());
		prisent.setImaginaryPart(prisent.getImaginaryPart() 
				- o.getImaginaryPart());		
		return prisent.toString();
	}
	
	public String multiply(Complex o){
		Complex prisent = new Complex();		
		double a = this.getRealPart();
		double b = this.getImaginaryPart();
		double c = o.getRealPart();
		double d = o.getImaginaryPart();
		prisent.setRealPart(a * c - b * d) ;
		prisent.setImaginaryPart(b * c + a * d);
		return prisent.toString();
	}
	
	public String divide(Complex o) {
		Complex prisent = new Complex();		
		double a = this.getRealPart();
		double b = this.getImaginaryPart();
		double c = o.getRealPart();
		double d = o.getImaginaryPart();
		prisent.setRealPart((a * c + b * d) /( c * c + d * d)) ;
		prisent.setImaginaryPart((b * c - a * d) /(c*c + d *d));
		return prisent.toString();
	}

	public double  absolute(){		
		double a = this.getRealPart();
		double b = this.getImaginaryPart();
		double c = Math.sqrt(a * a + b * b);
		return c;		
	}

	public double getRealPart() {
		return realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	public Object clone() throws CloneNotSupportedException{	
		Complex one = (Complex)super.clone();
		return one;
	}

	public String toString(){
		return (imaginaryPart == 0)? (realPart + ""): 
			(realPart + " + " + imaginaryPart + "i");
	}
	
}