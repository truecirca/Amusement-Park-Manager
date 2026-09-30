package edu.westga.cs1302.park.model;

/**
 * A class to hold information about a ride at an amusement park
 * @author Matthew Hartman
 * @version 09/14/2026
 */
public class Ride {

	private String rideTitle;
	private int rideRating;
	private int numberOfRatings;
	
	/**
	 * A constructor for the Ride class use to instantiate the variables for the class
	 * @precondition the title may not be null, the rating must be between 0 and 10 inclusive, the number of ratings can not be less than 0
	 * @postcondition the rides variables have been initialized and passed the error checks
	 * @param rideTitle the title of the ride
	 * @param rideRating the rating for the ride from 1 to 10
	 * @param numberOfRatings the number of times the ride has been rated
	 */
	public Ride(String rideTitle, int rideRating, int numberOfRatings) {
		
		if (rideTitle.equals(null)) {
			throw new IllegalArgumentException("The title of the ride can't be null.");
		}
		if (rideRating < 0) {
			throw new IllegalArgumentException("The rides rating must be greater than zero.");
		}
		if (rideRating > 10) {
			throw new IllegalArgumentException("The rides rating must not exceed ten.");
		}
		if (numberOfRatings < 0) {
			throw new IllegalArgumentException("The ride cannot have a negitive number of ratings.");
		}
		
		this.rideTitle = rideTitle;
		this.numberOfRatings = numberOfRatings;
		this.rideRating = rideRating;
	}
	
	/**
	 * A constructor used to accept only the ride title while setting rating values to 0 as a default
	 * @precondition none
	 * @param rideTitle the title of the ride
	 */
	public Ride(String rideTitle) {
		this(rideTitle, 0, 0);
	}
	
	/**
	 * A method used to allow a new rating to be added/submitted
	 * @precondition the rating can not be less than 0 or greater than 10
	 * @postcondition the rating and rating count is updated
	 * @param newRating the rating to be added to the ride
	 */
	public void rateRide(int newRating) {
		
		if (newRating < 0) {
			throw new IllegalArgumentException("The rating can not be less than 0.");
		}
		if (newRating > 10) {
			throw new IllegalArgumentException("The rating can not be greater than 10.");
		}
		
		this.numberOfRatings++;
		this.rideRating += (newRating - this.rideRating) / this.numberOfRatings;
	}
	
	/**
	 * A toString method used to return a description of the Ride class
	 * @precondition none
	 * @return a description of the ride
	 */
	public String toString() {
		String description = "This is: " + this.rideTitle + ". It has a rating of " + this.rideRating + " out of 10 and has been rated " + this.numberOfRatings + " time(s).";
		
		return description;
	}
	
	/**
	 * A getter method for the title of the ride
	 * @precondition none
	 * @return the title of the ride
	 */
	public String getRideTitle() {
		return this.rideTitle;
	}
	
	/**
	 * A getter method for the rating of the ride
	 * @precondition none
	 * @return the rating of the ride
	 */
	public int getRideRating() {
		return this.rideRating;
	}
	
	/**
	 * A getter method for the number of times the ride has been rated
	 * @precondition none
	 * @return the number of times the ride has been rated
	 */
	public int getNumberOfRatings() {
		return this.numberOfRatings;
	}
}
