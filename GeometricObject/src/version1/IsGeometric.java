package version1;

/**
 * 该类提供三种方法判断用户输入的数据是否能构成相应的几何图形
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
