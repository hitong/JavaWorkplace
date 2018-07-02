package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import been.Admin;
import been.Book;
import been.User;

public class JDBCConnection {
	public static void operater(String sql) throws SQLException{
		Connection connection=null;
		Statement statement =null;
		
        try{
        	connection = getConnection();
            statement= connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
	
	public static  Connection getConnection(){
		Connection connection=null;
        try{
            String url="jdbc:postgresql://127.0.0.1:5432/shop";
            String user="postgres";
            String password = "1906194855";
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return connection;
	}
	
	public static void close(ResultSet rs,Statement st,Connection conn){
        try {
               if(rs!=null) rs.close();
               if(st!=null) st.close();
               if(conn!=null){
                      if(!conn.isClosed()){
                             conn.close();
                      }
               }
        } catch (Exception e) {
               e.printStackTrace();
        }
	}
	
	public static HashMap<String, Book> getBookMap(){
		Connection connection=null;
        Statement statement =null;
        HashMap<String, Book> map = new HashMap<>();
        try{
            connection= getConnection();
            String sql="SELECT * FROM book";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           
            while(resultSet.next()){
            	Book tmp = new Book();
            	tmp.setISBN(resultSet.getString("ISBN"));
            	tmp.setName(resultSet.getString("name"));
            	tmp.setEditor(resultSet.getString("editor"));
            	tmp.setPrice(resultSet.getString("price"));
            	tmp.setImg(resultSet.getString("img"));
            	tmp.setPub(resultSet.getString("pub"));
            	tmp.setMessage(resultSet.getString("message"));
            	tmp.setStock(resultSet.getString("stock"));
            	tmp.setType(resultSet.getString("type"));
                map.put(resultSet.getString("ISBN"), tmp);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return map;
	}
	
	public static LinkedList<Book> getBookList(){
		Connection connection=null;
        Statement statement =null;
        LinkedList<Book> list = new LinkedList<>();
        try{
            connection = getConnection();
            String sql="SELECT * FROM book";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           
            while(resultSet.next()){
            	Book tmp = new Book();
            	tmp.setISBN(resultSet.getString("ISBN"));
            	tmp.setName(resultSet.getString("name"));
            	tmp.setEditor(resultSet.getString("editor"));
            	tmp.setPrice(resultSet.getString("price"));
            	tmp.setImg(resultSet.getString("img"));
            	tmp.setPub(resultSet.getString("pub"));
            	tmp.setMessage(resultSet.getString("message"));
            	tmp.setStock(resultSet.getString("stock"));
            	tmp.setType(resultSet.getString("type"));
                list.add(tmp);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
	}
	
	public static LinkedList<User> getUserList(){
		Connection connection=null;
        Statement statement =null;
        LinkedList<User> list = new LinkedList<>();
        try{
            connection = getConnection();
            String sql="SELECT * FROM book_user";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           
            while(resultSet.next()){
            	User tmp = new User();
            	tmp.setName(resultSet.getString("user_name"));
        		tmp.setPassWord(resultSet.getString("user_password"));
        		tmp.setSex(resultSet.getString("user_sex"));
        		tmp.setBirth(resultSet.getString("user_birth"));
        		tmp.setTel(resultSet.getString("user_tel"));
        		tmp.setRealName(resultSet.getString("user_realname"));
        		tmp.setAd(resultSet.getString("user_ad"));
        		tmp.setMonney(resultSet.getString("user_mon"));
        		tmp.setNum(Integer.parseInt(resultSet.getString("user_num")));
                list.add(tmp);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
	}
	
	public static HashMap<String, User> getUserMap(){
		Connection connection=null;
        Statement statement =null;
        HashMap<String, User> map = new HashMap<>();
        try{
            connection = getConnection();
            String sql="SELECT * FROM book_user";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           
            while(resultSet.next()){
            	User tmp = new User();
            	tmp.setName(resultSet.getString("user_name"));
        		tmp.setPassWord(resultSet.getString("user_password"));
        		tmp.setSex(resultSet.getString("user_sex"));
        		tmp.setBirth(resultSet.getString("user_birth"));
        		tmp.setTel(resultSet.getString("user_tel"));
        		tmp.setRealName(resultSet.getString("user_realname"));
        		tmp.setAd(resultSet.getString("user_ad"));
        		tmp.setMonney(resultSet.getString("user_mon"));
        		tmp.setNum(Integer.parseInt(resultSet.getString("user_num")));
                map.put(resultSet.getString(1), tmp);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return map;
	}
	
	public static HashMap<String, Admin> getAdminMap() {
		Connection connection=null;
        Statement statement =null;
        HashMap<String, Admin> map = new HashMap<>();
        try{
            connection= getConnection();
            String sql="SELECT * FROM book_admin";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           
            while(resultSet.next()){
            	Admin tmp = new Admin();
            	tmp.setName(resultSet.getString("name"));
        		tmp.setPassword(resultSet.getString("password"));
        		map.put(tmp.getName(), tmp);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return map;
	}
	
	public static void main(String[] args){
		HashMap<String, Admin> hash = JDBCConnection.getAdminMap();
		Set<String> set = hash.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(hash.get(it.next()).getName());
		}
	}
}
