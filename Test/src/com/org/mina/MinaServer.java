package com.org.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {

    public static void main(String[] args) {
        MinaServer server = new MinaServer();
        server.start();
    }

    private void start() {
        try {
            final NioSocketAcceptor acceptor = new NioSocketAcceptor();
//         acceptor.getFilterChain().addLast( "logger", new LoggingFilter());
            acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" )))); // 字符编码

            // 设置会话管理类
            acceptor.setHandler(new MyIoHandler());
            // 设置read buff size（字节）
            acceptor.getSessionConfig().setReadBufferSize( 2048 ); // buff是可自动扩展的，但设置一个合适值，效率会较高。
            // 设置空闲时间（单位：秒，会话空闲时会调用IoHandler的sessionIdle方法，BOTH_IDLE：读和写，READER_IDLE：读，WRITER_IDLE：写）
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

            // 监听一个端口
            acceptor.bind(new InetSocketAddress(9999));

//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    // 发送一个广播，所以会话都能接受到
//                    acceptor.broadcast("Hello All.");
//                }
//            }, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}