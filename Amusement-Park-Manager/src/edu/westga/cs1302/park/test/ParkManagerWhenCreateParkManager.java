package edu.westga.cs1302.park.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.park.model.AmusementPark;
import edu.westga.cs1302.park.model.ParkManager;
import edu.westga.cs1302.park.model.Ride;

/**
 * A test class to test and confirm the functionality of the ParkManager class
 * @author Matthew Hartman
 * @version 09/17/2026
 */
class ParkManagerWhenCreateParkManager {

	@Test
	void testParkManagerGetParkWhenOnePark() {
		ParkManager testManager = new ParkManager();
		AmusementPark testPark = new AmusementPark("Disney");
		
		testManager.addAmusementPark(testPark);
		
		AmusementPark actual = testManager.getPark(0);
		
		assertEquals(testPark, actual);
	}
	
	@Test
	void testParkManagerGetParkWhenParkThreeParks() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Bush Gardens");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("Disney");
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		
		AmusementPark actual = testManager.getPark(1);
		
		assertEquals(testParkB, actual);
	}
	
	@Test
	void testParkManagerGetParkWhenParkFiveParks() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Bush Gardens");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("Disney");
		AmusementPark testParkD = new AmusementPark("There Is No Park In Ba Sing Se");
		AmusementPark testParkE = new AmusementPark("The Rodeo");
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		testManager.addAmusementPark(testParkD);
		testManager.addAmusementPark(testParkE);
		
		AmusementPark actual = testManager.getPark(4);
		
		assertEquals(testParkE, actual);
	}
	
	@Test
	void testIsParkAlreadyInListOnePark() {
		ParkManager testManager = new ParkManager();
		AmusementPark testPark = new AmusementPark("Disney");

		
		testManager.addAmusementPark(testPark);
		
		boolean actual = testManager.isParkAlreadyInList(testPark);
		
		assertEquals(true, actual);
	}
	
	@Test
	void testIsParkAlreadyInListThreeParks() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Bush Gardens");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("Disney");
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		
		boolean actual = testManager.isParkAlreadyInList(testParkB);
		
		assertEquals(true, actual);
	}
	
	@Test
	void testIsParkAlreadyInListFiveParks() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Bush Gardens");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("Disney");
		AmusementPark testParkD = new AmusementPark("There Is No Park In Ba Sing Se");
		AmusementPark testParkE = new AmusementPark("The Rodeo");
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		testManager.addAmusementPark(testParkD);
		testManager.addAmusementPark(testParkE);
		
		boolean actual = testManager.isParkAlreadyInList(testParkE);
		
		assertEquals(true, actual);
	}
	
	@Test
	void testParkNotAlreadyInListFiveParks() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Bush Gardens");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("Disney");
		AmusementPark testParkD = new AmusementPark("There Is No Park In Ba Sing Se");
		AmusementPark testParkE = new AmusementPark("The Rodeo");
		AmusementPark testParkF = new AmusementPark("Kansas");
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		testManager.addAmusementPark(testParkD);
		testManager.addAmusementPark(testParkE);
		
		boolean actual = testManager.isParkAlreadyInList(testParkF);
		
		assertEquals(false, actual);
	}
	
	@Test
	void testIsParkToStringOnePark() {
		ParkManager testManager = new ParkManager();
		AmusementPark testPark = new AmusementPark("Disney");
		Ride testRideA = new Ride("The Bullet", 10, 15);
		Ride testRideB = new Ride("Splat Mountain", 5, 20);
		
		testPark.addRide(testRideA);
		testPark.addRide(testRideB);
		
		testManager.addAmusementPark(testPark);
		
		String actual = testManager.toString();
		
		assertEquals("These are the current parks being managed:\nDisney with a rating of 8.0 / 10\n", actual);
	}
	
	@Test
	void testIsParkToStringThreePark() {
		ParkManager testManager = new ParkManager();
		AmusementPark testParkA = new AmusementPark("Disney");
		AmusementPark testParkB = new AmusementPark("Six Flags");
		AmusementPark testParkC = new AmusementPark("The Fair");
		
		Ride testRideA_A = new Ride("The Bullet", 10, 15);
		Ride testRideA_B = new Ride("Splash Mountain", 5, 20);
		
		Ride testRideB_A = new Ride("The Dropper", 7, 10);
		Ride testRideB_B = new Ride("The Sparow", 9, 9);
		Ride testRideB_C = new Ride("Love Tunnel", 8, 100);
		
		Ride testRideC_A = new Ride("The Samuri", 10, 20);
		Ride testRideC_B = new Ride("Duck Duck Goose", 2, 20);
		Ride testRideC_C = new Ride("Tea Cups", 6, 200);
		Ride testRideC_D = new Ride("Dave The Diver", 10, 50);
		
		testParkA.addRide(testRideA_A);
		testParkA.addRide(testRideA_B);
		
		testParkB.addRide(testRideB_A);
		testParkB.addRide(testRideB_B);
		testParkB.addRide(testRideB_C);
		
		testParkC.addRide(testRideC_A);
		testParkC.addRide(testRideC_B);
		testParkC.addRide(testRideC_C);
		testParkC.addRide(testRideC_D);
		
		
		testManager.addAmusementPark(testParkA);
		testManager.addAmusementPark(testParkB);
		testManager.addAmusementPark(testParkC);
		
		String actual = testManager.toString();
		
		assertEquals("These are the current parks being managed:\nDisney with a rating of 8.0 / 10\nSix Flags with a rating of 8.0 / 10\nThe Fair with a rating of 7.0 / 10\n", actual);
	}



}
