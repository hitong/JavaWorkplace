package work;

import java.util.ArrayList;

public class Search {
	public static ArrayList<Model> search(ArrayList<Model> saveDataFromFile, String terget, int[] choise){
		ArrayList<Model> tmp = new ArrayList<>();
		
		for(int i = 0; i < saveDataFromFile.size(); i++) {
			boolean flag = false;
			for(int j = 0; j < choise.length; j++) {
				if(MySwitch.mySwitch(saveDataFromFile.get(i) , choise[j]).contains(terget)){
					flag = true;
					break;
				}
			}
			if(flag) {
				tmp.add(saveDataFromFile.get(i));
			}
		}
		return tmp;
	}
}
