package first.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchingTool {
	
	private jdbcConnector jdbcConnector;

	public SearchingTool(jdbcConnector jdbc) {
		this.jdbcConnector = jdbc;
	}
	
	public void executeSQLSelectAll() throws SQLException{
		jdbcConnector.setConnectionToDerby();
			
		Statement myStatement = jdbcConnector.getConector().createStatement();  
		ResultSet rs = myStatement.executeQuery("select * from PionierskiHotel ");
		
		while(rs.next()){ // MyStatement sprawdzic.. !!
			System.out.println(rs.getString(1) +" "+ rs.getString(2)+" "+ rs.getString(3)+" "+ rs.getString(4));
		}
		jdbcConnector.closeTheConnection();
	}
	
	public void showAvailableRooms() throws SQLException{
		jdbcConnector.setConnectionToDerby();
			
		Statement myStatement = jdbcConnector.getConector().createStatement();  
		ResultSet rs = myStatement.executeQuery("select * from PionierskiHotel where available = 'T'");
		
		while(rs.next()){ // MyStatement sprawdzic.. !!
			System.out.println(rs.getString(1) +" "+ rs.getString(2)+" "+ rs.getString(3)+" "+ rs.getString(4));
		}
		jdbcConnector.closeTheConnection();
	}

	// search the room (which is .. )
	// show if size less/big than
	// show if cost less than
	
}
