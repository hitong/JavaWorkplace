package Test;

import java.sql.*;

public class JDBC_Test {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/SCDB";
		String user = "root";
		String password = "w1906194855";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement = conn.createStatement();
			String sql = "select * from S";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getString("Sno") + "  ");
				System.out.println(rs.getString("Sname"));
			}
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}