package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileWrite {
	public static boolean write(String filePath,String contents,boolean clean) {
		if(NullTest.isNull(filePath) || NullTest.isNull(contents)) {
			return false;
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), !clean));
			writer.write(contents);
			writer.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
