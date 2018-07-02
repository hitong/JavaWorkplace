package version2;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import version1.IsGeometric;

@SuppressWarnings("serial")
public class Triangle implements GeometricObject,Serializable {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	private Color color = Color.BLUE;
	private boolean filled = false;
	private Date dateCreated;
	
	static Decimal decimal = new Decimal();
	
	Triangle(){
		this.dateCreated = new Date();
	}
	
	Triangle(double side1, double side2,double side3) 
			throws NotATriangleException{
		this.dateCreated = new Date();	
		
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;
		
		try{
			this.setAllSide(side1, side2, side3);
		}
		catch(SideLengthSetIncorrectlyException ex){
			throw new NotATriangleException();
		}
	}
	
	Triangle(double side1, double side2,double side3, Color color, boolean filled) 
			throws NotATriangleException{
		this.dateCreated = new Date();	
		this.setColor(color);
		this.setFilled(filled);
		
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		side3 = (int)(side3 * 100) / 100.0;

		try{
			this.setAllSide(side1, side2, side3);
		}
		catch(SideLengthSetIncorrectlyException ex){
			throw new NotATriangleException();
		}
	}
	
	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) 
			throws SideLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		if(IsGeometric.work(side1, side1, side1))
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
		if(IsGeometric.work(side1, side2, side3))
			this.side2 = side2;
		else
			throw new SideLengthSetIncorrectlyException();
	}
	
	public double getSide3() {
		return this.side3;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String draw() {
		return  "(1) Draw the line AB first:" + side1 +
				"\n(2) Take the point A as the center of the circle,  and the " +
				 "length of " + side2 + "is the radius and draw the arc." + 
				"\n(3) Take B as the center of the circle, " + side3 +
				" is the radius, the arc is drawn, and the two arc " +
				"intersects the point C" + 
				"\n(4) Link AB, BC.";
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
	
	@SuppressWarnings("static-access")
	@Override
	public String getArea() {
		double s = Double.parseDouble(this.getPerimeter()) / 2.0;
		return decimal.work(Math.sqrt(s * (s - side1) * (s - side2) *(s - side3)));
	}
	
	@SuppressWarnings("static-access")
	@Override
	public String getPerimeter() { 
		return decimal.work(side1 + side2 +side3);
	}
	
	public void writeToFile(File f) throws IOException{
		try(ObjectOutputStream output = new MyObjectOutputStream(
					new FileOutputStream(f,true))){		
			output.writeObject(this);	
		}				
		catch (FileNotFoundException e) {
			System.out.println(e);
		} 
	}
	
	@Override
	public String toString(){
		return "Triangle\nside1: " + side1 + " side2: " + side2 + " side3: " + side3 +
				"\ncolor: " + this.getColor() + 
				"\nfilled: " + this.isFilled() + 
				"\ncreated date: " + this.getDateCreated() ;
	}
}

@SuppressWarnings("serial")
class NotATriangleException extends Exception {
	public String toString(){
		return "The side should biger than 0,and "
				+ "the sum of any two sides is greater than the third side";
	}
}

@SuppressWarnings("serial")
class SideLengthSetIncorrectlyException extends Exception {
	public String toString(){
		return "use the new side can not be a Triangle";
	}
}