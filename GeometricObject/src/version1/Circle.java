package version1;

import java.awt.Color;

public class Circle extends GeometricObject{
	private double radius;
	final static double PI = 3.14;

	Circle(){
		this.radius = 1.0;
		super.setColor(Color.BLUE);
	}
	
	Circle(double radius) throws Exception {	
		radius = (int)(radius * 100) / 100.0;
		this.setRadius(radius);		
		super.setColor(Color.BLUE);
	}
	
	Circle(double radius, Color color) throws Exception {
		radius = (int)(radius * 100) / 100.0;
		this.setRadius(radius);
		super.setColor(color);
	}
	
	Circle(double radius, boolean filled) throws Exception {
		radius = (int)(radius * 100) / 100.0;
		this.setRadius(radius);
		super.setFilled(filled);
	}
	
	Circle(double radius,Color color, boolean filled) 
				throws NotACircleException, Exception {
		super(color,filled);
		
		radius = (int)(radius * 100) / 100.0;
		this.setRadius(radius);
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
	String draw() {
		return "Take one point as the point,"
				+ "a line with a length of " + radius  
				+ " is plotted as a radius";
		
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
		return super.decimal(PI * radius * radius);
	}
	
	@Override
	String getPerimeter() {
		return super.decimal(radius * 2 * PI);
	}
		
	public String toString(){
		return "Circle\nradius: " + radius +
				"\ncolor: " + super.getColor() + 
				"\nfilled: " + super.isFilled() + 
				"\ncreated date: " + super.getDateCreated() ;
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