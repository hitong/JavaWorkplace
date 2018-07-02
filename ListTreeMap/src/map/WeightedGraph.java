package map;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph<E> extends AbstractGraph<E> {
	private List<PriorityQueue<WeightedEdge>> queues;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WeightedGraph(List<WeightedEdge> edges, List<E> vertices) {
		super((List) edges, vertices);
		createQueues(edges, vertices.size());
	}

	public WeightedGraph(int[][] edges, E[] vertices) {
		super(edges, vertices);
		createQueues(edges, vertices.length);
		// TODO Auto-generated constructor stub
	}

	public WeightedGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
		createQueues(edges, numberOfVertices);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WeightedGraph(List<WeightedEdge> edges, int numberOfVertices) {
		super((List) edges, numberOfVertices);
		createQueues(edges, numberOfVertices);
		// TODO Auto-generated constructor stub
	}

	private void createQueues(int[][] edges, int numberOfVertices) {
		queues = new ArrayList<PriorityQueue<WeightedEdge>>();
		for (int i = 0; i < numberOfVertices; i++) {
			queues.add(new PriorityQueue<WeightedEdge>());
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];
			queues.get(u).offer(new WeightedEdge(u, v, weight));
		}
	}

	private void createQueues(List<WeightedEdge> edges, int numberOfVertices) {
		queues = new ArrayList<PriorityQueue<WeightedEdge>>();

		for (int i = 0; i < numberOfVertices; i++) {
			queues.add(new PriorityQueue<WeightedEdge>());
		}

		for (WeightedEdge edge : edges) {
			queues.get(edge.u).offer(edge);
		}
	}

	public void printWeightedEdges() {
		for (int i = 0; i < queues.size(); i++) {
			System.out.print("Vertice " + i + ": ");
			for (WeightedEdge edge : queues.get(i)) {
				System.out.print("(" + edge.u + ", " + edge.v + ", " + edge.weight + ") ");
			}
			System.out.println();
		}
	}

	public MST getMnimumSpanningTree() {
		return getMnimumSpanningTree(0);
	}

	public MST getMnimumSpanningTree(int startingIndex) {
		List<Integer> T = new ArrayList<Integer>();
		T.add(startingIndex);

		int numberOfVertices = vertices.size();
		int[] parent = new int[numberOfVertices];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		int totalWeight = 0;

		List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);

		int err = 0;
		while (T.size() + err < numberOfVertices) {
			int v = -1;
			double smallestWeight = Double.MAX_VALUE;
			for (int u : T) {
				while (!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v)) {
					queues.get(u).remove();
				}

				if (queues.get(u).isEmpty()) {
					continue;
				}

				WeightedEdge edge = queues.get(u).peek();
				if (edge.weight < smallestWeight) {
					v = edge.v;
					smallestWeight = edge.weight;
					parent[v] = u;
				}
			}
			if(v == -1) {
				err++;
				continue;
			}
			T.add(v);
			totalWeight += smallestWeight;
		}

		return new MST(startingIndex, parent, T, totalWeight);
	}

	private List<PriorityQueue<WeightedEdge>> deepClone(List<PriorityQueue<WeightedEdge>> queues) {
		List<PriorityQueue<WeightedEdge>> copied = new ArrayList<PriorityQueue<WeightedEdge>>();
		for (int i = 0; i < queues.size(); i++) {
			copied.add(new PriorityQueue<WeightedEdge>());
			for (WeightedEdge edge : queues.get(i)) {
				copied.get(edge.u).add(edge);
			}
		}
		return copied;
	}

	public class MST extends Tree {
		private int totalWeight;

		public MST(int root, int[] parent, List<Integer> searchOrder, int totalWeight) {
			super(root, parent, searchOrder);
			this.totalWeight = totalWeight;
		}

		public int getTotalWeight() {
			return totalWeight;
		}
	}

	public ShortestPathTree getShortestPath(int sourceIndex) {
		List<Integer> T = new ArrayList<Integer>();
		T.add(sourceIndex);

		int numberOfVertices = vertices.size();

		int[] parent = new int[numberOfVertices];
		parent[sourceIndex] = -1;

		int[] costs = new int[numberOfVertices];
		for (int i = 0; i < costs.length; i++) {
			costs[i] = Integer.MAX_VALUE;
		}

		costs[sourceIndex] = 0;

		List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);
		int err = 0;// 记录孤立点的个数，下面while循环中，如果出现孤立点，将会导致v为-1从而导致数组异常
		while (T.size() + err < numberOfVertices) {
			int v = -1;
			int smallestCost = Integer.MAX_VALUE;
			for (int u : T) {
				while (!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v)) {
					queues.get(u).remove();
				}

				if (queues.get(u).isEmpty()) {
					continue;
				}

				WeightedEdge e = queues.get(u).peek();
				if (costs[u] + e.weight < smallestCost) {
					v = e.v;
					smallestCost = costs[u] + e.weight;
					parent[v] = u;
				}
			}
			try {
				costs[v] = smallestCost;
				T.add(v);
			} catch (ArrayIndexOutOfBoundsException ex) {
				err++;
			}
		}
		return new ShortestPathTree(sourceIndex, parent, T, costs);
	}

	public class ShortestPathTree extends Tree {
		private int[] costs;

		public ShortestPathTree(int root, int[] parent, List<Integer> searchOrder, int[] costs) {
			super(root, parent);
			this.costs = costs;
		}

		public int getCost(int v) {
			return costs[v];
		}

		public void printAllPaths() {
			System.out.println("All shortest paths from " + vertices.get(getRoot()) + " are:");
			for (int i = 0; i < costs.length; i++) {
				printPath(i);
				System.out.println("(cost: " + costs[i] + ")");
			}
		}
	}

	public List<PriorityQueue<WeightedEdge>> getWeightedEdges() {
		return queues;
	}
}
