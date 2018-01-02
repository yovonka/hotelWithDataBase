package first.database;

import java.sql.*;

public class jdbcConnector {
	
	private Connection conector; 
	
	public Connection getConector() {
		return conector;
	}

	public void setConnectionToDerby() throws SQLException{
		if(conector!=null) return;
		
		String derbyURL = "jdbc:derby:C:\\derby\\bin\\HotelBase"; //MyDbTest database file name 
		conector = DriverManager.getConnection(derbyURL); 
		System.out.println("Correct connection with: " + conector);
	}
	
	public void closeTheConnection() throws SQLException{
		if(conector!=null) {
			conector.close();
			conector=null;
		}
	}

}

