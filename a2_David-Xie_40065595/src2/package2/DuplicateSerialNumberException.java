package package2;

//-------------------------------------------------------
//Assignment 2 
//Part: 2
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #2
* Due Date: July 26 2020
*/

/**
 * This class implements a special exception for duplicate serial numbers of a cargoship
 * @author David Xie
 * @version 1.0
 */
public class DuplicateSerialNumberException extends Exception {
	
	/**
	 * This is the default constructor of this exception
	 */
	public DuplicateSerialNumberException() {
		super("This serial number is a duplicate!");
	}
	
	/**
	 * This constructs a duplicate serial number exception with a specified message
	 * @param message the message for this duplicate serial number exception
	 */
	public DuplicateSerialNumberException(String message) {
		super(message);
	}

}
