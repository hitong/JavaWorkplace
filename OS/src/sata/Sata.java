package sata;

import java.util.Scanner;


public class Sata {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("磁盘个数为100个，起始盘号为0");
		while (true) {
			System.out.println("请选择磁盘调度算法：");
			System.out.println("1、先来先服务(手动)");
			System.out.println("2、先来先服务(自动)");
			System.out.println("3、最短寻道(手动)");
			System.out.println("4、最短寻道(自动)");
			switch (input.nextInt()) {
			case 1:userIn(input, 1);break;
			case 2:autoIn(2);break;
			case 3:userIn(input, 3);break;
			case 4:autoIn(4);break;
			default:
				System.out.println("输入有错误");
			}
		}
	}

	public static void userIn(Scanner input, int c) {
		System.out.println("请输入磁头起始位置：");
		int start = input.nextInt();
		System.out.println("请输入你需要输入的序列个数：");
		int len = input.nextInt();
		int[] arr = new int[len];
		for (int i = 1; i <= len; i++) {
			System.out.print("第" + i + "个数据:");
			arr[i - 1] = input.nextInt();
		}
		System.out.println("磁头起始位置为：" + start);
		System.out.println("请求序列为：");
		pArr(arr);
		if (c == 1) {
			fcfs(start, arr);
		} else if(c == 3){
			sstf(start, arr);
		}
	}
	
	public static void autoIn(int c){
		int start = (int)(Math.random() * 10000) % 100;
		int len = (int)(Math.random() * 10000) % 10 + 5;
		int[] arr = new int[len];
		for (int i = 1; i <= len; i++) {
			arr[i - 1] = (int)(Math.random() * 100000) % 100;
		}
		System.out.println("磁头起始位置为：" + start);
		System.out.println("请求序列为：" );
		pArr(arr);
		if (c == 2) {
			fcfs(start, arr);
		} else if(c == 4){
			sstf(start, arr);
		}
	}

	public static void fcfs(int start, int[] arr) {
		double avgLen = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > start) {
				avgLen += arr[i] - start;
			} else {
				avgLen += start - arr[i];
			}
			start = arr[i];
		}
		System.out.println("访问序列为：" );
		pArr(arr);
		System.out.println("平均寻道长度:  " + avgLen / arr.length);
	}

	public static void sstf(int start, int[] arr) {
		int save = start;
		int max = Integer.MAX_VALUE;
		int si = -1;
		int[] tmp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != -1) {
					if (Math.abs(max - start) > Math.abs(arr[j] - start)) {
						max = arr[j];
						si = j;
					}
				}
			}
			tmp[i] = max;
			start = tmp[i];
			max = Integer.MAX_VALUE;
			arr[si] = -1;
		}
		arr = tmp;
		fcfs(save, arr);
	}
	
	public static void pArr(int[] arr){
		for(int i: arr){
			System.out.print(i + "、");
		};
		System.out.println();
	}
}
