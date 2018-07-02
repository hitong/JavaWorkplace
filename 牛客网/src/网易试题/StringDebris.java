package 网易试题;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 一个由小写字母组成的字符串可以看成一些
 * 同一字母的最大碎片组成的。例如,"aaabbaaac"
 * 是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定
 * 一个字符串,请你帮助计算这个字符串的所有碎片的
 * 平均长度是多少。
 * @author Supertong
 *
 */
public class StringDebris {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		DecimalFormat df = new DecimalFormat("#.00");  
		if(s.length() == 0){
			System.out.println("0.00");
		}
		int m = 1;
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) != s.charAt(i - 1)){
				m++;
			}
		}
		
		System.out.println(df.format(s.length() / (m * 1.0)));
		input.close();
	}
}
