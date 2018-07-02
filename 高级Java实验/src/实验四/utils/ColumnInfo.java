package 实验四.utils;

import java.lang.reflect.*;
import java.sql.Date;

import chapter4.question3.Constant;
import 实验四.other.EntityField;

import java.lang.annotation.*;

public class ColumnInfo {// 用于描述数据库表的字段信息（类中的属性信息）
	private String columnName;// 字段的名称
	private Class<?> type;// 字段类型
	private boolean isID = false;// 是否为主键
	private boolean nullable = true;// 是否为空
	private int length = 30;// 字段长度
	private boolean needKeep = true;// 是否保存
	private EntityField entityField = new EntityField();
	
	public EntityField getEntityField(){
		return entityField;
	}

	public ColumnInfo getColumnInfo(Field field) {
		columnName = field.getName();// 设置名字为属性名
		entityField.setFieldName(columnName);
		type = field.getType();// 类型为属性类型
		entityField.setType(type.getSimpleName());
		Annotation[] annotations = field.getAnnotations();// 得到此属性的全部注解
		for (Annotation annotation : annotations) {// 循环注解
			if (annotation.annotationType().equals(Column.class)) {// 如果此注解是Column型
				this.needKeep = true;// 故要保存
				Column column = (Column) annotation;
				if (!(column.value().equals(""))) {// 如果是有中文的注解就名字就用作中文
					columnName = column.value();
					entityField.setColumn(columnName);
				}
				if (column.nullable()) {// 当然判断是否保持
					this.needKeep = true;
				}
				if (column.length() != -1) {// 得到长度
					this.length = column.length();
				}
				if (column.nullable()) {
					this.nullable = false;
				}
			}
			if (annotation.annotationType().equals(ID.class)) {// 判断是否是主键
				this.needKeep = true;
				ID id = (ID) annotation;
				this.isID = true;
				entityField.setKey(true);
				if (!id.value().equals("")) {
					this.columnName = id.value();// 如果是则换成主键的名字
				}
			}
		}
		if (needKeep) {
			return this;// 返回这个对象
		} else {
			return null;
		}

	}

	@Override
	public String toString() {
		StringBuilder sql1 = new StringBuilder(columnName);
		if (this.type.equals(String.class)) {
			sql1.append(Constant.BLANK + "varchar(" + this.length + ")");
		} else if (this.type.equals(Integer.class)) {
			sql1.append(Constant.BLANK + "int");
		} else if(this.type.equals(Date.class)){
			sql1.append(Constant.BLANK + "date");
		} else if(this.type.equals(Short.class)){
			sql1.append(Constant.BLANK + "short");
		}
		if (this.isID) {
			sql1.append(Constant.BLANK + "primary key");
		}
		if (!this.nullable) {
			sql1.append(Constant.BLANK + "not null");
		}
		if (this.nullable) {
			sql1.append(Constant.BLANK + "null");
		}
		sql1.append(";");
		return sql1.toString();
	}
}
