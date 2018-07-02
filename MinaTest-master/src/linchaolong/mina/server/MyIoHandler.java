package linchaolong.mina.server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MyIoHandler extends IoHandlerAdapter {

	// 会话创建
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		// 获取客户端ip
		InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteAddress();
		InetAddress inetAddress = socketAddress.getAddress();
		System.out.println("sessionCreated  id=" + session.getId() + " , ip=" + inetAddress.getHostAddress());
	}

	// 会话打开
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		super.sessionOpened(session);
		System.out.println("sessionOpened");
	}

	// 会话关闭
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		System.out.println("sessionClosed");
	}

	// 会话等待
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		super.sessionIdle(session, status);
		System.out.println( "IDLE " + session.getIdleCount( status ));
	}

	// 会话异常
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		super.exceptionCaught(session, cause);
		cause.printStackTrace();
	}

	// 接受消息
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// 读取客户端消息
		String str = message.toString();
		System.out.println("from session " + session.getId() + " : " + str);
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close(true);
			return;
		}
		// 给客户端返回数据
		session.write(new Date().toString());
	}

	// 发送消息
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
		System.out.println("messageSent : " + message);
	}

	// 关闭输入流
	@Override
	public void inputClosed(IoSession session) throws Exception {
		super.inputClosed(session);
		System.out.println("inputClosed");
	}
}
