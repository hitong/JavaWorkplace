package 实验二;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

import utils.DateFormate;
import utils.FileWrite;

public class MyProxy implements InvocationHandler {
	private Object proxied;
	private static final String logPath = "src/实验二/DynProxyLog";

	public MyProxy(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		method.invoke(proxied, args);
		String methodName = method.getName();
		if (methodName.charAt(0) == 's') {
			FileWrite.write(logPath,
					"处理时间：" + DateFormate.dateFormate(new Date()) + "方法名称：" + methodName + ";参数：" + args[0] + "\r\n",
					false);
		}
		return null;
	}

}
