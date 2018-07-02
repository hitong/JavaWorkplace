package 动态分配;

public class Depart {
	private int num;
	private int start;
	private int longth;
	private int status;

	public Depart(int num, int start, int longth, int status) {
		this.num = num;
		this.status = status;
		this.start = start;
		this.longth = longth;
	}
	
	public Depart(int longth, int status){
		this.status = status;
		this.longth = longth;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStart() {
		return start;
	}

	public int getLongth() {
		return longth;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setLongth(int longth) {
		this.longth = longth;
	}

	public String toString() {
		return "Num:" + num + "    Start:" + this.start + "    Longth: " + this.longth + "    Status: " + this.status;

	}
}
