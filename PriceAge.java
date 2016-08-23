package Price;
/**
 * Class Price Age Groups
 * @author 
 *
 */
public class PriceAge extends PriceSuper {
/**
 * Age
 */
private String age;

// set and get methods
	/**
	 * price age
	 * @param age
	 * @param price
	 */
	public PriceAge(String age, double price){

		super(price);
		this.age = age;
	}
	/**
	 * Return Age
	 */
	public String get(){
		return this.age;
	}

	
}
