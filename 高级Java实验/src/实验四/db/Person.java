package 实验四.db;

import java.sql.Date;

import 实验四.utils.Column;
import 实验四.utils.Entity;
import 实验四.utils.ID;

@Entity("person")
public class Person {
	@ID
	@Column(length = 15,value = "PersonId",nullable=false)
	private String personId;
	
	@Column(length = 15,value = "Name",nullable=true)
	private String personName;
	
	@Column(value = "Birthday",nullable=true)
	private Date birthday;
	
	@Column(value = "Sex",nullable=true)
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
