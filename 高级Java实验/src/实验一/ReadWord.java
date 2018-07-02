package 实验一;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ReadWord {
	private ArrayList<String> wordList = new ArrayList<>();
	private File file;

	public ReadWord(String filePath) throws FileNotFoundException {
		file = new File(filePath);
		try {
			FileInputStream in = new FileInputStream(file);
			try {
				readWordFromFile(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Not Found File");
		}
	}

	private void readWordFromFile(FileInputStream in) throws IOException {
		int tmpRead;
		StringBuilder tmpWord = new StringBuilder();
		while ((tmpRead = in.read()) != -1) {
			if ((tmpRead >= 'a' && tmpRead <= 'z') || 
					(tmpRead >= 'A' && tmpRead <= 'Z')) {
				tmpWord.append((char) tmpRead);
			} else {
				if (!tmpWord.toString().isEmpty()) {
					wordList.add(tmpWord.toString());
					tmpWord = new StringBuilder();
				}
			}
		}
		if (!tmpWord.toString().isEmpty()) {
			wordList.add(tmpWord.toString());
		}
		Collections.sort(wordList);
	}

	public HashSet<String> getJavaKeyWords() {
		HashSet<String> KeyWordList = new HashSet<>();
		for (int i = 0; i < wordList.size(); i++) {
			if (JavaKeyWords.isKeyWord(wordList.get(i))) {
				KeyWordList.add(wordList.get(i));
			}
		}
		return KeyWordList;
	}
	
	public File getFilePath() {
		return this.file;
	}

	public ArrayList<String> getWordList() {
		return this.wordList;
	}
}
