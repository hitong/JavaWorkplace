package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InfixTurnSuffix {

	/**
	 * 将数字与操作符分割（在此方法中，非法字符不做处理）
	 * 
	 * @param s
	 * @return
	 */
	public static ArrayList<String> split(String s) {
		ArrayList<String> tmp = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				if (tmp.size() == 0) {
					tmp.add(ch + "");
				} else {
					if ((tmp.get(tmp.size() - 1).charAt(0) >= '0' && tmp.get(tmp.size() - 1).charAt(0) <= '9')) {
						tmp.set(tmp.size() - 1, tmp.get(tmp.size() - 1) + ch);
					} else {
						tmp.add(ch + "");
					}
				}
			} else {
				tmp.add(ch + "");
			}
		}
		return tmp;
	}

	/**
	 * 将一个中缀表达式转成存储后缀表达式的链表，如果方法中存在非法字符，将抛出异常
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<String> infixTurnSuffix(String s) throws InputMismatchException {
		ArrayList<String> tmp = split(s);
		Stack<Character> op = new Stack<>();
		LinkedList<String> later = new LinkedList<>();
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).charAt(0) == ' ') {
				continue;
			}
			if (tmp.get(i).charAt(0) >= '0' && tmp.get(i).charAt(0) <= '9') {
				later.add(tmp.get(i));
			} else {
				char c = tmp.get(i).charAt(0);
				if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')' && c != '（' && c != '）') {
					System.out.println(c);
					throw new InputMismatchException();
				}
				if (op.size() == 0) {
					op.push(c);
				} else if (c == '(' || c == '（') {
					op.push(c);
				} else if (c == ')' || c == '）') {
					while (op.peek() != '(' && op.peek() != '（') {
						later.add(op.pop() + "");
					}
					op.pop();
				} else {
					if (!IsOperator(c)) {
						throw new InputMismatchException();
					} else {
						while (!op.empty() && Precedence(op.peek(), c) >= 0) {
							later.add(op.pop() + "");
						}
						op.push(c);
					}
				}
			}
		}
		while (!op.empty()) {
			if (op.peek() == '(' || op.peek() == '（') {
				throw new InputMismatchException();
			}
			later.add(op.pop() + "");
		}
		return later;
	}

	/**
	 * 判读符号是否是操作符
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean IsOperator(char ch) {
		char[] ops = { '+', '-', '*', '/' };
		for (int i = 0; i < ops.length; i++) {
			if (ch == ops[i])
				return true;
		}
		return false;
	}

	/**
	 * 比较相邻操作符的优先级
	 * 
	 * @param op1
	 * @param op2
	 * @return
	 */
	public static int Precedence(char op1, char op2) {
		if (op1 == '(' || op1 == '（') {
			return -1;
		}

		if (op1 == '+' || op1 == '-') {
			if (op2 == '*' || op2 == '/') {
				return -1;
			} else {
				return 0;
			}
		}

		if (op1 == '*' || op1 == '/') {
			if (op2 == '+' || op2 == '-') {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public static boolean compute(String s, int[] pick) throws InputMismatchException {
		List<String> list = InfixTurnSuffix.infixTurnSuffix(s);
		int[] tmp = { pick[0], pick[1], pick[2], pick[3] };
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).charAt(0) >= '0' && list.get(i).charAt(0) <= '9') {
				stack.push(Double.parseDouble(list.get(i)));
				boolean flag = true;
				for (int j = 0; j < 4; j++) {
					if (tmp[j] % 13 == stack.peek() % 13) {
						tmp[j] = -1;
						flag = false;
						break;
					}
				}
				if (flag) {
					throw new InputMismatchException();
				}
			} else {
				double t1 = stack.pop();
				double t2 = stack.pop();
				switch (list.get(i).charAt(0)) {
				case '+':
					stack.push(t2 + t1);
					break;
				case '-':
					stack.push(t2 - t1);
					break;
				case '*':
					stack.push(t2 * t1);
					break;
				case '/':
					stack.push(t2 / t1);
					break;
				default:
					;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (tmp[i] > 0) {
				throw new InputMismatchException();
			}
		}

		if (stack.size() == 1) {
			return stack.pop() == 24;
		} else {
			throw new InputMismatchException();
		}
	}
}
