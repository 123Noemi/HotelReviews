package challenge.hotelReview.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
	public Connection openConnection(Connection con) {
		String url = "C:\\Users\\Noemi\\Desktop\\Challenge\\DataBase\\HotelReviews.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = java.sql.DriverManager.getConnection("jdbc:sqlite:"+url);
			
			con.setAutoCommit(false);  
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return con;	
	}
	
	public void closeConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
