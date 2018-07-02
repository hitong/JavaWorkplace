//package com.org.mina;
//
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.codec.ProtocolCodecFactory;
//import org.apache.mina.filter.codec.ProtocolDecoder;
//import org.apache.mina.filter.codec.ProtocolEncoder;
//
//// 工厂类
//public class MyTextLineCodecFactory implements ProtocolCodecFactory {
//
//    private final MyTextLineEncoder encoder;
//    private final MyTextLineDecoder decoder;
//
//    public MyTextLineCodecFactory() {
//        // 使用自定义编码/解码类
//        encoder = new MyTextLineEncoder();
//        decoder = new MyTextLineDecoder();
//    }
//    @Override
//    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
//        return encoder;
//    }
//    @Override
//    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
//        return decoder;
//    }
//}