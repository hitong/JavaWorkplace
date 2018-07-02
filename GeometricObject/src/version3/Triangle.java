package version3;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JPanel;

import version1.IsGeometric;
import version2.Decimal;

@SuppressWarnings("serial")
public class Triangle extends JPanel implements GeometricObject,Serializable {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	private Color color = Color.BLUE;
	private Point point = new Point();
	private boolean filled = false;
	
	Triangle(){
	}
	
	Triangle(double side1, double side2,double side3) 
			throws NotATriangleException{	
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
	
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int getSide1() {
		return (int)side1;
	}

	public void setSide1(double side1) 
			throws SideLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		if(IsGeometric.work(side1, side1, side1))
			this.side1 = side1;
		else
			throw new SideLengthSetIncorrectlyException();
	}

	public int getSide2() {
		return (int)side2;
	}

	public void setSide2(double side2) 
			throws SideLengthSetIncorrectlyException{
		side2 = (int)(side2 * 100) / 100.0;
		if(IsGeometric.work(side1, side2, side3))
			this.side2 = side2;
		else
			throw new SideLengthSetIncorrectlyException();
	}

	public int getSide3() {
		return (int)side3;
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
	public String getArea() {
		double s = Double.parseDouble(this.getPerimeter()) / 2.0;
		return Decimal.work(Math.sqrt(s * (s - side1) * (s - side2) *(s - side3)));
	}
	
	@Override
	public String getPerimeter() { 
		return Decimal.work(side1 + side2 +side3);
	}
	
	public void writeToFile(File f) throws IOException{
		try(ObjectOutputStream output = new MyObjectOutputStream(
					new FileOutputStream(f,true))){		
			output.writeObject(this);
			output.close();
		}				
		catch (FileNotFoundException e) {
			System.out.println(e);
		} 
	}

	public int getID(){
		return 3;
	}
	
	@Override
	public String toString(){
		return "Triangle\nside1: " + side1 + " side2: " + side2 + " side3: " + side3 +
				"\ncolor: " + this.getColor() + 
				"\nfilled: " + this.isFilled() + 
				"\nlocation : " + getX() + " " +getY() ;
	}

	@Override
	public void setPoint(Point point) {
		this.point = point;
		
	}
	
	public int getX(){
		return point.x;
	}
	
	public int getY(){
		return point.y;
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