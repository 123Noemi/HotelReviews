package challenge.hotelReview;

import org.junit.Test;

import challenge.hotelReview.model.Hotel;
import challenge.hotelReview.service.HotelServiceImpl;
import challenge.hotelReview.utils.Utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

public class HotelReviewTest {

	HotelServiceImpl hotelServiceImpl=new HotelServiceImpl();
	Utils utils=new Utils();
	LocalDate checkIn = utils.StringToLocalDate("20/05/2022");
	LocalDate checkOut = utils.StringToLocalDate("22/05/2022");
	
	
	@Test
    public void testValidateDates() {
        assertTrue(checkIn.isBefore(checkOut));
    }
	
	@Test
    public void testValidateDates2() {
        assertTrue(checkIn.isAfter(checkOut));
    }
	
	
	@Test
	public void testFindByLocation() {
		System.out.println("testFindByLocation");
		int[] totalPrice = {};
		List<Hotel> hotelList=hotelServiceImpl.find("London",checkIn,checkOut,totalPrice);
		assertNotNull(hotelList); 
		
		for(Hotel hotel : hotelList)
		{
		    System.out.println(hotel.toString());
		}
	}
	
	
	@Test
	public void testFindAll() {
		System.out.println("testFindAll");
		int[] totalPrice = {};
		List<Hotel> hotelList=hotelServiceImpl.find("",checkIn,checkOut,totalPrice);
		assertNotNull(hotelList); 
		
		for(Hotel hotel : hotelList)
		{
		    System.out.println(hotel.toString());
		}
	}
	
	@Test
	public void testFindByLocationAndPrice() {
		System.out.println("testFindByLocationAndPrice");
		int[] totalPrice = {50,200};
		
		List<Hotel> hotelList=hotelServiceImpl.find("",checkIn,checkOut,totalPrice);
		assertNotNull(hotelList); 
		
		for(Hotel hotel : hotelList)
		{
		    System.out.println(hotel.toString());
		}
	}
	
	@Test
	public void testFindByLocationAndPrice2() {
		System.out.println("testFindByLocationAndPrice2");
		int[] totalPrice = {50,100};
		
		List<Hotel> hotelList=hotelServiceImpl.find("",checkIn,checkOut,totalPrice);
		assertNotNull(hotelList); 
		
		for(Hotel hotel : hotelList)
		{
		    System.out.println(hotel.toString());
		}
	}
	
}
