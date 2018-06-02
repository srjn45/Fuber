package code.srjn.fuber.domain;

/**
 * this class contains the info of a user riding a cab and traveling from point
 * A to B
 * 
 * As SelectionKey is created when a Channel is registered on Selector similarly
 * a Ride is created when a User books a Cab.
 * 
 * Ride contains info of both User and the Cab and also the info like distance
 * traveled pickup and drop points.
 * 
 * This can be dumped into DB to maintain the record of the Users old rides.
 * 
 * @author Srajan
 *
 */
public class Ride {

	private int otp;
	private User user;
	private Cab cab;
	private CabType cabType;
	private Location pickupLocation;
	private Location dropLocation;
	private double distance;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public Location getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Location getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(Location dropLocation) {
		this.dropLocation = dropLocation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Ride [otp=" + otp + ", user=" + user + ", cab=" + cab + ", cabType=" + cabType + ", pickupLocation="
				+ pickupLocation + ", dropLocation=" + dropLocation + ", distance=" + distance + "]";
	}

}
