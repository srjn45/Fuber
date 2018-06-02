package code.srjn.fuber.domain;

/**
 * this class hold the info of the cab(type, location etc.)
 * 
 * later on cabby info can also be added
 * 
 * @author Srajan
 *
 */
public class Cab {

	private String licensePlateNumber;
	private CabType cabType;
	private Location location;

	// other info like cabby name, details and rating etc.

	public Cab() {
		super();
	}

	public Cab(String licensePlateNumber, CabType cabType, Location location) {
		super();
		this.licensePlateNumber = licensePlateNumber;
		this.cabType = cabType;
		this.location = location;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
			this.cabType = cabType;
	}

	public void setCabType(String cabType) {
		if (cabType != null) {
			this.cabType = CabType.valueOf(cabType);
		}
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Cab [licensePlateNumber=" + licensePlateNumber + ", cabType=" + cabType + ", location=" + location
				+ "]";
	}

}