package StaffMgr;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Database.readwrite;
import Moblima.Cinema;
import Moblima.Cineplex;
import Moblima.Holiday;
import Moblima.Movie;
import Moblima.showTime;
import Price.PriceAge;
import Price.PriceCinema;
import Price.PriceDay;
import Price.PriceType;
/**
 * Staff App
 * @author
 *
 */
public class StaffCtr {
	DateFormat fmt = new SimpleDateFormat("HH:mm");
	/**
	 * Movie Title
	 */
	private String movieTitle;
	Scanner sc = new Scanner(System.in);
	/**
	 * Flag Counter
	 */
	int flag =0;
	/**
	 * variable K
	 */
	private int k;
	String timeStr;
	/**
	 * Timing
	 */
	private String timing;
	/**
	 * name
	 */
	private String name;
	/**
	 * Year of date
	 */
	private String year;
	/**
	 * Month of date
	 */
	private String month;
	/**
	 * Day of date
	 */
	private String day;
	/**
	 * Title of movie
	 */
	private String title;
	/**
	 * Type of movie
	 */
	private String type;
	/**
	 * Movie rating
	 */
	private String rating;
	/**
	 * show status
	 */
	private String show;
	/**
	 * Duration of movie
	 */
	private String runtime1;
	/**
	 * sypnosis of movie
	 */
	private String sypnosis;
	/**
	 * director of movie
	 */
	private String director;
	/**
	 * cast of movie
	 */
	private String cast;
	/**
	 * score of movie
	 */
	private double score;
	/**
	 * ticket sales
	 */
	private int ticketSale;
	/**
	 * Score counter
	 */
	private double score_counter;
	/**
	 * input integer choice
	 */
	private int choice;
	/**
	 * input string choice
	 */
	private String choiceStr = "";
	/**
	 * Status
	 */
	private String status;
	String newTime;
	/**
	 * Password
	 */
	private String password;
	/**
	 * Cineplex
	 */
	private String cineplex;
	/**
	 * Cinema
	 */
	private String cinema;
	/**
	 * String input
	 */
	private String input;
	/**
	 * Add show timings
	 */
	public void addShowTime(){

	
		System.out.println("Which movie do you want to add a timing for?");
		readwrite movList = new readwrite();


		try{
			ArrayList mov = movList.readMovies("src/Database/Movies.txt");
			ArrayList time = movList.readShowtime("src/Database/ShowTimes.txt");
			ArrayList cp = movList.readCineplex("src/Database/Cineplex.txt");
			ArrayList cine = movList.readCinema("src/Database/Cinema.txt");
			do{
		
		k =1;
		for (int i=0; i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			System.out.println(k+". "+ obj.getTitle());					//1. iron man etc
			obj.setdisplaynum(k);
			k++;
			}
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);						// choice is the index for movie
		if (choice<1 || choice > k-1){
			System.out.println("Wrong input, please try again");
		}
		}while (choice<1 || choice > k-1);
			
		for (int i=0; i<mov.size();i++){
				Movie obj = (Movie)mov.get(i);
				if(obj.getdisplaynum() == choice){
					movieTitle = obj.getTitle();					// get movie title here
					runtime1 = obj.getRuntime();
				}
				
			}

		// up we settle movietitle
			System.out.println("Which Cineplex?");
			k =1;
			for (int i=0; i<cp.size();i++){
				Cineplex obj = (Cineplex)cp.get(i);
				System.out.println(k+". "+ obj.getName());					//1. Cathay etc
				obj.setnum(k);
				k++;
				}
			do{
			choiceStr = sc.nextLine();
			choice = Integer.parseInt(choiceStr);						// choice is the index for cineplex
			if (choice<1 || choice > k-1){
				System.out.println("Wrong input, please try again");
			}
			}while (choice<1 || choice > k-1);
			
			for (int i=0; i<cp.size();i++){
				Cineplex obj = (Cineplex)cp.get(i);
				if(obj.getnum() == choice){
					cineplex = obj.getName();					// get cineplex here
				}
				
			}
			
			//up we settle cineplex
			System.out.println("Which Cinema?");
			k =1;
			for (int i=0; i<cine.size();i++){
				Cinema obj = (Cinema)cine.get(i);
				if (obj.getCineplex().equals(cineplex)){
				System.out.println(k+". "+ obj.getCineID());					//1. OR1 etc
				obj.setnum(k);
				k++;
				}
				}
			do{
			choiceStr = sc.nextLine();
			choice = Integer.parseInt(choiceStr);						// choice is the index for cinema
			if (choice<1 || choice > k-1){
				System.out.println("Wrong input, please try again");
			}
			}while (choice<1 || choice > k-1);
			
			for (int i=0; i<cine.size();i++){
				Cinema obj = (Cinema)cine.get(i);
				if(obj.getnum() == choice){
					cinema = obj.getCineID();					// get cinema here
				}
				
			}
			
			//up we settle cinema
			
			
		
		// now we are left with new timing

		System.out.println("Please enter the new timing is the format 12:00/23:00 etc");
		try {
		    input = sc.nextLine();
		    fmt.setLenient(false);
		    Date timing = fmt.parse(input);
		} catch (ParseException e) {
		    System.out.println("Incorrect format! Please Restart!");
		    return;
		}
		
		for (int i=0; i<time.size();i++){
			showTime obj = (showTime)time.get(i);
			if (obj.getMovie().equals(movieTitle) && obj.getCineplex().equals(cineplex) && obj.getCinema().equals(cinema)
					&& !obj.getTime().equals('0')){
				try{
				Date date = fmt.parse(obj.getTime());

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.MINUTE,Integer.parseInt(runtime1));
				String upperTime = fmt.format(cal.getTime());
				Date upperBound = fmt.parse(upperTime);			// here is upperBound time
				
				
				cal.setTime(date);
				cal.add(Calendar.MINUTE, -Integer.parseInt(runtime1));
				String bottomTime = fmt.format(cal.getTime());
				Date bottomBound = fmt.parse(bottomTime);			// here is bottomBound time
				
				Date inputTime = fmt.parse(input);
				
				if ( bottomBound.before( inputTime ) && upperBound.after(inputTime)){
					System.out.println("This is an invalid time as there is already a screening at this timing and "
							+ "location, Please restart");
					return;
				}
					
					
			}catch (ParseException e) {
			    System.out.println("Incorrect format! Please Restart!");
			    return;
			}
			}
			}
		
		timing = input;
	
			showTime showTime = new showTime(movieTitle, cineplex, cinema, timing);
			time.add(showTime);
			movList.saveShowtime("src/Database/ShowTimes.txt", time);
			System.out.println("New time has been added!");
			
		}catch (IOException x) {
			System.out.println("IOException > " + x.getMessage());
			}
		}
		
	
	// change holidays
	public void changeHolidays(){
		sc = new Scanner(System.in);
		System.out.println("What is the name of the holiday?");
		name = sc.nextLine();
		System.out.println("What is the day of the holiday?");
		day = sc.nextLine();
		System.out.println("What is the month of the holiday?");
		month = sc.nextLine();
		System.out.println("What is the year of the holiday?");
		year = sc.nextLine();
		
		// create holiday object
		Holiday newHoliday = new Holiday(day,month,year,name);
		// adding holiday to holiday.txt file
		
		try{
			readwrite ha = new readwrite();
			ArrayList holiday = ha.readHoliday("src/Database/PublicHolidays.txt");
			holiday.add(newHoliday);
			ha.saveHoliday("src/Database/PublicHolidays.txt", holiday);
			
			System.out.println("Holiday has been added!");
			
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	
	}
	
	// change price
	/**
	 * Change price of Age, Cinema, Movie, Day
	 */
	public void changePrice(){
		Scanner sc = new Scanner(System.in);
		String choiceStr="";
		int choice = 0;

		do{
			
			boolean success = false;
			while(!success){
				try{
					System.out.println("============= Edit Menu ============");
					System.out.println("|1. Change Prices By Age Category  ");
					System.out.println("|2. Change Prices By Cinema Type   ");
					System.out.println("|3. Change Prices By Movie Type    ");
					System.out.println("|4. Change Prices By Day           ");
					System.out.println("|5. Quit                           ");
					System.out.println("====================================");
		
					System.out.print("\nPlease choose: ");
					
					choiceStr = sc.nextLine();
					System.out.println();
					choice = Integer.parseInt(choiceStr);
					success = true;
				}catch(NumberFormatException e){
				
					System.out.println("Invalid Input. Only numbers between 1 to 4 are accepted.\n");
				}
			}
			switch(choice){
			
			case 1: 
				try{
					readwrite ageObj = new readwrite();
					ArrayList age = ageObj.readPriceAge("src/Database/PriceAge.txt");
					for(int i=0;i<age.size();i++){
						PriceAge obj_age = (PriceAge)age.get(i);
						System.out.println(i+1 + " " + obj_age.get());
					}
					System.out.println("which one do u want to change");
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
				    PriceAge obj_price = (PriceAge)age.get(choice-1);

				    System.out.println("Current price is " + obj_price.getPrice());
				    System.out.println("Please enter the price u want to change:");
		
				    double price = sc.nextDouble();
				    
			        obj_price.changePrice(price);					    
				    ageObj.saveAge("src/Database/PriceAge.txt", age);			
									
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				System.out.println("Price has been updated successfully..");
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					sc.nextLine();
					break;
				}
											
			case 2: 
				try{
					readwrite cinematypeObj = new readwrite();
					ArrayList cinema = cinematypeObj.readPriceCinema("src/Database/PriceCinema.txt");
					for(int i=0;i<cinema.size();i++){
						PriceCinema obj_cinema = (PriceCinema)cinema.get(i);
						System.out.println(i+1 + " " + obj_cinema.get());
					}
					System.out.println("which one do u want to change");
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
				    PriceCinema obj_price = (PriceCinema)cinema.get(choice-1);

				    System.out.println("Current price is " + obj_price.getPrice());
				    System.out.println("Please enter the price u want to change:");
		
				    double price = sc.nextDouble();
				    
			        obj_price.changePrice(price);					    
				    cinematypeObj.saveCinema("src/Database/PriceCinema.txt", cinema);
					
									
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				System.out.println("Price has been updated successfully..");
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					sc.nextLine();
					break;
				}
				
			case 3:
				try{
					readwrite PricetypeObj = new readwrite();
					ArrayList pricetype = PricetypeObj.readPriceType("src/Database/PriceType.txt");
					for(int i=0;i<pricetype.size();i++){
						PriceType obj_type = (PriceType)pricetype.get(i);
						System.out.println(i+1 + " " + obj_type.get());
					}
					System.out.println("which one do u want to change");
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
				    PriceType obj_price = (PriceType)pricetype.get(choice-1);
	
				    System.out.println("Current price is " + obj_price.getPrice());
				    System.out.println("Please enter the price u want to change:");
		
				    double price = sc.nextDouble();
				    
			        obj_price.changePrice(price);					    
			        PricetypeObj.saveType("src/Database/PriceType.txt", pricetype);
										
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				System.out.println("Price has been updated successfully..");
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					sc.nextLine();
					break;
				}
			case 4: 
				try{
					readwrite dayObj = new readwrite();
					ArrayList day = dayObj.readPriceDay("src/Database/PriceDay.txt");
					for(int i=0;i<day.size();i++){
						PriceDay obj_day = (PriceDay)day.get(i);
						System.out.println(i+1 + " " + obj_day.get());
					}
					System.out.println("which one do u want to change");
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
				    PriceDay obj_price = (PriceDay)day.get(choice-1);
		
				    System.out.println("Current price is " + obj_price.getPrice());
				    System.out.println("Please enter the price u want to change:");
		
				    double price = sc.nextDouble();
				    
			        obj_price.changePrice(price);					    
				    dayObj.saveDay("src/Database/PriceDay.txt", day);
					
									
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				System.out.println("Price has been updated successfully..");
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					sc.nextLine();
					break;
				}
			case 5:
			    System.out.println("Edit Session Closed. \n");
				break;
					
			
			default: 
				System.out.println("Invalid Choice! Please Try Again. \n");
				break;	
			}			
			
		} while(choice != 5);		
	}	
	
	// create new movie
	/**
	 * Create Movies
	 */
    public void Create(){
		
		// getting movie title
		    System.out.println("What is the movie title?");
		    title = sc.nextLine();
		
		// getting movie type
		System.out.println("What is the movie type? Digital/ Blockbuster etc");
		
		try{
		do{
		System.out.println("1. Digital");
		System.out.println("2. Blockbuster");
		System.out.println("3. 3D");
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);
		if ((choice>3 || choice<1)){
			System.out.println("Your choice is wrong! Please choose again");
		}
		}while (choice>3 || choice<1);
		
		if (choice ==1){
			type = "Digital";
		}
		else if (choice ==2){
			type = "Blockbuster";
		}
		else
			type = "3D";
		}catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}
		
		// getting movie rating
		System.out.println("What is the movie rating? ");
		try{
		do{
		System.out.println("1. R21");
		System.out.println("2. PG");
		System.out.println("3. NC16");
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);
		if ((choice>3 || choice<1)){
			System.out.println("Your choice is wrong! Please choose again");
		}
		}while (choice>3 || choice<1);
		
		if (choice ==1){
			rating = "R21";
		}
		else if (choice ==2){
			rating = "PG";
		}
		else
			rating  = "NC16";
		
		// now we get showing status
		System.out.println("What is the showing status? ");
		do{
		System.out.println("1. Now Showing");
		System.out.println("2. Preview");
		System.out.println("3. Coming Soon");
		System.out.println("4. End of Showing");
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);
		if ((choice>4 || choice<1)){
			System.out.println("Your choice is wrong! Please choose again");
		}
		}while (choice>4 || choice<1);
		
		if (choice ==1){
			show = "Now Showing";
		}
		else if (choice ==2){
			show = "Preview";
		}
		else if (choice ==3)
			show  = "Coming Soon";
		else
			show ="End of Showing";
		}catch (NumberFormatException a) {
			System.out.println("Invalid Input");
		}
		
		// now we getting movie run time
		System.out.println("What is the movie runtime? Please input the number of minutes");
		try{
		runtime1 = sc.nextLine();
		}catch (InputMismatchException e ) {
			System.out.println("Invalid Input, Please restart");
			return;
		}
		
		
		System.out.println("What is the Sypnosis?");
		sc.nextLine();
		sypnosis = sc.nextLine();
		
		
		// now we getting director
		System.out.println("What is the director name?");
		director = sc.nextLine();
		
		// now we getting casts
		System.out.println("Who are the casts? Please input all casts here");
		cast = sc.nextLine();
		
		// now we getting score, the review score, which is 0 for now
		score = 0;
		
		// now we getting ticketSale, which is number of tickets sold
		ticketSale =0;
		
		// score_counter, how many people gave a review score
		score_counter =0;
		
		Movie newMovie = new Movie(title, type, rating,show,runtime1,sypnosis,director,cast,score,ticketSale,score_counter);   
		// adding new movie!
		
		try{
			readwrite movList = new readwrite();
			ArrayList mov = movList.readMovies("src/Database/Movies.txt");
			mov.add(newMovie);
			
			movList.saveMovie("src/Database/Movies.txt", mov);
			System.out.println("Added the new movie "+ title);
		}catch (IOException x) {
			System.out.println("IOException > " + x.getMessage());
		}
		}
		
			
		
	
		
    
    // update movie status
    /**
     * Update status of movie
     * @return Boolean true / false (Updated/Failed)
     */
    public boolean updateStatus(){
		System.out.println("Please select the movie that you like to update");
		readwrite timeList = new readwrite();
		readwrite movList = new readwrite();

		try{
			ArrayList mov = movList.readMovies("src/Database/Movies.txt");
			do{
		k =1;
		for (int i=0; i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			System.out.println(k+". "+ obj.getTitle());					//1. iron man etc
			obj.setdisplaynum(k);
			k++;
			}
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);						// choice is the index for movie
		if (choice<1 || choice > k-1){
			System.out.println("Wrong input, please try again");
		}
		}while (choice<1 || choice > k-1);

			for (int i=0; i<mov.size();i++){
				Movie obj = (Movie)mov.get(i);
				if(obj.getdisplaynum() == choice){
					movieTitle = obj.getTitle();
					runtime1 = obj.getRuntime();
				}
		}
			
			
		}catch (IOException x) {
			System.out.println("IOException > " + x.getMessage());
		}


		
		// got movie title!

		System.out.println("What will you like to update?");
		System.out.println("1. Change movie Status");
		System.out.println("2. Change movie Showtime");
		choiceStr = sc.nextLine();
		choice = Integer.parseInt(choiceStr);
		
		switch(choice){
			case(1): 
				System.out.println("What Status will you want it to change to?");
				System.out.println("1. Coming Soon");
				System.out.println("2. Preview");
				System.out.println("3. Now Showing");
				System.out.println("4. End of showing");
				
				choice = sc.nextInt();
				while (choice>4 || choice <1){
					System.out.println("Please choose again!");
					System.out.println("1. Coming Soon");
					System.out.println("2. Preview");
					System.out.println("3. Now Showing");
					System.out.println("4. End of Showing");
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
				}
				
				if (choice==1)
					status = "Coming Soon";
				else if (choice ==2)
					status = "Preview";
				else if (choice ==3)
					status = "Now Showing";
				else
					status = "End of Showing";
				
				try{
					ArrayList mov = movList.readMovies("src/Database/Movies.txt");
					for (int i=0; i<mov.size();i++){
						Movie obj = (Movie)mov.get(i);
						if (obj.getTitle().equals(movieTitle)){
							obj.setShow(status);
						}
					}
					movList.saveMovie("src/Database/Movies.txt", mov);
					System.out.println("Show Time has been changed");
					
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				break;
				
				
			// here is case 2! Changing movie showtime
			case(2):
				try{			
					// now we get the cinema and we have the movie above
					
					ArrayList time = timeList.readShowtime("src/Database/Showtimes.txt");
					// k is here again
					k =1;
					for (int i=0; i<time.size();i++){
						showTime obj = (showTime)time.get(i);
						if (obj.getMovie().equals(movieTitle) && !obj.getTime().equals("0")){
							obj.setNum(k);
							k++;
						}
					}
							if (k==1){
								System.out.println("There is no showtime yet! Please add one first");
								return false;			//exit program
							}
							else{
								System.out.println("Which show time will you like to change/ delete?");	
								for (int i=0; i<time.size();i++){
									showTime obj = (showTime)time.get(i);
									if (obj.getMovie().equals(movieTitle) && !obj.getTime().equals("0")){
									System.out.println(obj.getnum()+". Cineplex: "+ obj.getCineplex()
											+ ". Cinema: "+obj.getCinema()+ ". Showtime: "+obj.getTime());
									}
									}
								}
					
					// getting choice of showtime
					
					do{
						choiceStr = sc.nextLine();
						choice = Integer.parseInt(choiceStr);			// gotten choice of showtime here

						int flag =0;

						if (choice<k && choice>0){						

							System.out.println("To delete, please input 'delete'. To change, please input timing in form of 12:00/23:00 etc");
						    input = sc.nextLine();
						    if (input.equals("delete")){
								for (int i=0; i<time.size();i++){
									showTime obj = (showTime)time.get(i);
									if (obj.getnum() == choice){
									obj.setTime("0");
									}
									}
						    }
						    
						    else{

								
						    // set the time to 0 so that it does not show anymore
							
							for (int i=0; i<time.size();i++){
								showTime obj = (showTime)time.get(i);
								if (obj.getnum()== choice){
									obj.setTime(input);
									break;
								}
								}
							
						    }
						}
						else{
							System.out.println("Wrong choice! Input again!");
							flag =1;
						}
					}while(flag == 1);

					// if everything up there is right, we have a new time now
					timeList.saveShowtime("src/Database/ShowTimes.txt",time);
					System.out.println("Change the show time");
					
					break;
				}catch (IOException x) {
					System.out.println("IOException > " + x.getMessage());
				}
				
			default: return false;
				
		} return true;
		}
    
    
    // Add show time
    
				
	
    
    // staff login
    	/**
    	 * Login
    	 * @return Boolean True/False (Login Success/Failed)
    	 */
    	public boolean Login(){
    		
    		System.out.println("Please enter your name:");
    		name = sc.nextLine().toLowerCase();
    		System.out.println("Please enter your password:");
    		password = sc.nextLine();
    		
    		try{
    			readwrite staffArray = new readwrite();
    			ArrayList staffList = staffArray.readStaff("src/Database/Staff.txt");
    			for (int i=0;i<staffList.size();i++){
    				Staff person = (Staff)staffList.get(i);
    				if(name.equals(person.getName()) && password.equals(person.getPassword())){
    					return true;
    				}
    					}
    		}catch (IOException e) {
    			System.out.println("IOException > " + e.getMessage());
    	}
    	return false;
    }
    

	

}
