package Price;
/**
 * Class Price for days
 * @author 
 *
 */
public class PriceDay extends PriceSuper {
	/**
	 * Day
	 */
	private String day;

	// get and set
	/**
	 * Priceday
	 * @param day
	 * @param price
	 */
		public PriceDay(String day, double price){
			super(price);
			this.day = day;
			
		}
		/**
		 * return day
		 */
		public String get(){
			return this.day;
		}
		
}
