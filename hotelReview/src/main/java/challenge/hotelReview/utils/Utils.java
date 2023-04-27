package challenge.hotelReview.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

	public LocalDate StringToLocalDate (String date) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate lDate = LocalDate.parse(date, formato); 
		
		return lDate;
	}
	
	public LocalDate currentDate() {
		LocalDate date = LocalDate.now();
		
		return date;
	}
	
	public LocalDate nextDate() {
		LocalDate date = currentDate();
		return date.plusDays(1);
	}
	
}
