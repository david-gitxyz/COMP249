package pack2;

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
 * This class implements a city bus which is a public transportation.
 * @author David Xie
 * @version 1.0
 *
 */
public class CityBus extends PublicTransportation {
	
	/**
	 * In part 2, the access rights of attributes have been changed to private, the strictest access right. 
	 * As a result, the classes Metro and Tram no longer have direct access to these attributes and must 
	 * use public accessors and mutators to access and modify the city bus attributes.
	 * Restricted access is good in order to respect encapsulation rules. It keeps the class attributes 
	 * safe from outside interference and/or misuse. As an added bonus, it provides greater flexibility in 
	 * programming by making implementation changes without losing compatibility in other classes.
	 * In short, restricted access trades in ease of access for better encapsulation and secure data.
	 */
	private long routeNb;
	private int beginOpYear;
	private String lineName;
	private String driverName;
	
	/**
	 * This is the default constructor for a city bus with no specified parameters.
	 */
	public CityBus() {
		super();
		routeNb = 0;
		beginOpYear = 1830;
		lineName = "No name";
		driverName = "No name";
	}
	
	/**
	 * This is the parameterized constructor for a specified city bus.
	 * @param price the ticket price for the specified city bus
	 * @param stops the number of stops of the specified city bus
	 * @param route the route number of the specified city bus
	 * @param opYr the beginning year of operation of the specified city bus
	 * @param nameLine the name of the line
	 * @param nameDriver the name of the driver
	 */
	public CityBus(double price, int stops, long route, int opYr, String nameLine, String nameDriver) {
		super(price, stops);
		routeNb = route;
		beginOpYear = opYr;
		lineName = nameLine;
		driverName = nameDriver;
	}
	
	/**
	 * This is the copy constructor which makes a copy of a city bus.
	 * @param copyBus the city bus being copied
	 */
	public CityBus(CityBus copyBus) {
		super(copyBus);
		routeNb = copyBus.routeNb;
		beginOpYear = copyBus.beginOpYear;
		lineName = copyBus.lineName;
		driverName = copyBus.driverName;
	}
	
	/**
	 * This is the mutator for the route number for this city bus.
	 * @param route the route number of this city bus
	 */
	public void setRoute(long route) {
		routeNb = route;
	}
	
	/**
	 * This is the accessor to the route number of this city bus.
	 * @return this city bus' route number
	 */
	public long getRoute() {
		return routeNb;
	}
	
	/**
	 * This is the mutator for the beginning year of operation of this city bus.
	 * @param opYr the beginning year of operation of this city bus
	 */
	public void setOpYr(int opYr) {
		beginOpYear = opYr;
	}
	
	/**
	 * This is the accessor to the beginning year of operation of this city bus.
	 * @return this city bus' beginning year of operation
	 */
	public int getOpYr() {
		return beginOpYear;
	}
	
	/**
	 * This is the mutator of the line name for this city bus.
	 * @param nameLine the line name of this city bus
	 */
	public void setLineName(String nameLine) {
		lineName = nameLine;
	}
	
	/**
	 * This is the accessor to the line name of this city bus.
	 * @return this city bus' line name
	 */
	public String getLineName() {
		return lineName;
	}
	
	/**
	 * This is the mutator of the driver's name for this city bus.
	 * @param nameDriver the driver's name for this city bus
	 */
	public void setDriverName(String nameDriver) {
		driverName = nameDriver;
	}
	
	/**
	 * This is the accessor to the driver's name of this city bus.
	 * @return this city bus' driver's name
	 */
	public String getDriverName() {
		return driverName;
	}
	
	/**
	 * This is the toString() method for this city bus.
	 * @return a clear description and information of this city bus
	 */
	public String toString() {
		return ("This city bus costs " + getPrice() + "$ and has " + getStops() + " stops." 
				+ " The route number is " + routeNb + " and it began to operate in " + beginOpYear + 
				". The line name is " + lineName + " and the driver's name is " + driverName + ".");
	}
	
	/**
	 * This is the equals() method for city buses to compare whether the buses are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the city bus attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            CityBus otherBus = (CityBus)otherObject;
            return (getPrice() == otherBus.getPrice() 
            		&& getStops() == otherBus.getStops() 
            		&& routeNb == otherBus.routeNb 
            		&& beginOpYear == otherBus.beginOpYear 
            		&& lineName.equals(otherBus.lineName) 
            		&& driverName.equals(otherBus.driverName));
        }
	}

}
