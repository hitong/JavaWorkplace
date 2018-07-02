//package Test;
//
//import java.util.Scanner;
//
//public class TestArr {
//	final static String[] answer = { 
//			"BCABDACDABACDCBBADCA",
//			"CBADBDADACBDACBBCADC", 
//			"AAABCCAAABAADACAAAAA", 
//			"DAACBDBABDADCDDCBCAD",
//			"DCBABCDCBABCDCBAACBD",
//			"DCDABBCACAADACABBCDC",
//			"BABDBCCCDDBABCCACBBD", 
//			"CBCDABDBABCBBCCCABDC"
//	};
//
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.print("套数：");
//		int i = 0;
//		i = input.nextInt() - 1;
//		int err = 0;
//		String s = input.next();
//		for (int j = 0; j < 20; j++) {
//			if (s.charAt(j) != answer[i].charAt(j)) {
//				System.out.println("第" + (j + 1) + "个" + "  正确答案是" + answer[i].charAt(j) + 
//						"  你的选择是:" + s.charAt(j) );
//				err++;
//			}
//		}
//		if(err == 0) {
//			System.out.println("Wonderful!!!");
//		}
//		else {
//			System.out.println("The number of falses is " + err);			
//		}
//		input.close();
//	}
//}