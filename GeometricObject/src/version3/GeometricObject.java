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
	 * �÷����������ͼ��
	 * @param geometricObject
	 * @return
	 */
	GeometricObject[] erase(GeometricObject[] geometricObject);
	
	/**
	 * �÷������ڻ�ȡ��Ӧͼ�ε����
	 * @return
	 */
	String getArea();
	
	/**
	 * �÷������ڻ�ȡ��Ӧͼ���ܳ�
	 * @return
	 */
	String getPerimeter();
	
	/**
	 * ���ö���д�봫����ļ���
	 * @param file
	 * @throws IOException
	 */
	void writeToFile(File file) throws IOException;
	
	
	/**
	 * �÷������ڻ�ȡͼ��ID������ʶ��ͼ����Ϣ
	 * @return
	 */
	int getID();
	
	/**
	 * ���ڻ�ȡͼ�ε�x������
	 * @return
	 */
	int getX();
	
	/**
	 * ���ڻ�ȡͼ�ε�Y������
	 * @return
	 */
	int getY();
	
	/**
	 * �÷���ͨ���������ͼ�ε�������Ϣ���������ľ��嵽ÿ�������ͼ������
	 * @param p
	 */
	void setPoint(Point p);
}
