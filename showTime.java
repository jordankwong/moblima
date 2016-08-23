package Moblima;
/**
 * Show time
 * @author 
 *
 */
public class showTime {
	/**
	 * Time of movie
	 */
	private String time;
	/**
	 * Movie Title
	 */
	private String movie;
	/**
	 * Cineplex for movie
	 */
	private String cineplex;
	/**
	 * Cinema for movie
	 */
	private String cinema;
	/**
	 * int Num
	 */
	private int num;
	
	//get and set methods
	/**
	 * Show time
	 * @param movie
	 * @param cineplex
	 * @param cinema
	 * @param time
	 */
	public showTime(String movie, String cineplex, String cinema, String time){
		this.time = time;
		this.movie = movie;
		this.cineplex = cineplex;
		this.cinema = cinema;
	}
	/**
	 * Movie
	 * @return Movie
	 */
	public String getMovie(){
		return movie;
	}
	/**
	 * Time
	 * @return Time
	 */
	public String getTime(){
		return time;
	}
	/**
	 * Cineplex
	 * @return Cineplex
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
	 * Number
	 * @return number
	 */
	public int getnum(){
		return num;
	}
	/**
	 * Set timing
	 * @param time
	 */
	public void setTime(String time){
		this.time = time;
	}
	/**
	 * Set Number
	 * @param num
	 */
	public void setNum(int num){
		this.num = num;
	}

}
