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
 * This class implements a package with a tracking number, its weight, and the shipping cost.
 * @author David Xie
 * @version 1.0
 *
 */
public abstract class Package {
	
	private long trackNumber;
	private double weight;
	
	/**
	 * This method calculates the shipping cost of this package
	 * @return This package's shipping cost
	 */
	public abstract double getCost();
	
	/**
	 * This constructs the default package.
	 */
	public Package() {
		
	}
	
	/**
	 * This constructs a package with specified tracking number and weight.
	 * @param number the tracking number of this package
	 * @param weight the weight of this package
	 */
	public Package(long number, double weight) {
		trackNumber = number;
		this.weight = weight;
	}
	
	/**
	 * This is the accessor to this package's tracking number
	 * @return this package's tracking number
	 */
	public long getNumber() {
		return trackNumber;
	}
	
	/**
	 * This is the accessor to this package's weight
	 * @return this package's weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * This is the mutator to this package's weight
	 * @param weight the weight of this package
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
		
	/**
	 * This method converts pounds to ounces.
	 * @param weight the weight of this package in pounds
	 * @return this package's weight in ounces
	 */
	public double toOunces(double weight) {
		return weight*16;
	}
	
	/**
	 * This method converts ounces to pounds
	 * @param weight the weight of this package in ounces
	 * @return this package's weight in pounds
	 */
	public double toPounds(double weight) {
		return weight/16;
	}
	
	/**
	 * This method contains the information to this package.
	 * @return this package's information
	 */
	public String toString() {
		return "This package's tracking number is " + trackNumber + ". Its weight is " + weight + 
				" and the shipping cost is $" + getCost();
	}

}
