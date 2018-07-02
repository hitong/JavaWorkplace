package 实验一;

public final class JavaKeyWords {
	public final static String[] allKeyWord = { "abstract", "assert",
			"boolean", "break", "byte", "case", "catch", "char", "class",
			"const", "continue", "default", "do", "double", "else", "enum",
			"extends", "final", "finally", "float", "for", "goto", "if",
			"implements", "import", "instanceof", "int", "interface", "long",
			"native", "new", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "try",
			"void", "volatile", "while" };

	public static boolean isKeyWord(String str) {
		for (int i = 0; i < allKeyWord.length; i++) {
			if(str.equals(allKeyWord[i])){
				return true;
			}
		}
		return false;
	}
}
