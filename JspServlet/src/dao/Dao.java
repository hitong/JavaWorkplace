package dao;  
  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.JDBCConnection;
import util.SplitPage;
import been.Admin;
import been.Book;
import been.User;
  
public class Dao {  
	public static void addUser(User user) throws SQLException{	
		String sql="INSERT INTO \"public\".\"book_user\" (\"user_name\", "
				+ "\"user_password\", \"user_sex\", \"user_birth\", "
				+ "\"user_realname\", \"user_ad\", \"user_num\", "
				+ "\"user_tel\", \"user_mon\") VALUES ("
				+ "'" + user.getName() + "', '" + user.getPassWord() + "', '"
				+ user.getSex() + "','" + user.getBirth()+ "'"
				+ ", '" + user.getRealName() + "', '" + user.getAd()
				+ "', '" + user.getNum() + "', '" + user.getTel() + "', '" + user.getMonney()+ "')";
		JDBCConnection.operater(sql);
	}
	
	public static LinkedList<Book> searchBook(String search,String type){
		List<Book> list = Dao.getBookList();
		Iterator<Book> it = list.iterator();
		LinkedList<Book> s = new LinkedList<>();
		while(it.hasNext()){
			Book tmp = it.next();
			if(tmp.getName().contains(search) && tmp.getType().contains(type)){
				s.push(tmp);
				continue;
			}
		}
		return s;
	}
	
	public static Stack<User> searchUser(String search){
		List<User> list = Dao.getUserList();
		Iterator<User> it = list.iterator();
		Stack<User> s = new Stack<>();
		while(it.hasNext()){
			User tmp = it.next();
			if(tmp.getName().contains(search)){
				s.push(tmp);
				continue;
			}
		}
		return s;
	}
	
	public static LinkedList<Book> getBookList(){
		return JDBCConnection.getBookList();
	}
	
	public static LinkedList<User> getUserList(){
		return JDBCConnection.getUserList();
	}
	
	public static HashMap<String,User> getUserMap(){
		return JDBCConnection.getUserMap();
	}
	
	public static HashMap<String,Admin> getAdminMap(){
		return JDBCConnection.getAdminMap();
	}
	
	public static HashMap<String, Book> getBookMap(){
		return JDBCConnection.getBookMap();
	}
	
	public static void delUser(String del) throws SQLException{
		String sql = "DELETE from public.book_user WHERE user_name = '" + del +"'";
		JDBCConnection.operater(sql);
	}
	
	public static void updateUser(User user) throws SQLException{
		String sql = "UPDATE public.book_user SET "
				+ "user_password = '" + user.getPassWord() +"', " 
				+ "user_sex = '" + user.getSex() + "', " 
				+ "user_birth = '" + user.getBirth() + "', "
				+ "user_realName = '" + user.getRealName() + "', "
				+ "user_ad = '" + user.getAd() + "' ,"
				+ "user_num = '" + user.getNum() + "' ,"
				+ "user_tel = '" + user.getTel() + "' ," 
				+ "user_mon = '" + user.getMonney() + "' "
				+ "WHERE user_name = '" + user.getName() + "'";
		JDBCConnection.operater(sql);
	}
	
	public static void addBook(Book book) throws SQLException{
		String sql = "INSERT INTO \"public\".\"book\" "
				+ "(\"isbn\", \"name\", \"editor\", \"price\", \"img\", "
				+ "\"pub\", \"message\", \"stock\", \"type\")"
				+ "VALUES ("
				+ "'" + book.getISBN() + "', '" + book.getName() + "'"
				+ ", '" + book.getEditor() + "'"
				+ ", '" + book.getPrice() + "','" + book.getImg() + "'"
				+ ", '" + book.getPub() + "', '" + book.getMessage() + "', '" 
										+ book.getStock() + "','" + book.getType() + "')";
		JDBCConnection.operater(sql);
	}
	
	public static void updateBook(Book book) throws SQLException{
		String sql = "UPDATE public.book SET " +
				"name = '" + book.getName() + "', " + "editor = '" + book.getEditor() + "', " +
				"price = '" + book.getPrice() + "'," + "img = '" + book.getImg() + "'," +
				"pub = '" + book.getPub() + "'," + "message = '" + book.getMessage() + "'," +
				"stock = '" + book.getStock() + "'," + "type = '" + book.getType() + "' " +
				" WHERE isbn = '" + book.getISBN() + "'";
		JDBCConnection.operater(sql);	
	}
	
	public static void delBook(String del) throws SQLException{
		String sql = "DELETE FROM public.book WHERE isbn = '" + del +"'";
		JDBCConnection.operater(sql);
	}
	
	public static List<Book> findAllBook(SplitPage sp) {
		HashMap<String, Book> map = Dao.getBookMap();
		List<Book> list = new ArrayList<>(map.values());
		try {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					sp.getPageRows() * sp.getCurrentPage());
		} catch (IndexOutOfBoundsException ex) {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					list.size());
		}
		
		return list;
	}
	
	public static List<Book> findAllBook(String choise, SplitPage sp){
		HashMap<String, Book> map = Dao.getBookMap();
		List<Book> list = new ArrayList<>(map.values());
		if(choise.compareTo("全部分类") != 0){
			for(int i = 0 ; i < list.size();i++){
				if(list.get(i).getType().compareTo(choise)!=0){
					list.remove(i);
					i--;
				}
			}
		}
	
		try {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					sp.getPageRows() * sp.getCurrentPage());

		} catch (IndexOutOfBoundsException ex) {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					list.size());
		}
		
		return list;
	}
	
	public static List<User> findAllUser(SplitPage sp) {
		HashMap<String, User> map = Dao.getUserMap();
		List<User> list = new ArrayList<>(map.values());
		try {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					sp.getPageRows() * sp.getCurrentPage());

		} catch (IndexOutOfBoundsException ex) {
			list = list.subList((sp.getCurrentPage() - 1) * sp.getPageRows(),
					list.size());
		}
		return list;
	}
	
	public static int getUserPage(){
		HashMap<String, User> map = Dao.getUserMap();
		boolean flag = (map.size() % 10 == 0);
		if(map.size() > 0){
			if(flag){
				return map.size() / 10;
			}
			else{
				return map.size() / 10 + 1;
			}
		}
		else{
			return -1;
		}
	}
	
	public static int getBookPage(){
		HashMap<String, Book> map = Dao.getBookMap();
		boolean flag = (map.size() % 10 == 0);
		if(map.size() > 0){
			if(flag){
				return map.size() / 10;
			}
			else{
				return map.size() / 10 + 1;
			}
		}
		else{
			return -1;
		}
	}
	
	public static void main(String[] args) throws SQLException{	
		List<User> li = Dao.searchUser("  ");
		for(User b: li){
			System.out.println(b.getName());
		}
		
		/*
		String test = "123";
		try {
			Dao.delBook(test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
} 