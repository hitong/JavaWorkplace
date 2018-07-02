package javaProForDateStructure;

import java.util.ArrayList;
import java.util.List;

public class FarmerCrossingTheRiver {
	public final static int NUMBER_OF_NODES = 16;
	List<Edge> edge = new ArrayList<>();
	List<List<Integer>> verticese = new ArrayList<>();

	FarmerCrossingTheRiver() {
		edge = getEdges();
		createAdjacencyLists(getEdges());
	}

	/**
	 * 创建邻接线性表
	 * 
	 * @param edge
	 */
	void createAdjacencyLists(List<Edge> edge) {
		for (int i = 0; i < NUMBER_OF_NODES; i++) {
			verticese.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edge.size(); i++) {
			verticese.get(edge.get(i).start).add(edge.get(i).end);
		}
	}

	/**
	 * 初始化深度搜索条件，调用深度搜索方法
	 * 
	 * @param
	 * @return 返回路径数组
	 */
	public int[] dfs(int v) {
		int[] parent = new int[NUMBER_OF_NODES];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		boolean[] isVisited = new boolean[NUMBER_OF_NODES];
		if (dfs(v, parent, isVisited)) {
			return parent;
		} else {
			return null;
		}
	}

	/**
	 * 深度算法具体实现
	 * 
	 * @param v
	 * @param parent
	 * @param serchOrders
	 * @param isVisited
	 * @return
	 */
	private boolean dfs(int v, int[] parent, boolean[] isVisited) {
		isVisited[v] = true;

		/**
		 * 判断状态节点V，是否为不满足的六个状态 9,6 -> 菜，羊 在一边，狼，人在另一边 3,12 -> 羊，狼 在一边，人，菜在另一边 7,8 ->
		 * 羊，菜，狼在一边，人在另一边 可通过更改该条件，实现狼吃白菜等条件 例如删除v==9和v==6条件，即羊不在吃菜，可构成新的答案并返回路径
		 */
		if (v == 9 || v == 6 || v == 3 || v == 12 || v == 8 || v == 7) {
			return false;
		}

		/**
		 * 15状态表示1111，即所有都安全到达对岸
		 */
		if (v == 15) {
			return true;
		}

		for (int i : verticese.get(v)) {
			if (!isVisited[i]) {
				if (dfs(i, parent, isVisited)) {
					parent[v] = i;// 找寻到正确路径，通过前置保存
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 通过传入路径数组，打印路径
	 * 
	 * @param parent
	 */
	public void printPath(int[] parent) {
		int tmp = 0;
		int flag = 0;
		while (tmp != -1) {
			int t = getNode(tmp);
			ArrayList<String> south = new ArrayList<>();
			ArrayList<String> north = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					if (t % 10 == 0) {
						south.add("狼");
					} else {
						north.add("狼");
					}
					break;
				case 1:
					if (t % 10 == 0) {
						south.add("白菜");
					} else {
						north.add("白菜");
					}
					break;
				case 2:
					if (t % 10 == 0) {
						south.add("羊");
					} else {
						north.add("羊");
					}
					break;
				case 3:
					if (t % 10 == 0) {
						south.add("人");
					} else {
						north.add("人");
					}
					break;
				}
				t = t / 10;
			}
			tmp = parent[tmp];
			System.out.println("步骤" + flag++ + ":");
			System.out.println("南岸:" + south);
			System.out.println("北岸:" + north);
		}
		tmp = 0;
		while (parent[tmp] != -1) {
			System.out.println(getNode(tmp) + " -> " + getNode(parent[tmp]));
			System.out.println(translate(tmp, parent[tmp]));
			tmp = parent[tmp];
		}
	}

	/**
	 * 将节点翻译成英文字符串
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	private String translate(int o1, int o2) {
		int node = Math.abs(getNode(o1) - getNode(o2));
		String s = "";
		for (int i = 0; i < 4; i++) {
			int tmp = node % 10;
			node = node / 10;
			if (tmp == 1) {
				switch (i) {
				case 0:
					s = s + " Wolf";
					break;
				case 1:
					s = s + " Sheep";
					break;
				case 2:
					s = s + " Cabage";
					break;
				case 3:
					return s == "" ? "Only Farmer crossing river" : "Farmer take " + s + " crossing river";
				default:
					;
					return "err";
				}
			}
		}
		return "err";
	}

	/**
	 * 获得边集
	 * 
	 * @return
	 */
	List<Edge> getEdges() {
		List<Edge> list = new ArrayList<Edge>();

		// 每个节点对应四个新节点
		for (int i = 0; i < NUMBER_OF_NODES; i++) {
			for (int j = 0; j < 4; j++) {
				int node = getNode(i);
				if (canChange(node, j)) {
					if (j != 3) {
						node = change(node, 3);
					}
					node = change(node, j);
					int v = getFlippedNode(node);
					list.add(new Edge(i, v));
				}
			}
		}
		return list;
	}

	/**
	 * 判断是否能连接当前两点，例如：农夫在南岸，羊在北岸，不能够形成农夫和羊同时移动
	 * 
	 * @param node
	 * @param j
	 * @return
	 */
	boolean canChange(int node, int j) {
		int tmp1 = (int) Math.pow(10, j);
		int tmp2 = node / tmp1;
		tmp2 = tmp2 % 10;

		return tmp2 == node / 1000;
	}

	/**
	 * 切换当前当前状态
	 * 
	 * @param node
	 * @return
	 */
	int getFlippedNode(int node) {
		int[] tmp = new int[4];
		for (int i = 0; i < 4; i++) {
			tmp[i] = node % 10;
			node = node / 10;
		}

		return tmp[0] + tmp[1] * 2 + tmp[2] * 4 + tmp[3] * 8;
	}

	/**
	 * 通过接收的节点代码，和修改位置，更改指定位置状态并返回，如：1111，0 -> 1110
	 * 
	 * @param node
	 * @param i
	 * @return
	 */
	int change(int node, int i) {
		int tmp1 = (int) Math.pow(10, i);
		int tmp2 = node / tmp1;
		tmp2 = tmp2 % 10;
		if (tmp2 == 0) {
			return node = node + 1 * tmp1;
		} else {
			return node = node - 1 * tmp1;
		}
	}

	/**
	 * 通过指定下标，返回其相对应的节点代码，如：下标为15，返回整形代码，1111
	 * 
	 * @param i
	 * @return
	 */
	int getNode(int i) {
		int[] tmp = new int[4];
		int time = 0;
		while (i != 0) {
			tmp[time] = i % 2;
			i = i / 2;
			time++;
		}
		for (int j = time - 1; j >= 0; j--) {
			i = i * 10 + tmp[j];
		}

		return i;
	}

	/**
	 * 用于构造边集
	 * 
	 * @author Sun
	 *
	 */
	class Edge {
		int start = 0;
		int end = 0;

		Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		FarmerCrossingTheRiver f = new FarmerCrossingTheRiver();
		f.printPath(f.dfs(0));
	}
}