package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	private Connection con = null;
	private String host = "jdbc:mysql://localhost:3306/world";
	private String user = "root";
	private String password = "";
	
	public DB_Connection() {
		try {
			con = DriverManager.getConnection(host,user,password);
			System.out.println("Connected to database");
			
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery("SELECT * FROM user");
			
			int count = 0;
			while(set.next() && count < 10) {
				System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3)+" "+set.getString(4)+" "+set.getInt(5));
				count++;
			}
			
		}catch(SQLException ex) {
//			throw new Error("Error: ", ex);
			System.out.println(String.format("Error here: %s", ex.getMessage()));
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
}
