package partThirteen;

import java.util.*;
public class House implements Cloneable , Comparable<House>{
	private int id ;
	private double area;
	private Date whenBuilt;
	
	public House(int id , double area){
		this.id = id;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public double getArea() {
		return area;
	}

	public Date getWhenBuilt() {
		return whenBuilt;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public int compareTo(House o){
		if(area > o.area)
			return 1;
		else if(area == o.area)
			return 0;
		else 
			return -1;
	}
}
