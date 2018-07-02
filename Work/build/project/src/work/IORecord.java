package work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class IORecord {
	public final static int AllSize = 6;

	public static ArrayList<Model> readFile() {
		ArrayList<Model> allRecode = new ArrayList<>();
		ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(new File("d://cache.wt")));
			while(true){
				Model model = new Model();
				model.setMainConcent(reader.readUTF());
				model.serComeFromFile(reader.readUTF());
				model.setComeFromText(reader.readUTF());
				model.setData(reader.readUTF());
				model.setDepart(reader.readUTF());
				model.setSender(reader.readUTF());
				allRecode.add(model);
			}
		} catch (Exception e) {
		}
		return allRecode;
	}
	
	public static ObservableList<Model>  getRecoding( ObservableList<Model> observableList){
		if(observableList == null){
			return null;
		}
		observableList.clear();
		observableList.addAll(IORecord.readFile());
		return observableList;
	}
	
	public static boolean writeFile(ObservableList<Model> allRecode){
		if (allRecode == null || allRecode.size() == 0) {
			return false;
		}
		ArrayList<Model> arrayList = new ArrayList<Model>();
		for(int i= 0; i < allRecode.size(); i++){
			arrayList.add(allRecode.get(i));
		}
		return writeFile(arrayList);
	}

	public static boolean writeFile(ArrayList<Model> allRecode) {
		if (allRecode == null || allRecode.size() == 0) {
			return false;
		}
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(new File("d://cache.wt")));
			for (int i = 0; i < allRecode.size(); i++) {
				writer.writeUTF(allRecode.get(i).getMainConcent().getValue());
				writer.writeUTF(allRecode.get(i).getComeFromFile().getValue());
				writer.writeUTF(allRecode.get(i).getComeFromText().getValue());
				writer.writeUTF(allRecode.get(i).getData().getValue());
				writer.writeUTF(allRecode.get(i).getDepart().getValue());
				writer.writeUTF(allRecode.get(i).getSender().getValue());
			}
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
