package edu.westga.cs1302.park.view;

import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.park.model.AmusementPark;
import edu.westga.cs1302.park.model.ParkManager;
import edu.westga.cs1302.park.model.Ride;

/**
 * A class to handle the TUI side of the application designed to work with the ParkManager class
 * @author Matthew Hartman
 * @version 09/18/2026
 */
public class ManagementView {

	private ParkManager userParkManager;
	private Scanner keyboard;
	private int currentUserChoice;
	private String newParkName;
	private String newRideName;
	private ArrayList<Ride> ridesAtAndAboveRating;
	
	/**
	 * A constructor used to initialize the park manager object
	 * @precondition the park manager object can not be null
	 * @postcondition the park manager object is initialized 
	 * @param userParkManager the park manager object to be used
	 */
	public ManagementView(ParkManager userParkManager) {
		if (userParkManager == null) {
			throw new IllegalArgumentException("The park manager object can not be null");
		}
		
		this.userParkManager = userParkManager;
		this.keyboard = new Scanner(System.in);
		this.newParkName = "No Name";
		this.newRideName = "No Name";
		this.ridesAtAndAboveRating = new ArrayList<Ride>();
	}
	
	/**
	 * A method used to conduct the program functions based on user input
	 * @precondition none
	 * @postcondition the application is directed correctly 
	 */
	public void run() {
		this.displayMenu();
		this.promptUser();
		this.menuExecutionHandler();
		
	}
	
	/**
	 * A private helper method used to display the menu to the user
	 * @precondition none
	 * @postcondition the menu is displayed to the user correctly
	 */
	private void displayMenu() {
		System.out.println("1. Create a new amusement park");
		System.out.println("2. Add a new ride to an existing amusement park");
		System.out.println("3. Get a listing of all rides with a rating above a specified value");
		System.out.println("4. Display information about a particular amusement park");
		System.out.println("5. Quit\n");
	}

	/**
	 * A private helper method that controls the loop for the menu execution by continuing to get user input and executing it via a private helper method
	 * @precondition none
	 * @postcondition the menu is looped through until the user decides they are done
	 */
	private void menuExecutionHandler() {
		do {
		this.executeMenuOption(this.currentUserChoice);
		this.promptUser();
		}
		while (this.currentUserChoice != 5);
	}

	/**
	 * A private helper method to get the users input for the menu and execute accordingly
	 * @precondition none
	 * @postcondition the menu choice is read
	 */
	private void promptUser() {
		this.currentUserChoice = this.getUserInt("What would you like to do?");
	}
	
	/**
	 * A private helper method used to interact with the user, displaying instructions and getting their input and then converting that input to an int
	 * @precondition the instructionsForUser can not be null and user choice must be between 1 and 5
	 * @param instructionsForUser the instructions to display to the user
	 * @return the users input 
	 */
	private int getUserInt(String instructionsForUser) {
		if (instructionsForUser.equals(null)) {
			throw new IllegalArgumentException("The instructions for the user can not be null");
		}
		
		System.out.print(instructionsForUser);
		String userChoice = this.keyboard.nextLine();
		
		int convertedUserChoice = Integer.parseInt(userChoice);
		
		return convertedUserChoice;
	}
	
	/**
	 * A private helper method used to display the correct information based on the users choice
	 * @precondition none
	 * @postcondition the correct information is displayed for the user based on their input
	 * @param menuOptionChosen the menu option chosen by the user
	 */
	private void executeMenuOption(int menuOptionChosen) {
		switch (menuOptionChosen) { 
		case (1):
			this.userOptionOneManager();
				break;
		case (2):
			if (!this.confirmParkIsPresent()) {
				break;
			}
				this.userOptionTwoManager();
			break;
		case (3):
			if (!this.confirmParkIsPresent()) {
				break;
			}
			this.userOptionThreeManager();	
			break;
		case (4):
			if (!this.confirmParkIsPresent()) {
				break;
			}
			this.userOptionFourManager();
			break;
		default :
			System.out.println("No valid choice made");
			break;
			}
		this.displayMenu();
		}

	/**
	 * A private helper method used to confirm there is a park to check through for either adding to the park or getting data of the park
	 * @precondition none
	 * @return whether or not there was a park to be checked 
	 */
	private boolean confirmParkIsPresent() {
		if (this.userParkManager.getNumberOfParks() == 0) {
			System.out.println("There must be atleast one park to check\n");
			return false;
		}
		return true;
	}

	/**
	 * A private helper method used to handle the fourth menu option should it be chosen
	 * @precondition none
	 * @postcondition the user is shown the parks in the list and prompted for their choice resulting in the correct desired display
	 */
	private void userOptionFourManager() {
		System.out.println("Current list of amusement parks:");
		this.printListOfParks();
		
		this.currentUserChoice = this.getUserInt("Please enter the park of interest: ");
		this.currentUserChoice -= 1;
		
		while (this.currentUserChoice > this.userParkManager.getNumberOfParks() - 1 || this.currentUserChoice < 0) {
			System.out.println("No valid option picked.");
			this.currentUserChoice = this.getUserInt("Please enter the park of interest: ");
			this.currentUserChoice -= 1;
		}
		
		System.out.println("\n" + this.userParkManager.getPark(this.currentUserChoice).toString());
	}

	/**
	 * A private helper method used to handle the third menu option should it be chosen
	 * @precondition there should be atleast one park in the list already
	 * @postcondition a list of parks at or above the desired rating from the desired park is displayed to the user
	 */
	private void userOptionThreeManager() {
		if (this.userParkManager.getNumberOfParks() == 0) {
			System.out.println("You do not have any parks added to check");
		}
		System.out.println("\nThe current list of amusement parks:");
		this.printListOfParks();
		
		this.currentUserChoice = this.getUserInt("\nPlease enter which park you would like to check: ");
		while (this.currentUserChoice > this.userParkManager.getNumberOfParks() || this.currentUserChoice < 1) {
			System.out.println("That is not a valid option");
			this.currentUserChoice = this.getUserInt("\nPlease enter which park you would like to check: ");
		}
	
		int tempRatingChoice = this.getUserInt("\nPlease enter a raing to search for: ");
		while (tempRatingChoice < 0 || tempRatingChoice > 10) {
			System.out.println("The rating must be from 0 to 10 inclusively");
			tempRatingChoice = this.getUserInt("\nPlease enter a raing to search for: ");
		}

		this.ridesAtAndAboveRating = this.userParkManager.getPark(this.currentUserChoice - 1).getRidesAtOrAboveGivenRating(tempRatingChoice);
		if (this.ridesAtAndAboveRating.size() == 0) {
			System.out.println("There are no rides at or above the desired rating");
		} else {
			System.out.println("\n" + this.userParkManager.getPark(this.currentUserChoice - 1).getAmusementParkName() + " contains the following rides with a rating of " + tempRatingChoice + " and above:");
		}
		for (Ride currentRide: this.ridesAtAndAboveRating) {
			System.out.println(currentRide.getRideTitle() + " with a rating of " + currentRide.getRideRating());
		}
		System.out.println();
	}

	/**
	 * A private helper method used to handle the second menu option should it be chosen
	 * @precondition none
	 * @postcondition the menu option is successfully executed and a ride was added to the desired park
	 */
	private void userOptionTwoManager() {
		System.out.print("\nPlease enter the rides name: ");
		this.newRideName = this.keyboard.nextLine();
		
		int convertedRideRating = this.getUserInt("\nPlease enter the ride rating: ");
		while (convertedRideRating < 0 || convertedRideRating > 10) {
			System.out.println("The rating must be anything from 0 to 10");
			convertedRideRating = this.getUserInt("\nPlease enter the ride rating: ");
		}
		
		System.out.println("\nCurrent list of amusement parks:");
		
		this.printListOfParks();
		
		int parkToAddTo = this.getUserInt("\nPlease enter the park number where this is to be added: ");
		
		while (parkToAddTo > this.userParkManager.getNumberOfParks() || parkToAddTo < 1) {
			System.out.println("Not a valid choice.");
			parkToAddTo = this.getUserInt("\nPlease enter the park number where this is to be added: ");
		}

		this.userParkManager.getPark(parkToAddTo - 1).addRide(new Ride(this.newRideName, convertedRideRating, 1));
		
		System.out.println("\n~~~~" + this.newRideName + " with a rating of " + convertedRideRating + " was added to " + this.userParkManager.getPark(parkToAddTo - 1).getAmusementParkName() + "~~~~\n");
	}

	/**
	 * A private helper method for displaying the list of parks to the user
	 * @precondition none
	 * @postcondition the full list of parks is shown to the user
	 */
	private void printListOfParks() {
		for (int index = 0; index < this.userParkManager.getNumberOfParks(); index++) {
			System.out.println((index + 1) + " - " + this.userParkManager.getPark(index).getAmusementParkName());
		}
	}

	/**
	 * A private helper method to handle the first menu option should it be chosen
	 * @precondition none
	 * @postcondition the park is added to the list of parks using the park manager object
	 */
	private void userOptionOneManager() {
		System.out.print("\nPlease enter the parks name: ");
		this.newParkName = this.keyboard.nextLine();
		
		AmusementPark newUserPark = new AmusementPark(this.newParkName);
		
		this.userParkManager.addAmusementPark(newUserPark);
		
		System.out.println("\n~~~~" + this.newParkName + " added~~~~\n");
	}
}
