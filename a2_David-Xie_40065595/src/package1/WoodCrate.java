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
 * This class implements a wood crate which is a crate
 * @author David Xie
 *@version 1.0
 */
public class WoodCrate extends Crate {
	
	private double woodCost;
	
	/**
	 * This constructs a wood crate with specified tracking number and weight.
	 * @param number the tracking number of this wood crate
	 * @param weight the weight of this wood crate, in pounds
	 */
	public WoodCrate(long number, double weight) {
		super(number, weight);
		woodCost = getCost();
	}
	
	/**
	 * This method calculates the shipping cost of this wood crate
	 * @return this wood crate's shipping cost
	 */
	public double getCost() {
		return 2.5*getWeight();
	}
	
	/**
	 * This method contains the information related to this wood crate
	 * @return this wood crate's information
	 */
	public String toString() {
		return "This package's tracking number is " + getNumber() + ". It's a wood crate with a "
				+ "weight of " + getWeight() + " pounds and the shipping cost is $" + woodCost;
	}


}
