package pack3;

//-------------------------------------------------------
//Assignment 1 
//Part: 2
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #1
* Due Date: July 12 2020
*/

import pack1.PublicTransportation;

/**
 * This class implements a ferry which is a public transportation
 * @author David Xie
 * @version 1.0
 *
 */
public class Ferry extends PublicTransportation {
	
	private int buildYr;
	private String shipName;
	
	/**
	 * This is the default constructor for a ferry with no specified parameters
	 */
	public Ferry() {
		super();
		buildYr = 1820;
		shipName = "No name";
	}
	
	/**
	 * This is the parameterized constructor for a specified ferry.
	 * @param price the ticket price for the specified ferry
	 * @param stops the number of stops for the specified ferry
	 * @param year the build year of the specified ship
	 * @param name the name of the specified ship
	 */
	public Ferry(double price, int stops, int year, String name) {
		super(price, stops);
		buildYr = year;
		shipName = name;
	}
	
	/**
	 * This is the copy constructor which makes a copy of a ferry.
	 * @param copyFerry the ferry being copied
	 */
	public Ferry(Ferry copyFerry) {
		super(copyFerry);
		buildYr = copyFerry.buildYr;
		shipName = copyFerry.shipName;
	}
	
	/**
	 * This is the mutator of the build year of the ship of this ferry.
	 * @param year the build year of the ship of this ferry
	 */
	public void setBuildYr(int year) {
		buildYr = year;
	}
	
	/**
	 * This is the accessor to the build year of the ship of this ferry.
	 * @return this ferry's ship build year
	 */
	public int getBuildYr() {
		return buildYr;
	}
	
	/**
	 * This is the mutator of the ship name of this ferry.
	 * @param name the name of the ship of this ferry
	 */
	public void setShipName(String name) {
		shipName = name;
	}
	
	/**
	 * This is the accessor to the ship's name of this ferry.
	 * @return this ferry's ship name
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 * This is the toString() method for this ferry.
	 * @return a clear description and information of this ferry
	 */
	public String toString() {
		return ("This ferry costs " + getPrice() + "$ and has " + getStops() + " stops." 
				+ " The ship's build year is " + buildYr + " and it is named " + shipName + ".");
	}
	
	/**
	 * This is the equals() method for ferries to compare whether the ferries are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the ferry attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Ferry otherFerry = (Ferry)otherObject;
            return (getPrice() == otherFerry.getPrice()
               && getStops() == otherFerry.getStops() 
               && buildYr == otherFerry.buildYr 
               && shipName.equals(otherFerry.shipName));
        }
	}

}
