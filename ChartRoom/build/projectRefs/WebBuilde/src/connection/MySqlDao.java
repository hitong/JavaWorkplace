package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDao {
	public static Connection getConnection() throws Exception {
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8&useSSL=false";
		String userName = "root";
		String userPwd = "w1906194855";
		Class.forName(driverName);
		return DriverManager.getConnection(url, userName, userPwd);
	}
}
