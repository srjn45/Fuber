package code.srjn.fuber.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabService {

	// otp, ride
	private Map<Integer, Ride> rideMap = new HashMap<>();

	private List<Cab> availableCabs = new LinkedList<>();
	private List<Cab> bookedCabs = new LinkedList<>();

	public CabService(LinkedList<Cab> availableCabs) {
		this.availableCabs = availableCabs;
	}

	/**
	 * find the closest cab in the selected category and books it
	 * 
	 * @param user
	 * @return
	 */
	public void bookRide(Ride ride) {
		Cab bookCab = null;
		double distance = Double.MAX_VALUE;
		synchronized (availableCabs) {
			for (Cab cab : availableCabs.stream().filter(cab -> (ride.getCabType().getType().equals(CabType.ALL)
					|| ride.getCabType().getType().equals(cab.getCabType()))).collect(Collectors.toList())) {
				double d = cab.getLocation().getDistanceFrom(ride.getPickupLocation());
				if (d < distance) {
					bookCab = cab;
					distance = d;
				}
			}
			availableCabs.remove(bookCab);
			bookedCabs.add(bookCab);
			ride.setCab(bookCab);
		}

	}

	public double endRide(Ride ride) {
		Cab cab = ride.getCab();
		bookedCabs.remove(cab);
		cab.setLocation(ride.getDropLocation());
		synchronized (availableCabs) {
			availableCabs.add(cab);
		}
		double fare = 0;
		if (cab.getCabType().getType().equals(CabType.PINK)) {
			fare += 5;
		}
		fare += 2 * ride.getDistance();
		return fare;
	}
}
