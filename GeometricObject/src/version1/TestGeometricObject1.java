package version1;

import java.util.Random;

public class TestGeometricObject1{
	public static void main(String[] args){
		GeometricObject[] geometricObject = RandomCreateGeometricObject();
			
		for(int i = 0; i < geometricObject.length; i++){
			System.out.println("-----------------------------------");
			System.out.println("Object" + (i + 1));
			System.out.println(geometricObject[i]);
			System.out.println("Perimeter is " + geometricObject[i].getPerimeter());
			System.out.println("Area is " + geometricObject[i].getArea());
			System.out.println();
		}
		
		System.out.println(geometricObject[0].draw());
		while(geometricObject.length != 0)
			geometricObject = geometricObject[0].erase(geometricObject);
		
		System.out.println(geometricObject.length);
		System.out.println("...");	
	}
	
	public static GeometricObject[]  RandomCreateGeometricObject(){
		Random	random = new Random();	
		int size = (int)(random.nextDouble() * 20) + 5;
		GeometricObject[] geometricObject = new GeometricObject[size];	
		for(int i = 0; i <size; i ++){
			try{
				if(Math.random() > 0.5){
					geometricObject[i] = new Circle((random.nextDouble() - random.nextDouble()) * 100);
				}
				else{
					double side1 = random.nextDouble() * 100;
					double side2 = random.nextDouble() * 100;
					double side3 = random.nextDouble() * 100;
					
					geometricObject[i] = new Triangle(side1, side2, side3);
				}
			}
			catch(NotATriangleException ex){
				geometricObject[i] = new Triangle();
			}
			catch(NotACircleException ex){
				geometricObject[i] = new Circle();
			}
			catch(SideLengthSetIncorrectlyException ex){
				geometricObject[i] = new Triangle();
			}
			catch(RadiusLengthSetIncorrectlyException ex){
				geometricObject[i] = new Circle();
			}
			catch(Exception ex){
				System.out.println(ex);
			}
		}
		
		return geometricObject;
	}
}
