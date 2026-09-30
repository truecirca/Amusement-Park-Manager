package edu.westga.cs1302.park.model;

import java.util.ArrayList;

/**
 * A class to allow for a user to keep track of all amusement parks they are managing
 * @author Matthew Hartman
 * @version 09/17/2026
 */
public class ParkManager {

	private ArrayList<AmusementPark> listOfParks;
	private int numberOfParksAdded;
	
	/**
	 * A constructor that is used to initialize the list of parks being managed
	 * @precondition none
	 * @postcondition the array list used to store all parks being managed is initialized
	 */
	public ParkManager() {
		this.listOfParks = new ArrayList<AmusementPark>();
		this.numberOfParksAdded = 0;
	}
	
	/**
	 * A method to allow a new park to be added to the list of parks
	 * @precondition the park object can not be null && the park can not already be in the lsit
	 * @param newPark the park to be added to the list of parks being managed
	 * @postcondition the list of parks was updated with a new park
	 */
	public void addAmusementPark(AmusementPark newPark) {
		if (this.isParkAlreadyInList(newPark)) {
			throw new IllegalArgumentException("The park is already in the list");
		}
		if (newPark == null) {
			throw new IllegalArgumentException("The park object can't be null");
		}
		
		this.listOfParks.add(newPark);
		this.numberOfParksAdded++;
	}
	
	/**
	 * A method to return a specified park using an index variable
	 * @precondition the indexOfPark must not be larger or smaller than the size of the list of parks
	 * @param indexOfPark the index of the desired park
	 * @return the amusement park from the list at the desired position
	 */
	public AmusementPark getPark(int indexOfPark) {
		if (indexOfPark < 0) {
			throw new IllegalArgumentException("The index provided must be greater than 0.");
		}
		if (indexOfPark > this.listOfParks.size()) {
			throw new IllegalArgumentException("The index provided is not valid and exceeds the size of the list of parks.");
		}
		
		return this.listOfParks.get(indexOfPark);
	}
	
	/**
	 * A method to get the number of parks in the list of parks
	 * @precondition none
	 * @return the size of the list of parks
	 */
	public int getNumberOfParks() {
		return this.numberOfParksAdded;
	}
	
	/**
	 * A method to check if a park already exists in the list or not
	 * @precondition the park object to check for can not be null
	 * @param parkToCheckFor the park to check the list for
	 * @return if the park exists or does not exist
	 */
	public boolean isParkAlreadyInList(AmusementPark parkToCheckFor) {
		if (parkToCheckFor == null) {
			throw new IllegalArgumentException("The park object to check for can not be null.");
		}
		
		if (this.listOfParks.contains(parkToCheckFor)) { 
			return true;
		}
		
		return false;
	}
	
	/**
	 * A toString method used to get a description of the object
	 * @precondition none
	 * @return a description representing the object
	 */
	public String toString() {
		String description = "These are the current parks being managed:\n";
		
		for (AmusementPark currentPark: this.listOfParks) {
			description += currentPark.getAmusementParkName() + " with a rating of " + currentPark.getParkRating() + ".0 / 10\n";
		}
		
		return description;
	}
	
}
