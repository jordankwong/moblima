package Moblima;
/**
 * Cinema class
 * @author 
 *
 */
public class Cinema {

	/**
	 * Cineplex 
	 */
	private String cineplex;
	/**
	 * cineplexID
	 */
	private String cineID;
	/**
	 * type of cinema
	 */
	private String type;
	/**
	 * Counter
	 */
	private int num;
	
	
	// various get and set methods below
	/**
	 * cinema
	 * @param cineplex
	 * @param cineID
	 * @param type
	 */
	public Cinema(String cineplex, String cineID, String type){
		this.cineplex = cineplex;
		this.cineID = cineID;
		this.type = type;
	}
	/**
	 * return cineplex
	 * @return Cineplex
	 */
	public String getCineplex() {
		return cineplex;
	}

/**
 * cineplexID
 * @return cineplexID
 */
	public String getCineID() {
		return cineID;
	}
/**
 * type of cineplex
 * @return cineplex type
 */
	public String getType() {
		return type;
	}
	/**
	 * set cinema number
	 * @param num
	 */
	public void setnum(int num){
		this.num = num;
	}
	/**
	 * counter
	 * @return cineplex counter
	 */
	public int getnum(){
		return num;
	}
	
}

