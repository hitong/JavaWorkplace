package version1;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Date;

public abstract class GeometricObject{
	private Color color;
	private boolean filled;
	private Date dateCreated;
	
	GeometricObject(){
		this.dateCreated = new Date();
		this.color = Color.BLUE;
		this.filled = false;
	}
	
	GeometricObject(Color color, boolean filled){
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();	
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

	abstract String draw();
	
	abstract GeometricObject[] erase(GeometricObject[] geometricObject);
	
	abstract String getArea();
	
	abstract String getPerimeter();
	
	public static String decimal(double number){
		NumberFormat nf = NumberFormat.getNumberInstance();  
	    nf.setMaximumFractionDigits(2);  
		return nf.format(number);
	}

	public String toString(){
		return "Color: " + color + "\n" +
				"Filled: " + filled + "\n" +
				"Created Date: " + dateCreated + "\n";
	}
	
}
