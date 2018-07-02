package map;

public class WeightedEdge extends AbstractGraph.Edge implements Comparable<WeightedEdge> {
	public  int weight;
	private Location l;

	public WeightedEdge(int u, int v, int weight) {
		super(u, v);

		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setLocation(Vertex u, Vertex v) {
		l = new Location(u.getX(),u.getY(),v.getX(),v.getY(),u.name,v.name);
	}
	
	public void change(boolean flag, Vertex v) {
		if(flag) {
			l.changePre(v.x,v.y);
		} else {
			l.changeLast(v.x,v.y);
		}
	}
	
	public Location getLocation() {
		return l;
	}
	
	@Override
	public int compareTo(WeightedEdge o) {
		// TODO Auto-generated method stub
		if(o.weight > this.weight ) {
			return -1;
		} else if(o.weight == this.weight) {
			return 0;
		} else {
			return 1;
		}
	}
}