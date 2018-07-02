package partThirteen;

abstract class NewGeometricObject implements Comparable<NewGeometricObject>{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected NewGeometricObject(){
		dateCreated = new java.util.Date();
	}
	
	protected NewGeometricObject(String color, boolean filled){
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
	
	public int compareTo(NewGeometricObject o){
		if(this.getArea() >=o.getArea())
			return 1;
		else if(this.getArea() == ((NewGeometricObject)o).getArea())
			return 0;
		else
			return -1;
	}
	
	public static Object getMax(Object o1, Object o2){		
		if(((NewGeometricObject)o1).getArea() >= 
				((NewGeometricObject)o2).getArea())
			return o1;
		else
			return o2;
	}
	
	abstract public String toString();
	
}

class Circle extends NewGeometricObject{
	private double side;
	
	Circle(){
		this.side = 1;
	}
	
	
	Circle(double side){
		this.side = side;
	}
	
	public double getArea(){
		return side * side * Math.PI;
	}
	
	public double getPerimeter(){
		return 2 * side * Math.PI;
	}	
	
	public String toString(){
		return "The cirlce's side is " + side;
	}


}

class Retangle extends NewGeometricObject{
	private double width;
	private double hight;
	
	
	Retangle(){
		this.width = 1;
		this.hight = 1;
	}
	
	
	Retangle(double side1, double side2){
		this.width = side1;
		this.hight = side2;
		
	}
	
	public double getArea(){
		return width * hight;
	}
	
	public double getPerimeter(){
		return width + hight;
	}
	
	public String toString(){
		return "The width is " + width + "   the hight is " + hight;
	}
}