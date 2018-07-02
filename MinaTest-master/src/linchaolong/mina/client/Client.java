package linchaolong.mina.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// 传统 Socket Client 
public class Client {
	
	private boolean _isExit = false;

	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

	private void start() {

		BufferedReader in = null;
		try {
			final Socket socket = new Socket("127.0.0.1", 9999);
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			
			// 创建一个线程用于接收消息
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while( !_isExit ){
							String line = reader.readLine();
							System.out.println("from server : " + line);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			// 从控制台输入消息，发送到服务端
			in = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while (!"bye".equals((line = in.readLine()))) {
				writer.write(line);
				writer.newLine();
				writer.flush();
			}
			
			_isExit = true;
			in.close();
			writer.close();
			reader.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			_isExit = true;
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
