package version2;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fan2 extends JPanel{
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	final static int FAST = 3;
	Color[] myColor = {
			Color.red, Color.blue, Color.yellow, Color.green, Color.orange
	};
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 1.0;
	private Color color = Color.red;
	
	Fan2(){	
		int choice1 = (int)(Math.random() * 10) % 5 + 1;
		int choice2 = (int)(Math.random() * 10) % 5 + 1;
		
		try{
			this.setRadius(choice1);
			this.setColor(myColor[choice2]);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

	
	Fan2(int speed, boolean on, double radius, Color color)
		throws Exception{
			this.setSpeed(speed);
			this.setOn(on);
			this.setRadius(radius);
			this.setColor(color);
		
	}
	
	@SuppressWarnings("deprecation")
	protected void paintComponent(Graphics g){ 
		super.paintComponent(g);	
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)this.getRadius() * 30 + 100;	
		int x = xCenter - (radius + 30) / 2;
		int y = yCenter - (radius + 30) / 2;
		int x1 = xCenter - radius / 2;
		int y1 = yCenter - radius / 2;	
		g.setColor(this.getColor());
		int n = new Date().getSeconds() * 10000;
		g.fillArc(x1, y1,  radius,  radius, 0 + n, 30);
		g.fillArc(x1, y1,  radius,  radius, 90 + n, 30);
		g.fillArc(x1, y1,  radius,  radius, 180 + n, 30);
		g.fillArc(x1, y1,  radius,  radius, 270 + n, 30);
		g.setColor(Color.BLACK);
		g.drawArc(x, y ,radius + 30, radius + 30, 0, -360);		
	}
	
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) throws SpeedExceedingLimitException{
		if(speed > 0 && speed < 4)
			this.speed = speed;
		else
			throw new SpeedExceedingLimitException();
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) throws RadiusExceedingLimitException{
		if(radius > 0)
			this.radius = radius;
		else
			throw new RadiusExceedingLimitException();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	@Override
	public boolean equals(Object obj){
	    return this.speed == ((Fan2)obj).getSpeed();
	}
	
	
	@Override
	public String toString(){
		return "Speed:"	 + speed + "\n" + 
				"On:"	 + on+ "\n" + 
				"Radius:"	 + radius + "\n" + 
				"Color:"	 + color ;
	}
	
}

@SuppressWarnings("serial")
class SpeedExceedingLimitException extends Exception{
	public String toString(){
		return "Speed should be in 1 to 3";
	}
}

@SuppressWarnings("serial")
class RadiusExceedingLimitException extends Exception{
	public String toString(){
		return "Radius should biger than 0";
	}
}