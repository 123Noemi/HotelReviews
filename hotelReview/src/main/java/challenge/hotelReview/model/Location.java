package challenge.hotelReview.model;


public class Location {
	private String id;
	private String name;
	

	public Location() {
		super();
	}
	
	public Location(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return "location [id=" + id + ", name=" + name + "]";
	}

}
