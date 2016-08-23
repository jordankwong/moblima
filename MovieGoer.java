package Moblima;
/**
 * Customer
 * @author 
 *
 */
public class MovieGoer {
	/**
	 * Name of customer
	 */
	private String name;
	/**
	 * Handphone number
	 */
	private String hp;
	/**
	 * Email address 
	 */
	private String email;
	/**
	 * Movie Title 
	 */
	private String movieTitle;
	/**
	 * Movie Date
	 */
	private String movieDate;
	/**
	 * Movie Time
	 */
	private String movieTime;
	/**
	 * Movie Price
	 */
	private String moviePrice;
	/**
	 * Cineplex
	 */
	private String cineplex;
	/**
	 * Cinema
	 */
	private String cinema;
	/**
	 * Transaction ID
	 */
	private String TranID;
	/**
	 * MovieGoer
	 * @param name
	 * @param hp
	 * @param email
	 * @param title
	 * @param date
	 * @param time
	 * @param price
	 * @param cineplex
	 * @param cinema
	 * @param id
	 */
	public MovieGoer(String name, String hp, String email, String title, String date, String time,String price, String cineplex, String cinema, String id){
		this.name = name;	
		this.hp = hp;
		this.email = email;
		this.movieTitle = title;
		this.movieDate = date;
		this.movieTime = time;
		this.moviePrice = price;
		this.cineplex = cineplex;
		this.cinema = cinema;
		this.TranID = id;

	}
	
	//get methods
	/**
	 * Name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	/**
	 * Handphone number
	 * @return Handphone number
	 */
	public String getHp(){
		return hp;
	}
	/**
	 * Email
	 * @return email address
	 */
	public String getemail(){
		return email;
	}
	/**
	 * Title of movie
	 * @return Title of movie
	 */
	public String getTitle(){
		return movieTitle;
	}
	/**
	 * Date of purchase
	 * @return Date of purchase
	 */
	public String getDate(){
		return movieDate;
	}
	/**
	 * Time of movie
	 * @return time of movie
	 */
	public String getTime(){
		return movieTime;
	}
	/**
	 * price
	 * @return Price
	 */
	public String getPrice(){
		return moviePrice;
	}
	/**
	 * Cineplex
	 * @return cineplex
	 */
	public String getCineplex(){
		return cineplex;
	}
	/**
	 * Cinema
	 * @return Cinema
	 */
	public String getCinema(){
		return cinema;
	}
	/**
	 * Transaction ID
	 * @return Transaction ID
	 */
	public String getID(){
		return TranID;
	}
	
}
	


