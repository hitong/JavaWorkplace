package version2;

import java.text.NumberFormat;

/**
 * 
 * @author Sun
 *�����ṩ���ڽ����ָ�ʽ���������λС����
 */
public final class Decimal {
	public static String work(double number){
		NumberFormat nf = NumberFormat.getNumberInstance();  
	    nf.setMaximumFractionDigits(2);  
		return nf.format(number);
	}
}
