package version2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestGeometricObject2 {
	public static void main(String[] args){
		if(RandomCreateGeometricObject()){
			GeometricObject[] geometricObject = readGeometricObject();
			
			for(int i = 0; i < geometricObject.length; i++){
				System.out.println("-----------------------------------");
				System.out.println("Object" + (i + 1));
				System.out.println(geometricObject[i]);
				System.out.println("Perimeter is " + geometricObject[i].getPerimeter());
				System.out.println("Area is " + geometricObject[i].getArea());
				System.out.println();
			}
			while(geometricObject.length != 0){
				System.out.println(geometricObject.length);
				geometricObject = geometricObject[0].erase(geometricObject);
			}		
			System.out.println("All clean");	
		}	
		else{
			System.out.println("RandomCreateGeometricObject is Error");
			return;
		}
	}
	
	public static boolean RandomCreateGeometricObject(){
		try{
			ArrayList<GeometricObject> geometricObject = new ArrayList<>();
			File file = new File("GeometricObjects2.dat");
		
			if(file.length() == 0){
				ObjectOutputStream o = new ObjectOutputStream(
						new FileOutputStream(file));
				o.writeObject(new Triangle());
				o.close();
			}
			
			int size = (int)(Math.random() * 10) + 5;
			
			for(int i = 0; i < size; i++){
				if(Math.random() > 0.7){
					try {
						geometricObject.add(new Circle(Math.random() * 10));
					} 
					catch (NotACircleException e) {
						geometricObject.add(new Circle());
					}
		
				} 
				else if(Math.random() < 0.3){
					try {
						geometricObject.add(new Triangle(
								Math.random() * 10, Math.random() + 1, Math.random() + 2));
					} 
					catch (NotATriangleException e) {
						geometricObject.add(new Triangle());
					}
				}
				else{
					try {
						geometricObject.add(new Rectangle(
								Math.random() * 10, Math.random() * 10));
					} 
					catch (NotARectangleException e) {
						geometricObject.add(new Rectangle());
					}
				}
			}
		
			while(!geometricObject.isEmpty()){
				geometricObject.get(0).writeToFile(file);
				geometricObject.remove(0);
			}
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	public static GeometricObject[] readGeometricObject(){
		ArrayList<GeometricObject> o = new ArrayList<>();
		
		try(ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(new File("GeometricObjects2.dat")))){
			
			while(true){
				o.add((GeometricObject)input.readObject());
			}
		} 
		catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		catch (ClassNotFoundException ex){
			System.out.println(ex);
		}
		catch (IOException ex) {
		}
		
		GeometricObject[] geometricObject = 
				new GeometricObject[o.size()];//ArryList -> Array
		for(int i = 0; i < o.size(); i++)
			geometricObject[i] = o.get(i);
		
		return geometricObject;
	}
}
