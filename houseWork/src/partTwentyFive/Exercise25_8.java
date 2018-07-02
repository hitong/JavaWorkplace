package partTwentyFive;


import java.util.*;

public class Exercise25_8 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Stack<Double> num = new Stack<>();
		while(true){
			try{
				num.push(input.nextDouble());		
			}
			catch(InputMismatchException ex){	
				if(num.size() < 2){
					System.out.println("可操作数据数目不足，此次操作输入无效");
					input.nextLine();
				}
				else{
					
				switch (input.next().charAt(0)) {
					case '+':
						num.push(num.pop() + num.pop());
						break;
					case '-':
						num.push(num.pop() - num.pop());
						break;
					case '*':
						num.push(num.pop() * num.pop());
						break;
					case '/':
						num.push(num.pop() / num.pop());
						break;
					case '%':
						num.push(num.pop() % num.pop());
						break;
					default:
						System.out.println("运算错误");
					}
				System.out.println("当前结果: " + num.peek());}		
			}
		}
	}
}
