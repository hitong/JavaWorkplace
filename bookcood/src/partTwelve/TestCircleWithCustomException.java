package partTwelve;


public class TestCircleWithCustomException {
	public static void main(String[] args){
		try{
			new CircleWithCustomException(5);
			new CircleWithCustomException(-5);
			new CircleWithCustomException(0);
			
		}
		catch(InvalidRadiusException ex){
			System.out.println(ex);
		}
		
		System.out.println("Number of objects created: " +
				CircleWithCustomException.getNumberOfObjects());
		
	}
}



/**
public class TestCircleWithCustomException {
	public static void main(String[] args){
		try{
			method();
			System.out.println("After the method call");
		}
		catch(RuntimeException ex){
			System.out.println("RuntimeException in main");
			
		}
		catch(Exception ex){
			System.out.println("Exception in main");
		}
		
	}
	
	static void method() throws Exception{
		try{
			CircleWithCustomException c1 = new CircleWithCustomException(1);
			c1.setRadius(-1);
			System.out.println(c1.getRadius());
		}
		catch(RuntimeException ex){
			System.out.println("RuntimeException in method()");
			throw ex;
		}
		catch(Exception ex){
			System.out.println("Exception in method()");
			throw ex;
		}
	}
	
}
**    ��ϰ��12. 26      ***/


class CircleWithCustomException{
	private double radius;
	
	private static int numberOfObjects = 0;
	
	public CircleWithCustomException() throws InvalidRadiusException{
		this(1.0);		
	}
	
	public CircleWithCustomException(double radius) throws InvalidRadiusException{
		setRadius(radius);	
		numberOfObjects++;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius)  
			throws InvalidRadiusException{
		if(radius >= 0)
			this.radius = radius;
		else
			throw new InvalidRadiusException(radius);
	}

	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
	
	public double findArea(){
		return radius* radius * 3.14159;
	}
}

@SuppressWarnings("serial")
class InvalidRadiusException extends Exception{
	private double radius;
	
	public InvalidRadiusException(double radius){
		super("Invalid radius" + radius);
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
}