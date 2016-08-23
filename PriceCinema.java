package Price;
/**
 * Cinema Price
 * @author 
 *
 */
public class PriceCinema extends PriceSuper {
	/**
	 * Cinema String
	 */
	private String cinema;

	// get and set
	/**
	 * Cinema Price
	 * @param cinema
	 * @param price
	 */
		public PriceCinema(String cinema, double price){
			super(price);
			this.cinema = cinema;
		}
		/**
		 * Return Cinema
		 */
		public String get(){
			return this.cinema;
		}
		
}
