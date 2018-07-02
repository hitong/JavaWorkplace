package 实验二;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import utils.FileWrite;

public class Question2 {
	public static String className = "实验二.Person";
	private static String savePath = "src/实验二/基本信息.txt";
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor();
			Object person = constructor.newInstance();
			Method[] getMethod = new Method[5];
			Method[] setMethod = new Method[5];
			setMethod[0] = clazz.getMethod("setIdNo", String.class);
			setMethod[1] = clazz.getMethod("setName", String.class);
			setMethod[2] = clazz.getMethod("setAge", Integer.class);
			setMethod[3] = clazz.getMethod("setSex", String.class);
			setMethod[4] = clazz.getMethod("setIsMarried", Boolean.class);
			
			getMethod[0] = clazz.getMethod("getIdNo");
			getMethod[1] = clazz.getMethod("getName");
			getMethod[2] = clazz.getMethod("getAge");
			getMethod[3] = clazz.getMethod("getSex");
			getMethod[4] = clazz.getMethod("getIsMarried");
			
			setMethod[0].invoke(person, "5122245566");
			setMethod[1].invoke(person, "张小平");
			setMethod[2].invoke(person, 23);
			setMethod[3].invoke(person, "Male");
			setMethod[4].invoke(person, true);
			
			boolean clean = true;
			if (FileWrite.write(savePath, "身份证号:" + getMethod[0].invoke(person) + "\r\n", clean)) {
				System.out.println("成功写入身份证号");
			} else {
				System.out.println("写入身份证号异常");
			}
			if (FileWrite.write(savePath, "姓名:" + getMethod[1].invoke(person) + "\r\n", false)) {
				System.out.println("成功写入姓名信息");
			} else {
				System.out.println("写入姓名信息异常");
			}
			if (FileWrite.write(savePath, "年龄:" + getMethod[2].invoke(person) + "\r\n", false)) {
				System.out.println("成功写入年龄信息");
			} else {
				System.out.println("写入年龄信息异常");
			}
			if (FileWrite.write(savePath, "性别:" + getMethod[3].invoke(person) + "\r\n", false)) {
				System.out.println("成功写入性别信息");
			} else {
				System.out.println("写入性别信息异常");
			}
			if (FileWrite.write(savePath, "是否已婚:" + getMethod[4].invoke(person) + "\r\n", false)) {
				System.out.println("成功婚恋状态信息");
			} else {
				System.out.println("写入婚礼状态信息异常");
			}
			
			MyProxy proxy = new MyProxy((Person) person);
			try {
				proxy.invoke(proxy, setMethod[1], new String[]{"修改"});
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println("操作异常");
			ex.printStackTrace();
		}
	}
}
