package version1;

/**
 * �����ṩ���ַ����ж��û�����������Ƿ��ܹ�����Ӧ�ļ���ͼ��
 * 
 **/
public class IsGeometric {
	public static boolean work(double side1){
			return side1 > 0;
	}
	
	public static boolean work(double side1, double side2){
		return side1 > 0 && side2 > 0;
	}
	
	public static boolean work(double side1, double side2, double side3){
		return (side1 + side2 > side3) && 
				(side1 + side3 > side2) && 
				(side2 + side3 > side1) &&
				side1 > 0 && side2 > 0 && side3 > 0;
	}
}
