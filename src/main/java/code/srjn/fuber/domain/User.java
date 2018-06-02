package code.srjn.fuber.domain;

/**
 * this class contains user demographics received after registration process
 * 
 * @author Srajan
 *
 */
public class User {

	private String user;
	private long phoneNumber;
	// and other user related info

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", phoneNumber=" + phoneNumber + "]";
	}

}
