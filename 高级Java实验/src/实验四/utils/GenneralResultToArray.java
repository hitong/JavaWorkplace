package 实验四.utils;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import 实验四.other.Entity;

import java.sql.Date;

public class GenneralResultToArray {
	@SuppressWarnings("deprecation")
	public static <T> ArrayList<T> change(Class<T> clazz, Entity entity, ResultSet resultSet) {
		ArrayList<T> arrayList = new ArrayList<>();
		try {
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int fieldSize = resultSetMetaData.getColumnCount();
			Method[] setMethod = new Method[fieldSize];

			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
				String methodName = null;
				for(int j = 0; j < entity.getFields().size(); j++){
					if(entity.getFields().get(j).getColumn().equals(resultSetMetaData.getColumnName(i + 1))){
						methodName = "set" + utils.StringUtils.upperCaseFirthLatter(entity.getFields().get(j).getFieldName());
					}
				}
				String methodType = utils.StringUtils.dbTypeTOJType(resultSetMetaData.getColumnTypeName(i + 1));
				setMethod[i] = clazz.getMethod(methodName, Class.forName(methodType));
			}
			
			while(resultSet.next()){
				T tmpt = clazz.newInstance();
				for(int j = 0; j < fieldSize; j++){
					try{
						setMethod[j].invoke(tmpt, resultSet.getString(j + 1));
					}catch(IllegalArgumentException e){
						try{
							setMethod[j].invoke(tmpt, Short.parseShort(resultSet.getString(j + 1)));
						}catch (IllegalArgumentException ex) {
							String tmp = resultSet.getString(j + 1);
							String[] t = tmp.split("-");
							int[] date = new int[3];
							for(int k = 0; k < 3; k++){
								date[k] = Integer.parseInt(t[k]);
							}
							setMethod[j].invoke(tmpt, new Date(date[0] - 1900,date[1],date[2]));
						}
					}
				}
				arrayList.add(tmpt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayList;
	}
}
