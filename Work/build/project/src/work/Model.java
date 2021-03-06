package work;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model{
	private final StringProperty mainConcent;
	private final StringProperty comeFromText;
	private final StringProperty comeFromFile;
	private final StringProperty data;
	private final StringProperty depart;
	private final StringProperty sender;
	private boolean used = false;
	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public Model(){
		mainConcent = new SimpleStringProperty("");
		comeFromText = new SimpleStringProperty("");
		comeFromFile =  new SimpleStringProperty("");
		data =  new SimpleStringProperty("");
		depart =  new SimpleStringProperty("");
		sender =  new SimpleStringProperty("");
	}

	public Model(String mainConcent, String comeFromText, String comeFromFile, String data, String depart,
			String sender) {
		this.mainConcent = new SimpleStringProperty(mainConcent);
		this.comeFromText = new SimpleStringProperty(comeFromText);
		this.comeFromFile = new SimpleStringProperty(comeFromFile);
		this.data = new SimpleStringProperty(data);
		this.depart = new SimpleStringProperty(depart);
		this.sender = new SimpleStringProperty(sender);
	}

	public StringProperty getMainConcent() {
		return mainConcent;
	}

	public StringProperty getComeFromText() {
		return comeFromText;
	}

	public StringProperty getComeFromFile() {
		return comeFromFile;
	}

	public StringProperty getData() {
		return data;
	}

	public StringProperty getDepart() {
		return depart;
	}

	public StringProperty getSender() {
		return sender;
	}

	public void setMainConcent(String mainConcent) {
		this.mainConcent.set(mainConcent);
	}

	public void setData(String data) {
		this.data.set(data);
	}

	public void setSender(String sender) {
		this.sender.set(sender);
	}

	public void setComeFromText(String comeFromText) {
		this.comeFromText.set(comeFromText);
	}

	public void serComeFromFile(String comeFromFile) {
		this.comeFromFile.set(comeFromFile);
	}

	public void setDepart(String depart) {
		this.depart.set(depart);
	}
}
