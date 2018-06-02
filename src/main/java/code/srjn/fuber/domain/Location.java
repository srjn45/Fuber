package code.srjn.fuber.domain;

public class Location {

	private double latitude;
	private double longitude;

	public Location() {
		super();
	}

	public Location(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistanceFrom(Location location) {
		return Math.sqrt(((latitude - location.latitude) * (latitude - location.latitude))
				+ ((longitude - location.longitude) * (longitude - location.longitude)));
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
