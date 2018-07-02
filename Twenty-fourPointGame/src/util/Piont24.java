//package util;
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Piont24 {
//	static int[] arr; // 存放4个数
//	static int[] op; // 标记计算 优先级。+-用1表示—*/用2表示
//
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		Set<String> set = new HashSet<>();
//		String t = input.nextLine();
//		while(t.length() != 1) {
//			set.add(t);
//			t = input.nextLine();
//		}
//		System.out.println(set.size());
//		input.close();
//	}
//
//	/**
//	 * 得到所有数的排列组合,即得到24种不同的数字序列(不考虑相同数字处理)
//	 * 双括号问题!!
//	 * 
//	 * @param t
//	 */
//	public static void getOrder(int t) {
//		if (t >= arr.length) {
//			computer(0, 0, "");
//			return;
//		}
//		for (int i = t; i < arr.length; i++) {
//			ch(i, t);
//			getOrder(t + 1);
//			ch(i, t);
//		}//组合遍历和恢复
//	}
//
//	/**
//	 * 第i个数与第j个数交换
//	 * 
//	 * @param i
//	 * @param j
//	 */
//	public static void ch(int i, int j) {
//		int t = 0;
//		t = arr[i];
//		arr[i] = arr[j];
//		arr[j] = t;
//	}
//
//	/**
//	 * 每次都从0,0,""开始,但是数组中的元素位置每次都不一样,所以在此函数
//	 * 的计算中,不需要在做数字交换操作
//	 * 
//	 * @param t
//	 *            表示第t个数
//	 * @param num
//	 *            计算的当前值
//	 * @param s
//	 *            当前的表达式
//	 */
//	public static void computer(int t, int num, String s) {
//		if (t == 4) {//遍历完所有表达式
//			if (num == 24 && isOk(s)) {
//				System.out.println(s);
//			}
//			return;
//		}
//		if (t == 0) {//只能取到第一个数
//			computer(t + 1, num + arr[t], String.valueOf(arr[0]));
//			return;
//		}
//		for (int i = 0; i < 4; i++) {//遍历四种运算情况
//			if (i == 0) {
//				op[t - 1] = 1;
//				computer(t + 1, num + arr[t], s + "+" + String.valueOf(arr[t]));
//			}
//			if (i == 1) {
//				op[t - 1] = 1;
//				computer(t + 1, num - arr[t], s + "-" + String.valueOf(arr[t]));
//			}
//			if (i == 2) {
//				op[t - 1] = 2;
//				computer(t + 1, num * arr[t], s + "*" + String.valueOf(arr[t]));
//			}
//			if (i == 3) {
//				op[t - 1] = 2;
//				if (num % arr[t] == 0) {
//					try {
//						computer(t + 1, num / arr[t], s + "/" + String.valueOf(arr[t]));
//					}
//					catch(ArithmeticException ex) {
//						return;
//					}
//				} else {
//					return;
//				}
//			}
//		}
//	}
//	
//	public void doubliebrackets() {
//	}
//
//	/**
//	 * 根据op标记的优先级判断是否加括号
//	 * 
//	 * @param s
//	 * @return 加输出加括号的表达式返回false，不加返回true
//	 */
//	public static boolean isOk(String s) {
//		int t = 0;
//		if (op[0] == 1 && op[1] == 1 && op[2] == 2 || op[0] == 2 && op[1] == 1 && op[2] == 2) {
//			t = s.lastIndexOf("*") > s.lastIndexOf("/") ? s.lastIndexOf("*") : s.lastIndexOf("/");
//			System.out.println("(" + s.substring(0, t) + ")" + s.substring(t));
//			return false;
//		} else if (op[0] == 1 && op[1] == 2) {
//			t = s.indexOf("*") > s.indexOf("/") ? s.indexOf("*") : s.indexOf("/");
//			System.out.println("(" + s.substring(0, t) + ")" + s.substring(t));
//			return false;
//		}
//		return true;
//	}
//}