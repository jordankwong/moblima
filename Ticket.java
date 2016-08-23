package Moblima;

/**
 * Class Ticket 
 * @author 
 *
 */
public class Ticket {
	/**
	 * Price for ticket
	 */
	private double price;
	/**
	 * Serial number
	 */
	private String serialnumber;
	/**
	 * Movie
	 */
	private String movie;
	/**
	 * Type
	 */
	private String type;
	/**
	 * Age
	 */
	private String age;
	/**
	 * Day
	 */
	private String day;
	
	/**
	 * Ticket
	 * @param movie
	 * @param type
	 * @param age
	 * @param day
	 * @param price
	 */
	public Ticket(String movie, String type, String age, String day, double price){
		this.movie = movie;
		this.type = type;			//cinema type!
		this.age = age;
		this.day = day;
		this.price = price;

	}
	/**
	 * Price
	 * @return Price
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * Serial number
	 * @return Serial number
	 */
	public String getSerialNum(){
		return serialnumber;
	}
	/**
	 * Set Serial Number
	 * @param num
	 */
	public void setSerialNum(String num){
		this.serialnumber = num;
	}
	
}
