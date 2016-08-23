package Moblima;
/**
 * Holiday class
 * @author 
 *
 */
public class Holiday {
	/**
	 * day of holiday
	 */
	private String day;
	/**
	 * month of holiday
	 */
	private String month;
	/**
	 * year of holiday
	 */
	private String year;
	/**
	 * Reason of holiday
	 */
	private String Hday;
	/**
	 * HOLIDAY!!!!!
	 * @param day
	 * @param month
	 * @param year
	 * @param Hday
	 */
	public Holiday(String day, String month, String year, String Hday){
		this.day = day;	
		this.month = month;
		this.year = year;
		this.Hday = Hday;

	}
	
	// various get and set methods
	
	/**
	 * Day of holiday
	 * @return day of holiday
	 */
	public String getDay(){
		return day;
	}
	/**
	 * Month of holiday
	 * @return Month of holiday
	 */
	public String getMonth(){
		return month;
	}
	/**
	 * Year of Holiday
	 * @return Year of Holiday
	 */
	public String getYear(){
		return year;
	}
	/**
	 * HOLIDAY reason
	 * @return Holiday title
	 */
	public String getHday(){
		return Hday;
	}
	/**
	 * set day
	 * @param day
	 */
	public void setDay(String day){
		this.day = day;
	}
	/**
	 * set holiday reason
	 * @param Hday
	 */
	public void setHday(String Hday){
		this.Hday = Hday;
	}
	/**
	 * set month of holiday
	 * @param month
	 */
	public void setMonth(String month){
		this.month = month;
	}
	/**
	 * set year of holiday
	 * @param year
	 */
	public void setYear(String year){
		this.year = year;
	}
	
}


