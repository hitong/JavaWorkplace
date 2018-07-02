package db;

import java.sql.Date;

public class Person {
	private String personId;
	private String personName;
	private Date birthday;
	private Short sex=0;  //男 = 1； 女 = 0
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthDay) {
		this.birthday = birthDay;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
    
	public String toString(){
		return "personId:  " + personId + "     " + 
				"personName:  " + personName + "    " +
				"birthday:  " + birthday + "    " +
				"sex:  " +( sex ==0?"女":"男");
	}
}
