package javaBasic;

public class Complex {
	private double realPart;
	private double imaginPart;
	
	
	Complex(){
		realPart = imaginPart = 0;
	}
	
	Complex(double realPart){
		this.setRealPart(realPart);
		this.setImaginPart(0);
	}
	
	Complex(double realPart, double imaginPart){
		this.setRealPart(realPart);
		this.setImaginPart(imaginPart);
	}
	
	/**
	 * 将两个复数相加得到一个新的复数并返回
	 * @param c
	 * @return
	 */
	public Complex add(Complex c){	
		return new Complex(this.getRealPart() + c.getRealPart() , 
						   this.getImaginPart() + c.getImaginPart());
	}
	
	/**
	 * 两个复数相减得到一个新的复数并返回
	 * @param c
	 * @return
	 */
	public Complex substruct(Complex c){
		
		return new Complex(this.getRealPart() - c.getRealPart(), 
				this.getImaginPart() - c.getImaginPart());
	}

	/**
	 * 两个复数相乘得到一个新的复数并返回
	 * @param c
	 * @return
	 */
	public Complex multiply(Complex c){
		
		return new Complex(this.getRealPart() * c.getRealPart() - 
					this.getImaginPart() * c.getImaginPart() , 
					this.getImaginPart() * c.getRealPart() + 
					this.getRealPart() * c.getRealPart());
	}
	

	/**
	 * 两个复数相除得到一个新的复数并返回
	 * @param c
	 * @return
	 */
	public Complex divide(Complex c){
		double temp1 = this.getRealPart() * c.getRealPart() + 
					this.getImaginPart() * c.getImaginPart();
		double temp2 = this.getImaginPart() * c.getRealPart() - 
					this.getRealPart() * c.getRealPart();
		double temp3 = c.getRealPart() * c.getRealPart() + 
					c.getImaginPart() * c.getImaginPart();
		
		return new Complex(temp1 / temp3, temp2 / temp3);
	}
	
	/**
	 * 将该复数取绝对值后，返回结果
	 * @return
	 */
	public Complex abs(){
		return new Complex(Math.sqrt(this.getImaginPart() * this.getRealPart()));
	}
	
	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginPart() {
		return imaginPart;
	}

	public void setImaginPart(double imaginPart) {
		this.imaginPart = imaginPart;
	}
	
	
	public String toString(){
		return this.getImaginPart() == 0 ? 
				this.getRealPart()  + "" :
				this.getRealPart() + " + " + this.getImaginPart() + "i";
	}
	
}
