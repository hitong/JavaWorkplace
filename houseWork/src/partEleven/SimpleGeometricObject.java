package partEleven;

import java.util.*;

public class SimpleGeometricObject {
	private String color = "write";
	private boolean filled;
	private java.util.Date dateCreated;
	
	SimpleGeometricObject(){
		
	}
	
	public SimpleGeometricObject(String color, boolean filled){
		dateCreated = new java.util.Date();
		
	}
	
	public String color(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		return filled;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
	}
	
	public boolean getFilled(){
		return filled;
	}
	
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	public String toString(){
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
}

class Triangle extends SimpleGeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){	
	}
	
	public Triangle(double side1, double side2, double side3)
		throws IllegalTriangleException {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;		
		if(!isTriangle())
			 throw new IllegalTriangleException();
	}

	private boolean isTriangle(){
		if(side1 <= 0 || side3 <= 0 || side2 <= 0 ||
				(side1 + side2 <= side3) || 
				(side1 + side3 <= side2) ||
				(side2 + side3 <= side1))
			return false;
		else 
			return true;
	}
	
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}
	
	public double getArea(){
		double s = (side1 + side2 +side3) / 2.0;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	
	public String toString(){
		return "Triangle: sidel = " + " side1 = " + side1 +
				" side2 = "  + side2 + " side3 = " + side3;
	}
	
}

class IllegalTriangleException extends Exception{

	IllegalTriangleException(){	
	}
	
	public String toString(){
		return "it is not a Triangle";
	}
}


class CircleFromSimpleGeometricObject 
			extends SimpleGeometricObject{
	
	private double radius;
	
	public CircleFromSimpleGeometricObject(){
		
	}
	
	public CircleFromSimpleGeometricObject(double radius){
		this.radius = radius;
	}
	
	public CircleFromSimpleGeometricObject(double radius, 
			String color, boolean filled){
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	
	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea(){
		return radius * radius * Math.PI;
	}
	
	public double getDiametet(){
		return 2 * radius;	
		
	}
	
	public double getPerimeter(){
		return 2 * radius * Math.PI;
	}
	
	public void printCirle(){
		System.out.println("The circle is created " + getDateCreated() + 
				" and the radius is " + radius);
	}
}
 