package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Count24 {
	private  List<String> answerList = new ArrayList<String>();
	private boolean version3 = false;
	private List<String> getAnswerList() {
		return answerList;
	}
	
	public void reSet() {
		answerList = new ArrayList<String>();
	}
	
	private class Data {
		private double[] arr;//这个数字既是用户输入的，也可以是两个或多个数运算得到的结果
		private String expStr = "";//将表达式单独提出，方便后续获取计算到具体位置的过程
		private String[] strs;//当这个数是用户输入的时候就是一个数字而已，当这个数字是运算的结果时就是算式

		private Data() {
		}

		private Data(int a, int b, int c, int d) {
			arr = new double[] { a, b, c, d };
			strs = new String[] { a + " ", b + " ", c + " ", d + " " };
			expStr = a + "";
		}

		private Data(int arr[]) {
			this.arr = new double[] { arr[0], arr[1], arr[2], arr[3] };
			this.strs = new String[] { arr[0] + " ", arr[1] + " ", arr[2] + " ", arr[3] + " " };
		}
	}

	private void count(Data data) throws Exception {
		double[] arr = data.arr;
		if (arr.length <= 1) {
			if (arr.length == 1 && arr[0] == 24) {
				answerList.add(data.expStr.substring(1, data.expStr.length() - 2));//去除最外层括号
				if(version3) {
					throw new Exception();
				}
			}
			return;
		}
		for (int i = 0, len = arr.length; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {//从前向后取两个数
				double x = arr[i];
				double y = arr[j];
				String xs = data.strs[i];
				String ys = data.strs[j];
				for (int k = 0; k < 4; k++) {
					Data tmp = getNewArr(data, i);
					switch (k) {
					case 0:
						tmp.arr[j - 1] = x + y;
						tmp.expStr = xs + "+ " + ys;
						break;
					case 1:
						tmp.arr[j - 1] = x - y;
						tmp.expStr = xs + "- " + ys;
						break;
					case 2:
						tmp.arr[j - 1] = x * y;
						tmp.expStr = xs + "* " + ys;
						break;
					case 3:
						if (y != 0) {
							tmp.arr[j - 1] = x / y;
							tmp.expStr = xs + "/ " + ys;
						} else {
							continue;
						}
						break;
					}
					tmp.expStr = "( " + tmp.expStr + ") ";
				 	tmp.strs[j - 1] = tmp.expStr;//保存j-1位置所经的算式
					count(tmp);
				}
			}
		}
	}

	private Data getNewArr(Data data, int i) {
		Data tmp = new Data();
		tmp.expStr = data.expStr;
		tmp.arr = new double[data.arr.length - 1];
		tmp.strs = new String[data.arr.length - 1];
		for (int m = 0, len = data.arr.length, n = 0; m < len; m++) {
			if (m != i) {
				tmp.arr[n] = data.arr[m];
				tmp.strs[n] = data.strs[m];
				n++;//记录新data数组下标，新data数组元素对应传入的data数组，i之后的元素都提前一位
			}
		}
		return tmp;
	}	
	private List<String> easyCount(int[] pick) throws Exception {
		this.reSet();
		int[] tmp = new int[4];
		for(int i = 0; i < 4; i++) {
			tmp[i] = pick[i] % 13; 
			if(tmp[i] == 0) {
				tmp[i] = 13;
			}
		}
		col(0,tmp);
		Set<String> set = new HashSet<String>(this.getAnswerList());
		return new ArrayList<String>(set);
	}
	
	private void col(int t,int[] arr) throws Exception {
		if (t >= 4) {
			this.count(new Data(arr));
			return;
		}
		for (int i = t; i < arr.length; i++) {
			ch(arr,i, t);
			col(t + 1,arr);
			ch(arr,i, t);
		}
	}
	
	private void ch(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public List<String> getSolutions(int[]	pick) throws Exception{
		this.reSet();
		return easyCount(pick);
	}
	
	public void setVersion3() {
		this.version3 = true;
	}
}
