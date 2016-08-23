package Moblima;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Database.readwrite;
import StaffMgr.StaffCtr;
import StaffMgr.StaffMenu;



/**
 * Main app for customer
 */
public class MoblimaApp {
	/**
	 * flag counter
	 */
	static int flag;
	/**
	 * choice input
	 */
	static int choice;
	/**
	 * Scanner
	 */
	static Scanner sc = new Scanner(System.in);
	/**
	 * main app
	 * @param args
	 */
	public static void main(String[] args) {
	String choiceStr = "";
		
		// user menu
		do {
			try {
					System.out.println("================== Menu =====================");
					System.out.println("|1. Our Cineplexes                       	");
					System.out.println("|2. Movie Listing and details            	");
					System.out.println("|3. Movie Showtimes			            	");
					System.out.println("|4. Top 5 Movies by Review or Tickets Sold	");
					System.out.println("|5. Book Tickets                            ");
					System.out.println("|6. View Transaction History            	");
					System.out.println("|7. Add Review or Review Score				");
					System.out.println("|8. View past movie reviews and ratings 	");
					System.out.println("|9. Login as Staff                      	");
					System.out.println("|10. Quit                                	");
					System.out.println("=============================================");

					System.out.print("\nPlease choose: ");
					System.out.println();
					choiceStr = sc.nextLine();
					choice = Integer.parseInt(choiceStr);
					
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input. Only numbers between 1 to 10 are accepted.\n");
		}
			
			try{
			switch (choice) {

			case 1:{
				readwrite ca = new readwrite();
				ca.printCineplex("src/Database/Cineplex.txt");
				System.out.println();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
				
			}
			
			case 2:{
				readwrite ma = new readwrite();
				ma.printMovies("src/Database/Movies.txt");
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			}
			
			case 3:{
				AudienceCtr show = new AudienceCtr();
				show.show_showtime();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			}
			
			case 4:{
				AudienceCtr sort = new AudienceCtr();
				sort.sort();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			}
			
			case 5:{
				AudienceCtr bs = new AudienceCtr();
				bs.bookTicket();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			}
			
			case 6:{
				AudienceCtr vh = new AudienceCtr();
				vh.history();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			
			}
			
			case 7:{
				AudienceCtr ur = new AudienceCtr();
				ur.userReview();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			
			}
			case 8:{
				AudienceCtr ur = new AudienceCtr();
				ur.showReviews();
				System.out.println("Press any key to continue.");
				if(sc.nextLine() != ""){
					break;
				}
			
			}
			
			case 9:{
				StaffCtr cg = new StaffCtr();
				boolean check = cg.Login();
				if (check == true){
					System.out.println("You have logged in");
					StaffMenu sm = new StaffMenu();
					sm.staffMenu();
				}
				else
					System.out.println("Failed to login. Please try again");
					System.out.println("Press any key to continue.");
					if(sc.nextLine() != ""){
					break;
				}
			}
			}
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
				}
	} while (choice != 10);
		System.out.println("Program terminating...");
		sc.close();

}
}


			





		

