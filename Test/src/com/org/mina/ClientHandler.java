package com.org.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler extends IoHandlerAdapter {
	// 当客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("incomming 客户端: " + session.getRemoteAddress());
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("客户端发送信息异常....");
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println(message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("客户端与服务端断开连接.....");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("已建立连接" + session.getRemoteAddress());
	}

	public void setId(String id) {
		this.id = id;
	}

	private String id = null;
}
