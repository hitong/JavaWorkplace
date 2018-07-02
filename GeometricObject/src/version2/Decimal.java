package version2;

import java.text.NumberFormat;

/**
 * 
 * @author Sun
 *该类提供用于将数字格式化输出（两位小数）
 */
public final class Decimal {
	public static String work(double number){
		NumberFormat nf = NumberFormat.getNumberInstance();  
	    nf.setMaximumFractionDigits(2);  
		return nf.format(number);
	}
}
