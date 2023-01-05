package package1;

//-------------------------------------------------------
//Assignment 1 
//Part: 1
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #1
* Due Date: July 12 2020
*/

/**
 * This class implements a public transportation that people can take.
 * @author David Xie
 * @version 1.0
 *
 */
public class PublicTransportation {
	
	private double ticketPrice;
	private int nbStops;
	
	/**
	 * This is the default constructor for public transportations with no parameters are specified.
	 */
	public PublicTransportation() {
		ticketPrice = 0;
		nbStops = 0;
	}
	
	/**
	 * This is the parameterized constructor for specified public transportation.
	 * @param price the ticket price of this specified public transportation
	 * @param stops the number of stops of this specified public transportation
	 */
	public PublicTransportation(double price, int stops) {
		ticketPrice = price;
		nbStops = stops;
	}
	
	/**
	 * This is the copy constructor which makes a copy of this public transportation.
	 * @param copyTransport this public transportation is being copied
	 */
	public PublicTransportation(PublicTransportation copyTransport) {
		ticketPrice = copyTransport.ticketPrice;
		nbStops = copyTransport.nbStops;
	}
	
	/**
	 * This is the mutator for the ticket price of this public transportation.
	 * @param price the ticket price of this specified public transportation
	 */
	public void setPrice(double price) {
		ticketPrice = price;
	}
	
	/**
	 * This is the accessor to this ticket price of the public transportation.
	 * @return this public transportation's ticket price
	 */
	public double getPrice() {
		return ticketPrice;
	}
	
	/**
	 * This is the mutator to this public transportation's number of stops.
	 * @param stops the number of stops of this public transportation
	 */
	public void setStops(int stops) {
		nbStops = stops;
	}
	
	/**
	 * This is the accessor to this public transportation's number of stops.
	 * @return this public transportation's number of stops.
	 */
	public int getStops() {
		return nbStops;
	}
	
	/**
	 * This is the toString() method for this ferry.
	 * @return a clear description and information of this public transportation
	 */
	public String toString() {
		return ("This public transportation costs " + ticketPrice + "$ and has " + nbStops + " stops.");
	}
	
	/**
	 * This is the equals() method for public transportations to compare whether the transportations are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the public transportation attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            PublicTransportation otherTransport = (PublicTransportation)otherObject;
            return (ticketPrice == otherTransport.ticketPrice
               && nbStops == otherTransport.nbStops);
        }
	}

}
