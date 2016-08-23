package StaffMgr;

import java.io.IOException;
import java.util.Scanner;

import Moblima.AudienceCtr;;

/**
 * Class Staff Menu
 * @author
 *
 */
public class StaffMenu {
	/**
	 * Scanner
	 */
	private Scanner sc;
	/**
	 * Staff menu
	 */
	public StaffMenu(){
		 sc = new Scanner(System.in);
	}
	/**
	 * Staff menu
	 */
	public void staffMenu(){
		String choiceStr="";
		int choice = 0;
		do{
				try{
					System.out.println("=============== Menu ===============");
					System.out.println("|1. Change Ticket Prices           ");
					System.out.println("|2. Change Holidays                ");
					System.out.println("|3. Enter New Movies               ");
					System.out.println("|4. Update Movie Status/ Showtime   ");
					System.out.println("|5. Add new showtime  				 ");
					System.out.println("|6. Show Top 5 Ranking Movies   	");
					System.out.println("|7. Logout                         ");
					System.out.println("====================================");
		
					System.out.print("\nPlease choose: ");
					choiceStr = sc.nextLine();
					System.out.println();
					choice = Integer.parseInt(choiceStr);
				}catch(NumberFormatException e){
					System.out.println("Invalid Input. Only numbers between 1 to 7 are accepted.\n");
				}
				
				try{
			
			switch(choice){
			
			case 1: {
						StaffCtr cp = new StaffCtr();
						cp.changePrice();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
			case 2: {
				        StaffCtr ch = new StaffCtr();
						ch.changeHolidays();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
			case 3: {
						StaffCtr cm = new StaffCtr();
						cm.Create();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
			case 4: {
						StaffCtr um = new StaffCtr();
						um.updateStatus();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
			
			case 5: {
						StaffCtr um = new StaffCtr();
		        		um.addShowTime();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
					
			case 6: {
				        AudienceCtr s = new AudienceCtr();
						s.sort();
						System.out.println("Press any key to continue.");
						if(sc.nextLine() != ""){
							break;
						}
					}
			
			case 7: {
						System.out.println("\nYou have been logged out.\n");
							break;
					}
			
			default: {
						System.out.println("Invalid Choice! Please Try Again. \n");
						break;
					}
			}
			
			
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		} 
	}while(choice <7);
	
	}
}