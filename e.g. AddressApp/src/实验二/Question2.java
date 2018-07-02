package 实验二;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Question2 {
	public static String className = "实验二.Person";

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor();
			Object person = constructor.newInstance();
			Method[] method = new Method[5];
			method[0] = clazz.getMethod("setIdNo", String.class);
			method[1] = clazz.getMethod("setName", String.class);
			method[2] = clazz.getMethod("setAge", Integer.class);
			method[3] = clazz.getMethod("setSex", String.class);
			method[4] = clazz.getMethod("setIsMerried", Boolean.class);

			method[0].invoke(person, "5122245566");
			method[1].invoke(person, "张小平");
			method[2].invoke(person, 23);
			method[3].invoke(person, "Male");
			method[4].invoke(person, true);
			System.out.println(((Person) person).getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
