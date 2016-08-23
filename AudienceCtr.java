package Moblima;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Database.readwrite;
import Price.PriceAge;
import Price.PriceCinema;
import Price.PriceDay;
import Price.PriceType;
/**
 * Application for customer choices and input
 * @author 
 *
 */
public class AudienceCtr {
	/**
	 * create integer flag to act as a hit or miss
	 */
	static int flag;
	/**
	 * separator for different object in file
	 */
	public static final String SEPARATOR = "|";
	
	String fileCinema = "src/database/PriceCinema.txt";
	String fileDay = "src/database/PriceDay.txt";
	String fileType = "src/database/PriceType.txt";
	String fileAge = "src/database/PriceAge.txt";
	String showTime = "src/database/Showtimes.txt";
	
	// Here are the date information
	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
	int date = now.get(Calendar.DAY_OF_MONTH);
	int DAY = now.get(Calendar.DAY_OF_WEEK); 	// If current day is Sunday, day=1. Saturday, day=7

	
	// here are the variables for us to convert user input into suitable file inputs and create ticket
	/**
	 * Customer name
	 */
	private String customerName;
	/**
	 * days for movie
	 */
	private String day;		// directory, day1 day2 day3 etc etc
	/**
	 * tempday to store input date
	 */
	private String tempDay="";
	/**
	 * Age group customer belongs to
	 */
	private String ageType;  //important for ticket input
	/**
	 * cineplex input
	 */
	private String cineplex=""; // cineplex input
	/**
	 * movie input
	 */
	private String movChoice="";
	/**
	 * Cinema input
	 */
   	private String cinema="";
   	/**
   	 * Movie type
   	 */
   	private String movieType="";
   	/**
   	 * Cinema type
   	 */
   	private String cinemaType="";
   	/**
   	 * timing for movie
   	 */
   	private String time="";
   	/**
   	 * Handphone number of customer
   	 */
   	private String hp;
   	/**
   	 * seat number booked
   	 */
   	private String book;
   	/**
   	 * email of customer
   	 */
   	private String email;
   	/**
   	 * Final ticket to calculate price
   	 */
   	private Ticket finalTicket;
   	/**
   	 * Variable k
   	 */
	private int k =1;
	/**
	 * choice number
	 */
	private int choice;
	/**
	 * choice string
	 */
	private String choiceStr;
	/**
	 * review score
	 */
	private int review;
	/**
	 * score for movie
	 */
	private int score;
	/**
	 * name
	 */
	private String name;
	/**
	 * movie being reviewed
	 */
	private String reviewMov; // to store movie for reviewing
	/**
	 * comments for movie
	 */
	private String comments;
	
	// viewer booking ticket
	/**
	 * To book ticket!
	 */
	public void bookTicket(){

	   	// here are the arraylists for us to read from files
		readwrite list = new readwrite();
		
		String filename = "src/Database/" ;
		String fileDirectory= "src/Database/";
		
		Scanner sc = new Scanner(System.in);

		try {
			
		    // opening connection to database for movie type input!
			
		    System.out.println("Which Movie?");
		    
			ArrayList mov = list.readMovies("src/Database/Movies.txt");
			ArrayList cine = list.readCinema("src/Database/Cinema.txt");
			ArrayList timing = list.readShowtime(showTime);
			// only show movies with status not "End of Showing" or "Coming Soon"
			
			do{
				int j=1;
				for (int i = 0 ; i < mov.size() ; i++) {
					Movie obj = (Movie)mov.get(i);
					if (!(obj.getShow().equals("End of Showing") || obj.getShow().equals("Coming Soon"))){
						System.out.println(j+". "+obj.getTitle());
						obj.setdisplaynum(j);
						j++;
					}
				}
			

			choice = sc.nextInt();
			for (int i = 0 ; i < mov.size() ; i++) {
				Movie obj = (Movie)mov.get(i);
				if (obj.getdisplaynum() == choice){
					movChoice = obj.getTitle();							//movChoice is movie title
					}
				}
			if (movChoice ==""){
				System.out.println("Wrong input! Please choose again");
			}
			}while(movChoice=="");
					
			for (int i = 0 ; i < mov.size() ; i++) {
				Movie obj = (Movie)mov.get(i);
				if (movChoice.equals(obj.getTitle())){
					movieType = obj.getType();					// movieType aka blockbuster
				}
			}
			
	    	do{
	        	k=1;
				for (int i=0; i<timing.size();i++){
					showTime obj = (showTime)timing.get(i);
					if(obj.getMovie().equals(movChoice)){
						obj.setNum(k);
						k++;
					}
					}
				if (k==1){
					System.out.println("This movie has no showtimes yet! Please wait for the staff to add show times");
				}
				else{
		        	System.out.println("Which Cineplex?");							// here important	
					System.out.println("1. OrchardCine");
					System.out.println("2. JPCine");
					System.out.println("3. The Cineplex");
				
				}
				sc.nextLine();
				choiceStr = sc.nextLine();
				choice = Integer.parseInt(choiceStr);
				if (choice<1 || choice>3){
					System.out.println("Wrong input. Please try again");
				}
				else{
					if (choice ==1){
						cineplex = "OrchardCine";
					}
					else if (choice ==2){
						cineplex = "JPCine";
					}
					else{
						cineplex = "The Cineplex";			// getting cineplex
					}
				}
	    	}while(choice<1||choice>3);
	    	
				
			
	    	do{
	        	k=1;
				for (int i=0; i<timing.size();i++){
					showTime obj = (showTime)timing.get(i);
					if(obj.getMovie().equals(movChoice) && obj.getCineplex().equals(cineplex)){
						k++;
					}
					}
				if (k==1){
					System.out.println("This movie has no showtimes in this cineplex yet! Please wait for the staff to add show times");
					return;
				}
				else{
		        	System.out.println("Which Cinema?");
				
		        	if (cineplex =="OrchardCine"){
		        		System.out.println("1. OR1");
		        		System.out.println("2. OR2");
		        		System.out.println("3. OR3");
		        	}
		        	else if (cineplex =="JPCine"){
		        		System.out.println("1. JP1");
		        		System.out.println("2. JP2");
		        		System.out.println("3. JP3");
		        	}
		        	else{
		        		System.out.println("1. TH1");
		        		System.out.println("2. TH2");
		        		System.out.println("3. TH3");
		        	}
		        		
				}
				choiceStr = sc.nextLine();
				choice = Integer.parseInt(choiceStr);
				if (choice<1 || choice>3){
					System.out.println("Wrong input. Please try again");
				}
	    	}while(choice<1||choice>3);
	    	
			if (cineplex.equals("OrchardCine")){
				if (choice == 1)
					cinema = "OR1";
				else if(choice ==2)
					cinema = "OR2";
				else
					cinema="OR3";
			}
			else if (cineplex.equals("JPCine")){
				if (choice == 1)
					cinema = "JP1";
				else if(choice ==2)
					cinema = "JP2";
				else
					cinema="JP3";
				
			}
			else{
				if (choice == 1)
					cinema = "TH1";
				else if(choice ==2)
					cinema = "TH2";
				else
					cinema="TH3";							//getting cinema
			}
			
			k=1;
			for (int i=0; i<timing.size();i++){
				showTime obj = (showTime)timing.get(i);
				if(obj.getMovie().equals(movChoice) && obj.getCineplex().equals(cineplex)
						&& obj.getCinema().equals(cinema)){
					k++;
				}
				}
			if (k==1){
				System.out.println("This movie has no showtimes in this cinema yet! Please wait for the staff to add show times");
				return;
			}
		
		System.out.println("Which Day?");
		
		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar x = Calendar.getInstance();
		Calendar y = Calendar.getInstance();
		Calendar z = Calendar.getInstance();
		x.setTime(new Date()); // Now use today date.
		y.setTime(new Date()); 
		z.setTime(new Date()); 
		y.add(Calendar.DATE, 1); // Adding 1 days
		z.add(Calendar.DATE, 2); // Adding 2 days
		String output1 = sdf.format(x.getTime());
		String output2 = sdf.format(y.getTime());
		String output3 = sdf.format(z.getTime());
		
		do{
			System.out.println("1. "+output1);
			System.out.println("2. "+output2);
			System.out.println("3. "+output3);
	    
			choice = sc.nextInt();
			if (choice == 1){
				day = String.valueOf(output1);
				tempDay = output1;
			}
			else if (choice ==2){
				day = String.valueOf(output2);
				tempDay = output2;
			}
			else if (choice ==3){
				day = String.valueOf(output3);
				tempDay = output3;
			}
			else{
				System.out.println("Wrong input! Please choose again!");
				day ="";
			}
		}while(day=="");

		sc.nextLine();			//clear buffer
		

						k=1;
						
						for (int i=0; i<timing.size();i++){
							showTime obj = (showTime)timing.get(i);
							if (obj.getMovie().equals(movChoice) && obj.getCineplex().equals(cineplex)
									&& obj.getCinema().equals(cinema)){
									obj.setNum(k);
									k++;
							}
							}
						
						
						System.out.println("Which showtime will you like?");
						for (int i=0; i<timing.size();i++){
							showTime obj = (showTime)timing.get(i);
							if (obj.getMovie().equals(movChoice) && obj.getCineplex().equals(cineplex)
									&& obj.getCinema().equals(cinema)){
							System.out.println(obj.getnum()+". "+obj.getTime());
							}
							}
						
				
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);

			
			// we got our choice
	
						for (int i=0; i<timing.size();i++){
							showTime obj = (showTime)timing.get(i);
							if (obj.getnum() == choice){
								time = String.valueOf(obj.getTime());			// we have time now
							}
							}
						
						
		
		filename +=( cineplex+"/"+ cinema +"/" +movChoice+"/"+day+"/"+time+".txt");		
		fileDirectory += (cineplex+"/"+ cinema +"/" +movChoice+"/"+day);
		
		File theDir = new File(fileDirectory);

		// if the directory does not exist, create it
		if (!theDir.exists()) {

		    try{
		        theDir.mkdirs();
		    }catch(SecurityException se){
		        //handle it
		    }
		}
		
			File myFile = new File(filename);
			if(!myFile.exists()) {
			    myFile.createNewFile();
			} 			
			// read file containing Movie records.		
			ArrayList<Seat> al = list.readSeats(filename) ; // now al is a list of seat objects BOOKED				
			Seat[][] seatArray = new Seat[5][5] ;
			String index = "ABCDE";
				for (int i=0;i<5;i++){
					for(int j=0; j<5;j++){
						char first = index.charAt(i);				// get ABCDE
						char second = Integer.toString(j+1).charAt(0); 	// get 12345
						StringBuilder sb = new StringBuilder();
						sb.append(first);
						sb.append(second);
						String ID = sb.toString();			// now we have a seat ID...
						
						for (int a = 0 ; a < al.size() ; a++) {
							flag =0;
							Seat seat = (Seat)al.get(a);
							if (seat.getSeatID().equals(ID)){
								System.out.print("[X]");
								flag =1;
								break;
							}

							}
						if (flag!=1)
							System.out.print(ID+" ");
					}
					System.out.println();

				}

		System.out.println("Which seat will you like?");
		
		do{
			book = sc.nextLine();						//book = seatID!
			flag =0;
			for (int a = 0 ; a < al.size() ; a++) {
				Seat seat = (Seat)al.get(a);
				if (seat.getSeatID().equals(book)){
					flag=1;
					break;
				}
				else
					flag =0;
			}
		
		if (flag==1){
			System.out.println("The seat you have chosen is already booked.");
			System.out.println("Please choose again!");
		}
		
		}while(flag ==1);
			
		

		System.out.println("What is your name sir/mdm?");
		customerName = sc.nextLine();							//customerName!
		customerName = customerName.toLowerCase();
		
		System.out.println("What is your number sir/mdm?");
		hp = sc.nextLine();							//customerName!
		
		System.out.println("What is your email sir/mdm?");
		email= sc.nextLine();
		
		
		do{
		System.out.println("What is your age category sir/mdm?");
		System.out.println("1. Child (Age < 18)");
		System.out.println("2. Adult(Age: 18-55)");
		System.out.println("3. Senior Citizen(Age > 55)");
		choice = sc.nextInt();			
		if (choice==1)
			ageType = "Child";
		else if (choice==2)
			ageType ="Adult";
		else if (choice ==3)
			ageType = "Senior Citizen";
		else{
			ageType = "";
			System.out.println("Wrong input! Please input your choice again (1-3)");
			System.out.println("1. Child (Age < 18");
			System.out.println("2. Adult(Age: 18-55");
			System.out.println("3. Senior Citizen(Age > 55");
		}
		}while (ageType=="" );					// Age type!
        AudienceCtr check = new AudienceCtr();
		String finalDay = check.check(String.valueOf(date), String.valueOf(month), String.valueOf(year), DAY);
		
		// Digital GoldClass OR1 Adult Weekday
		
		AudienceCtr ticMgr = new AudienceCtr();
		finalTicket = ticMgr.getTicket(movieType, cinemaType, cinema, ageType, finalDay);
		// final ticket created
		
		String ticPrice = String.valueOf(finalTicket.getPrice());
		
		System.out.println("The ticket will cost you: $SGD"+ ticPrice);
		System.out.println("Please confirm to pay");
	
		do{
			System.out.println("1. Confirm");
			System.out.println("2. Quit");
			choice = sc.nextInt();
			if (choice != 1 && choice !=2){
				System.out.println("Wrong input! Please choose again");
				choice =0;
			}
		}while (choice ==0);
		
		if (choice ==2)
			return;				//escape the program
		
		if (choice ==1){
	
		Seat booked = new Seat(book,customerName);
		al.add(booked);
		list.saveSeat(filename, al);			// saved to seats file
		
		// here we create transaction ID!!
		
		now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1; // Note: zero based!
		DAY = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		
		// int to String and building string
		
		StringBuilder stringBuilder = new StringBuilder();
		
		 stringBuilder.append(cinema);
		 stringBuilder.append(String.valueOf(year));
		 if(month<10){
			 stringBuilder.append("0"+String.valueOf(month));
		 }
		 else{
			 stringBuilder.append(String.valueOf(month));
		 }
		 if (DAY<10){
			 stringBuilder.append("0"+String.valueOf(DAY));
		 }
		 else{
			 stringBuilder.append(String.valueOf(DAY));
		 }
		 if(hour<10){
			 stringBuilder.append("0"+String.valueOf(hour));
		 }
		 else{
			 stringBuilder.append(String.valueOf(hour));
		 }
		 if (minute<10){
			 stringBuilder.append("0"+String.valueOf(minute));
		 }
		 else{
		 stringBuilder.append(String.valueOf(minute));
		 }

		String ticID = stringBuilder.toString();					//ticID is here!
		
		// creating final ticket of this transaction

		finalTicket.setSerialNum(ticID);
		
		System.out.println("Your booking has been confirmed for seat "+ book);
		
		
		// Here we are adding transaction into file!!
    	readwrite mg = new readwrite();
    	String fileGoer = "src/Database/MovieGoer.txt" ;
			
			ArrayList mg2 = mg.readGoer(fileGoer) ;
			
			MovieGoer person = new MovieGoer(customerName, hp, email, movChoice, tempDay,time, ticPrice,cineplex,cinema,ticID);
			mg2.add(person);
			mg.saveGoer(fileGoer, mg2);		//adding newly created "transaction" person into file
		}		
		// Here we are adding movie ticketsale!!!
		ArrayList<Movie> newList = new ArrayList();
		for (int i=0; i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			if (obj.getTitle().equals(movChoice)){
				obj.addTicketSale();
			}
			newList.add(obj);
			list.saveMovie("src/Database/Movies.txt",newList);	
		}
					}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
					}
		}
		
		
				
		
					
					
	
	
	// sorting algo
	/**
	 * sort list of movie by ticket sales or review score
	 * @throws IOException
	 */
	public void sort() throws IOException{
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Do you want to sort by:");
		System.out.println("1. Ticket Sales");
		System.out.println("2. Review Score");
		choice = sc.nextInt();
		
		while(choice!=1 && choice!=2){
			System.out.println("Wrong input! Please try again");
			System.out.println("1. Ticket Sales");
			System.out.println("2. Review Score");
			choice = sc.nextInt();
		}
		
		try{
		readwrite movList = new readwrite();
		ArrayList<Movie> mov = movList.readMovies("src/Database/Movies.txt");
		ArrayList newList = new ArrayList();
		
		int a;
		if (mov.size() >5)
			a=5;
		else
			a=mov.size();
		
		if (choice==1){
		
			//insertion sort to sort the movie objects
			for (int i=1; i<mov.size();i++){
				for (int j=i; j>0;j--){
				Movie obj1 = (Movie)mov.get(j-1);	
				Movie obj2 = (Movie)mov.get(j);
				
				if (obj2.getTicketSale() >obj1.getTicketSale()){
					Movie tempObj = obj2;
					mov.set(j, obj1);
					mov.set(j-1, tempObj);
				}
				else
					break;
					
				}

			}
			
			
			for (int k=0;k<a;k++){
				Movie obj = (Movie)mov.get(k);
				System.out.println("Movie: "+obj.getTitle());
				System.out.println("Ticket Sales: " +obj.getTicketSale());
				System.out.println();
			}
		}
		else{
			for (int i=1; i<mov.size();i++){
				for (int j=i; j>0;j--){
				Movie obj1 = (Movie)mov.get(j-1);	
				Movie obj2 = (Movie)mov.get(j);
				
				if (obj2.getScore() >obj1.getScore()){
					Movie tempObj = obj2;
					mov.set(j, obj1);
					mov.set(j-1, tempObj);
				}
				else
					break;
					
				}

			}
			
			
			// putting the score into 1 decimal point
			for (int k=0;k<a;k++){
				Movie obj = (Movie)mov.get(k);
				System.out.println("Movie: "+obj.getTitle());
				DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
				System.out.println("Review Score: " +oneDigit.format(obj.getScore()));
				System.out.println("");

		}

		}
		movList.saveMovie("src/Database/Movies.txt",mov);
		
	} catch (IOException e) {
		System.out.println("IOException > " + e.getMessage());
	}
}
	
	// ticket manager
	/**
	 * To get price for ticket
	 * @param type
	 * @param cinema
	 * @param cineCode
	 * @param age 
	 * @param day
	 * @return
	 */
	public Ticket getTicket(String type, String cinema, String cineCode, String age, String day){
		// variables for us to create Ticket object
		String movie ="";
		String cinemaType="";
		double ticketPrice=0;	//we are going to add it up
		
		
	try{
		readwrite list = new readwrite();
		// Initialize all the Arraylist for the price determinants
		ArrayList a = list.readPriceAge(fileAge);
		ArrayList t = list.readPriceType(fileType);
		ArrayList c = list.readPriceCinema(fileCinema);
		ArrayList d = list.readPriceDay(fileDay);
		
		//getting the information to create a ticket class by comparing the attributes with database
		

		for (int i = 0 ; i < a.size() ; i++){
			PriceAge ageValue = (PriceAge)a.get(i);
			if (age.equals(ageValue.get())){					// age is part of the parameters!
				ticketPrice += ageValue.getPrice();				
				break;
			}
		}
		

		for (int i = 0 ; i < t.size() ; i++){
			PriceType typeValue = (PriceType)t.get(i);
			if (type.equals(typeValue.get())){
				ticketPrice += typeValue.getPrice();		
				movie = typeValue.get();				//blockbuster etc
				break;
			}
		}

		
		

		for (int i = 0 ; i < d.size() ; i++){
			PriceDay dayValue = (PriceDay)d.get(i);
			if (day.equals(dayValue.get())){
				ticketPrice += dayValue.getPrice();		//price by day
				break;
			}

		}


		for (int i = 0 ; i < c.size() ; i++){
			PriceCinema cinemaValue = (PriceCinema)c.get(i);
			if (cinema.equals(cinemaValue.get())){
				ticketPrice += cinemaValue.getPrice();		// price by cinema
				break;
			}
		}

		

		
	}catch (IOException e) {
		System.out.println("IOException > " + e.getMessage());
	}
	
	
	// blockbuster, platinum, adult, weekday, price
	Ticket tic = new Ticket(movie, cinemaType, age, day, ticketPrice);
	return tic;
}
	
	
	
	// user review
	/**
	 * Get review from user
	 */
	public void userReview() {
		Scanner sc = new Scanner(System.in);
		// its own readwrite function
		readwrite list = new readwrite();
		try{
			System.out.println("Please choose a movie to add a review/ give a review score to: ");
			ArrayList mov = list.readMovies("src/Database/Movies.txt");
			ArrayList re = list.readMovieReview("src/Database/MovieReviews.txt");
			ArrayList ms = list.readMovieScore("src/Database/MovieScore.txt");

		
			try{//Creating a menu for user reviews
				for (int i=0;i<mov.size();i++){
					Movie obj = (Movie)mov.get(i);
					if (obj.getShow().equals("Preview")||obj.getShow().equals("Now Showing")){
					System.out.println(k+". "+obj.getTitle());
					obj.setdisplaynum(k);
					k++;
					}
			}
			System.out.println(k+ ". Quit");
			}catch(NumberFormatException e){
				System.out.println("Invalid Input. Please input number between the range given\n");
			}
			
			do{
			
			review = sc.nextInt();
			System.out.println(); 
			if (review<0 && review>k){
				System.out.println("Input is wrong! Please input again");
			}
			}while(review<0 && review>k);
			// now we have a choice review, which movie to review for
			
			if (review ==k)
				return;							// ends this function
			
			System.out.println("What do you want to do?");
			System.out.println("1. Add a review");
			System.out.println("2. Give a review score");
			
			choice = sc.nextInt();
			while(choice>2 || choice <1){
				System.out.println("Wrong input! Please input again");
				System.out.println("1. Add a review");
				System.out.println("2. Give a review score");
				choice = sc.nextInt();
			}

			if (choice ==1){

				
				for (int i=0;i<mov.size();i++){
					Movie obj = (Movie)mov.get(i);
					if (obj.getdisplaynum() == review){
						reviewMov = obj.getTitle();							// we have movie name here
						break;		// this will end the for loop
					}
					}
				System.out.println("May I have your name?");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please input your review");
				comments = sc.nextLine();
				
				MovieReview obj = new MovieReview(reviewMov,name,comments);
				re.add(obj);
				list.saveMovieReview("src/Database/MovieReviews.txt",re);
				System.out.println("Your review has been received, thank you very much");
				//saved review!
			}
			
			// choice == 2
			else{
				System.out.println("How many points do you want to give to this movie? Please input a number between 1-5");
				do{
				score = sc.nextInt();
				if(score<1||score>5){
					System.out.println("Wrong input! Please input again");
				}
				}while(score<1||score>5);
				
				for (int i=0;i<mov.size();i++){
					Movie obj = (Movie)mov.get(i);
					if (obj.getdisplaynum() == review){
						reviewMov = obj.getTitle();
					
						System.out.println("Sir/Mdm what is your name?");
						sc.nextLine();
						name = sc.nextLine();
						obj.addScoreCounter();
						obj.addScore(score);
						// score added, counter incremented by 1
						// Adding the list back to txt file
						
						list.saveMovie("src/Database/Movies.txt", mov);
						System.out.println("Score added! Thank you!");
						break;		// this will end the for loop
					}
					}
				
				MovieScore obj = new MovieScore(reviewMov,name,score);
				ms.add(obj);
				list.saveMovieScore("src/Database/MovieScore.txt",ms);
				
				
				
			}

		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
	
	// view history
	/**
	 * History of customer ticket purchase
	 */
	public void history(){
		String name;
		String num;
		int a = 0; // counter
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is your name?");
		name = sc.nextLine().toLowerCase();
		System.out.println("What is your handphone number?");
		num = sc.nextLine();
		
		try{
		readwrite goList = new readwrite();
		ArrayList goer = goList.readGoer("src/Database/MovieGoer.txt");
		for(int i=0; i<goer.size();i++){
			MovieGoer obj = (MovieGoer)goer.get(i);
			if (obj.getName().equals(name) && (obj.getHp().equals(num))){		// get hp here is a string
				System.out.println("Movie: "+obj.getTitle()+" ");
				System.out.println("Date: "+obj.getDate()+" ");
				System.out.println("Time: "+obj.getTime()+" ");
				System.out.println("Price: SGD"+obj.getPrice()+" ");
				System.out.println("Cineplex: "+obj.getCineplex()+" ");
				System.out.println("Cinema: "+obj.getCinema()+" ");
				System.out.println("TransactionID: "+obj.getID()+" ");
				System.out.println();
				a+=1;
			}
		}
		
		if (a==0){
			System.out.println("Sorry the name and handphone you keyed in do no exist");
		}
		
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
	//check date
	public String check(String date, String month, String year, int day){
		readwrite Harray = new readwrite();
    	String filename = "src/Database/PublicHolidays.txt" ;
		try {
			// read file containing Professor records.
			ArrayList al = Harray.readHoliday(filename) ;
			for (int i = 0 ; i < al.size() ; i++) {
					Holiday Hday = (Holiday)al.get(i);
					if (Hday.getDay().equals(date) && Hday.getMonth().equals(month) && Hday.getYear().equals(year)){
						return "Public Holiday";
					}
	}
		}catch (IOException e) {
		System.out.println("IOException > " + e.getMessage());
		}
			if (day==2 || day ==3 || day==4|| day==5|| day==6)
					return ("Weekday");
			else 
				return ("Weekend");
		}
	
	
	// show all reviews and review scores
	/**
	 * show all reviews and review scores
	 */
	public void showReviews(){
		Scanner sc = new Scanner(System.in);
		readwrite review = new readwrite();
		try {
		ArrayList mov = review.readMovies("src/Database/Movies.txt");
		ArrayList a = review.readMovieScore("src/Database/MovieScore.txt");
		ArrayList b = review.readMovieReview("src/Database/MovieReviews.txt");
		
		System.out.println("Which movie will you like to see the reviews and scores?");
		
		k=1;
		for (int i=0;i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			obj.setdisplaynum(k);
			System.out.println(obj.getdisplaynum()+". "+obj.getTitle());
			k++;
			}
		choice = sc.nextInt();
		
		for (int i=0;i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			if(obj.getdisplaynum() == choice){
				movChoice = obj.getTitle();
				break;
			}
			}
		
		System.out.println("The scores");
		for (int i=0;i<a.size();i++){
			MovieScore obj = (MovieScore)a.get(i);
			if(obj.getMovie().equals(movChoice)){
				System.out.println("Name: "+ obj.getName()+ " Score: "+obj.getScore());
			}
			}
		System.out.println();
		System.out.println("The reviews");
		for (int i=0;i<b.size();i++){
			MovieReview obj = (MovieReview)b.get(i);
			if(obj.getMovie().equals(movChoice)){
				System.out.println("Name: "+ obj.getName()+ " Review: "+obj.getReview());
			}
			}


		}catch (IOException e) {
		System.out.println("IOException > " + e.getMessage());
		}
		}
	
	// show all Show times!
	/**
	 * display showtimes for all movies
	 */
	public void show_showtime(){
		Scanner sc = new Scanner(System.in);
		readwrite review = new readwrite();
		try {
		ArrayList mov = review.readMovies("src/Database/Movies.txt");
		ArrayList a = review.readShowtime("src/Database/Showtimes.txt");
		
		System.out.println("Which movie will you like to see the reviews and scores?");
		
		k=1;
		for (int i=0;i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			obj.setdisplaynum(k);
			System.out.println(obj.getdisplaynum()+". "+obj.getTitle());
			k++;
			}
		choice = sc.nextInt();
		
		for (int i=0;i<mov.size();i++){
			Movie obj = (Movie)mov.get(i);
			if(obj.getdisplaynum() == choice){
				movChoice = obj.getTitle();
				break;
			}
			}
		
		System.out.println("The Showtimes");
		for (int i=0;i<a.size();i++){
			showTime obj = (showTime)a.get(i);
			if(obj.getMovie().equals(movChoice)){
				System.out.println("Cineplex: "+ obj.getCineplex());
				System.out.println("Cinema: "+obj.getCinema());
				System.out.println("Timing: "+ obj.getTime());
				System.out.println();
			}
			}


		}catch (IOException e) {
		System.out.println("IOException > " + e.getMessage());
		}
		}
	}


	


