package challenge.hotelReview.service;

import java.time.LocalDate;
import java.util.List;
import challenge.hotelReview.dao.HotelDAOImpl;
import challenge.hotelReview.model.Hotel;
public class HotelServiceImpl implements HotelService{

	private HotelDAOImpl hotelDAO=new HotelDAOImpl();
	
	@Override
	public List<Hotel> find(String location,LocalDate checkIn,LocalDate checkOut,int[] priceRange) {
		return hotelDAO.find(location,checkIn,checkOut,priceRange);
	}	
}
