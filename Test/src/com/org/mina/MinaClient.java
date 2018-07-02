package com.org.mina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

// Mina Socket Client
//https://mina.apache.org/mina-project/userguide/ch2-basics/sample-udp-client.html
public class MinaClient {
	public static void main(String[] args) {
		MinaClient client = new MinaClient();
		client.start();
	}

	private void start() {
		NioSocketConnector connector = new NioSocketConnector();
		// 设置会话管理器
		connector.setHandler(new ClientHandler());
		// 添加编码过滤
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8")))); // 字符编码

		// 连接服务器
		ConnectFuture connFuture = connector.connect(new InetSocketAddress("127.0.0.1", 9999));
		connFuture.awaitUninterruptibly();

		CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
		IoSession session = connFuture.getSession();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String line = reader.readLine();
				if ("quit".equals(line)) {
					break;
				}
				// 编码
				ByteBuffer byteBuff = encoder.encode(CharBuffer.wrap(line));
				session.write(byteBuff);
			}
			connFuture.cancel();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
	}

}