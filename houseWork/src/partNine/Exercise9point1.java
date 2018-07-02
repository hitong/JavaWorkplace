package partNine;


public class Exercise9point1 {
	public static void main(String[] args){
		Rectangle firstRectangle = new Rectangle(4,40);
		System.out.println("The first rectangle's width, height, area and perimeter is " +
				firstRectangle.width + "  " +
				firstRectangle.height + "  " + 
				firstRectangle.getArea() + "  " +
				firstRectangle.getPerimeter());
				
		
	Rectangle secondRectangle = new Rectangle(3.5, 35.9);
	System.out.println("The second rectangle's width, height, area and perimeter is " +
			secondRectangle.width +"  " + 
			secondRectangle.height +"  " + 
			secondRectangle.getArea() +"  " +
			secondRectangle.getPerimeter());
		
	}
}
	

class Rectangle{
	double width = 1;
	double height = 1;
	
	Rectangle(){	
	}
	
	Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	double getArea(){
		return width * height;
	}	
	
	double getPerimeter(){
		return width + width + height + height;
	}
}

