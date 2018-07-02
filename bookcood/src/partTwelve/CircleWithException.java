package partTwelve;

public class CircleWithException {
	private double radius;
	
	public static int numberOfObject = 0;
	
	public CircleWithException(){
		this(1.0);
	}
	
	public CircleWithException(double raidus){
		this.setRadius(radius);
		numberOfObject++;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) 
		throws IllegalArgumentException{
		if(radius >= 0)
			this.radius = radius;
		else{
			throw new IllegalArgumentException(
					"Radius cannot be negative");
		}

	}

	public static int getNumberOfObject() {
		return numberOfObject;
	}
	
	public double findArea(){
		return radius * radius * 3.14159;
	}
}
