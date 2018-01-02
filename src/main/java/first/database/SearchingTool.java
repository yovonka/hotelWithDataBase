package first.database;

import java.sql.*;
import java.util.LinkedList;

public class SearchingTool {
	
	private jdbcConnector jdbcConnector = new jdbcConnector();
	
	public LinkedList<Room> executeSQLSelect(String myQuery){
		
		try {
			jdbcConnector.setConnectionToDerby();
		} catch (SQLException e) {
			System.out.println("Connection error");
		}
			
		LinkedList<Room> list = new LinkedList<Room>();
		
		try {
			Statement myStatement = jdbcConnector.getConector().createStatement();
			ResultSet rs = myStatement.executeQuery(myQuery);
			while(rs.next()){ 
				list.add(new Room(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("Search errror");
		}  
		
		try {
			jdbcConnector.closeTheConnection();
		} catch (SQLException e) {
			System.out.println("Close error");
		}
		return list;
	}
	
	public String createQuery(int size, int prize) {
		
		return "select * from PionierskiHotel where available = 'T' and size = "+size+" and prize <= "+prize;	
	}

	
}
