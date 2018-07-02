package util;

import java.util.ArrayList;
import java.util.List;

public class NineTailModel {
	public static int ROW = 4;
	public static int COL = 4;
	public static int NUMBER_OF_NODES = (int)Math.pow(2,ROW * COL);
	public AbstractGraph<Integer>.Tree tree;

	/**
	 * 游戏规则核心方法
	 * @param node
	 * @param position
	 * @return
	 */
	public static int getFlippedNode(char[] node, int position) {
		int row = position / COL;
		int col = position % COL;

		flipACell(node, row, col);
		flipACell(node, row - 1, col);
		flipACell(node, row + 1, col);
		flipACell(node, row, col - 1);
		flipACell(node, row, col + 1);
		
//		flipACell(node, row +1 , col + 1);//补齐四角
//		flipACell(node, row -1 , col -1);
//		flipACell(node, row +1 , col - 1);
//		flipACell(node, row -1 , col + 1);
		return getIndex(node);
	}
	
	public NineTailModel() {
		List<AbstractGraph.Edge> edges = getEdges();
		UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(edges, NUMBER_OF_NODES);
		tree = graph.bfs(NUMBER_OF_NODES - 1);// 将终局设置为根节点
	}

	/**
	 * 初始化边集，将各个节点连接建模
	 * 
	 * @return
	 */
	private List<AbstractGraph.Edge> getEdges() {
		List<AbstractGraph.Edge> edges = new ArrayList<AbstractGraph.Edge>();
		int boxNum = getBoxsOfVertices();
		for (int u = 0; u < NUMBER_OF_NODES; u++) {
			for (int k = 0; k < boxNum; k++) {
				char[] node = getNode(u);
				if (node[k] == 'H') {// 每次都会将node操作改变node的状态
					int v = getFlippedNode(node, k);
					edges.add(new AbstractGraph.Edge(v, u));
				}
			}
		}
		return edges;
	}
	
	public static int getBoxsOfVertices() {
		return Integer.toBinaryString(NUMBER_OF_NODES - 1).length();
	}

	public static void flipACell(char[] node, int row, int col) {
		if (row >= 0 && row < ROW && col >= 0 && col < COL) {
			if (node[row * COL+ col] == 'H') {
				node[row * COL + col] = 'T';
			} else {
				node[row * COL + col] = 'H';
			}
		} else {

		}
	}

	/**
	 * 字符数组翻译成对应节点值
	 * 
	 * @param node
	 * @return
	 */
	public static int getIndex(char[] node) {
		int result = 0;
		for (int i = 0; i < getBoxsOfVertices(); i++) {
			if (node[i] == 'T') {
				result = result * 2 + 1;
			} else {
				result = result * 2 + 0;
			}
		}
		return result;
	}
	
	public static int getIndex(Character[] node) {
		char[] tmp = new char[node.length];
		for(int i = 0; i < node.length; i++) {
			tmp[i] = node[i];
		}
		return getIndex(tmp);
	}

	/**
	 * 节点值翻译成对应字符数组
	 * 
	 * @param index
	 * @return
	 */
	public static char[] getNode(int index) {
		int  boxNum = getBoxsOfVertices();
		char[] result = new char[boxNum];

		for (int i = 0; i < boxNum; i++) {
			int digit = index % 2;
			if (digit == 0) {
				result[boxNum - 1 - i] = 'H';///
			} else {
				result[boxNum - 1 - i] = 'T';
			}
			index = index / 2;
		}
		return result;
	}
	
	public static Character[] getNode2(int index) {
		int  boxNum = getBoxsOfVertices();
		Character[] result = new Character[boxNum];

		for (int i = 0; i < boxNum; i++) {
			int digit = index % 2;
			if (digit == 0) {
				result[boxNum - 1 - i] = 'H';
			} else {
				result[boxNum - 1 - i] = 'T';
			}
			index = index / 2;
		}
		return result;
	}


	/**
	 * 通过广度遍历生成的父节点前驱数组，访问生成最短路径
	 * 
	 * @param nodeIndex
	 * @return
	 */
	public List<Integer> getShortestPath(int nodeIndex) {
		return tree.getPath(nodeIndex);
	}
	
	public List<Integer> getShortestPathRandom(){
		return tree.getPath((int)(Math.random() * Integer.MAX_VALUE) % NUMBER_OF_NODES);
	}

	public static void printNode(char[] node) {
		for (int i = 0; i < getBoxsOfVertices(); i++) {
			if (i % COL != COL - 1) {
				System.out.print(node[i]);
			} else {
				System.out.println(node[i]);
			}
		}
		System.out.println();
		System.out.println();
	}
}
