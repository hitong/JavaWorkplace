package 实验四.other;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;

import 实验四.db.Person;
import 实验四.utils.RunSql;
import 实验四.utils.TableInfo;

public class BaseDao {
//	public final static HashMap<String, Entity> entities = new HashMap<String, Entity>();
//	static {
//		ArrayList<Entity> tmpArr = new ArrayList<Entity>();
//		try {
//			XmlReaderFromDB.readDB("src/实验四/db.xml", tmpArr);
//			for (Entity entity : tmpArr) {
//				entities.put(entity.getClassName(), entity);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}// 将数据库表信息加载进哈希表中

	public boolean deleteObj(Object obj) {
		if (utils.NullTest.isNull(obj)) {
			return false;
		}
		Entity entity = this.getEntity(obj);
		EntityField keyField = entity.getKeyFiled();
		boolean flag = false;
		try {
			Method method = obj.getClass()
					.getMethod("get" + utils.StringUtils.upperCaseFirthLatter(keyField.getFieldName()));
			String sql = "delete from " + entity.getTable() + " where " + keyField.getColumn() + "='"
					+ method.invoke(obj) + "'";
			System.out.println(sql);
			flag = RunSql.returnBool(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateObj(Object obj) {
		if (utils.NullTest.isNull(obj)) {
			return false;
		}
		Entity entity = this.getEntity(obj);
		EntityField keyField = entity.getKeyFiled();
		boolean flag = false;
		try {
			StringBuilder tmp = new StringBuilder();
			Method method;
			for (EntityField entityField : entity.getFields()) {
				method = obj.getClass()
						.getMethod("get" + utils.StringUtils.upperCaseFirthLatter(entityField.getFieldName()));
				tmp.append(entityField.getColumn() + " = " + "'" + method.invoke(obj) + "' ,");
				flag = true;
			}
			if (flag) {
				tmp.deleteCharAt(tmp.length() - 1);
			}
			method = obj.getClass().getMethod("get" + utils.StringUtils.upperCaseFirthLatter(keyField.getFieldName()));

			String sql = "update " + entity.getTable() + " set " + tmp + " where " + keyField.getColumn() + "='"
					+ method.invoke(obj) + "'";
			flag = RunSql.returnBool(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 添加对象信息进入数据库
	 * 
	 * @param obj
	 * @return
	 */
	public boolean addObj(Object obj) {
		if (utils.NullTest.isNull(obj)) {
			return false;
		}
		Entity entity = this.getEntity(obj);
		boolean flag = false;
		try {
			StringBuilder tmpValue = new StringBuilder("(");
			StringBuilder tmpColumn = new StringBuilder("(");
			Method method;
			for (EntityField entityField : entity.getFields()) {
				method = obj.getClass()
						.getMethod("get" + utils.StringUtils.upperCaseFirthLatter(entityField.getFieldName()));
				tmpValue.append("'" + method.invoke(obj) + "' ,");
				tmpColumn.append(entityField.getColumn() + " ,");
				flag = true;
			}
			if (flag) {
				tmpValue.deleteCharAt(tmpValue.length() - 1);
				tmpValue.append(")");
				tmpColumn.deleteCharAt(tmpColumn.length() - 1);
				tmpColumn.append(")");
			}
			String sql = "insert into " + entity.getTable() + tmpColumn + " values" + tmpValue;
			flag = RunSql.returnBool(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 判断该对象是否在对应的数据库中
	 * 
	 * @param obj
	 * @return
	 */
	public boolean selectObj(Object obj) {
		if (utils.NullTest.isNull(obj)) {
			return false;
		}
		Entity entity = this.getEntity(obj);
		EntityField keyField = entity.getKeyFiled();
		boolean flag = false;
		try {
			Method method = obj.getClass()
					.getMethod("get" + utils.StringUtils.upperCaseFirthLatter(keyField.getFieldName()));
			String sql = "select * from " + entity.getTable() + " where " + keyField.getColumn() + "='"
					+ method.invoke(obj) + "'";
			flag = RunSql.returnBool(sql);
			System.out.println(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Object> queryObj(Object obj, String sql) {
		if(utils.NullTest.isNull(obj) || utils.NullTest.isNull(sql)){
			return null;
		}
		Entity entity = getEntity(obj);
		return RunSql.returnArray(obj,entity,sql);
	}

	private Entity getEntity(Object obj) {
		TableInfo tableInfo = new TableInfo();
		tableInfo.getTableInfo(obj.getClass());
		Entity entity = tableInfo.getEntity();
		return entity;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		BaseDao bd = new BaseDao();
		Person person = new Person();
		person.setPersonId(System.currentTimeMillis() + "");
		person.setBirthday(new Date(2018-1900,10,1));
		person.setPersonName("Object加入");
		person.setSex((short) 1);
		ArrayList<Object> arrayList = bd.queryObj(person, "select * from person");
		for(int i = 0; i < arrayList.size(); i++){
			Person tmpPerson = (Person)bd.queryObj(person, "select * from person").get(i);
			System.out.println(tmpPerson.getPersonName());
		}
//		 System.out.println(bd.addObj(person));
//		 System.out.println(bd.selectObj(person));
//		 System.out.println(bd.deleteObj(person));
//		Animal animal = new Animal();
//		animal.setId(System.currentTimeMillis() + "");
//		animal.setBirthday(new Date(2011-1900,11,20));
//		animal.setType("食肉系");
//		System.out.println(bd.addObj(animal));
//		System.out.println(bd.selectObj(animal));
//		Animal tmpAnimal = (Animal)bd.queryObj(animal, "select * from animal").get(1);
//		System.out.println(tmpAnimal.getId());
	}
}
