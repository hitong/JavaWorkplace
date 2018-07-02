package partThirteen;

import partEleven.GeometricObject;

import java.util.*;

public class Exercise13point7 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ArrayList<GeometricObject> list = new ArrayList<>();
		for(int i = 0; i < 5; i++  ){
			System.out.println("Input first square's length:");		
			list.add(new Square(input.nextDouble()));
		}
		
		
		for(int i = 0; i < 5; i++){
			if((Colorable)(list.get(i)) != null)
				((Colorable)(list.get(i))).howToColor();
		}
	}

	
}

interface Colorable{
	void howToColor();
}

class Square extends GeometricObject implements Colorable{
	private double side;
	
	Square(){
		side = 1;
	}
	
	Square(double side){
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public void howToColor(){
		System.out.println("Color all four sides"); 
	}
  
	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}
	
}