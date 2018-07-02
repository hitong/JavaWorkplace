package version1;

import java.awt.Color;

public class Triangle extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){
	}
	
	Triangle(double side1, double side2,double side3) throws Exception{
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;		
		this.setAllSide(side1, side2, side3);
	}
	
	Triangle(double side1, double side2,double side3 , Color color) 
			throws Exception{
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;
		
		this.setAllSide(side1, side2, side3);
		super.setColor(color);
	}
	
	Triangle(double side1, double side2, double side3, boolean filled) 
			throws Exception{
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;
		
		this.setAllSide(side1, side2, side3);
		super.setFilled(filled);
	}
	
	Triangle(double side1, double side2,double side3, Color color, boolean filled) 
			throws Exception{
		super(color, filled);		
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;	
		this.setAllSide(side1, side2, side3);
	}
	
	@Override
	String draw() {
		return  "(1) Draw the line AB first:" + side1 +
				"\n(2) Take the point A as the center of the circle,  and the " +
				 "length of " + side2 + "is the radius and draw the arc." + 
				"\n(3) Take B as the center of the circle, " + side3 +
				" is the radius, the arc is drawn, and the two arc " +
				"intersects the point C" + 
				"\n(4) Link AB, BC.";
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) 
			throws SideLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		if(IsGeometric.work(side1, side2 , side3))
			this.side1 = side1;
		else
			throw new SideLengthSetIncorrectlyException();
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) 
			throws SideLengthSetIncorrectlyException{
		side2 = (int)(side2 * 100) / 100.0;
		if(IsGeometric.work(side1, side2 , side3))
			this.side2 = side2;
		else
			throw new SideLengthSetIncorrectlyException();
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) 
			throws SideLengthSetIncorrectlyException{
		side3 = (int)(side3 * 100) / 100.0;
		if(IsGeometric.work(side1, side2, side3))
			this.side3 = side3;
		else
			throw new SideLengthSetIncorrectlyException();
	}
	
	public void setAllSide(double side1, double side2, double side3) 
			throws SideLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;
		if(IsGeometric.work(side1, side2, side3)){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else
			throw new SideLengthSetIncorrectlyException();
	}

	@Override
	public GeometricObject[] erase(GeometricObject[] geometricObject) {
		GeometricObject[] g = new GeometricObject[geometricObject.length - 1];
		
		for(int i = 0; i < geometricObject.length; i++){		
			if(geometricObject[i].hashCode() == this.hashCode()){
				for(int j = i + 1; j < geometricObject.length; j++)
					g[j - 1] = geometricObject[j];
				break;
			}
			g[i] = geometricObject[i];
		}
		
		return g;
	}
	
	@Override
	String getArea() {
		double s = Double.parseDouble(this.getPerimeter()) / 2.0;
		return super.decimal(Math.sqrt(s * (s - side1) * (s - side2) *(s - side3)));
	}
	
	@Override
	String getPerimeter() { 
		return super.decimal(side1 + side2 +side3);
	}
	
	@Override
	public String toString(){
		return "Triangle\nside1: " + side1 + " side2: " + side2 + " side3: " + side3 +
				"\ncolor: " + super.getColor() + 
				"\nfilled: " + super.isFilled() + 
				"\ncreated date: " + super.getDateCreated() ;
	}
}

/****************
 * Òì³£ÉêÃ÷
 * 
 * **********************/
@SuppressWarnings("serial")
class NotATriangleException extends Exception {
	public String toString(){
		return "The side should biger than 0,and "
				+ "the sum of any two sides is greater than the third side";
	}
}

@SuppressWarnings("serial")
class SideLengthSetIncorrectlyException extends Exception{
	public String toString(){
		return "use the new side can not be a Triangle";
	}
}
