package javaProForDateStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TestHuffmanCode {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		HuffmanTree tree = new HuffmanTree();
		while(true){
			MainUI();
			try{		
				int choise = input.nextInt();
				
				switch(choise){
					case 1:{
						System.out.println("请输入文件地址:");
						String f = input.next();
						System.err.println("正在读取文件...");
						readPlainFile(tree, f);
						System.err.println("读取完成");
						System.out.println("是否保存压缩该文件？(Y/N)");
						String c = input.next();
						if(c.charAt(0) != 'Y' && c.charAt(0) != 'y'){
							break;
						}
						System.out.println("请输入保存地址或者保存的名字");
						compressedFile(tree, input.next());
					};break;
					case 2:{
						System.out.println("请输入压缩文件的地址:");
						String f = input.next();
						System.err.println("正在读取压缩文件...");
						readCompressedFiles(tree, f);
						System.err.println("读取完成");
					
					}break;
					case 3:System.exit(0);
					default:{
						input.close();
						System.err.println("请输入正确的选项");
					}
				}
			}catch(InputMismatchException ex){
				System.err.println("输入有误");
				input.nextLine();
			}catch (FileNotFoundException ex){
				System.err.println("未找到指定文件");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	public static void MainUI(){
		System.out.println("1.读取普通文件");
		System.out.println("2.读取压缩文件");
		System.out.println("3.退出");
	}
	
	public static void readPlainFile(HuffmanTree tree, String f) throws FileNotFoundException{
		tree.setIn(new File(f));
		tree.clear();
		tree.readDateFromFile();
	//	System.err.println("正在打印文件对应的huffman编码...");
	//	tree.printHuffman();
	}
	
	public static void readCompressedFiles(HuffmanTree tree, String f) throws Exception{
		tree.clear();
		tree.setCompreesedIn(new File(f));
		StringBuilder s = tree.readCompressedFiles();
		System.out.println(s);
		System.out.println("正在打印文件对应的huffman编码...");
		tree.printHuffman();
	}
	
	public static void compressedFile(HuffmanTree tree, String f) throws Exception{
		tree.setOut(new File(f));			
		tree.saveCompressedFiles();
	}
}