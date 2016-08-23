package Moblima;
/**
 * movie class
 * @author 
 *
 */
public class Movie{
	
/**
 * title of movie
 */
	private String title;
	/**
	 * movie type
	 */
	private String type;
	/**
	 * movie rating
	 */
	private String rating;
	/**
	 * current status of movie
	 */
	private String show;
	/**
	 * Duration of movie
	 */
	private String runtime;
	/**
	 * sypnosis of movie
	 */
	private String sypnosis;
	/**
	 * director of movie
	 */
	private String director;
	/** 
	 * casts of movie
	 */
	private String casts;
	/**
	 * score for movie
	 */
	private double score;
	/**
	 * no. displayed for movie
	 */
	private int displaynum;
	/**
	 * Ticket sales of movie
	 */
	private int ticketSale;
	/**
	 * score counter
	 */
	private double score_counter;
	//added these and the get/add method.
	
	/**
	 * MOVIE
	 * @param theTitle
	 * @param theType
	 * @param rate
	 * @param showing
	 * @param showLength
	 * @param sypnosis
	 * @param director
	 * @param casts
	 * @param score
	 * @param ticketsale
	 * @param score_counter
	 */
	public Movie(String theTitle, String theType, String rate, String showing,
			String showLength, String sypnosis, String director,
			String casts,double score, int ticketsale,double score_counter) {
		
		this.title = theTitle;
		this.type = theType;
		this.rating = rate;
		this.show = showing;
		this.runtime = showLength;
		this.sypnosis = sypnosis;
		this.director = director;
		this.casts = casts;
		this.score = score;
		this.ticketSale = ticketsale;
		this.score_counter = score_counter;
	}
	/**
	 * Title
	 * @return Title
	 */
	public String getTitle(){
		return this.title;
	}
	/**
	 * Type
	 * @return Type
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * Rating
	 * @return rating
	 */
	public String getRating(){
		return this.rating;
	}
	/**
	 * Show
	 * @return show
	 */
	public String getShow(){
		return this.show;
	}
	/**
	 * Set show
	 * @param show
	 */
	public void setShow(String show){
		this.show = show;
	}
	/**
	 * Runtime
	 * @return runtime
	 */
	public String getRuntime(){
		return this.runtime;
	}
	/**
	 * Sypnosis
	 * @return sypnosis
	 */
	public String getSypnosis(){
		return this.sypnosis;
	}
	/**
	 * Director
	 * @return director
	 */
	public String getDirector(){
		return this.director;
	}
	/**
	 * Cast
	 * @return cast
	 */
	public String getCast(){
		return this.casts;
	}
	/**
	 * Score
	 * @return Score
	 */
	public double getScore(){
		return score;
	}
	/**
	 * increase score
	 * @param num
	 */
	public void addScore(int num){
		score += num;
	}
	/**
	 * increase ticket sale counter
	 */
	public void addTicketSale(){
		ticketSale++;
	}
	
	// this 2 methods are important for displaying index numbers in the main app
	/**
	 * Displayed number for movie in main app
	 * @param j
	 */
	public void setdisplaynum(int j){
		this.displaynum = j;
	}
	/**
	 * Display number
	 * @return Display number
	 */
	public int getdisplaynum(){
		return displaynum;
	}
	/**
	 * Ticket sales
	 * @return ticket sale
	 */
	public int getTicketSale(){
		return ticketSale;
	}
	/**
	 * increase score counter
	 */
	public void addScoreCounter(){
		score_counter++;
	}
	/**
	 * average score
	 * @return Average score
	 */
	public double getScoreCounter(){
		return score_counter;
	}
}
