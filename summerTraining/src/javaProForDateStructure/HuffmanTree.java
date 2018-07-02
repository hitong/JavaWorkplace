package javaProForDateStructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HuffmanTree{
	transient private TreeNode root = null; //存储huffmanTree根节点
	transient private HashMap<Character, Leaf> map = new HashMap<>();//存储字符与其信息对应的散列表
	transient private StringBuilder date = new StringBuilder(); //存储文本内容信息
	transient private File in = null; //存储文件输入地址
	transient private File compreesedIn = null; //存储压缩文件的输入地址
	transient private File out = null; //存储压缩文件输出地址
	
	public HuffmanTree(){
	}
	
	public HuffmanTree(StringBuilder s){
		date = date.append(s);
		this.add(date);
	}
	
	private class TreeNode implements Comparable<TreeNode>{	
		private Character e = null;
		private int weight = 0;
		private StringBuilder huffManCode = new StringBuilder();
		private int deep = 0;
		private TreeNode right = null;
		private TreeNode left = null;
		
		TreeNode(Character charactor, Leaf leaf){
			this.weight = leaf.weight;	
			e = charactor;
		}
		
		TreeNode(TreeNode left, TreeNode right, int deep){
			this.deep = deep;		
			this.left = left;
			this.right = right;
			this.weight = left.weight + right.weight;
		}
		
		/**
		 * 依次从权重，深度进行比较排序
		 */
		@Override
		public int compareTo(TreeNode o) {
			// TODO Auto-generated method stub
			if(weight > o.weight){
				return 1;
			}
			else if(weight < o.weight){
				return -1;
			}
			else if(deep > o.deep){			
				return 1;
			}
			else if(deep < o.deep){
				return -1;
			}
			return 0;
		}
	}
	
	class Leaf implements Comparable<Leaf>{
		StringBuilder code = new StringBuilder();
		int weight = 1;
		int deep = 0;
		
		Leaf(){
		}
		
		Leaf(int weight){
			this.weight = weight;
		}
		@Override
		public int compareTo(Leaf o) {
			// TODO Auto-generated method stub
			if(weight > o.weight){
				return 1;
			}
			else if(weight < o.weight){
				return -1;
			}
			else if(deep > o.deep){			
				return 1;
			}
			else if(deep < o.deep){
				return -1;
			}
			else 
				return 0;
		}
	}
	
	public void add(StringBuilder s){
		clear();
		date = new StringBuilder(s);
	
		for(int i = 0; i < s.length(); i++){
			this.add(new Character(s.charAt(i)));
		}
	}
	
	/**
	 * 添加新元素，或者增加原有元素权重
	 * @param newChar
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(Character newChar){
		if(map.containsKey(newChar)){
			map.get(newChar).weight++;
		}
		else{
			map.put(newChar, new Leaf());
		}
		
		List tmp = new LinkedList(map.values());
		Collections.sort(tmp);
	}	
	
	/**
	 * 返回一个哈希表，键值为字符，值为该字符的信息(其中封装了，该字符的权重，深度，以及huffmanCode)
	 * 该方法调用buildHuffmanTree，huffmanCode方法构建huffmantree，
	 * 并通过preForLeaves赋予每片子相应的huffmanCode
	 * @return 返回拥有子叶信息的hashmap<Character, Leaf>
	 * @throws NoWordException
	 */
	public HashMap<Character, Leaf> getHuffmanCode() throws NoWordException{
		if(map.size() == 0){
			throw new NoWordException();
		}
		LinkedList<TreeNode> forest = new LinkedList<>();
		Set<Character> tmp = map.keySet();
		Iterator<Character> it = tmp.iterator();		
		while(it.hasNext()){
			Character ch = it.next();
			forest.add(new TreeNode(ch, map.get(ch)));
		}
		Collections.sort(forest);
		
		buildHuffmanTree(forest);
		setCode(root);
		preForLeaves(root);
		if(map.size() == 1){
			map.get(root.e).code.append("0");
		}
		
		return map;
	}

	/**
	 * 通过先序遍历huffman树，给每一片树叶，赋予其对应的huffman编码
	 * @param root
	 */
	private void preForLeaves(TreeNode root){
		if(root != null){
			if(root.left == null && root.right == null){			
				map.get(root.e).code = root.huffManCode;
				return;
			};
			
			preForLeaves(root.left);
			preForLeaves(root.right);
		}
	}
	
	/**
	 * 遍历所有节点，并计算每个节点的huffmanCode
	 * @param root
	 */
	private void setCode(TreeNode root){
		if(root != null){
			if(root.left != null){
				root.left.huffManCode.append(root.huffManCode + "0");	
			}		
			if(root.right != null){
				root.right.huffManCode.append(root.huffManCode + "1");	
			}	
			
			setCode(root.left);
			setCode(root.right);	
		}
	}
	
	/**
	 * 输出huffman编码与字符的对应信息
	 */
	public void printHuffman(){
		List<Character> list = new ArrayList<>(map.keySet());
		for(Character ch: list){
			if(ch == '\n'){
				System.out.printf("\\n   %-4d    %s\n", map.get(ch).weight, map.get(ch).code);
			}
			else if(ch == '\r'){
				System.out.printf("\\r   %-4d    %s\n", map.get(ch).weight, map.get(ch).code);
			}
			else{
				System.out.printf("%c    %-4d    %s\n", ch, map.get(ch).weight, map.get(ch).code);
			}
		}
	}
	
	
	/**
	 *清除所有信息
	 */
	public void clear(){
		map = new HashMap<Character, Leaf>();
		root = null;
		date = new StringBuilder();
	}
	
	/**
	 * 从压缩文档中读取hashmap信息，通过获取的信息恢复huffman树，
	 * @param m
	 * @return
	 * @throws NoWordException
	 */
	public TreeNode reBuildeHuffmanTree(HashMap<Character, Integer> m) throws NoWordException{
		ArrayList<Character> list = new ArrayList<>(m.keySet());
		for(int i = 0; i < list.size(); i++){
			map.put(list.get(i), new Leaf(m.get(list.get(i))));
		}
		getHuffmanCode();
		return root;
	}
	
	/**
	 * 将TreeNode中的所有节点，通过贪婪算法组成一个树
	 * @param sortNode
	 * @return 
	 */
	private void buildHuffmanTree(LinkedList<TreeNode> sortNode){
		if(sortNode.isEmpty()){
			return ;
		}
		while(sortNode.size() > 1){
			TreeNode temp1 = sortNode.poll();
			TreeNode temp2 = sortNode.poll();
			TreeNode father;
			
			if(temp1.deep > temp2.deep){
				father = new TreeNode(temp1, temp2 ,temp1.deep + 1);
			}
			else if(temp1.deep < temp2.deep){
				father = new TreeNode(temp2, temp1, temp2.deep + 1);
			}
			else if(temp1.compareTo(temp2) == -1){
					father = new TreeNode(temp1, temp2 ,temp1.deep + 1);
			}			
			else{
				father = new TreeNode(temp2, temp1 ,temp1.deep + 1);
			}
					
			sortNode.add(father);
			Collections.sort(sortNode);
		}
		root = sortNode.remove(0);
	}	
	
	/**
	 * 从文档中读取相关代码
	 * @return 返回该内容的字符串
	 * @throws FileNotFoundException 
	 */
	public StringBuilder readDateFromFile() throws FileNotFoundException{
		if(in != null){
			try {
				DataInputStream inputStream = new DataInputStream(new FileInputStream(in));
				StringBuilder tmp = new StringBuilder();
				int t = 0;
				while((t = inputStream.read()) != -1){
					tmp = tmp.append((char)t);
				}
				inputStream.close();
				System.out.println(tmp);
				System.err.println("正在生成对应huffman编码，请等待...");
				add(tmp);
				getHuffmanCode();		
				return tmp;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			} catch(Exception ex){
				System.out.println("Faild to read in file");
			}		
		}
		else
			throw new FileNotFoundException();
		return date;
	}
	
	/**
	 * 调用getHuffmanCode方法获得一个<Character,Leaf>的hash表
	 * 调用getCompressionCode的方法，获取压缩后的数据代码
	 * 调用writeToFile方法，将压缩后的代码存入文档
	 * @throws FileNotFoundException 
	 */
	public void saveCompressedFiles() throws FileNotFoundException{	
		if(map.size() != 0){
			try {
				System.err.println("正在保存huffman编码...");
				writeToFile(map);
				System.err.println("正在保存文件...");
				if(writeToFile(getCompressionCode(map, date))){
					System.out.println("文件保存成功");
				}
			} catch (IOException ex){
				System.out.println(ex);
			}
		}
	}
	
	/**
	 * 读取解压文件，并返回解压后的内容
	 * @return
	 * @throws FileNotFoundException
	 */
	public StringBuilder readCompressedFiles(){
		if(compreesedIn != null){
			LinkedList<Integer> list = new LinkedList<>();
			try {
				@SuppressWarnings("resource")
				DataInputStream input = new DataInputStream(new FileInputStream(compreesedIn));
				int size = input.readInt();
			
				HashMap<Character, Integer> readMap = new HashMap<Character, Integer>();
				for(int i = 0; i < size; i++){
					Character c = input.readChar();
					int n = input.readInt();
					readMap.put(c, n);
				}						
				root = reBuildeHuffmanTree(readMap);			
				int x = 0;
				while(true){
					x = input.readInt();
					list.add(x);
				}			
			} catch(Exception ex){
				StringBuilder s = new StringBuilder();
				int ext = list.removeLast();
				while(list.size() != 0){
					s = s.append(intToString(list.poll()));
				}
		
				s = new StringBuilder(s.substring(0, s.length() - ext + 1));			
				date = decompressionData(s, root);
				
			}
		}		
		return date;
	}

	/**
	 * 解压压缩文件，返回解压内容的字符串
	 * @param s
	 * @param root
	 * @return
	 */
	private StringBuilder decompressionData(StringBuilder s, TreeNode root){
		StringBuilder tmp = new StringBuilder();
		for(int i = 0; i < s.length();){		
			TreeNode d = root;
			while(true){
				if(s.charAt(i) == '0'){
					if(d.left == null){
						tmp.append(d.e);
						break;
					}
					else{
						d = d.left;
					}					
				}
				else{
					if(d.right == null){
						tmp.append(d.e);
						break;
					}
					else{
						d = d.right;
					}	
				}	
				i++;
				if(i == s.length()){
					break;
				}
			}	
		}
		return tmp;
	}
	
	/**
	 * 10进制代码转换成二进制字符串
	 * @param number
	 * @return
	 */
	private String intToString(int number){
		String tmp = "";
		while(number != 0){	
			if(number % 2 == 0)
				tmp = "0" + tmp;
			else
				tmp = "1" + tmp;
	
			number /= 2;
		}
	
		if(tmp.length() < 31){
			int size = tmp.length();
			for(int i = 0 ; i < 31 - size ; i++)
				tmp = "0" + tmp;
		}
		return tmp;
	}

	/**
	 * 得到二进制压缩码
	 * @param map
	 * @param date
	 * @return
	 */
	private LinkedList<Integer> getCompressionCode(HashMap<Character, Leaf> map, StringBuilder date){
		if(date.length() == 0){
			return null;
		}
		
		LinkedList<Integer> b = new LinkedList<>();
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < date.length(); i++){
			Leaf leaf = map.get(date.charAt(i));
			s = s.append(leaf.code);		
		}
		int t = 0;
		while(s.length() > (t += 31)){
			b.add(stringToInt(s.substring(t - 31, t)));
		//	s = new StringBuilder(s.substring(31));
		}
		int ext = 31 - s.length() % 31;
		StringBuilder tmp = new StringBuilder();
		for(int i = 0; i < ext; i++){
			tmp = tmp.append("0");
		}	
		s = s.append(tmp);
		b.add(stringToInt(s.substring(t - 31, t)));
		b.add(ext);
		return b;

	}
	
	/**
	 * 二进制字符串内容转换成其对应的数字
	 * @param string
	 * @return
	 */
	private int stringToInt(String string){	
		return Integer.valueOf(string,2);
	}
	
	/**
	 * 将压缩后的代码存储到指定文件中,传入内容为空，返回false，否则返回true
	 */
	private boolean writeToFile(LinkedList<Integer> compressedCode){
		if(compressedCode.size() == 0){
			return false;
		}
		
		while(true){
			try {
				DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(out,true));
				while(compressedCode.size() != 0){
					Integer s = compressedCode.remove(0);
					outputStream.writeInt(s);
				}
				
				outputStream.flush();
				outputStream.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
		
	/**
	 * 存储对应数据的hashmap
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private boolean writeToFile(HashMap<Character, Leaf> m) throws FileNotFoundException, IOException{
		if(m.size() == 0){
			return false;
		}
		
		DataOutputStream outputStream = new DataOutputStream(
				new FileOutputStream(out));
		ArrayList<Character> list = new ArrayList<>(map.keySet());
		outputStream.writeInt(m.size());
		Iterator<Character> it = list.iterator();
		while(it.hasNext()){
			Character ch = (Character)it.next();
			outputStream.writeChar(ch);	
			outputStream.writeInt(map.get(ch).weight);
		}		
		outputStream.flush();
		outputStream.close();
		return true;	
	}
	
	public File getCompreesedIn() {
		return compreesedIn;
	}

	public void setCompreesedIn(File compreesedIn) throws Exception {
		DataInputStream test = new DataInputStream(new FileInputStream(compreesedIn));
		test.close();
		this.compreesedIn = compreesedIn;
	}

	public File getIn() {
		return in;
	}

	public void setIn(File in) throws FileNotFoundException{
		Scanner test = new Scanner(in);
		test.close();
		this.in = in;
	}

	public File getOut() {
		return out;
	}

	public void setOut(File out) throws Exception {
		DataOutputStream test = new DataOutputStream(new FileOutputStream(out));
		test.close();
		this.out = out;
	}
}

@SuppressWarnings("serial")
class NoWordException extends Exception{
	public String toString(){	
		return "The data is empty";		
	}
}