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
 * This class implements a Crate which is a Package.
 * @author David Xie
 *@version 1.0
 */
public class Crate extends Package {
	
	/**
	 * This is the default constructor for a Crate
	 */
	public Crate() {
		
	}
	
	/**
	 * This constructs a Crate with specified tracking number and weight.
	 * @param number the tracking number for this crate
	 * @param weight the weight of this crate
	 */
	public Crate(long number, double weight) {
		super(number, weight);
	}
	
	/**
	 * This is a placeholder getCost() method for the child classes
	 */
	public double getCost() {
		return 0;
	}

}
