package linchaolong.mina.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

// 传统Socket Server
public class Server {

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	private void start() {

		try {
			ServerSocket server = new ServerSocket(2222);
			
			Socket socket = server.accept();
			final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
			final BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")) );
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					String line = null;
					try {
						while( (line = reader.readLine()) != null ){
							System.out.println("from client : " + line);
							writer.write(line);
							writer.flush();
						}
						
						reader.close();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}					
				}
			}).start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
