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
 * This class implements a metal crate which is a crate
 * @author David Xie
 *@version 1.0
 */
public class MetalCrate extends Crate {
	
	private double metalCost;
	
	/**
	 * This constructs a metal crate with specified tracking number and weight
	 * @param number the tracking number of this metal crate
	 * @param weight the weight of this metal crate, in pounds
	 */
	public MetalCrate(long number, double weight) {
		super(number, weight);
		metalCost = getCost();
	}
	
	/**
	 * This method calculates the shipping cost of this metal crate based on its weight
	 * @return this metal crate's shipping cost
	 */
	public double getCost() {
		return 3*getWeight();
	}
	
	/**
	 * This method contains the information related to this metal crate
	 * @return this metal crate's information
	 */
	public String toString() {
		return "This package's tracking number is " + getNumber() + ". It's a metal crate with a "
				+ "weight of " + getWeight() + " pounds and the shipping cost is $" + metalCost;
	}


}
