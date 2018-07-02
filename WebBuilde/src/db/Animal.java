package db;

import java.sql.Date;

public class Animal {
	private String type;
	private Date birthday;
	private String id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString(){
		return "id: " + id + "    " +
				"type:  " + type + "    " +
				"birthday:  " + birthday + "    ";
				
	}
}