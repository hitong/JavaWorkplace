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
public class Circle implements GeometricObject,Serializable{
	private double radius = 1.0;
	final static double PI = 3.14;
	static Decimal decimal = new Decimal();
	private Color color = Color.BLUE;
	private boolean filled = false;
	private Date dateCreated;
	
	Circle(){
		this.dateCreated = new Date();
	}
	
	Circle(double radius) throws NotACircleException {
		this.dateCreated = new Date();
		radius = (int)(radius * 100) / 100.0;
		try{
			this.setRadius(radius);
		}
		catch(RadiusLengthSetIncorrectlyException ex){
			throw new NotACircleException();
		}
	}
	
	Circle(double radius,boolean filled) throws Exception {
		this.dateCreated = new Date();
		radius = (int)(radius * 100) / 100.0;
		try{
			this.setRadius(radius);
		}
		catch(RadiusLengthSetIncorrectlyException ex){
			throw new NotACircleException();
		}
		this.setFilled(filled);
	}
	
	Circle(double radius, Color color, boolean filled) 
			throws Exception {
		this.dateCreated = new Date();
		radius = (int)(radius * 100) / 100.0;
		try{
			this.setRadius(radius);
		}
		catch(RadiusLengthSetIncorrectlyException ex){
			throw new NotACircleException();
		}
		this.setFilled(filled);
		this.setColor(color);
	}
	
	Circle(double radius, Color color) 
			throws Exception {
		this.dateCreated = new Date();
		radius = (int)(radius * 100) / 100.0;
		try{
			this.setRadius(radius);
		}
		catch(RadiusLengthSetIncorrectlyException ex){
			throw new NotACircleException();
		}
		this.setColor(color);
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

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) 
			throws RadiusLengthSetIncorrectlyException{
		radius = (int)(radius * 100) / 100.0;
		if(IsGeometric.work(radius))
			this.radius = radius;
		else
			throw new RadiusLengthSetIncorrectlyException();
	}

	@Override
	public String draw() {
		return "Take one point as the point,"
				+ "a line with a length of " + radius  
				+ " is plotted as a radius";
		
	}
	@SuppressWarnings("static-access")
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
		
		return new SaveAllObject().work(g);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public String getArea() {
		return decimal.work(PI * radius * radius);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public String getPerimeter() {
		return decimal.work(radius * 2 * PI);
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
		return "Circle\nradius: " + radius +
				"\ncolor: " + this.getColor() + 
				"\nfilled: " + this.isFilled() + 
				"\ncreated date: " + this.getDateCreated() ;
	}
	
}

@SuppressWarnings("serial")
class NotACircleException extends Exception{
	public String toString(){
		return "The circle's radius should biger than 0";
	}
}
 
@SuppressWarnings("serial")
class RadiusLengthSetIncorrectlyException extends Exception{
	public String toString(){
		return "use the new radius can not be a Circle";
	}
}