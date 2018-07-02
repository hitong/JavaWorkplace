package version3;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JPanel;

import version1.IsGeometric;
import version2.Decimal;

@SuppressWarnings("serial")
public class Circle extends JPanel implements GeometricObject,Serializable{
	private double radius = 1.0;
	final static double PI = 3.14;
	private Color color = Color.BLUE;
	private boolean filled = false;
	Point point = new Point();

	Circle(){
	}
	
	Circle(double radius, Color color, boolean filled) 
			throws NotACircleException {
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
	
	public int getX(){
		return point.x;
	}
	
	public int getY(){
		return point.y;
	}
	
	public void setPoint(Point point){
		this.point = point;
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

	public int getSide1() {
		return (int)radius;
	}
	
	public int getSide2(){
		return -1;
	}
	
	public int getSide3(){
		return -1;
	}
	
	public void setRadius(double radius) 
			throws RadiusLengthSetIncorrectlyException{
		radius = (int)(radius * 100) / 100.0;
		if(IsGeometric.work(radius))
			this.radius = radius;
		else
			throw new RadiusLengthSetIncorrectlyException();
	}

	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
		/**将处理结果保存到文件中*/
	}
	
	@Override
	public String getArea() {
		return Decimal.work(PI * radius * radius);
	}
	@Override
	public String getPerimeter() {
		return Decimal.work(radius * 2 * PI);
	}
	
	public void writeToFile(File f) throws IOException{
		try (ObjectOutputStream output = new MyObjectOutputStream(
					new FileOutputStream(f,true))){		
			output.writeObject(this);
			output.close();
		}	
		catch (FileNotFoundException e) {
			System.out.println(e);
		} 
	}
		
	public String toString(){
		return "Circle\nradius: " + radius +
				"\ncolor: " + this.getColor() + 
				"\nfilled: " + this.isFilled() + 
				"\nlocation: " + getX() + " " + getY() ;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
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