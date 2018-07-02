package com.org.mina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;

public class Client {

    private boolean _isExit = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    private void start() {

        BufferedReader in = null;
        try {
            final Socket socket = new Socket("127.0.0.1",9999);
//    		NioDatagramConnector connector = new NioDatagramConnector();
//    		connector.setHandler( this );
//    		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
//        	ConnectFuture connFuture = connector.connect( new InetSocketAddress("127.0.0.1", 9999 ));
//        	connFuture.getSession().setAttribute("text", 123);
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
//                        e.printStackTrace();
                    }
                }
            }).start();
             
            // 从控制台输入消息，发送到服务端
            in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            writer.write("userName");
            writer.newLine();
            writer.flush();
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