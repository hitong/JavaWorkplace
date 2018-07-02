package util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Code;

/**
 * 该Huffman类提供，字符串的压缩以及解压方法， 如果原数据转化为0，1代码串的长度超过指定长 度，则不会保留0，1形式，而用相应的int类型的
 * 压缩形式代替,并且在获取压缩码的形式中，将会
 * 
 * @author Sun
 *
 */
public class Huffman {
	// public static void main(String[] args) {
	// Scanner input = new Scanner(System.in);
	// StringBuilder s =new StringBuilder(input.nextLine());
	// long startTime = System.currentTimeMillis();
	// Huffman h = new Huffman(s);
	// long endTime = System.currentTimeMillis();
	// System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	// System.out.println("start");
	// h.readDateFromFile("f:/100m.txt");
	// System.out.println(h.Data());
	// System.out.println(h.readDateFromFile("F://qq文档//1906194855//FileRecv//a.exe"));
	// System.out.println(t);
	// System.out.println(h.getCompressedCode().length() / 31.0 * 4 + 1);
	// System.out.println("end");
	// HashMap<Character, String> map = h.getCode();
	// Iterator<Character> it = map.keySet().iterator();
	// while(it.hasNext()) {
	// char tmp = it.next();
	// System.out.println(tmp + " " + map.get(tmp));
	// }

	// System.out.println(h.getCompressedCode());
	// System.out.println(h.writeCompressDataToFile("F:/test.dat"));
	// System.out.println(h.readCompressDateFromFile("F:/test.dat"));
	// HashMap<Character, String> map2 = h.getCode();
	// Iterator<Character> it2 = map2.keySet().iterator();
	// while(it2.hasNext()) {
	// char tmp2 = it2.next();
	// System.out.println(tmp2 + " " + map2.get(tmp2));
	// }
	// System.out.println(h.getCode().get('\n'));
	// System.out.println(h.writeToFile("F:/a.txt"));
	// System.out.println(h.getCompressedCode());
	//
	// System.out.println(h.getCode().size());
	// System.out.println(h.writeCompressDataToFile("F:/test.dat"));
	// System.out.println(h.getData());
	//
	//
	// input.close();
	// }

	private StringBuilder compressedCode = new StringBuilder("");// 存储经过Huffman编码过后的数据,达到程序溢出值，将会为空
	private StringBuilder data;// 存储原始数据
	private TreeNode root = null;// 存储根节点
	private HashMap<Character, String> code = new HashMap<>();// 存储（字符，Huffman编码）键值对
	private HashMap<Character, Integer> weight = new HashMap<>();
	private boolean isMemoryOverflow = false;// 判断01压缩码是否溢出
	private ArrayList<Integer> overflow = new ArrayList<>();

	public Huffman(StringBuilder data) {
		this.data = data;
		buildHuffmanTree();
	}

	public Huffman() {
		this.data = new StringBuilder();
	}

	public void inputByTerminal(String data, boolean isSave) {
		if (!isSave) {
			this.reSet();
		}
		this.data = new StringBuilder(data);
		this.buildHuffmanTree();
	}

	public void inputByFile(String path) {
		this.reSet();
		this.readHuffmanCodeFromFile(path);
		this.buildHuffmanTree();
	}

	/**
	 * 构造Huffman树
	 */
	private void buildHuffmanTree() {
		generatingNode();
		code = new HashMap<>();
		Heap<TreeNode> heap = new Heap<>();
		Iterator<Character> it = weight.keySet().iterator();
		while (it.hasNext()) {
			char t = it.next();
			heap.add(new TreeNode(weight.get(t), t));
		}

		boolean flag = true;
		int t = heap.size();
		while (heap.size() > 1) {
			TreeNode t1 = heap.remove();
			TreeNode t2 = heap.remove();
			heap.add(new TreeNode(t1, t2));
			flag = false;
		}

		root = heap.remove();// root为Huffman树根节点

		if (flag && t == 1) {
			code.put(root.root.ch, "0"); //将单个节点置为0
		} else {
			try {
				assignCode(root.root);// 生成Huffman编码
			} catch (NullPointerException ex) {
				return;
			}
		}
		compressedCode(); //压缩编码
	}

	/**
	 * 生成Huffman编码
	 * 
	 * @param root
	 */
	private void assignCode(TreeNode.Node root) {
		if (root.left != null) {
			root.left.code = root.code + "0";// 左子树编码设为0
			assignCode(root.left);

			root.right.code = root.code + "1";// 右子树编码设为1
			assignCode(root.right);
		} else {
			code.put(root.ch, root.code);// 将叶节点Huffman编码保存至code表中
		}
	}

	/**
	 * 遍历数据，生成各字符节点，并计算对应权重
	 */
	private void generatingNode() {
		for (int i = 0; i < data.length(); i++) {
			char t = data.charAt(i);
			if (weight.containsKey(t)) {
				int tmp = weight.get(t);
				weight.put(t, tmp + 1);
			} else {
				weight.put(t, 1);
			}
		}
	}

	private void deCompressionCode() {
		rebuildTree();
		if (this.isMemoryOverflow) {
			deCodingOverflow();
		} else {
			deCoding();
		}
	}

	private void deCodingOverflow() {
		this.data = new StringBuilder();
		TreeNode tmp = root.clone();
		System.out.println("该内容正在进行越界处理" + this.overflow.size());
		int ext = this.overflow.get(this.overflow.size() - 1);
		StringBuilder tmpCompress = new StringBuilder();
		int size = overflow.size() - 1;
		for (int i = 0; i < size; i++) {
			tmpCompress = new StringBuilder(intToString(overflow.get(i)));
			if (i == size - 1) {
				tmpCompress = new StringBuilder(tmpCompress.substring(0, tmpCompress.length() - ext));
			}
			for (int j = 0; j < tmpCompress.length(); j++) {
				while (j < tmpCompress.length()) {
					if (tmp.root.left == null && tmp.root.right == null) {
						this.data.append(tmp.root.ch);
						tmp = root.clone();
						j--;
						break;
					}
					if (tmpCompress.charAt(j) == '0') {
						tmp.root = tmp.root.left;
					} else {
						tmp.root = tmp.root.right;
					}
					j++;
				}
			}
		}
	}

	private void deCoding() {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.clone();
		if (tmp.root == null) {
			return;
		}
		if (root.root.left == null && root.root.right == null) {
			for (int i = 0; i < this.compressedCode.length(); i++) {
				this.data.append(tmp.root.ch);
			}
			return;
		}
		this.data = new StringBuilder();
		for (int i = 0; i < this.compressedCode.length(); i++) {
			tmp = root.clone();
			while (i <= this.compressedCode.length()) {
				if (tmp.root.left == null && tmp.root.right == null) {
					data.append(tmp.root.ch);
					i--;
					break;
				}
				if (this.compressedCode.charAt(i) == '0') {
					tmp.root = tmp.root.left;
				} else {
					tmp.root = tmp.root.right;
				}
				i++;
			}
		}
	}

	private void rebuildTree() {
		code = new HashMap<>();
		Heap<TreeNode> heap = new Heap<>();
		Iterator<Character> it = weight.keySet().iterator();
		while (it.hasNext()) {
			char t = it.next();
			heap.add(new TreeNode(weight.get(t), t));
		}

		boolean flag = true;
		int t = heap.size();
		while (heap.size() > 1) {
			TreeNode t1 = heap.remove();
			TreeNode t2 = heap.remove();
			heap.add(new TreeNode(t1, t2));
			flag = false;
		}

		root = heap.remove();// root为Huffman树根节点

		if (flag && t == 1) {
			code.put(root.root.ch, "0");
		} else if (t != 0) {
			assignCode(root.root);// 生成Huffman编码
		}
	}

	private void compressedCode() {
		Iterator<Character> it = code.keySet().iterator();
		int length = 0;
		while (it.hasNext()) {
			char tmp = it.next();
			length = length + weight.get(tmp) * code.get(tmp).length();
		}

		if (length > 200000000) {//溢出值设为2亿，最大值需要小于2147483647
			memoryOverflow(length);
			this.isMemoryOverflow = true;
		} else {
			this.compressedCode = new StringBuilder(length);
			for (int i = 0; i < this.data.length(); i++) {
				this.compressedCode.append(code.get(data.charAt(i)));
			}
		}
	}

	private void memoryOverflow(int length) {
		int tmp = 31 - length % 31;

		int size = (int) Math.floor(length / 31.0) + 1 + 1;
		// System.out.println(length + " " + size);
		this.overflow = new ArrayList<>(size);
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < data.length(); i++) {
			s.append(code.get(data.charAt(i)));
			// System.out.println(overflow.size());
			while (s.length() > 31) {
				overflow.add(Integer.parseInt(s.substring(0, 31), 2));
				s = new StringBuilder(s.substring(31));
			}
		}

		for (int i = 0; i < tmp; i++) {
			s.append("0");
		}

		overflow.add(Integer.parseInt(s.toString(), 2));
		overflow.add(tmp);
	}

	public String getCompressedCode() {
		return this.compressedCode.toString();
	}

	public String getData() {
		return data.toString();
	}

	private void reSet() {
		compressedCode = new StringBuilder("");
		data = new StringBuilder("");
		root = null;
		code = new HashMap<>();
		weight = new HashMap<>();
	}

	public boolean writeHuffmanCodeToFile(String filePath) {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath + ".HFM")))) {
			Iterator<Character> it = this.weight.keySet().iterator();
			while (it.hasNext()) {
				char tmp = it.next();
				out.writeChar(tmp);
				out.writeInt(weight.get(tmp));
			}
			out.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	private boolean readHuffmanCodeFromFile(String filePath) {
		try (DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath + ".HFM")))) {
			char t;
			while (true) {
				t = in.readChar();
				Integer s = in.readInt();
				weight.put(t, s);
			}
		} catch (EOFException ex) {
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	private int height(TreeNode.Node root, int max) {
		if (root == null) {
			return 0;
		}

		int max1 = height(root.left, max + 1) + 1;
		int max2 = height(root.right, max + 1) + 1;
		return max1 > max2 ? max1 : max2;
	}

	public int getHeight() {
		return height(root.root, 0);
	}

	public void printTreeToFile(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(path + ".tree"));
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			printTreeByY();
			for (int i = 0; i < l.size(); i++) {
				osw.write(l.get(i).toString() + "\r\n");
			}
			osw.close();
		} catch (Exception ex) {

		}
	}

	private void printTreeByY() {
		Queue<TreeNode.Node> level = new LinkedList<>();
		level.add(root.root);
		int height = this.getHeight();
		int max = (int) Math.pow(2, height);
		l = new ArrayList<>();
		print(level, 0, height, max);

	}

	ArrayList<StringBuilder> l;

	private void print(Queue<TreeNode.Node> level, int levelIndex, int height, int maxnode) {
		StringBuilder tmp = new StringBuilder();
		if (levelIndex > height) {
			return;
		}
		Queue<TreeNode.Node> nextLevel = new LinkedList<>();
		int maxCount = maxnode * 2 + 1;
		int nodecount = (int) (Math.pow(2, levelIndex));
		int pre = (int) (Math.pow(2, height - levelIndex) - 1);
		int intervaltotal = maxCount - nodecount - 2 * pre;
		int intervalcount = nodecount - 1;
		int interval = 0;
		if (intervalcount != 0 && intervaltotal > 0) {
			interval = intervaltotal / intervalcount;
		}
		for (int i = 0; i < pre; i++) {
			tmp.append(" ");
		}
		while (!level.isEmpty()) {
			TreeNode.Node node = level.poll();
			if (node.left == null && node.right == null && node.weight > 0) {
				tmp.append(node.ch);
			} else {
				tmp.append("-");

			}
			if (node.left != null) {
				nextLevel.add(node.left);
			} else {
				nextLevel.add(new TreeNode().root);
			}

			if (node.right != null) {
				nextLevel.add(node.right);
			} else {
				nextLevel.add(new TreeNode().root);
			}

			for (int i = 0; i < interval; i++) {
				tmp.append(" ");
			}
		}
		l.add(tmp);
		print(nextLevel, levelIndex + 1, height, maxnode);
	}

	public boolean readDateFromFile(String filePath) {
		StringBuilder tmp = new StringBuilder("");
		try {
			File file = new File(filePath);
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String t;
			while ((t = in.readLine()).length() >= 0) {
				tmp.append(t + "\r\n");
			}
			in.close();
		} catch (NullPointerException ex) {
			this.reSet();
			this.data = tmp;
			buildHuffmanTree();
			return true;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean readCompressDateFromFile(String filePath) {
		LinkedList<Integer> tmp = new LinkedList<>();
		int numOfSize = 0;
		boolean flag = false;
		try (DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)))) {
			flag = in.readBoolean();
			while (true) {
				tmp.add(in.readInt());
			}
		} catch (EOFException ex) {
			this.reSet();
			this.isMemoryOverflow = flag;
			if (this.isMemoryOverflow) {
				Iterator<Integer> it = tmp.iterator();
				this.overflow = new ArrayList<>(tmp.size());
				while (it.hasNext()) {
					this.overflow.add(it.next());
				}
			} else {
				numOfSize = tmp.removeLast();
				Iterator<Integer> it = tmp.iterator();
				StringBuilder s = new StringBuilder();
				while (it.hasNext()) {
					s.append(intToString(it.next()));
				}
				this.compressedCode = new StringBuilder(s.substring(0, s.length() - numOfSize));
			}

			this.readHuffmanCodeFromFile(filePath.substring(0, filePath.length() - 4));
			deCompressionCode();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public String binToData(String src) throws NoSuchFieldException {
		if (root == null) {
			throw new NoSuchFieldException();
		}
		TreeNode tmp = root.clone();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) != '0' && src.charAt(i) != '1') {
				throw new NoSuchFieldException();
			}
		}
		if (root.root.left == null && root.root.right == null) {
			for (int i = 0; i < src.length() && src.charAt(i) == '0'; i++) {
				s.append(tmp.root.ch);
			}
			if (src.length() != s.length()) {
				throw new NoSuchFieldException();
			}
			return s.toString();
		}
		try {
			for (int i = 0; i < src.length(); i++) {
				tmp = root.clone();
				while (i <= src.length()) {
					if (tmp.root.left == null && tmp.root.right == null) {
						s.append(tmp.root.ch);
						i--;
						break;
					}
					if (src.charAt(i) == '0') {
						tmp.root = tmp.root.left;
					} else {
						tmp.root = tmp.root.right;
					}
					i++;
				}
			}
			return s.toString();
		} catch (Exception ex) {
			throw new NoSuchFieldException();
		}
	}

	/**
	 * 原data数据将会被清除
	 * 
	 * @param src
	 * @return
	 * @throws NoSuchFieldException
	 */
	public String dataToBin(String src) throws NoSuchFieldException {
		for (int i = 0; i < src.length(); i++) {
			if (weight.get(src.charAt(i)) == null) {
				throw new NoSuchFieldException();
			}
		}
		this.data = new StringBuilder(src);
		this.compressedCode();
		return this.compressedCode.toString();
	}

	private String intToString(int number) {
		String tmp = "";
		while (number != 0) {
			if (number % 2 == 0)
				tmp = "0" + tmp;
			else
				tmp = "1" + tmp;

			number /= 2;
		}

		if (tmp.length() < 31) {
			int size = tmp.length();
			for (int i = 0; i < 31 - size; i++)
				tmp = "0" + tmp;
		}
		return tmp;
	}

	public List<Code> getListOfCode() {
		Iterator<Character> it = weight.keySet().iterator();
		ArrayList<Code> list = new ArrayList<Code>(weight.size());
		while (it.hasNext()) {
			char tmp = it.next();
			list.add(new Code(tmp + "", weight.get(tmp), code.get(tmp)));
		}
		return list;
	}

	public boolean writeCompressDataToFile(String filePath) {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath + ".dat")))) {
			out.writeBoolean(this.isMemoryOverflow);
			if (!this.isMemoryOverflow) {
				int tmp = 31 - this.compressedCode.length() % 31;
				for (int i = 0; i < tmp; i++) {
					this.compressedCode.append("0");
				}

				for (int i = 0; i < this.compressedCode.length() / 31; i++) {
					out.writeInt(Integer.parseInt(this.compressedCode.substring(i * 31, (i + 1) * 31), 2));
				}
				out.writeInt(tmp);
			} else {
				// System.out.println(this.overflow.size());
				for (int i = 0; i < this.overflow.size(); i++) {
					out.writeInt(overflow.get(i));
				}
			}
			writeHuffmanCodeToFile(filePath);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public boolean writeToFile(String filePath) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(data.toString());
			osw.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	/***
	 * 返回Huffman表
	 * 
	 * @return
	 */
	public HashMap<Character, String> getCode() {
		return code;
	}

	public TreeNode getRoot() {
		return root;
	}

	public static class TreeNode implements Comparable<TreeNode> {
		Node root;

		public TreeNode(TreeNode t1, TreeNode t2) {
			root = new Node();
			root.left = t1.root;
			root.right = t2.root;
			root.weight = t1.root.weight + t2.root.weight;
		}

		public TreeNode(Node root) {
			this.root = root;
		}

		public TreeNode() {
			this.root = new Node();
		}

		public TreeNode(int weight, char ch) {
			root = new Node(weight, ch);
		}

		public int getWidth() {
			if (root == null)
				return 0;
			int max = 1;
			LinkedList<Node> ll = new LinkedList<Node>();
			ll.add(root);
			while (true) {
				int len = ll.size(); // 获取当前层的节点数
				if (len == 0) // 队列空，二叉树已经遍历完
					break;
				while (len > 0) {
					Node b = ll.poll();
					len--;
					if (b.left != null)
						ll.add(b.left);
					if (b.right != null)
						ll.add(b.right);
				}
				max = Math.max(max, ll.size());
			}
			return max;
		}

		@Override
		public int compareTo(TreeNode t) {
			if (root.weight < t.root.weight) {
				return 1;
			} else if (root.weight == t.root.weight) {
				if (root.ch < t.root.ch) {
					return 1;
				}
				return 0;
			} else {
				return -1;
			}
		}

		public TreeNode clone() {
			Node tmp = new Node();
			tmp.ch = root.ch;
			tmp.code = root.code;
			tmp.left = root.left;
			tmp.right = root.right;
			tmp.weight = root.weight;
			return new TreeNode(tmp);
		}

		public class Node {
			char ch;
			int weight;
			Node left;
			Node right;
			String code = "";

			public Node() {
			}

			public Node(int weight, char ch) {
				this.weight = weight;
				this.ch = ch;
			}

			public char getCh() {
				return ch;
			}

			public Node getLeft() {
				return root.left;
			}

			public Node getRight() {
				return root.right;
			}
		}

		public Node getNode() {
			return root;
		}
	}
}