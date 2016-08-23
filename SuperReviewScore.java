package Moblima;
/**
 * Class Super Review Score
 * @author 
 *
 */
public abstract class SuperReviewScore {
	/**
	 * Movie
	 */
	private String movie;
	/**
	 * name
	 */
	private String name;
	/**
	 * Review Score
	 * @param movie
	 * @param name
	 */
	public SuperReviewScore(String movie, String name){
		this.movie = movie;
		this.name = name;
	}
	/**
	 * Movie
	 * @return Movie
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * Name
	 * @return Name
	 */
	public String getName() {
		return name;
	}
	
	
	}
	
