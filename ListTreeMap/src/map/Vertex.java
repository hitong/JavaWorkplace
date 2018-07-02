package map;

public class Vertex {
		String name;
		int x;
		int y;

		public Vertex(String name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}

		public String toString() {
			return name;
		}
		
		public boolean equals(Vertex v) {
			return v.name.compareTo(this.name) == 0;
		}
	}