package code.srjn.fuber.domain;

import org.junit.Test;

import org.junit.Assert;

public class LocationTest {

	@Test
	public void testGetDistanceFrom() {
		Location location = new Location(0, 0);
		// only longitude change
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(0, 5)));
		// only latitude change
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(5, 0)));
		// both changed
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(4, 3)));

		// all the sides
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(3, 4)));
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(-3, -4)));
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(-3, 4)));
		Assert.assertTrue(5 == location.getDistanceFrom(new Location(3, -4)));

	}

}
