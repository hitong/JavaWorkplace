package chapter4.question3;

import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

import 实验四.utils.Column;
import 实验四.utils.Entity;
import 实验四.utils.ID;

public class TableSolution {

    Class<?> clazz;
    List<StringBuilder> imitateList = new ArrayList<StringBuilder>();//模拟表，存储输入存储信息********及更新，删除后的信息等
    Scanner write = new Scanner(System.in);
    StringBuilder tableInfo = new StringBuilder();//模拟表，存储一行的信息
    String tableName = "";

    public String getT(Class<?> clazz1) {//信息输入方法
        StringBuilder insertSql = new StringBuilder();//输入信息sql语方法
        insertSql.append("insert into ");
        this.clazz = clazz1;
        Annotation[] annotations1 = clazz.getAnnotations();
        for (Annotation annotation : annotations1) {
            if (annotation.annotationType().equals(Entity.class)) {//得到表名
                Entity entity = (Entity) annotation;
                insertSql.append(entity.value());//得到sql语句一部分
                tableName = entity.value();
            } else {
                insertSql.append(clazz.getSimpleName());//得到sql语句一部分
                tableName = clazz.getSimpleName();
            }
        }
        insertSql.append("(");
        //得到栏目名****
        Field[] fields = clazz.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            String value = "";//注解名变量
            boolean isID = false;//主键
            Annotation[] annotations = fields[j].getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                if (annotations[i].annotationType().equals(Column.class)) {
                    Column column = (Column) annotations[i];
                    if (!column.value().equals("")) {
                        value = column.value();
                    } else {
                    }
                }
                if ((annotations[i].annotationType().equals(ID.class))) {//如果是主键
                    isID = true;
                }
            }
            if (value.equals("")) {
                insertSql.append(fields[j].getName());//栏目名
                if (imitateList.isEmpty()) {
                    if (isID) {
                        tableInfo.append(fields[j].getName() + "(主键)    ");//得到行信息
                    } else {
                        tableInfo.append(fields[j].getName() + "    ");//得到行信息
                    }
                }
                if (j == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            } else {
                insertSql.append(value);//注解栏目名
                if (imitateList.isEmpty()) {
                    if (isID) {
                        tableInfo.append(value + "(主键)    ");//得到行信息
                    } else {
                        tableInfo.append(value + "    ");//得到行信息
                    }
                }
                if (j == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            }
        }
        if (imitateList.isEmpty()) {
            imitateList.add(tableInfo);
        }
        tableInfo = new StringBuilder();//接下来是装入具体信息
        insertSql.append(") ");
        insertSql.append("values(");
        //得到栏目名***
        System.out.println("请输入需要输入表的信息");
        for (int h = 0; h < fields.length; h++) {
            Annotation[] annotations = fields[h].getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                if (annotations[i].annotationType().equals(Column.class)) {
                    Column column = (Column) annotations[i];
                    if (!column.value().equals("")) {
                        System.out.print(column.value() + "输入:");
                    } else {
                        System.out.print(fields[h].getName() + "输入:");
                    }
                }
            }
            //输入信息
            if (fields[h].getType().equals(String.class)) {
                String string = write.next();
                insertSql.append("'" + string + "'");//输入信息
                tableInfo.append(string + "  ");//模拟表一行
                if (h == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            } else if (fields[h].getType().equals(Integer.class)) {//输入信息
                int int1 = write.nextInt();
                insertSql.append(int1);
                tableInfo.append(int1 + "  ");//模拟表一行
                if (h == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            } else if (fields[h].getType().equals(Double.class)) {//输入信息
                double double1 = write.nextDouble();
                insertSql.append(double1);
                tableInfo.append(double1 + "  ");//模拟表一行
                if (h == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            } else if (fields[h].getType().equals(boolean.class)) {//输入信息
                boolean boolean1 = write.nextBoolean();
                insertSql.append(boolean1);
                tableInfo.append(boolean1 + "  ");//模拟表一行
                if (h == fields.length - 1) {
                } else {
                    insertSql.append(",");
                }
            }
            //输入信息
        }
        imitateList.add(tableInfo);
        insertSql.append(")\n");
        return insertSql.toString();
    }

    public void getContents() {//得到模拟表中的全部信息
        System.out.println(imitateList.get(0).toString());
        for (int i = 1; i < imitateList.size(); i++) {
            System.out.println(imitateList.get(i).toString());
        }
    }

    public String delete(Class<?> clazz1) {//删除信息sql语句的方法
        this.clazz = clazz1;
        boolean isDelete = false;
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append("delete from ");
        Annotation[] annotations1 = clazz.getAnnotations();
        for (Annotation annotation : annotations1) {
            if (annotation.annotationType().equals(Entity.class)) {//得到表名
                Entity entity = (Entity) annotation;
                deleteSql.append(entity.value());//得到注解表名
            } else {
                deleteSql.append(clazz.getSimpleName());  //得到属性表名
            }
            System.out.println("表信息：");
            getContents();
            System.out.print("请输入主键的值:");
            String key = write.next();
            deleteSql.append(" where id='" + key + "'");
            for (int j = 1; j < imitateList.size(); j++) {
                String[] content = (imitateList.get(j).toString()).split("  ");
                System.out.println(imitateList.get(j).toString());
                for (int k = 0; k < content.length; k++) {
                    if (content[k].equals(key)) {
                        isDelete = true;
                    }
                }
                if (isDelete) {
                    imitateList.remove(j);
                    break;
                }
            }
            //备注得到表里面的内容
        }
        return deleteSql.toString();
    }

    public String update(Class<?> clazz1) {//更新信息sql语句的方法
        this.clazz = clazz1;
        boolean isUpdate = false;
        StringBuilder updateSql = new StringBuilder();
        updateSql.append("update ");
        Annotation[] annotations1 = clazz.getAnnotations();
        for (Annotation annotation : annotations1) {
            if (annotation.annotationType().equals(Entity.class)) {//得到表名
                Entity entity = (Entity) annotation;
                updateSql.append(entity.value());//得到注解表名
            } else {
                updateSql.append(clazz.getSimpleName());  //得到属性表名
            }
         }
            tableInfo = new StringBuilder();//接下来是装入具体信息
            updateSql.append(" set ");
            System.out.print("请输入主键的值或者其他栏目信息：");
            String key = write.next();
            Field[] fields = clazz.getDeclaredFields();
            for (int h = 0; h < fields.length; h++) {
                Annotation[] annotations = fields[h].getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    if (annotations[i].annotationType().equals(Column.class)) {
                        Column column = (Column) annotations[i];
                        if (!column.value().equals("")) {
                            System.out.print(column.value() + "输入:");
                            updateSql.append(column.value() + "=");//更新信息
                        } else {
                            System.out.print(fields[h].getName() + "输入:");
                            updateSql.append(fields[h].getName() + "=");//更新信息
                        }
                    }
                }
                //输入信息
                if (fields[h].getType().equals(String.class)) {
                    String string = write.next();
                    updateSql.append("'" + string + "'");//输入信息
                    tableInfo.append(string + "  ");//模拟表一行
                    if (h == fields.length - 1) {
                    } else {
                        updateSql.append(",");
                    }
                } else if (fields[h].getType().equals(Integer.class)) {//输入信息
                    int int1 = write.nextInt();
                    updateSql.append(int1);
                    tableInfo.append(int1 + "  ");//模拟表一行
                    if (h == fields.length - 1) {
                    } else {
                        updateSql.append(",");
                    }
                } else if (fields[h].getType().equals(Double.class)) {//输入信息
                    double double1 = write.nextDouble();
                    updateSql.append(double1);
                    tableInfo.append(double1 + "  ");//模拟表一行
                    if (h == fields.length - 1) {
                    } else {
                        updateSql.append(",");
                    }
                } else if (fields[h].getType().equals(boolean.class)) {//输入信息
                    boolean boolean1 = write.nextBoolean();
                    updateSql.append(boolean1);
                    tableInfo.append(boolean1 + "  ");//模拟表一行
                    if (h == fields.length - 1) {
                    } else {
                        updateSql.append(",");
                    }
                }
                //输入信息
            }
            System.out.println(tableInfo.toString());
            System.out.println(tableInfo.toString().length());
            for (int j = 1; j < imitateList.size(); j++) {
                String[] content = (imitateList.get(j).toString()).split("  ");
                for (int k = 0; k < content.length; k++) {
                    if (content[j].equals(key)) {
                        isUpdate = true;
                    }
                }
                if (isUpdate) {
                    imitateList.set(j, tableInfo);
                    break;
                }
            }
            updateSql.append(" where id='" + key + "'");//
            System.out.println(imitateList.get(imitateList.size()-1).toString().length());
            getContents();//备注得到表里面的内容
            return updateSql.toString();//返回修改sql语句
    }
}
