package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Code {
	private final StringProperty ch;
	private final StringProperty code;
	private final IntegerProperty weight;
	
	public Code() {
		this(null, null, null);
	}
	
	public Code(String ch, Integer weight, String code) {
		this.ch = new SimpleStringProperty(ch);
		this.weight = new SimpleIntegerProperty(weight);
		this.code = new SimpleStringProperty(code);
	}

	public String getCh() {
		return ch.getValue();
	}
	
	public String getCode() {
		return ch.getValue();
	}
	
	public Integer getWeight() {
		return weight.getValue();
	}
	
	public void setWeight(Integer weight) {
		this.weight.set(weight);
	}
	
	public void setCh(String ch) {
		this.ch.set(ch);
	}
	
	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty chProperty() {
		return ch;
	}

	public StringProperty codeProperty() {
		return code;
	}

	public IntegerProperty weightProperty() {
		return weight;
	}
}
