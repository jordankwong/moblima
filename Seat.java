package Moblima;
/**
 * Class Seats
 * @author 
 *
 */
public class Seat {
	/**
	 * Seat ID
	 */
    private String seatID;
    /**
     * Seats occupied
     */
    private boolean assigned;
    /**
     * name of customer occupying seat
     */
    private String customerName;
    
    // set and get methods
    /**
     * Seat
     * @param seatID
     * @param name
     */
    public Seat(String seatID, String name){
    this.seatID = seatID;
    this.customerName = name;
    }
    /**
     * Seat ID
     * @return Seat ID
     */
    public String getSeatID(){
        return seatID;
    }
    /**
     * Customer Name
     * @return Customer Name
     */
    public String getCustomerName(){
        return customerName;
    }
    /**
     * Seat Availability
     * @return Boolean true or false
     */
    public boolean isAvailable(){
    	if (customerName != "")
    		return true;
    	return false;
    }
    /**
     * Seat occupied
     * @param name
     * @return Boolean true
     */
    public boolean assignSeat(String name){
    	if(isAvailable()){
    		this.customerName = name;
        	assigned = true;
        	return true;
    	}
    	return false;
    }
    /**
     * Remove Assigned seat
     */
    public void unAssignSeat(){
    	assigned = false;
    }
    /**
     * Show seats layout and seats availability
     */
    public void printSeat(){
    	if(assigned) System.out.print("[X]");
    	else System.out.print("[ ]");
    }
}
