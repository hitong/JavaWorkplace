package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractGraph<V> implements Graph<V> {
	protected List<V> vertices;//元素点
	protected List<List<Integer>> neighbors;//邻接表中的邻居
	
	protected  AbstractGraph(int[][] edges, V[] vertices	){
		this.vertices = new ArrayList<V>();
		for(int i = 0; i < vertices.length; i++){
			this.vertices.add(vertices[i]);
		}
		
		createAdjacencyLists(edges, this.vertices.size());
	}
	
	protected AbstractGraph(List<Edge> edges, List<V> vertices){
		this.vertices = vertices;
		createAdjacencyLists(edges, vertices.size());
	}
	
	@SuppressWarnings("unchecked")
	protected AbstractGraph(List<Edge> edges, int numberOfVertices){
		vertices = new ArrayList<V>();
		for(int i = 0; i < numberOfVertices; i++){
			vertices.add((V)(new Integer(i)));
		}
		
		createAdjacencyLists(edges, numberOfVertices);
	}
	
	@SuppressWarnings("unchecked")
	protected AbstractGraph(int[][] edges, int numberOfVertices){
		vertices = new ArrayList<V>();
		for(int i = 0; i < numberOfVertices; i++){
			vertices.add((V)new Integer(i));
		}
		createAdjacencyLists(edges, numberOfVertices);
	}
	
	private void createAdjacencyLists(List<Edge> edges, int numberOfVertices) {
		// TODO Auto-generated method stub
		this.neighbors = new ArrayList<List<Integer>>();
		for(int i = 0; i < numberOfVertices; i++){
			this.neighbors.add(new ArrayList<Integer>());
		}

		for(Edge edge: edges){
			this.neighbors.get(edge.u).add(edge.v);
		}
	}
	
	private void createAdjacencyLists(int[][] edges, int numberOfVertices) {
		// TODO Auto-generated method stub
		neighbors = new ArrayList<>();
		for(int i = 0; i < numberOfVertices; i++){
			neighbors.add(new ArrayList<Integer>());
		}
		
		for(int i= 0; i < numberOfVertices; i++){
			int u = edges[i][0];
			int v = edges[i][1];
			neighbors.get(u).add(v);
		}	
	}
	
	public int getSize(){
		return this.vertices.size();
	}
	
	public List<V> getVertices(){
		return this.vertices;
	}
	
	public V getVertex(int index){
		return this.vertices.get(index);
	}
	
	public int getIndex(V v){
		return vertices.indexOf(v);
	}
	
	public List<Integer> getNeighbors(int index){
		return neighbors.get(index);
	}
	
	public int getDegree(int v){
		return neighbors.get(v).size();
	}
	
	public int[][] getAdjacencyMatrix(){
		int[][] adjacencyMatrix = new int[getSize()][getSize()];
		for(int i = 0; i <getSize(); i++	){
			for(int j = 0; j < this.neighbors.get(i).size(); j++){
				int v = this.neighbors.get(i).get(j);
				adjacencyMatrix[i][v] = 1;
			}
		}
		
		return adjacencyMatrix;
	}

	public void printAdjacencyMatrix(){
		int[][] adjacencyMatrix = this.getAdjacencyMatrix();
		for(int i = 0; i < adjacencyMatrix.length; i++){
			for(int j = 0; j < adjacencyMatrix[0].length; j++){
					System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printEdges(){
		for(int i = 0; i < this.neighbors.size(); i++){
			for(int j = 0; j < this.neighbors.get(i).size(); j++){
				System.out.print("(" + i + " , " + this.neighbors.get(i).get(j) + " )  ");
			}
			System.out.println();
		}
	}
	
	public Tree dfs(int v){
		List<Integer> searchOrder = new ArrayList<Integer>();
		
		int[]	 parent = new int[this.vertices.size()];
		for(int i = 0; i < parent.length; i++){
			parent[i] = -1;
		}
		
		boolean[] isVisited = new boolean[vertices.size()];
		
		dfs(v, parent, searchOrder, isVisited);
		
		return new Tree(v, parent, searchOrder);
	}
	
	private void dfs(int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
		isVisited[v] = true;
		searchOrder.add(v);
		
		for(int i : this.neighbors.get(v)){
			if(!isVisited[i]){
				parent[i] = v;
				dfs(i, parent, searchOrder, isVisited);		
			}
		}		
	}
	
	public boolean dfsNotRecForFindAPath(int a, int b){
		Stack<Integer> s = new Stack<>();
		boolean[] isVisited = new boolean[getSize()];
		for(int i = 0; i < getSize(); i++){
			isVisited[i] = false;
		}
		s.push(a);
		while(!s.isEmpty()){	
			int t = s.pop();
			if(isVisited[t]){
				continue;
			}
			isVisited[t] = true;
			System.out.print(t + " ");
			if(t == b){
				return true;
			}
			
			for(int i = 0; i < this.neighbors.get(t).size() ;i++){
				int tmp = this.neighbors.get(t).get(i);
				if(!isVisited[tmp]){
					s.push(tmp);
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 通过广度遍历生成树，传入V作为根节点
	 * 
	 */
	public Tree bfs(int v){
		List<Integer> searchOrder = new ArrayList<>();
		int[] parent = new int[vertices.size()];
		for(int i = 0; i < parent.length; i++){//所有节点访问重置
			parent[i] = -1;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[parent.length];
		isVisited[v] = true;
		queue.offer(v);
//		System.out.println(neighbors.get(63));

		while(!queue.isEmpty()){
			int u = queue.poll();
			searchOrder.add(u);
			for(int i: neighbors.get(u)){
				if(!isVisited[i]){
					queue.offer(i);
					parent[i] = u;
					isVisited[i] = true;
				}
			}
		}
		return new Tree(v, parent, searchOrder);
	}
	
	List<List<Integer>> list = new ArrayList<>();
	
	public List<List<Integer>> getConncetedComponents(){		
		for(int i = 0; i < getSize(); i++){
			int[] path = new int[Integer.MAX_VALUE % 50];
			int[] visited = new int[getSize()];
			DFSPath(i, i,path,-1,visited);
		}
		return list;
	}
	
	private void DFSPath(int u, int v, int[] path, int d, int[] visited){
		int w,i;
		visited[u] = 1;
		d++;
		path[d] = u;

		for(int j = 0; j < this.neighbors.get(u).size(); j++){
			w = this.neighbors.get(u).get(j);
			if(w == v && d > 1 && u >= v){
				 list.add(new ArrayList<Integer>());
				for( i = 0; i <= d; i++){
					list.get(list.size() - 1).add(path[i]);
				}
				
				list.get(list.size() - 1).add(v);
			}
			if (visited[w]==0){
				DFSPath(w, v, path, d,visited);
		     }
		}
		visited[u]=0;
	}
	
	public static class Edge {
		int u;
		int v;
		public  Edge(int u, int v){
			this.u = u;
			this.v = v;
		}
	}
	
	public class Tree {
		private int root;
		private int[] parent;
		private List<Integer> searchOrders;
		
		public Tree(int root, int[] parent, List<Integer> searchOrders){
			this.root = root;
			this.parent = parent;
			this.searchOrders = searchOrders;
		}
		
		public Tree(int root, int[] parent){
			this.root = root;
			this.parent = parent;
		}
		
		public int getRoot(){
			return root;
		}
		
		public int getParent(int v){
			return parent[v];
		}
		
		public List<Integer> getSearchOrders(){
			return this.searchOrders;
		}
		
		public int getNumberOfVerticesFound(){
			return searchOrders.size();
		}
		
		public List<V> getPath(int index){
			ArrayList<V> path = new ArrayList<>();
			
			do{
				path.add(vertices.get(index));
				index = parent[index];
			}while(index != -1);
			
			return path;
		}
		
		public void printPath(int index){
			List<V> path = getPath(index);
			
			System.out.print("A path from " + vertices.get(root) + " to " + vertices.get(index) + ": ");
			
			for(int i = path.size() - 1; i  >= 0; i--){
				System.out.print(path.get(i) + " ");
			}
		}
		
		public void printTree(){
			System.out.println("root is " + vertices.get(root));
			System.out.print("Edges: ");
			for(int i = 0; i < parent.length; i++){
				if(parent[i] != -1){
					System.out.print("("  + vertices.get(parent[i]) + "," + vertices.get(i) + ") ");
				}
			}
			System.out.println();
		}
	}
}
