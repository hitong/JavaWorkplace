package 实验二;

import java.util.Date;

import utils.DateFormate;
import utils.FileWrite;

public class PersonProxy {
	private Person person;
	private static final String logPath = "src/实验二/log";

	public PersonProxy(Person person) {
		this.person = person;
	}

	public void setName(String name) {
		person.setName(name);
		FileWrite.write(logPath,
				"处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：setName;" + "参数：" + name + "\r\n", false);
	}

	public void setIdNo(String idNo) {
		person.setIdNo(idNo);
		FileWrite.write(logPath, "处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：setIdNo;参数：" + idNo + "\r\n",
				false);
	}

	public void setAge(Integer age) {
		person.setAge(age);
		FileWrite.write(logPath, "处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：setAge;参数：" + age + "\r\n",
				false);
	}

	public void setSex(String sex) {
		person.setSex(sex);
		FileWrite.write(logPath, "处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：setSex;参数：" + sex + "\r\n",
				false);
	}

	public void setIsMarried(Boolean isMarried) {
		person.setIsMarried(isMarried);
		FileWrite.write(logPath,
				"处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：setIsMarried;参数：" + isMarried + "\r\n", false);
	}
}
