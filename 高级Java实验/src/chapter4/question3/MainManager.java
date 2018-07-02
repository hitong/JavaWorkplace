package chapter4.question3;
import java.util.*;

public class MainManager {
    public static void main(String[] args) {//主方法测试方法
      int isContinue;
      String isContinues;
      Scanner input=new Scanner(System.in);
      Class clazz=null;
      TableSolution test = new TableSolution();

      System.out.println("请输入一个类名：");
      String className=input.next();//得到类名
      String totalInfo="chapter4.question3"+"."+className;//类名全体信息

      try{
         clazz=Class.forName(totalInfo);//加载类
      }catch(Exception e){
         System.out.println("类加载错误！");
      }
      while(true){
          System.out.println("请输入信息>>");
          System.out.println("添加sql语言:\n" + test.getT(clazz));
          System.out.print("继续生成和创建？(1.退出 2.继续)：");
          isContinue=input.nextInt();
          if(isContinue==1){//退出输入循环
              break;
          }
      }   
      System.out.println("表信息：");
      test.getContents();//得到表信息
      System.out.println("");
      int select;
      while(true){
         System.out.print("表菜单：");
         System.out.println("1.生成录入sql信息：");
         System.out.println("\t2.生成删除sql信息：");
         System.out.println("\t3.生成修改sql信息：");
         System.out.println("\t4.退出：");
         System.out.print("请输入选择：");
         select=input.nextInt();
         if( select==1){
             System.out.println("添加sql语言:\n" + test.getT(clazz));
             System.out.println("表信息：");
             test.getContents();
             System.out.println();
         }else if(select==2){
             System.out.println("删除sql语言:\n" + test.delete(clazz));
             System.out.println("表信息：");
             test.getContents();
             System.out.println();
         }
         else if(select==3){
            System.out.println("更新sql语言:\n" + test.update(clazz));
            System.out.println("表信息：");
            test.getContents();
            System.out.println();
         }
         else if(select==4){
            break;
         }
      }
    }
}
