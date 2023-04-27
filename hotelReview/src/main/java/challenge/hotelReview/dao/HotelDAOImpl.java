package challenge.hotelReview.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import challenge.hotelReview.connection.ConnectionDB;
import challenge.hotelReview.model.Hotel;
import challenge.hotelReview.model.Location;
import challenge.hotelReview.model.Reviews;

public class HotelDAOImpl implements HotelDAO{
	Connection con=null;
	ArrayList<Reviews> revList;
	
	@Override
	public List<Hotel> find(String location,LocalDate checkIn,LocalDate checkOut,int[] priceRange) {
		
		Hotel h;
		Location loc;
		ConnectionDB connectionDB=new ConnectionDB();
		con=connectionDB.openConnection(con);
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		revList= new ArrayList<Reviews>();

		try {
			Statement st=con.createStatement();
			
			String query="SELECT h.id_hotel, h.name, h.description, loc.name AS loc_name, loc.id_location AS id_loc, AVG(r.rating) AS average,price,image "
					+ "FROM hotel h "
					+ "INNER JOIN location loc ON h.id_location = loc.id_location "
					+ "INNER JOIN reviews r ON h.id_hotel = r.id_hotel "
					+ "WHERE 1=1 ";
			if(!location.isEmpty())
				query=query+ "AND loc.name like '"+location+ "' ";
			
			if(priceRange.length>0) {
				int priceFrom=priceRange[0];
				int priceTo=priceRange[1];
				query=query+ "AND price BETWEEN "+ priceFrom + " AND "+priceTo;
			}
			
			query=query + " GROUP BY h.id_hotel, h.name, h.description, loc.name, loc.id_location ORDER BY average desc";
		
			st.executeQuery(query);
			ResultSet rs=st.executeQuery(query);	

			while(rs.next()){
				h=new Hotel();
				loc=new Location();
				loc.setName(rs.getString("loc_name"));
				loc.setId(rs.getString("id_loc"));
				h.setId(rs.getString("id_hotel"));
				h.setName(rs.getString("name"));
				h.setDescription(rs.getString("description"));
				h.setPrice(rs.getInt("price"));
				h.setAverage(rs.getFloat("average"));
				h.setImage(rs.getString("image"));
				h.setCheckIn(checkIn);
				h.setCheckOut(checkOut);
				h.setLocation(loc);
				h.setTotalPrice();
				
				h.setPriceRange(priceRange);
				
				//Retrieve hotel reviews
				revList=retrieveReviews(h.getId());
				
				h.setReviews(revList);
				hotelList.add(h);
			}
			

			rs.close();
			st.close();
			connectionDB.closeConexion(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hotelList;
	}
	
	public ArrayList<Reviews> retrieveReviews(String id_hotel){
		Reviews reviews;
		revList= new ArrayList<Reviews>();
		String query;
		try {
			query = "SELECT id_review ,rating,comment FROM reviews r WHERE r.id_hotel="+id_hotel;
			Statement st=con.createStatement();
			st.executeQuery(query);
			ResultSet rs=st.executeQuery(query);	
		
			while(rs.next()){
				reviews = new Reviews(rs.getString("id_review"),rs.getInt("rating"),rs.getString("comment"));
				revList.add(reviews);
			}
			
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return revList;
	}
}
