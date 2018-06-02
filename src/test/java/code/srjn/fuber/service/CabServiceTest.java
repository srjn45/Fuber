package code.srjn.fuber.service;

import org.junit.Assert;
import org.junit.Test;

import code.srjn.fuber.domain.CabType;
import code.srjn.fuber.domain.Location;
import code.srjn.fuber.domain.Ride;
import code.srjn.fuber.domain.RideStatus;

public class CabServiceTest {

	@Test
	public void testCabService() {
		CabService cabService = new CabService();
		Ride ride = new Ride();
		ride.setCabType(CabType.ALL);
		ride.setPickupLocation(new Location(4, 3));
		Assert.assertTrue(RideStatus.SEARCHING.getStatus().equals(ride.getStatus().getStatus()));

		Assert.assertTrue("MP 09 CS 4530".equals(cabService.bookRide(ride).getCab().getLicensePlateNumber()));
		Assert.assertTrue(RideStatus.ON_THE_WAY.getStatus().equals(ride.getStatus().getStatus()));

		cabService.startRide(ride.getOtp());
		Assert.assertTrue(RideStatus.STARTED.getStatus().equals(ride.getStatus().getStatus()));

		ride.setDropLocation(new Location(2, 10));
		ride.setDistance(9);
		Assert.assertTrue(18 == cabService.endRide(ride));
		Assert.assertTrue(RideStatus.ENDED.getStatus().equals(ride.getStatus().getStatus()));

	}

}
