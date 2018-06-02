package code.srjn.fuber.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import code.srjn.fuber.domain.Cab;
import code.srjn.fuber.domain.CabType;
import code.srjn.fuber.domain.Location;
import code.srjn.fuber.domain.Ride;

/**
 * Cab service maintains the list of all the cabs they have, it can be fetched
 * from the DB as well.
 * 
 * when a user books a cab it first filters the cab on the basis of the type
 * user selected then tries to find the closest cab and books it removing it
 * from availableCabs.
 * 
 * ride details are returned to the user along with otp (cabby can be notified
 * using push notification, currently not in scope as no DB)
 * 
 * on pickup cabby will enter otp and the ride will start
 * 
 * on drop cabby will end ride and the final fare will be calculated and
 * returned to cabby and can also be pushed to user using push notification.
 * 
 * @author Srajan
 *
 */
@Service
public class CabService {

	// otp, ride
	private Map<Integer, Ride> rideMap = new HashMap<>();

	private static List<Cab> availableCabs = new LinkedList<>();

	// for now hardcoded in real data loaded from database
	static {
		availableCabs.add(new Cab("MP 09 CS 4530", CabType.NORMAL, new Location(4, 5)));
		availableCabs.add(new Cab("MP 09 JD 6423", CabType.PINK, new Location(2, 7)));
		availableCabs.add(new Cab("MP 09 WS 6427", CabType.NORMAL, new Location(8, 9)));
		availableCabs.add(new Cab("MP 09 VR 2474", CabType.NORMAL, new Location(6, 7)));
		availableCabs.add(new Cab("MP 09 AS 9535", CabType.PINK, new Location(4, 0)));
		availableCabs.add(new Cab("MP 09 AS 6585", CabType.PINK, new Location(14, 54)));
		availableCabs.add(new Cab("MP 09 VR 2457", CabType.NORMAL, new Location(26, 31)));
	}

	/**
	 * find the closest cab in the selected category and books it
	 * 
	 * user will call this method along with pickup location and cab type and
	 * the nearest cab will be assigned, and the otp will be sent to the user
	 * 
	 * @param ride
	 * @return ride with cab or null if no cab found
	 */
	public Ride bookRide(Ride ride) {
		Cab bookCab = null;
		double distance = Double.MAX_VALUE;
		// selecting the neerest cab
		synchronized (availableCabs) {
			for (Cab cab : availableCabs.stream()
					.filter(cab -> (ride.getCabType().getType().equals(CabType.ALL.getType())
							|| ride.getCabType().getType().equals(cab.getCabType().getType())))
					.collect(Collectors.toList())) {
				double d = cab.getLocation().getDistanceFrom(ride.getPickupLocation());
				if (d < distance) {
					bookCab = cab;
					distance = d;
				}
			}
			if (bookCab == null) {
				return null;
			}
			availableCabs.remove(bookCab);
		}
		ride.setCab(bookCab);
		ride.setOtp((int) (System.currentTimeMillis() % 10000));
		// ride booked
		rideMap.put(ride.getOtp(), ride);
		// as the ride is booked the cabby will be notified
		return ride;
	}

	/**
	 * cabby enters the otp received by customer and the ride is started.
	 * 
	 * @param otp
	 * @return
	 */
	public Ride startRide(int otp) {
		return rideMap.get(otp);
	}

	/**
	 * cabby ends the ride and the final fare will be returned
	 * 
	 * at this time the drop location and the distance covered will also be
	 * received in the ride object
	 * 
	 * @param ride
	 * @return
	 */
	public double endRide(Ride ride) {
		rideMap.remove(ride.getOtp());
		Cab cab = ride.getCab();
		// update the location of cab to the drop location
		cab.setLocation(ride.getDropLocation());
		// add the cab back to the available cab list
		synchronized (availableCabs) {
			availableCabs.add(cab);
		}

		// calc fare
		double fare = 0;
		// extra 5 dogecoin for pink cab
		if (cab.getCabType().getType().equals(CabType.PINK)) {
			fare += 5;
		}
		// 2 dogecoin per km
		fare += 2 * ride.getDistance();
		return fare;
	}
}