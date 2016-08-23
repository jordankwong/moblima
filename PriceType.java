package Price;
/**
 * Price for different types of movies
 * @author
 *
 */
public class PriceType extends PriceSuper {
	/**
	 * Type
	 */
	private String type;

	// get and set
	/**
	 * Price Type
	 * @param type
	 * @param price
	 */
		public PriceType(String type, double price){
			super(price);
			this.type = type;

		}
		/**
		 * Return Type
		 */
		public String get(){
			return this.type;
		}
		
		
}
