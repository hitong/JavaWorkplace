package work;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;

public class Change {
	public static ArrayList<StringProperty> modelToArr(Model model){
		 ArrayList<StringProperty> tmp = new ArrayList<>();
		 tmp.add(model.getMainConcent());
		 tmp.add(model.getComeFromText());
		 tmp.add(model.getComeFromFile());
		 tmp.add(model.getData());
		 tmp.add(model.getDepart());
		 tmp.add(model.getSender());
		 return tmp;
	}
	
	public static Model arrToModel(ArrayList<String> arr) {
		Model model = new Model(arr.get(0),arr.get(1),arr.get(2),arr.get(3),arr.get(4),arr.get(5));
		 return model;
	}
}
