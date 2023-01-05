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
 * This class implements a cargoship with its serial number, its name, its creation year, its owner country, 
 * its price and its speed.
 * @author David Xie
 *@version 1.0
 */
public class Cargoship {
	
	private long serialNum;
	private String name;
	private int creationYr;
	private String ownerCountry;
	private double price;
	private int speed;
	
	/**
	 * This is the default constructor of a cargoship
	 */
	public Cargoship() {
		
	}
	
	/**
	 * This constructs a cargoship with specified parameters.
	 * @param number serial number of this cargoship
	 * @param name name of this cargoship
	 * @param year creation year of this cargoship
	 * @param country owner country of this cargoship
	 * @param price price of this cargoship
	 * @param speed speed of this cargoship
	 */
	public Cargoship(long number, String name, int year, String country, double price, int speed) {
		serialNum = number;
		this.name = name;
		creationYr = year;
		ownerCountry = country;
		this.price = price;
		this.speed = speed;
	}
	
	/**
	 * This method is the accessor to the serial number of this cargoship
	 * @return this cargoship's serial number
	 */
	public long getNumber() {
		return serialNum;
	}
	
	/**
	 * This is the mutator to the serial number of this cargoship
	 * @param number the serial number of this cargoship
	 */
	public void setNumber(long number) {
		serialNum = number;
	}
	
	/**
	 * This method contains the information related to this cargoship
	 * @return this cargoship's information
	 */
	public String toString() {
		return serialNum + " " + name + " " + creationYr + " " + ownerCountry + " " + price + " " + speed;
	}

}
