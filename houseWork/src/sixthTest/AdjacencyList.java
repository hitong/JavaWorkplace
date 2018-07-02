package sixthTest;

import java.util.List;

public class AdjacencyList <V> extends AbstractGraph<V>{
	protected AdjacencyList(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
		// TODO Auto-generated constructor stub
	}

	protected AdjacencyList(int[][] edges, V[] vertices) {
		super(edges, vertices);
		// TODO Auto-generated constructor stub
	}
	
	protected AdjacencyList(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
		// TODO Auto-generated constructor stub
	}
}
