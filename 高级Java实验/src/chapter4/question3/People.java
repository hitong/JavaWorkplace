package chapter4.question3;

import 实验四.utils.Column;
import 实验四.utils.Entity;
import 实验四.utils.ID;
import 实验四.utils.TableInfo;

@Entity("People")
public class People {
	@Column(nullable = false, value = "学号")
	private Integer id;
	@Column(nullable = true, value = "身份证")
	private String name;
	@ID()
	@Column(nullable = false, length = 44, value = "姓名")
	private String id1;

	public static void main(String args[]) {// 测试类中的主方法
		TableInfo test = new TableInfo();
		test.getTableInfo(People.class);
		System.out.println(test.toString());
	}
}
