package package2;

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
 * This class implements a tram which is a city bus.
 * @author David Xie
 * @version 1.0
 *
 */
public class Tram extends CityBus {
	
	private int maxSpeed;
	
	/**
	 * This is the default constructor for a tram with no specified parameters.
	 */
	public Tram() {
		super();
		maxSpeed = 0;
	}
	
	/**
	 * This is the parameterized constructor for a specified tram.
	 * @param price the ticket price of the specified tram
	 * @param stops the number of stops of the specified tram
	 * @param route the route number of the specified tram
	 * @param opYr the beginning year of operation of the specified tram
	 * @param nameLine the line name of the specified tram
	 * @param nameDriver the name of the driver of the specified tram
	 * @param speed the maximum speed of the specified tram
	 */
	public Tram(double price, int stops, long route, int opYr, String nameLine, String nameDriver, int speed) {
		super(price, stops, route, opYr, nameLine, nameDriver);
		maxSpeed = speed;
	}
	
	/**
	 * This is the copy constructor which makes a copy of a tram.
	 * @param copyTram the tram being copied
	 */
	public Tram(Tram copyTram) {
		super(copyTram);
		maxSpeed = copyTram.maxSpeed;
	}
	
	/**
	 * This is the mutator for the maximum speed of this tram.
	 * @param speed the maximum speed of this tram
	 */
	public void setMaxSpeed(int speed) {
		maxSpeed = speed;
	}
	
	/**
	 * This is the accessor to the maximum speed of this tram.
	 * @return this tram's maximum speed
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * This is the toString() method for this tram.
	 * @return a clear description and information of this tram
	 */
	public String toString() {
		return ("This tram costs " + getPrice() + "$ and has " + getStops() + " stops." 
				+ " The route number is " + routeNb + " and it began to operate in " + beginOpYear + 
				". The line name is " + lineName + " and the driver's name is " + driverName + 
				". Its maximum speed is " + maxSpeed + " km/h.");
	}
	
	/**
	 * This is the equals() method for trams to compare whether the trams are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the tram attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Tram otherTram = (Tram)otherObject;
            return (getPrice() == otherTram.getPrice() 
            		&& getStops() == otherTram.getStops() 
            		&& routeNb == otherTram.routeNb 
            		&& beginOpYear == otherTram.beginOpYear 
            		&& lineName.equals(otherTram.lineName) 
            		&& driverName.equals(otherTram.driverName)
            		&& maxSpeed == otherTram.maxSpeed);
        }
	}

}
