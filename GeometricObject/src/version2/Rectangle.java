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
public class Rectangle implements GeometricObject,Serializable{
	private double side1 = 1.0;
	private double side2 = 1.0;
	static Decimal decimal = new Decimal();
	private Color color = Color.BLUE;
	private boolean filled = false;
	private Date dateCreated;
	
	Rectangle(){
		this.dateCreated = new Date();
	}
	
	Rectangle(double side1, double side2) throws NotARectangleException {
		this.dateCreated = new Date();
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		try{
			this.setAllSide(side1, side2);
		}
		catch(RectangleRadiusLengthSetIncorrectlyException ex){	
			throw new NotARectangleException();
		}
	}
	
	Rectangle(double side1, double side2, Color color, boolean filled) 
			throws NotARectangleException {
		this.dateCreated = new Date();	
		
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		
		try{
			this.setAllSide(side1, side2);
		}
		catch(RectangleRadiusLengthSetIncorrectlyException ex){	
			throw new NotARectangleException();
		}
		
		this.setColor(color);
		this.setFilled(filled);
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) 
			throws RectangleRadiusLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		if(IsGeometric.work(side1, side2)){
			this.side1 = side1;
		}
		else
			throw new RectangleRadiusLengthSetIncorrectlyException();
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) 
			throws RectangleRadiusLengthSetIncorrectlyException{
		side2 = (int)(side2 * 100) / 100.0;
		if(IsGeometric.work(side1, side2)){
			this.side2 = side2;
		}
		else
			throw new RectangleRadiusLengthSetIncorrectlyException();
	}
	
	public void setAllSide(double side1, double side2) 
			throws RectangleRadiusLengthSetIncorrectlyException{
		side1 = (int)(side1 * 100) / 100.0;
		side2 = (int)(side2 * 100) / 100.0;
		if(IsGeometric.work(side1, side2)){
			this.side1 = side1;
			this.side2 = side2;
		}
		else
			throw new RectangleRadiusLengthSetIncorrectlyException();
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
		return "Draw a rectangle";
		
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
		
		return SaveAllObject.work(g);
	}
	
	@Override
	public String getArea() {
		return Decimal.work(side1 * side2);
	}
	@Override
	public String getPerimeter() {
		return Decimal.work((side1 + side2) * 2);
	}
	
	public void writeToFile(File f) throws IOException{
		try (ObjectOutputStream output = new MyObjectOutputStream(
					new FileOutputStream(f,true))){		
			output.writeObject(this);
		}	
		catch (FileNotFoundException e) {
			System.out.println(e);
		} 
	}
		
	public String toString(){
		return "Rectangle\nside1: " + side1 + " side2:" + side2 +
				"\ncolor: " + this.getColor() + 
				"\nfilled: " + this.isFilled() + 
				"\ncreated date: " + this.getDateCreated() ;
	}
}

@SuppressWarnings("serial")
class NotARectangleException extends Exception{
	public String toString(){
		return "The circle's radius should biger than 0";
	}
}
 
@SuppressWarnings("serial")
class RectangleRadiusLengthSetIncorrectlyException extends Exception{
	public String toString(){
		return "use the new radius can not be a Rectangle";
	}
}
