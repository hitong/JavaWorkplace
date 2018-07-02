package sixthTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sixthTest.AbstractGraph.Edge;

public class TestAdjacencyList {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入端点数目(非零自然数):")	;
		int numberOfVertices = input.nextInt() ;//端点数
		System.out.println("请输入稠密程度(0-1的小数，数值越小，稠密程度越大):")	;
		double thin = input.nextDouble();//稀疏程度
		
		ArrayList<Edge> edges = new ArrayList<>();

		for(int i = 0; i < numberOfVertices; i ++){
			for(int j = 0; j < numberOfVertices; j++){
				if(Math.random() > thin && i != j){
					edges.add(new Edge(i, j));
				}
			}
		}
		
		AdjacencyList<String> adj = new AdjacencyList<>(edges, numberOfVertices);
		adj.printEdges();
//		adj.bfs(0).printTree();
//		adj.dfs(0).printTree();
		adj.printAdjacencyMatrix();
	
		System.out.println("正在统计环路个数及路径...");
		List<List<Integer>> list = adj.getConncetedComponents();
		System.out.println("共有" + list.size() + "个环状");
		if(list.size() > 100){
			System.out.println("当前环状数目过多,如需展示路径，请将稠密值调低");
		}
		else{
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
		}
		
		System.out.println("输入整数数对，判断是否相通");
		while(true){
			int a = input.nextInt();
			int b = input.nextInt();
			System.out.println(adj.dfsNotRecForFindAPath(a,b));
		}
	}
}
