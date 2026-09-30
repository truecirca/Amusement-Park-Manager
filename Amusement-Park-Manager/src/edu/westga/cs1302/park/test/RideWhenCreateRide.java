package edu.westga.cs1302.park.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.park.model.Ride;

/**
 * A junit test class to test the functionality of the Ride class
 * @author Matthew Hartman
 * @version 09/14/2026
 */
class RideWhenCreateRide {

	@Test
	void testCreatesRide() {
		Ride testRide = new Ride("The Best Ride Ever", 10, 1000);
		
		String actual = testRide.toString();
		
		assertEquals("This is: The Best Ride Ever. It has a rating of 10 out of 10 and has been rated 1000 time(s).", actual);
	}
	
	@Test
	void testCreatesRideWhenRatingOneAndOneRating() {
		Ride testRide = new Ride("The Newest Ride Ever", 1, 1);
		
		String actual = testRide.toString();
		
		assertEquals("This is: The Newest Ride Ever. It has a rating of 1 out of 10 and has been rated 1 time(s).", actual);
	}
	
	@Test
	void testCreatesRideWhenRatingFiveRatedTwentyOneTimes() {
		Ride testRide = new Ride("The Most Underwhelming Ride Ever", 5, 21);
			
		String actual = testRide.toString();
		
		assertEquals("This is: The Most Underwhelming Ride Ever. It has a rating of 5 out of 10 and has been rated 21 time(s).", actual);
	}

	@Test
	void testRideClassGetterForRideTitle() {
		Ride testRide = new Ride("The Bullet", 7, 200);
		
		String actual = testRide.getRideTitle();
		
		assertEquals("The Bullet", actual);
	}
	
	@Test
	void testRideClassGetterForRideRating() {
		Ride testRide = new Ride("The Scream Machine", 8, 1500);
		
		int actual = testRide.getRideRating();
		
		assertEquals(8, actual);
	}
	
	@Test
	void testRideClassGetterForNumberOfRatings() {
		Ride testRide = new Ride("There is no ride in Ba Sing Se", 1, 2000);
		
		int actual = testRide.getNumberOfRatings();
		
		assertEquals(2000, actual);
	}
	
	@Test
	void testRideClassOneParamConstructor() {
		Ride testRide = new Ride("This is a ride");
		
		String actual = testRide.toString();
		
		assertEquals("This is: This is a ride. It has a rating of 0 out of 10 and has been rated 0 time(s).", actual);
	}
	
	@Test
	void testRideClassAddRatingMethodWithOneAddition() {
		Ride testRide = new Ride("The Twister", 6, 5);
		testRide.rateRide(2);
		
		String actual = testRide.toString();
		
		assertEquals("This is: The Twister. It has a rating of 6 out of 10 and has been rated 6 time(s).", actual);
	}
	
	@Test
	void testRideClassAddRatingMethodWithThreeAdditions() {
		Ride testRide = new Ride("The Cyclone");
		testRide.rateRide(9);
		testRide.rateRide(7);
		testRide.rateRide(5);
		
		String actual = testRide.toString();
		
		assertEquals("This is: The Cyclone. It has a rating of 7 out of 10 and has been rated 3 time(s).", actual);
	}
}

