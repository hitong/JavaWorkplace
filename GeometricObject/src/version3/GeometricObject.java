package version3;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

public interface GeometricObject extends Cloneable{
	/**
	 * 
	 */
	int Circle = 1;
	int Rectangle = 2;
	int Triangle = 3;
	double PI = 3.14;
	
	Object clone();
	boolean isFilled();
	int getSide1();
	int getSide2();
	int getSide3();
	Color getColor();
	
	/**
	 * 该方法用于清除图形
	 * @param geometricObject
	 * @return
	 */
	GeometricObject[] erase(GeometricObject[] geometricObject);
	
	/**
	 * 该方法用于获取相应图形的面积
	 * @return
	 */
	String getArea();
	
	/**
	 * 该方法用于获取相应图形周长
	 * @return
	 */
	String getPerimeter();
	
	/**
	 * 将该对象写入传入的文件中
	 * @param file
	 * @throws IOException
	 */
	void writeToFile(File file) throws IOException;
	
	
	/**
	 * 该方法用于获取图形ID，便于识别图形信息
	 * @return
	 */
	int getID();
	
	/**
	 * 用于获取图形的x轴坐标
	 * @return
	 */
	int getX();
	
	/**
	 * 用于获取图形的Y轴坐标
	 * @return
	 */
	int getY();
	
	/**
	 * 该方法通过接收鼠标图形的坐标信息，进而更改具体到每个具体的图形坐标
	 * @param p
	 */
	void setPoint(Point p);
}
