package StaffMgr;
/**
 * Class Staff
 * @author
 *
 */
public class Staff {
	private String name;
	private String password;
	/**
	 * Staff
	 * @param name
	 * @param password
	 */
	public Staff(String name, String password){
		this.name = name;
		this.password = password;
	}
	/**
	 * Return name
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * Return password
	 * @return
	 */
	public String getPassword(){
		return password;
	}
	
}
