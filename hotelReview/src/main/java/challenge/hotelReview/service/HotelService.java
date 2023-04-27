package challenge.hotelReview.service;

import java.time.LocalDate;
import java.util.List;

import challenge.hotelReview.model.Hotel;

public interface HotelService {
	public List<Hotel> find(String location,LocalDate checkIn,LocalDate checkOut,int[] priceRange);
}
