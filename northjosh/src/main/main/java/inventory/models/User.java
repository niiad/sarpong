package inventory.models;


/**
 * Class to handle API login and authorization
 * @author gaut2172
 *
 */
public class User {

	//FIXME GET RID OF PASSWORD attribute
	
	private String username;
	private String password;
	
	public User() {
		username = null;
		password = null;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String GetUsername() {
		return username;
	}
	
	public String GetPassword() {
		return password;
	}
}
