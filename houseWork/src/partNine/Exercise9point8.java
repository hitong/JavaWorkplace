package partNine;

public class Exercise9point8 {
	public static void main(String[] args){
		Fan one = new Fan(3, 10, "yellow" , true);
		Fan two = new Fan();
		two.setColor("blue");
		two.setOn(false);
		two.setSpeed(2);
		System.out.println(one.toString());
		System.out.println(two.toString());
	}
}


class Fan{
	final static int FAST = 3;
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	private int speed = SLOW;
	private boolean on;
	
	Fan(){
	}
	
	Fan(int speed, double radius, String color, boolean on){
		this.speed = speed;
		this.radius = radius;
		this.color = color;
		this.on = on;
	}
	
	
	private double radius = 5;
	String color = "blue" ;
	int getSpeed(){
		return speed;
	}
	void setSpeed(int speed){
		this.speed = speed;
	}
	
	boolean getOn(){
		return on;
	}
	
	void setOn(boolean on){
		this.on = on;
	}
	
	String getColor(){
		return color;
	}
	
	void setColor(String color){
		this.color = color;
	}
	
	double getRadius(){
		return radius;
	}
	
	void setRadius(double radius){
		this.radius = radius;
	}
	
	public String toString(){
		if(on)
		   return ("fan is on, speed is " + speed
		   		+ ", color is " + color + 
					", radius is " + radius);
		else 
			return ("fan is off, color is " + color + 
					", radius is " + radius);
	}
}