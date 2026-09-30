package edu.westga.cs1302.park.model;

import java.util.ArrayList;

/**
 * A class to hold and keep track of multiple rides in an amusement park
 * @author Matthew Hartman
 * @version 09/14/2026
 */
public class AmusementPark {
	
	private ArrayList<Ride> listOfParkRides;
	private String amusementParkName;
	
	/**
	 * A constructor for the amusement park class used to instantiate all instance variables for the class
	 * @precondition amusementParkName can not be null
	 * @postcondition the name of the park is set and the array list of the park rides is initialized
	 * @param amusementParkName the name of the amusement park
	 */
	public AmusementPark(String amusementParkName) {
		
		if (amusementParkName.equals(null)) {
			throw new IllegalArgumentException("The name of the park can not be null");
		}
		
		this.amusementParkName = amusementParkName;
		this.listOfParkRides = new ArrayList<Ride>();
	}
	
	/**
	 * A method used to check the list of rides to see if the given ride exists in the list or not
	 * @precondition the ride may not be null
	 * @param rideToCheckFor the ride to check the list for
	 * @return true or false based on the presence of the ride or lack there of in the list
	 */
	public boolean checkIfRideIsPresent(Ride rideToCheckFor) {
		
		if (rideToCheckFor == null) {
			throw new IllegalArgumentException("The ride can not be null.");
		}
		
		for (Ride currentRide: this.listOfParkRides) {
			if (currentRide == rideToCheckFor) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A method used to add a ride to the list of rides in the amusement park
	 * @precondition the ride object can not be null
	 * @postcondition a ride object is added to the list of rides in the park
	 * @param rideToAdd the ride to be added to the list of rides
	 */
	public void addRide(Ride rideToAdd) {
		
		if (rideToAdd == null) {
			throw new IllegalArgumentException("The ride can not be null.");
		}
		
		this.listOfParkRides.add(rideToAdd);
	}
	
	/**
	 * A method used to search for rides with a rating at or above the given rating
	 * @precondition the rating must be between 1 and 10 inclusively
	 * @param ratingToSearch the rating the user wishes to search for
	 * @return the rides at or above the given rating
	 */
	public ArrayList<Ride> getRidesAtOrAboveGivenRating(int ratingToSearch) {
		if (ratingToSearch < 1) {
			throw new IllegalArgumentException("The rating to search can not be less than 1");
		}
		if (ratingToSearch > 10) {
			throw new IllegalArgumentException("The rating to search can not be greater than 10");
		}
		
		ArrayList<Ride> ridesAtOrAboveRating = new ArrayList<Ride>();
		
		for (Ride currentRide: this.listOfParkRides) {
			if (currentRide.getRideRating() >= ratingToSearch) {
				ridesAtOrAboveRating.add(currentRide);
			}
		}
		
		return ridesAtOrAboveRating;
		
	}
	
	/**
	 * A toString method that returns a description of each of the rides in the park and the ratings of said rides and rating of the park over all
	 * @precondition none
	 * @return a description of the rides at the park, or lack there of
	 */
	public String toString() {
		String description = "";
		
		if (this.listOfParkRides.size() > 0) {
			description += this.amusementParkName + " has the following rides:\n";
			for (Ride currentRide: this.listOfParkRides) {
				description += currentRide.getRideTitle() + " with a rating of " + currentRide.getRideRating() + "\n";
			}
		} else {
			description += this.amusementParkName + " has no rides currently.\n";
		}
		
		if (this.listOfParkRides.size() == 0) {
			description += "The park has not had any ratings to date.\n";
		} else {
			description += "The overall rating of all rides in this park is " + this.getParkRating() + ".0 / 10\nThe park has recived " + this.getTotalRatingsForPark() + " ratings.\n";
			description += this.getHighestRatedRide() + " It is the highest rated ride for the park.\n";
		}
		
		return description;
	}
	
	/**
	 * A getter method for the name of the amusement park
	 * @precondition none
	 * @return the name of the amusement park
	 */
	public String getAmusementParkName() {
		return this.amusementParkName;
	}
	
	/**
	 * A getter method for the list of rides in the park
	 * @precondition none
	 * @return the full list of rides currently in the park
	 */
	public ArrayList<Ride> getListOfRides() {
		return this.listOfParkRides;
	}
	
	/**
	 * A method to allow the rating of a ride at a specified position in the list
	 * @precondition the rating may not be < 0
	 * @postcondition the rating is added to the ride
	 * @param newRating the rating to be added
	 */
	public void rateRide(int ridePosition, int rideRating) {
		this.listOfParkRides.get(ridePosition).rateRide(rideRating);
	}
	
	/**
	 * A method to calculate and return the over all average of the park based on its rides average ratings
	 * @precondition none
	 * @return the overall average of the park based on the average ratings of the rides in the park
	 */
	public int getParkRating() {
		int parkAverage = 0;
		int currentCount = 0;
		
		for (Ride currentRide: this.listOfParkRides) {
			currentCount++;
			parkAverage += (currentRide.getRideRating() - parkAverage) / currentCount;
		}
		
		return parkAverage;
	}
	
	/**
	 * A method to calculate the total amount of ratings for all rides in the park
	 * @precondition none
	 * @return the total amount of times all rides have been rated 
	 */
	public int getTotalRatingsForPark() {
		int ratingCount = 0;
		
		for (Ride currentRide: this.listOfParkRides) {
			ratingCount += currentRide.getNumberOfRatings();
		}
		
		return ratingCount;
	}
	
	/**
	 * A method to get the highest rated ride in the list
	 * @precondition none
	 * @return the ride with the highest rating
	 */
	public Ride getHighestRatedRide() {
		Ride bestRide = this.listOfParkRides.get(0);
		for (Ride currentRide: this.listOfParkRides) {
			if (currentRide.getRideRating() > bestRide.getRideRating()) {
				bestRide = currentRide;
			}
		}
		
		return bestRide;
	}
}
