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
 * This class implements a Box which is a Package with a tracking number ending in 1.
 * It calculates the shipping cost of a box.
 * @author xie_d
 *@version 1.0
 */
public class Box extends Package {
	
	private double boxCost;
	
	/**
	 * This constructs a box with specified tracking number and weight
	 * @param number the tracking number for this box
	 * @param weight the weight of this box, in pounds
	 */
	public Box(long number, double weight) {
		super(number, weight);
		boxCost = getCost();
	}
	
	/**
	 * This method calculates the shipping cost of this box.
	 * @return this box's shipping cost
	 */
	public double getCost() {
		return 2*getWeight();
	}
	
	/**
	 * This method contains the information of this box.
	 * @return this box's information
	 */
	public String toString() {
		return "This package's tracking number is " + getNumber() + ". It's a box with a "
				+ "weight of " + getWeight() + " pounds and the shipping cost is $" + boxCost;
	}


}
