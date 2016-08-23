package Database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Moblima.Cinema;
import Moblima.Cineplex;
import Moblima.Holiday;
import Moblima.Movie;
import Moblima.MovieGoer;
import Moblima.Seat;
import Price.PriceAge;
import Price.PriceCinema;
import Price.PriceDay;
import Price.PriceType;
import StaffMgr.Staff;

public class readwrite {

		public static final String SEPARATOR = "|";

		// ATTENTION: Cineplex read and write methods!
		public static ArrayList readCineplex(String filename) throws IOException {
			// read String from text file
			ArrayList stringArray = (ArrayList)read(filename);
			ArrayList cineplexArray = new ArrayList() ;// to store movies data

	        for (int i = 0 ; i < stringArray.size() ; i++) {
					String st = (String)stringArray.get(i);
					StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

					String  name = star.nextToken().trim();	// first token
					String  address = star.nextToken().trim();	// second token
					
					// create movie object from file data
					Cineplex cine = new Cineplex(name,address);
					// add to movie list
					cineplexArray.add(cine) ;
				}
				return cineplexArray ;
		}
		
		public static void printCineplex(String filename) throws IOException {
			// read String from text file
			ArrayList stringArray = (ArrayList)read(filename);

	        for (int i = 0 ; i < stringArray.size() ; i++) {
					String st = (String)stringArray.get(i);
					StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

					String  name = star.nextToken().trim();	// first token
					String  address = star.nextToken().trim();	// second token
					System.out.println("Cineplex name: "+name);
					System.out.println("Cineplex Address: "+address);
					System.out.println();
					
				}
		}
		
		
		// Seat methods
		
		public static ArrayList<Seat> readSeats(String filename) throws IOException {
			ArrayList<String> stringArray = (ArrayList)read(filename);
			ArrayList<Seat> seatArray = new ArrayList<Seat>() ;

	        for (int i = 0 ; i < stringArray.size() ; i++) {
					String st = (String)stringArray.get(i);

					StringTokenizer star = new StringTokenizer(st , SEPARATOR);
					
					while(star.hasMoreTokens()){
					
					String seatID = star.nextToken().trim();	
					String customerName = star.nextToken().trim();
					Seat seat = new Seat(seatID,customerName);
					seatArray.add(seat) ;
					
					}
				}
				return seatArray ;
		}
		  public static void saveSeat(String filename, List al) throws IOException {
		  		List<String> alw = new ArrayList<String>() ;

		          for (int i = 0 ; i < al.size() ; i++) {
		  				Seat seat = (Seat)al.get(i);
		  				StringBuilder st =  new StringBuilder() ;
		  				st.append(seat.getSeatID().trim());
		  				st.append(SEPARATOR);
		  				st.append(seat.getCustomerName().trim());
		  				alw.add(st.toString()) ;
		  			}
		  			write(filename,alw);
		  	}
		
		// Cinema methods
			public static ArrayList<Cinema> readCinema(String filename) throws IOException {
				// read String from text file
				ArrayList stringArray = (ArrayList)read(filename);
				ArrayList<Cinema> cinemaArray = new ArrayList() ;// to store movies data

		        for (int i = 0 ; i < stringArray.size() ; i++) {
						String st = (String)stringArray.get(i);
						// get individual 'fields' of the string separated by SEPARATOR
						StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

						String  cineplex = star.nextToken().trim();	// first token
						String  id = star.nextToken().trim();	// second token
						String  type = star.nextToken().trim();

						// create cinema object from file data
						Cinema cine = new Cinema(cineplex,id,type);
						// add to cinema list
						cinemaArray.add(cine) ;
					}
					return cinemaArray ;
			}
		
		// Holiday methods
			
			public static ArrayList readHoliday(String filename) throws IOException {
				// read String from text file
				ArrayList<String> stringArray = (ArrayList)read(filename);
				ArrayList<Holiday> holidayArray = new ArrayList<Holiday>() ;// to store holiday data

		        for (int i = 0 ; i < stringArray.size() ; i++) {
						String st = (String)stringArray.get(i);
						// get individual 'fields' of the string separated by SEPARATOR
						StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

						String  day = star.nextToken().trim();	// first token
						String  month = star.nextToken().trim();	// second token
						String  year = star.nextToken().trim();
						String  why = star.nextToken().trim();

						// create holiday object from file data
						Holiday Hday = new Holiday(day,month,year,why);
						// add to holiday list
						holidayArray.add(Hday) ;
					}
					return holidayArray ;
			}
			
			
			public static void saveHoliday(String filename, List al) throws IOException {
				List<String> alw = new ArrayList<String>() ;

		        for (int i = 0 ; i < al.size() ; i++) {
						Holiday Hday = (Holiday)al.get(i);
						StringBuilder st =  new StringBuilder() ;
						st.append(Hday.getDay().trim());
						st.append(SEPARATOR);
						st.append(Hday.getMonth().trim());
						st.append(SEPARATOR);
						st.append(Hday.getYear().trim());
						st.append(SEPARATOR);
						st.append(Hday.getHday().trim());
						alw.add(st.toString()) ;
					}
					write(filename,alw);
			}
		
			
			
			
		// Movie goer methods
			
			public static ArrayList<MovieGoer> readGoer(String filename) throws IOException {
				// read String from text file
				ArrayList<String> stringArray = (ArrayList)read(filename);
				ArrayList<MovieGoer> goerArray = new ArrayList<MovieGoer>() ;// to store movies data

		        for (int i = 0 ; i < stringArray.size() ; i++) {
						String st = (String)stringArray.get(i);
						// get individual 'fields' of the string separated by SEPARATOR
						StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

						String  name = star.nextToken().trim();	// first token
						String  hp = star.nextToken().trim();	// second token
						String  title = star.nextToken().trim();
						String  date = star.nextToken().trim();
						String  time = star.nextToken().trim();
						String  price = star.nextToken().trim();
						String  cineplex = star.nextToken().trim();
						String  cinema = star.nextToken().trim();
						String  TranID = star.nextToken().trim();

						// create moviegoer object from file data
						MovieGoer Hday = new MovieGoer(name,hp,title,date,time,price,cineplex,cinema,TranID);
						// add to moviegoer list
						goerArray.add(Hday) ;
					}
					return goerArray ;
			}
			
			public static void saveGoer(String filename, List al) throws IOException {
				List<String> alw = new ArrayList<String>() ;

		        for (int i = 0 ; i < al.size() ; i++) {
						MovieGoer mGoer = (MovieGoer)al.get(i);
						StringBuilder st =  new StringBuilder() ;
						st.append(mGoer.getName().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getHp().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getTitle().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getDate().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getTime().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getPrice().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getCineplex().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getCinema().trim());
						st.append(SEPARATOR);
						st.append(mGoer.getID().trim());
						alw.add(st.toString()) ;
					}
					write(filename,alw);
			}
			
		// movie methods
			
			public static ArrayList<Movie> readMovies(String filename) throws IOException {
				// read String from text file
				ArrayList<String> stringArray = (ArrayList)read(filename);
				ArrayList<Movie> movieArray = new ArrayList<Movie>() ;// to store movies data

		        for (int i = 0 ; i < stringArray.size() ; i++) {
						String st = (String)stringArray.get(i);
						// get individual 'fields' of the string separated by SEPARATOR
						StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

						String  title = star.nextToken().trim();	// first token
						String  type = star.nextToken().trim();	// second token
						String  rating = star.nextToken().trim();	
						String  show = star.nextToken().trim();	
						String  runtime = star.nextToken().trim();	
						String  sypnosis = star.nextToken().trim();	
						String  director = star.nextToken().trim();	
						String  cast = star.nextToken().trim();	
						String  reviews = star.nextToken().trim();	
						double  score = Double.parseDouble(star.nextToken().trim()); 
						int  ticketSale = Integer.parseInt(star.nextToken().trim()); 	
						String  showtime1 = star.nextToken().trim();	
						String  showtime2 = star.nextToken().trim();	
						String  showtime3 = star.nextToken().trim();
						double  score_counter = Double.parseDouble(star.nextToken().trim()); 
						String  review_ratings = star.nextToken().trim();
						Movie mov = new Movie(title, type, rating,show,runtime,sypnosis,director,cast,reviews,score,ticketSale, showtime1, showtime2, showtime3, score_counter, review_ratings);
						// add to movie list
						movieArray.add(mov) ;
					}
					return movieArray ;
			}
			
			public static void printMovies(String filename) throws IOException {
				// read String from text file
				ArrayList<String> stringArray = (ArrayList)read(filename);

				System.out.println("Movie details: ");
		        for (int i = 0 ; i < stringArray.size() ; i++) {
						String st = (String)stringArray.get(i);
						// get individual 'fields' of the string separated by SEPARATOR
						StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

						String title = star.nextToken().trim();	// first token
						String type = star.nextToken().trim();	// second token
						String rating = star.nextToken().trim();	
						String show = star.nextToken().trim();	
						String runtime = star.nextToken().trim();	
						String sypnosis = star.nextToken().trim();	
						String director = star.nextToken().trim();	
						String cast = star.nextToken().trim();	
						String reviews = star.nextToken().trim();	
						double score = Double.parseDouble(star.nextToken().trim());
						int  ticketSale = Integer.parseInt(star.nextToken().trim()); 	
						String  showtime1 = star.nextToken().trim();	
						String  showtime2 = star.nextToken().trim();	
						String  showtime3 = star.nextToken().trim();
						double  score_counter = Double.parseDouble(star.nextToken().trim()); 
						String  review_ratings = star.nextToken().trim();
						
						System.out.println("Movie Title: "+title);
						System.out.println("Movie Type: "+type);
						System.out.println("Movie Rating: "+rating);
						System.out.println("Movie Status: "+show);
						System.out.println("Movie Run Time: "+runtime);
						System.out.println("Movie Sypnosis: "+sypnosis);
						System.out.println("Movie Director: "+director);
						System.out.println("Movie Casts: "+cast);
						if (!reviews.equals("0"))
							System.out.println("Movie Reviews: " + reviews);
						else 
							System.out.println("Movie Reviews: None at the moment");
						if (score_counter>1){
							DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
							System.out.println("Movie Overall Reviewer Rating: " +oneDigit.format(score));
						}
						else{ 

							System.out.println("Movie Overall Reviewer Rating: NA");

						}
						System.out.println();

					}
			}
			
			  public static void saveMovie(String filename, List al) throws IOException {
			  		List<String> alw = new ArrayList<String>() ;

			          for (int i = 0 ; i < al.size() ; i++) {
			  				Movie mov = (Movie)al.get(i);
			  				StringBuilder st =  new StringBuilder() ;
			  				st.append(mov.getTitle().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getType().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getRating().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getShow().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getRuntime().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getSypnosis().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getDirector().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getCast().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getReviews().trim());
			  				st.append(SEPARATOR);
			  				st.append(String.valueOf(mov.getScore()).trim());
			  				st.append(SEPARATOR);
			  				st.append(String.valueOf(mov.getTicketSale()).trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getShowTime1().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getShowTime2().trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getShowTime3().trim());
			  				st.append(SEPARATOR);
			  				st.append(String.valueOf(mov.getScoreCounter()).trim());
			  				st.append(SEPARATOR);
			  				st.append(mov.getReviewRatings().trim());
			  				alw.add(st.toString()) ;
			  			}
			  			write(filename,alw);
			  	}
		
		// Price age methods
			  
				public static ArrayList readPriceAge(String filename) throws IOException {
					// read String from text file
					ArrayList stringArray = (ArrayList)read(filename);
					ArrayList<PriceAge> AgeArray = new ArrayList<PriceAge>() ;

			        for (int i = 0 ; i < stringArray.size() ; i++) {
							String st = (String)stringArray.get(i);

							StringTokenizer star = new StringTokenizer(st , SEPARATOR);
							
							while(star.hasMoreTokens()){
							
							String age = star.nextToken().trim();	
							String price = star.nextToken().trim();
							double realprice = Double.parseDouble(price);
							PriceAge pa = new PriceAge(age,realprice);
							AgeArray.add(pa) ;
							
							}
						}
						return AgeArray ;
				}
				
				
				  public static void saveAge(String filename, List<?> al) throws IOException {
				  		List<String> alw = new ArrayList<String>() ;// to store Professors data

				          for (int i = 0 ; i < al.size() ; i++) {
				  				PriceAge age = (PriceAge)al.get(i);
				  				StringBuilder st =  new StringBuilder() ;
				  				st.append(age.getAge().trim());
				  				st.append(SEPARATOR);
				  				st.append(age.getPrice());
				  				alw.add(st.toString()) ;
				  			}
				  			write(filename,alw);
				  	}
				  
				  
		// price cinema
				  
					public static ArrayList<PriceCinema> readPriceCinema(String filename) throws IOException {
						// read String from text file
						ArrayList stringArray = (ArrayList)read(filename);
						ArrayList<PriceCinema> cinemaArray = new ArrayList<PriceCinema>() ;

				        for (int i = 0 ; i < stringArray.size() ; i++) {
								String st = (String)stringArray.get(i);

								StringTokenizer star = new StringTokenizer(st , SEPARATOR);
								
								while(star.hasMoreTokens()){
								
									String cinema = star.nextToken().trim();
									String price = star.nextToken().trim();
									double realprice = Double.parseDouble(price);
									PriceCinema pa = new PriceCinema(cinema,realprice);
									cinemaArray.add(pa) ;
								
								}
							}
							return cinemaArray ;
					}
					
					  public static void saveCinema(String filename, List al) throws IOException {
					  		List<String> alw = new ArrayList<String>() ;// to store Professors data

					          for (int i = 0 ; i < al.size() ; i++) {
					  				PriceCinema cinema = (PriceCinema)al.get(i);
					  				StringBuilder st =  new StringBuilder() ;
					  				st.append(cinema.getCinema().trim());
					  				st.append(SEPARATOR);
					  				st.append(cinema.getPrice());
					  				alw.add(st.toString()) ;
					  			}
					  			write(filename,alw);
					  	}
					  
		// Price Day methods
						public static ArrayList<PriceDay> readPriceDay(String filename) throws IOException {
							// read String from text file
							ArrayList stringArray = (ArrayList)read(filename);
							ArrayList<PriceDay> dayArray = new ArrayList<PriceDay>() ;

					        for (int i = 0 ; i < stringArray.size() ; i++) {
									String st = (String)stringArray.get(i);

									StringTokenizer star = new StringTokenizer(st , SEPARATOR);
									
									while(star.hasMoreTokens()){
									
										String day = star.nextToken().trim();	
										String price = star.nextToken().trim();
										double realprice = Double.parseDouble(price);
										PriceDay pa = new PriceDay(day,realprice);
										dayArray.add(pa) ;
									
									}
								}
								return dayArray ;
						}
						
						  public static void saveDay(String filename, List<?> al) throws IOException {
						  		List<String> alw = new ArrayList<String>() ;// to store Professors data

						          for (int i = 0 ; i < al.size() ; i++) {
						  				PriceDay day = (PriceDay)al.get(i);
						  				StringBuilder st =  new StringBuilder() ;
						  				st.append(day.getDay().trim());
						  				st.append(SEPARATOR);
						  				st.append(day.getPrice());
						  				alw.add(st.toString()) ;
						  			}
						  			write(filename,alw);
						  	}
						  
		// Price Type
						  
							public static ArrayList<PriceType> readPriceType(String filename) throws IOException {
								// read String from text file
								ArrayList stringArray = (ArrayList)read(filename);
								ArrayList<PriceType> TypeArray = new ArrayList<PriceType>() ;

						        for (int i = 0 ; i < stringArray.size() ; i++) {
										String st = (String)stringArray.get(i);

										StringTokenizer star = new StringTokenizer(st , SEPARATOR);
										
										while(star.hasMoreTokens()){
										
										String type = star.nextToken().trim();	
										String price = star.nextToken().trim();
										double realprice = Double.parseDouble(price);
										PriceType pt = new PriceType(type,realprice);
										TypeArray.add(pt) ;
										
										}
									}
									return TypeArray ;
							}
							
							  public static void saveType(String filename, List al) throws IOException {
							  		List<String> alw = new ArrayList<String>() ;// to store Professors data

							          for (int i = 0 ; i < al.size() ; i++) {
							  				PriceType type = (PriceType)al.get(i);
							  				StringBuilder st =  new StringBuilder() ;
							  				st.append(type.getType().trim());
							  				st.append(SEPARATOR);
							  				st.append(type.getPrice());
							  				alw.add(st.toString()) ;
							  			}
							  			write(filename,alw);
							  	}
							  
		// Staff methods
							  
								public static ArrayList readStaff(String filename) throws IOException {
									// read String from text file
									ArrayList stringArray = (ArrayList)read(filename);
									ArrayList StaffArray = new ArrayList() ;

							        for (int i = 0 ; i < stringArray.size() ; i++) {
											String st = (String)stringArray.get(i);

											StringTokenizer star = new StringTokenizer(st , SEPARATOR);
											
											while(star.hasMoreTokens()){
											
											String name = star.nextToken().trim();	
											String password = star.nextToken().trim();
											Staff person = new Staff(name,password);
											StaffArray.add(person) ;
											
											}
										}
										return StaffArray ;
								}
								
								  public static void saveStaff(String filename, List al) throws IOException {
								  		List alw = new ArrayList() ;// to store Professors data

								          for (int i = 0 ; i < al.size() ; i++) {
								  				Staff person = (Staff)al.get(i);
								  				StringBuilder st =  new StringBuilder() ;
								  				st.append(person.getName().trim());
								  				st.append(SEPARATOR);
								  				st.append(person.getPassword());
								  				alw.add(st.toString()) ;
								  			}
								  			write(filename,alw);
								  	}
		
		// ATTENTION: Generic read and write methods!
		  public static List read(String fileName) throws IOException {
				List data = new ArrayList() ;
			    Scanner scanner = new Scanner(new FileInputStream(fileName));
			    try {
			      while (scanner.hasNextLine()){
			        data.add(scanner.nextLine());
			      }
			    }
			    finally{
			      scanner.close();
			    }
			    return data;
			  }
		  
		  // write
		  public static void write(String fileName, List data) throws IOException  {
			    PrintWriter out = new PrintWriter(new FileWriter(fileName));

			    try {
					for (int i =0; i < data.size() ; i++) {
			      		out.println((String)data.get(i));
					}
			    }
			    finally {
			      out.close();
			    }
			  }
	}



