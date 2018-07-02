package version3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import version3.GeometricObject;

/**
 * �����ṩ��������������������ArrayListд�뵽ָ����GeometricObject�ļ��У�ͬʱ�������飬����ArrayList
 * @author Sun
 *
 */
public class SaveAllObject {
	/**
	 * �÷�������������󣬽��䱣�����ļ��У������ظ��������
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
	 * �÷�������ArrayList���󣬽��䱣�����ļ��У������ظ�ArrayList����
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
