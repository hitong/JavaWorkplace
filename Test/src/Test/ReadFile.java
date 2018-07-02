package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.LinkedList;


public class ReadFile {
	public static void main(String[] args) throws Exception{
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/19061/Desktop/1.zip")));
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("C:/Users/19061/Downloads/bootanimation.zip")),1024*4);
		byte[] by = new byte[1024*1];
		String s = "啊是大bsadlabdsakljdsbaskldjbaskdljbaskljdbakjdlsb,xmcbzx.     ";
//		s.getBytes("utf-8");
//		OutputStreamWriter o =new OutputStreamWriter(bufferedOutputStream, "UTF-8");
//		by = s.getBytes();
 		int l;
// 		String mString = new String(by);
// 		System.out.println(mString);
 	
		byte[] tmp = new byte[1024 * 4];
		int length;
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		LinkedList<byte[]> linkedList = new LinkedList<>();
		while ((length = bufferedInputStream.read(tmp)) != -1) {
			byteArrayOutputStream.write(tmp, 0, length);
			linkedList.add(byteArrayOutputStream.toByteArray());
			byteArrayOutputStream.reset();
		}
		
		for(int i = 0; i < linkedList.size(); i++){
			bufferedOutputStream.write(linkedList.get(i));
		}
		System.out.println(linkedList.size());
		bufferedOutputStream.close();
		bufferedInputStream.close();
	}
}
