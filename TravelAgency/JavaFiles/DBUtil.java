package yourpackage;

import java.sql.*;

public class DBUtil {
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagency", "root","21082004Ravi@");
	}
	public static void closeConnection(Connection connection){
		if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
