package package1;

//-------------------------------------------------------
//Assignment 2 
//Part: 1
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #2
* Due Date: July 26 2020
*/

/**
 * This class throws a special exception for package exceptions
 * @author David Xie
 *@version 1.0
 */
public class PackageException extends Exception {
	
	/**
	 * This is the default constructor for this exception
	 */
	public PackageException() {
		super("There is a problem in loading this package!");
	}
	
	/**
	 * This is a specified package exception
	 * @param message the message indicating this package exception
	 */
	public PackageException(String message) {
		super(message);
	}

}
