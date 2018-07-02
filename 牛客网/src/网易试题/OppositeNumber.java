package 网易试题;

import java.util.Scanner;

/**
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒
 * ,然后再加上原先的数得到"相反数"。例如,为了得到1325
 * 的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231
 * ,之后再加上原先的数,我们得到5231+1325=6556.如果颠
 * 倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 
 * 颠倒之后是1. 
 * @author Supertong
 *
 */
public class OppositeNumber {
	public  static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int last = input.nextInt();
		int tmp = last;
		int now = 0;
		while(last != 0){
			now = now * 10 + last % 10;
			last = last / 10;
		}
		System.out.println(now + tmp);
		input.close();
	}
}
