package challenge.hotelReview.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;


public class Hotel {
	private String id;
	private String name;
	private String description;
	private Location location;
	private int price;
	private String image;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int totalPrice;
	private int[] priceRange=new int[2];
	private ArrayList<Reviews> reviews;
	private float average;
	
	public Hotel() {
		
	}
	
	public Hotel(String id, String name, String description, Location location, int price, String image,
			LocalDate checkIn, LocalDate checkOut, int totalPrice, int[] priceRange, ArrayList<Reviews> reviews,
			float average) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.price = price;
		this.image = image;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
		this.priceRange = priceRange;
		this.reviews = reviews;
		this.average = average;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public ArrayList<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Reviews> reviews) {
		this.reviews = reviews;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public int[] getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int[] priceRange) {
		this.priceRange = priceRange;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		long days=ChronoUnit.DAYS.between(this.getCheckIn(),this.getCheckOut());
	    int totalPrice=(int)days*this.price;
	    this.totalPrice = totalPrice;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}


	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", price=" + price + ", image=" + image + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", totalPrice=" + totalPrice + ", priceRange=" + Arrays.toString(priceRange) + ", reviews=" + reviews
				+ ", average=" + average + "]";
	}

}
