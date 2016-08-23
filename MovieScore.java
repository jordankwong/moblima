package Moblima;
/**
 * Movie Score
 * @author 
 *
 */
public class MovieScore extends SuperReviewScore {
	/**
	 * Score
	 */
	private double score;
	/**
	 * Movie Score
	 * @param movie
	 * @param name
	 * @param score
	 */
	public MovieScore(String movie, String name, double score){
		super(movie, name);
		this.score = score;
	}
	
	/**
	 * Score
	 * @return Score
	 */
	public double getScore(){
		return score;
	}
}
