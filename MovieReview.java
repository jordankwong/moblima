package Moblima;
/**
 * Movie Reviews
 * @author 
 *
 */
public class MovieReview extends SuperReviewScore {
	/**
	 * Reviews
	 */
	private String review;
	/**
	 * Movie Reviews
	 * @param movie
	 * @param name
	 * @param review
	 */
	public MovieReview(String movie, String name, String review){
		super(movie, name);
		this.review = review;
	}
	
	/**
	 * Reviews
	 * @return Reviews
	 */
	public String getReview(){
		return review;
	}
}
