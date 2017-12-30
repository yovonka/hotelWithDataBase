package first.database;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		jdbcConnector jdbc = new jdbcConnector();
		SearchingTool tool = new SearchingTool(jdbc);
//		TableCreator creator = new TableCreator(jdbc);
		
		try {
			tool.executeSQLSelectAll();
		} catch (SQLException e) {
			System.out.println("Err");
		}
		
		try {
			System.out.println("Dostepne pokoje");
			tool.showAvailableRooms();
		} catch (SQLException e) {
			System.out.println("Err");
		}
		

//		try {
//			creator.addNewRow("1.2", 'F' ,3, 1);
//		} catch (SQLException e) {
//			System.out.println("Err");
//		}
//		
//		try {
//			tool.executeSQLSelectAll();
//		} catch (SQLException e) {
//			System.out.println("Err");
//		}
		
	}
		
//		// 4) BookingTool the room - change the status , print confirmation , make available // f.e two exisiting bookingtool	
//		// 5) Add to clean quee (new table ?)
//		// 6) Everything in present tens - add Calendar
//		// 7) Clients // Workers // Costs
////		HashMap<String, Room> RoomBase = new HashMap<String, Room>();
////		RoomBase.put("4f3",new Room());

}
