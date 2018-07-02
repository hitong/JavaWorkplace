package version3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import version3.GeometricObject;

/**
 * 该类提供方法，将传入的数组或者ArrayList写入到指定的GeometricObject文件中，同时返回数组，或者ArrayList
 * @author Sun
 *
 */
public class SaveAllObject {
	/**
	 * 该方法接收数组对象，将其保存至文件中，并返回该数组对象
	 * @param geometricObject
	 * @return
	 */
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
	
	/**
	 * 该方法接收ArrayList对象，将其保存至文件中，并返回该ArrayList对象
	 * @param geometricObject
	 * @return
	 */
	public static ArrayList<GeometricObject> work(ArrayList<GeometricObject> geometricObject){
		try(ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(new File("GeometricObjects.dat"), false))){
			for(int i = 0; i < geometricObject.size(); i++){
				output.writeObject(geometricObject.get(i));
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}		
		return geometricObject;
	}
}
