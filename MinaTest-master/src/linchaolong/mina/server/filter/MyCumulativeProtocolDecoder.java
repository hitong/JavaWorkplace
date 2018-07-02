package linchaolong.mina.server.filter;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

// 防止数据丢失的处理
public class MyCumulativeProtocolDecoder extends CumulativeProtocolDecoder {

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		// 字符解码器
		CharsetDecoder decoder = (CharsetDecoder) session.getAttribute("decoder");
        if (decoder == null) {
        	decoder = Charset.forName( "GBK" ).newDecoder();
            session.setAttribute("decoder", decoder);
        }
        
        // 开始位置
        int startPos = in.position();
        while(in.hasRemaining()){
        	byte b = in.get();
        	if (b == '\n') {
        		int pos = in.position();
        		int limit = in.limit();
        		
        		// 截取从开始位置到当前位置的数据，转换为字符串
        		// 1.设置截取的位置
        		in.position(startPos);
        		in.limit(pos);
        		
        		//2.截取
        		IoBuffer buff = in.slice();
        		byte bytes[] = new byte[limit-2]; // -2 不包含换行符和结束符 
        		buff.get(bytes);
        		
        		//3.解码
        		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        		CharBuffer charBuffer = decoder.decode(byteBuffer);
        		out.write(charBuffer.toString());
        		
        		//4.复原
        		in.position(pos);
        		in.limit(limit);
        		return true; // 立刻进行一下次消息读取
			}
        }
        
		in.position(startPos); // 下次还是从开始位置读取
		return false;
	}

}
