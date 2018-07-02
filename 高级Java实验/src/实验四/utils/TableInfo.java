package 实验四.utils;

import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

import chapter4.question3.Constant;
import chapter4.question3.People;

public class TableInfo {
	private String tableName;// 得到表名
	private Class<?> clazz;// 需要生成表的类
	private boolean needKeep;// 是否保存
	Map<String, ColumnInfo> columns = new HashMap<String, ColumnInfo>();// 装信息
	实验四.other.Entity entity = new 实验四.other.Entity();

	public TableInfo getTableInfo(Class<?> clazz1) {
		this.clazz = clazz1;
		tableName = clazz.getSimpleName();// 得到名字（及表名）
		entity.setClassName(clazz1.getName());
		entity.setTable(tableName);
		Annotation[] annotations = clazz.getAnnotations();// 得到注解
		for (Annotation annotation : annotations) {

			if (annotation.annotationType().equals(Entity.class)) {// 如果是entity注解就表示需要保存

				needKeep = true;
				Entity entity = (Entity) annotation;
				if (!entity.value().equals("")) {
					tableName = entity.value();// 得到注解名字
				}
				break;
			}
		}
		if (needKeep) {
			Field[] fields = clazz.getDeclaredFields();/// 得到类的属性数组
			for (Field field : fields) {
				ColumnInfo columnInfo = new ColumnInfo();
				columnInfo = columnInfo.getColumnInfo(field);// 得到表示属性的表部分
				entity.getFields().add(columnInfo.getEntityField());
				if (columnInfo != null) {
					this.columns.put(field.getName(), columnInfo);// 装入信息
				}
			}
			return this;// 返回此对象
		} else {
			return null;
		}
	}

	public 实验四.other.Entity getEntity() {
		return this.entity;
	}

	@Override
	public String toString() {// 生成创建表的sql语句
		StringBuilder sql = new StringBuilder();
		sql.append(Constant.NEXTLINE);
		sql.append("create table ");
		sql.append(this.tableName + " (" + "");
		for (ColumnInfo column : this.columns.values()) {
			sql.append(Constant.NEXTLINE);
			sql.append(Constant.TAB);
			sql.append(column.toString());
		}
		sql.append("\n");
		sql.append(");");
		return sql.toString();
	}

	public static void main(String args[]) {
		TableInfo test = new TableInfo();
		test.getTableInfo(People.class);
		System.out.println(test.toString());

	}
}
