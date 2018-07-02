package version2;

import java.io.File;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

public class SaveAllObject {
	public static GeometricObject[] work(GeometricObject[] geometricObject){
		try(ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(new File("GeometricObjects.dat"), false))){
			for(int i = 0; i < geometricObject.length; i++){
				output.writeObject(geometricObject[i]);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}		
		return geometricObject;
	}
}
