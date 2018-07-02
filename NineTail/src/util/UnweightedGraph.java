package util;

import java.util.List;

public class UnweightedGraph<V> extends AbstractGraph<V>{
	public UnweightedGraph(int[][] edges, V[] vertices) {
		super(edges, vertices);
	}
	
	public UnweightedGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	
	public UnweightedGraph(List<AbstractGraph.Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
}
