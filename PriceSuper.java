package Price;
/**
 * Class Price Super
 * @author
 *
 */
public abstract class PriceSuper {
	/**
	 * Price
	 */
private double price;
	/**
	 * Price Super
	 * @param pri
	 */
public PriceSuper(double pri){
	this.price = pri;
}
	/**
	 * Price
	 * @return Price
	 */
		public double getPrice(){
				return this.price;
			}
		/**
		 * Change pricing
		 * @param price
		 */
		public void changePrice(double price){
				this.price = price;
			}
		
		public abstract String get();
}
