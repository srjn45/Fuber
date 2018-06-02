package code.srjn.fuber.domain;

public enum RideStatus {

	SEARCHING("searching"), ON_THE_WAY("ontheway"), STARTED("started"), ENDED("ended");

	private String status;

	RideStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return status;
	}

}
