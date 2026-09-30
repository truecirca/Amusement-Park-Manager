package edu.westga.cs1302.park.controller;

import edu.westga.cs1302.park.model.ParkManager;
import edu.westga.cs1302.park.view.ManagementView;

/**
 * A driver class used to output the program to the user
 * @author Matthew Hartman
 * @version 09/18/2026
 */
public class AmusementDriver {
	
	/**
	 * the main method used to run the program
	 * @precondition none
	 * @postcondition the program is successfully run
	 * @param args arguments used to run application
	 */
	public static void main(String [] args) {
		ParkManager userParkManager = new ParkManager();
		ManagementView userView = new ManagementView(userParkManager);
		userView.run();
	}

}
