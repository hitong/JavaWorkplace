package dbService;

import java.util.ArrayList;

import db.Person;
import other.GenneralBaseDao;

public class PersonService {
   private GenneralBaseDao<Person> bd = new GenneralBaseDao<Person>();
   private static PersonService personService = new PersonService();
   
   private PersonService(){
   }
   
   public static PersonService getInstanse(){
	   return personService;
   }
   
   public boolean deletePerson(Person person){
	   return bd.deleteObj(person);
   }
   
   public boolean addPerson(Person person){
	   return bd.addObj(person);
   }
   
   public boolean updatePerson(Person person){
	   return bd.updateObj(person);
   }
   
   public boolean selectPerson(Person person){
	   return bd.selectObj(person);
   }
   
   public ArrayList<Person> queryPerson(String sql){
	   return bd.queryObj(new Person(),sql);
   }
   
   public Person searchPerson(String personId){
	   ArrayList<Person> arrayList =  queryPerson("select * from person where PersonId = '" + personId + "'");
	   if(arrayList != null && arrayList.size() == 1){
		   return arrayList.get(0);
	   } else {
		   return null;
	   }
   }
}
