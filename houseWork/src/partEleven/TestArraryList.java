package partEleven;

import java.util.*;
public class TestArraryList {
	public static void main(String[] arge){
		ArrayList<String> cityList = new ArrayList<>();
		
		cityList.add("London");
		cityList.add("Denver");
		cityList.add("Paris");
		cityList.add("Miami");
		cityList.add("Seoul");
		cityList.add("Tokyo");
		
		System.out.println("List size? " + cityList.size());
		System.out.println("Is Miami in the list? " +
				cityList.contains("Miami"));
		System.out.println("The location of Denver is the list?" +
				 cityList.indexOf("Denver"));
		System.out.println("Is the list is empty? " + 
				cityList.isEmpty());
		
		cityList.add(2 , "Xian");
		
		cityList.remove("Miami");
		cityList.remove(1);
		
		System.out.println(cityList.toString());
		for (int i = cityList.size() - 1; i >= 0 ; i--){
			System.out.print(cityList.get(i) + " ");
		}
		System.out.println();
		
		ArrayList<CircleFromSimpleGeometricObject>	list =
				new ArrayList<>();
		
		list.add(new CircleFromSimpleGeometricObject(2));
		list.add(new CircleFromSimpleGeometricObject(3));
		
		System.out.println("The area of the circle?" +
				list.get(0).getArea());
		
	}
}
