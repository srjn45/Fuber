package code.srjn.fuber.domain;

public class Cab {

	private String licensePlateNumber;
	private CabType cabType;
	private Location location;

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