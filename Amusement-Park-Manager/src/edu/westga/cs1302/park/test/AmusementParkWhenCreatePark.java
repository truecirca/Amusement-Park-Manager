package edu.westga.cs1302.park.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.park.model.AmusementPark;
import edu.westga.cs1302.park.model.Ride;

/**
 * A test class for the AmusementPark class to ensure functionality 
 * @author Matthew Hartman
 * @version 09/14/2026
 */
class AmusementParkWhenCreatePark {

	@Test
	void testAmusementParkCreatedCorrectly() {
		AmusementPark testPark = new AmusementPark("Kemah Boardwalk");
		
		String actual = testPark.toString();
		
		assertEquals("Kemah Boardwalk has no rides currently.\nThe park has not had any ratings to date.\n", actual);
	}
	
	@Test
	void testAmusementParkGetRidesAboveGivenRatingOneRide() {
		AmusementPark testPark = new AmusementPark("Sea World");
		Ride testRide = new Ride("Orca", 5, 20);
		
		testPark.addRide(testRide);
		
		ArrayList<Ride> actual = testPark.getRidesAtOrAboveGivenRating(5);
		
		assertEquals("Orca", actual.get(0).getRideTitle());
		assertEquals(1, actual.size());
	}
	
	@Test
	void testAmusementParkGetRidesAboveGivenRatingThreeRides() {
		AmusementPark testPark = new AmusementPark("Sea World");
		Ride testRideA = new Ride("Tea Cups", 5, 20);
		Ride testRideB = new Ride("Sea Cups", 7, 20);
		Ride testRideC = new Ride("Tree Cups", 4, 20);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		
		ArrayList<Ride> actual = testPark.getRidesAtOrAboveGivenRating(5);
		
		assertEquals("Tea Cups", actual.get(0).getRideTitle());
		assertEquals("Sea Cups", actual.get(1).getRideTitle());
		assertEquals(2, actual.size());
	}
	
	@Test
	void testAmusementParkClassGetterForParkName() {
		AmusementPark testPark = new AmusementPark("There is no park in Ba Sing Se");
		
		String actual = testPark.getAmusementParkName();
		
		assertEquals("There is no park in Ba Sing Se", actual);
	}
	
	@Test
	void testAmusementParkClassGetterForRideList() {
		AmusementPark testPark = new AmusementPark("White Water");
		
		int actual = testPark.getListOfRides().size();
		
		assertEquals(0, actual);
	}
	
	@Test
	void testAmusementParkClassCheckIfRideIsPresent() {
		AmusementPark testPark = new AmusementPark("Six Flags");
		Ride testRide = new Ride("A ride", 5, 7);
		
		boolean actual = testPark.checkIfRideIsPresent(testRide);
		
		assertEquals(false, actual);
	}
	
	@Test
	void testAmusementParkClassCheckIfRideIsPresentMultipleRides() {
		AmusementPark testPark = new AmusementPark("What Park");
		Ride testRideA = new Ride("Dropper", 5, 5);
		Ride testRideB = new Ride("Deep Dark", 1, 20);
		Ride testRideC = new Ride("Cyclone", 10, 1);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		
		boolean actual = testPark.checkIfRideIsPresent(testRideB);
		
		assertEquals(true, actual);
	}
	
	@Test
	void testAmusementParkClassAddsRideCorrectly() {
		AmusementPark testPark = new AmusementPark("Zuul");
		Ride testRide = new Ride("The Bullet", 5, 6);
		
		testPark.addRide(testRide);
		
		boolean actual = testPark.checkIfRideIsPresent(testRide);
		
		assertEquals(true, actual);	
	}
	
	@Test
	void testAmusementParkClassAddsTwoRides() {
		AmusementPark testPark = new AmusementPark("Disney");
		Ride testRideA = new Ride("Scream Machine", 2, 5);
		Ride testRideB = new Ride("Cyclone", 10, 1);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		
		String actual = testPark.toString();
		
		assertEquals("Disney has the following rides:\nScream Machine with a rating of 2\nCyclone with a rating of 10\nThe overall rating of all rides in this park is 6.0 / 10\nThe park has recived 6 ratings.\nThis is: Cyclone. It has a rating of 10 out of 10 and has been rated 1 time(s). It is the highest rated ride for the park.\n", actual);
	}
	
	@Test
	void testAmusementParkClassAllowsRatingOfRideWhenOneRide() {
		AmusementPark testPark = new AmusementPark("Coffee Land");
		Ride testRide = new Ride("Coffee Maker", 10, 1);
		
		testPark.addRide(testRide);
		testPark.rateRide(0, 2);
		
		String actual = testPark.toString();
		
		assertEquals("Coffee Land has the following rides:\nCoffee Maker with a rating of 6\nThe overall rating of all rides in this park is 6.0 / 10\nThe park has recived 2 ratings.\n" + "This is: Coffee Maker. It has a rating of 6 out of 10 and has been rated 2 time(s). It is the highest rated ride for the park.\n", actual);
	}
	
	@Test
	void testAmusementParkClassAllowsRatingOfRideWhenMultipleRides() {
		AmusementPark testPark = new AmusementPark("Breakfast Land");
		Ride testRideA = new Ride("Donuts", 8, 6);
		Ride testRideB = new Ride("Bananas", 9, 5);
		Ride testRideC = new Ride("Eggs", 2, 15);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		
		testPark.rateRide(1, 1);
		
		String actual = testPark.toString();
		
		assertEquals("Breakfast Land has the following rides:\nDonuts with a rating of 8\nBananas with a rating of 8\nEggs with a rating of 2\nThe overall rating of all rides in this park is 6.0 / 10\nThe park has recived 27 ratings.\nThis is: Donuts. It has a rating of 8 out of 10 and has been rated 6 time(s). It is the highest rated ride for the park.\n", actual);
	}
	
	@Test
	void testAmusementParkClassGetParkAverageMultipleRides() {
		AmusementPark testPark = new AmusementPark("Code Land");
		Ride testRideA = new Ride("Monster", 8, 1);
		Ride testRideB = new Ride("Energy", 5, 1);
		Ride testRideC = new Ride("Aviator", 4, 1);
		Ride testRideD = new Ride("What Ride", 7, 1);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		testPark.addRide(testRideD);
		
		int actual = testPark.getParkRating();
		
		assertEquals(6, actual);
	}
	
	@Test
	void testAmusementParkClassGetParkAverageOneRide() {
		AmusementPark testPark = new AmusementPark("College Land");
		Ride testRide = new Ride("The Exam", 1, 50);
		
		testPark.addRide(testRide);
		
		int actual = testPark.getParkRating();
		
		assertEquals(1, actual);
	}
	
	@Test
	void testAmusementParkClassGetParkAverageTwoRide() {
		AmusementPark testPark = new AmusementPark("WonderLand");
		Ride testRideA = new Ride("Rabbit Hole", 10, 10);
		Ride testRideB = new Ride("Tea Party", 5, 7);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		
		int actual = testPark.getParkRating();
		
		assertEquals(8, actual);
	}
	
	@Test
	void testAmusementParkClassGetTotalRatingsForParkWithOneRide() {
		AmusementPark testPark = new AmusementPark("Propane Land");
		Ride testRide = new Ride("The Dropper", 7, 5);
		
		testPark.addRide(testRide);
		
		int actual = testPark.getTotalRatingsForPark();
		
		assertEquals(5, actual);
	}
	
	@Test
	void testAmusementParkClassGetTotalRatingsForParkWithTwoRides() {
		AmusementPark testPark = new AmusementPark("Lego Land");
		Ride testRideA = new Ride("Lego Batman", 10, 5);
		Ride testRideB = new Ride("Lego StarWars", 9, 15);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		
		int actual = testPark.getTotalRatingsForPark();
		
		assertEquals(20, actual);
	}
	
	@Test
	void testAmusementParkClassGetTotalRatingsForParkWithFiveRides() {
		AmusementPark testPark = new AmusementPark("Lego Land");
		Ride testRideA = new Ride("Lego Batman", 10, 5);
		Ride testRideB = new Ride("Lego StarWars", 9, 15);
		Ride testRideC = new Ride("Lego League", 7, 200);
		Ride testRideD = new Ride("No Legos Here", 0, 20);
		Ride testRideE = new Ride("Legos Here", 10, 10);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		testPark.addRide(testRideD);
		testPark.addRide(testRideE);
		
		int actual = testPark.getTotalRatingsForPark();
		
		assertEquals(250, actual);
	}
	
	@Test
	void testAmusementParkClassGetHighestRatedRideOneRide() {
		AmusementPark testPark = new AmusementPark("Glove World");
		Ride testRide = new Ride("De-Glover", 7, 10);
		
		testPark.addRide(testRide);
		
		Ride actual = testPark.getHighestRatedRide();
		
		assertEquals(testRide, actual);
	}
	
	@Test
	void testAmusementParkClassGetHighestRatedRideTwoRides() {
		AmusementPark testPark = new AmusementPark("Glove World");
		Ride testRideA = new Ride("De-Glover", 7, 10);
		Ride testRideB = new Ride("Re-Glover", 8, 20);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		
		Ride actual = testPark.getHighestRatedRide();
		
		assertEquals(testRideB, actual);
	}
	
	@Test
	void testAmusementParkClassGetHighestRatedRideFiveRides() {
		AmusementPark testPark = new AmusementPark("Glove World");
		Ride testRideA = new Ride("De-Glover", 7, 10);
		Ride testRideB = new Ride("Re-Glover", 8, 20);
		Ride testRideC = new Ride("Glove Cove", 4, 15);
		Ride testRideD = new Ride("Glove Coaster", 9, 20);
		Ride testRideE = new Ride("Glove Swings", 8, 5);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		testPark.addRide(testRideC);
		testPark.addRide(testRideD);
		testPark.addRide(testRideE);
		
		Ride actual = testPark.getHighestRatedRide();
		
		assertEquals(testRideD, actual);
	}


}
