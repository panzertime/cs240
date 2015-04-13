package creating;

public class CD {

	private String title;
	private String artist;
	private String country;
	private String company;
	private String price;
	private String year;
	
	public CD(String title, String artist, String country,
				String company, String price, String year) {
		setTitle(title);
		setArtist(artist);
		setCountry(country);
		setCompany(company);
		setPrice(price);
		setYear(year);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

}
