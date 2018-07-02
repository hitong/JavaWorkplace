package version3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * 用于图形信息读入
 * @author Sun
 *
 */
public class ReadGeometricObject {
	public static ArrayList<version3.GeometricObject> readGeometricObject(){
		ArrayList<version3.GeometricObject> o = new ArrayList<>();	
		try(ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(new File("GeometricObjects.dat")))){		
			while(true){
				o.add((version3.GeometricObject)input.readObject());
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
		return o;
	}
	
	
}
