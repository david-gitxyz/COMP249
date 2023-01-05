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
 * This class implements a Letter which is a package with a tracking number that ends with a 0.
 * It calculates the shipping cost of a letter based on its weight.
 * @author David Xie
 *@version 1.0
 */
public class Letter extends Package {
	
	private double letterCost;
	
	/**
	 * This constructs a letter with specified tracking number and weight.
	 * @param number the tracking number of this box
	 * @param weight the weight of this box, in ounces
	 */
	public Letter(long number, double weight) {
		super(number, weight);
		letterCost = getCost();
	}
	
	/**
	 * This method calculates the shipping cost of this letter based on its weight.
	 * @return This letter's shipping cost
	 */
	public double getCost() {
		return 0.05*getWeight();
	}
	
	/**
	 * This method contains information concerning this letter.
	 * @return This letter's information
	 */
	public String toString() {
		return "This package's tracking number is " + getNumber() + ". It's a letter with a "
				+ "weight of " + getWeight() + " ounces and the shipping cost is $" + letterCost;
	}

}
