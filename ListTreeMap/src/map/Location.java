package map;

public class Location {
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private String pre;
	private String last;
	
	public Location(int x1,int y1 , int x2, int y2,String pre, String last) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.pre= pre;
		this.last = last;
	}
	
	public void changePre(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public void changeLast(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public String getPre() {
		return pre;
	}

	public String getLast() {
		return last;
	}
}
