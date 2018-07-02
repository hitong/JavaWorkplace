package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import map.AbstractGraph.Tree;
import map.WeightedGraph.ShortestPathTree;

public class MyMap {
	private WeightedGraph<Vertex> w;
	private List<WeightedEdge> edgeList = new ArrayList<>();
	private ArrayList<Vertex> vertexs = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MyMap map = new MyMap();
		int times = input.nextInt();
		for (int i = 0; i < times; i++) {
			map.addVertex(new Vertex(input.next(), input.nextInt(), input.nextInt()));
		}
		for (int i = 0; i < map.getVertexs().size(); i++) {
			int u = (int) (Math.random() * 100) % map.getVertexs().size();
			int v = (int) (Math.random() * 100) % map.getVertexs().size();
			if (u != v) {
				System.out.println(u + " " + v);
				map.addEdge(new WeightedEdge(u, v, (int) (Math.random() * 500)));
			}
		}
		map.w.printWeightedEdges();
		map.w.getShortestPath(0).printAllPaths();
		map.getBFS(1).printTree();
		map.getDFS(0).printTree();
		input.close();
	}

	public void printTree() {
		w.bfs(0).printTree();
		w.getMnimumSpanningTree(0).printTree();
	}

	public MyMap() {
	}
	
	public WeightedEdge getEdge(int u, int v) {
		for(int i = 0; i < edgeList.size(); i++) {
			if(edgeList.get(i).u == u && edgeList.get(i).v == v) {
				return edgeList.get(i);
			}
		}
		return null;
	}

	public void addVertex(Vertex vertex) {
		for (int i = 0; i < vertexs.size(); i++) {
			if (vertexs.get(i).equals(vertex)) {
				vertexs.set(i, vertex);
				for(int j = 0; j < edgeList.size(); j++) {
					if(edgeList.get(j).u == i) {
						edgeList.get(j).change(true, vertex);
					}
					if(edgeList.get(j).v == i){
						edgeList.get(j).change(false, vertex);
					}
				}
				buildeGraph();
				return;
			}
		}
		vertexs.add(vertex);
		buildeGraph();
	}

	public void addEdge(WeightedEdge edge) {
		if (edge.u >= this.w.getSize() || edge.v >= this.w.getSize() || edge.u < 0 || edge.v < 0) {
			return;
		}
		edge.setLocation(vertexs.get(edge.u), vertexs.get(edge.v));
		for (int i = 0; i < edgeList.size(); i++) {
			if (edgeList.get(i).equals(edge)) {
				edgeList.set(i, edge);
				buildeGraph();
				return;
			}
		}
		edgeList.add(edge);
		buildeGraph();
	}

	public List<Vertex> getVertexs() {
		return vertexs;
	}

	public List<WeightedEdge> getEdge() {
		return edgeList;
	}

	@SuppressWarnings("rawtypes")
	public Tree getDFS(int start) {
		return w.dfs(start);
	}

	@SuppressWarnings("rawtypes")
	public Tree getBFS(int start) {
		return w.bfs(start);
	}

	@SuppressWarnings("rawtypes")
	public ShortestPathTree getMST(int start) {
		return w.getShortestPath(start);
	}

	private void buildeGraph() {
		w = new WeightedGraph<>(edgeList, vertexs);
	}
}
