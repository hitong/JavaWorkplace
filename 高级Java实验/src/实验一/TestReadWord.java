package 实验一;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class TestReadWord {

	public static void main(String[] args) {
		String filePath = "src/实验一/ReadWord.java";
//		String filePath = "src/实验一/测试文本/英文文章1.txt";
//		String filePath = "src/实验一/测试文本/英文文章2.txt";
		ReadWord read;
		try {
			read = new ReadWord(filePath);
			TestReadWord.testAllWord(read);
			TestReadWord.testJavaKeyWord(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testAllWord(ReadWord read) {
		ArrayList<String> allWords = read.getWordList();
		System.out.println("所有单词：");
		printWordList(allWords);
	}

	private static void testJavaKeyWord(ReadWord read) {
		HashSet<String> keyWords = read.getJavaKeyWords();
		System.out.println("Java关键字:");
		printWordList(keyWords);
	}

	private static void printWordList(Collection<String> arr) {
		System.out.println("单词总个数：" + arr.size() + "\n单词列表(升序):");
		Iterator<String> it = arr.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}