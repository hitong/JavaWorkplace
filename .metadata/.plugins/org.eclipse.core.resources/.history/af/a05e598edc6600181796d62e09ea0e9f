package work;

import java.util.ArrayList;
import java.util.Scanner;

public class Launch {
	private static String[] str = {
			"mainConcent",
			"comeFromText",
			"comeFromFile",
			"data",
			"depart",
			"sender"
	};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Model> all = IORecord.readFile();
		Model m = new Model();
		for(int i = 0; i < 6; i++) {
			System.out.println("请输入" + str[i]);
			MySwitch.mySwitch(m, i, input.nextLine());
		};

		all.add(m);
		System.out.println(all.size());
		if(IORecord.writeFile(all)) {
			System.out.println("你的记录已经录入");		
		}
		System.out.println("搜索区间：");
		ArrayList<Model> a = Search.search(all, input.nextLine(), new int[]{0});
		
		for(int i = 0; i < a.size(); i++) {
			for(int j  = 0; j < 6 ;j++)
			System.out.print(MySwitch.mySwitch(a.get(i),j) + " ");
			System.out.println();
		}
		input.close();
	}
}
