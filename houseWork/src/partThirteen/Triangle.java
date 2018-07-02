package partThirteen;


abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject(){
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled){
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	abstract double getArea();
	
	abstract double getPerimeter();
	
	public String toString(){
		return "created on " + dateCreated + "\ncolor is " + color + 
				"\nfilled is " + filled + 
				"\n area is " + this.getArea() + 
				"\n perimeter is " + this.getPerimeter(); 
	}
	
}

public class Triangle extends GeometricObject{
	private double side1;
	private double side2;
	private double side3;
	
	Triangle(){
		this.side1 = 1;
		this.side2 = 1;
		this.side3 = 1;
	}
	
	
	Triangle(double side1, double side2, double side3 ,
			String color, boolean filled){
		super(color , filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getArea(){
		double s = (side1 + side2 + side3) / 2.0;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
}


