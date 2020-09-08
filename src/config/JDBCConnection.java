package config;

import java.sql.*;

public class JDBCConnection {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//String url="jdbc:sqlserver://DESKTOP-M5R88DB;database=project";
		//String url="jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;database=PCSDB";
		String url="jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;database=project";
		String username="sa";
		String password="niit@123";
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
}