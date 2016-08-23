package Moblima;


// various get and set methods
/**
 * cineplex class
 * @author 
 *
 */
public class Cineplex {
	/**
	 * name of cineplex
	 */
	private String name;
	/**
	 * address of cineplex
	 */
	private String address;
	/**
	 * number counter
	 */
	private int num;
	/**
	 * cineplex
	 * @param cineplex
	 * @param address
	 */
	public Cineplex(String cineplex, String address){
		this.name = cineplex;	
		this.address = address;

	}
	/**
	 * name
	 * @return Name of cineplex
	 */
	public String getName(){
		return name;
	}
	/**
	 * Address
	 * @return address of cineplex
	 */
	public String getAddress(){
		return address;
	}
	/**
	 * set counter for cineplex
	 * @param num
	 */
	public void setnum(int num){
		this.num = num;
	}
	/**
	 * return counter for cineplex
	 * @return
	 */
	public int getnum(){
		return num;
	}
	
}
