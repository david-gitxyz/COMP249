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
 * This class implements a metro which is a city bus.
 * @author David Xie
 * @version 1.0
 *
 */
public class Metro extends CityBus {
	
	private int nbVehicle;
	private String cityName;
	
	/**
	 * This is the default constructor for a metro with no specified parameters.
	 */
	public Metro() {
		super();
		nbVehicle = 0;
		cityName = "No name";
	}
	
	/**
	 * This is the parameterized constructor for a specified metro.
	 * @param price the ticket price of the specified metro
	 * @param stops the number of stops of the specified metro
	 * @param route the route number of the specified metro
	 * @param opYr the beginning year of operation of the specified metro
	 * @param nameLine the line name of the specified metro
	 * @param nameDriver the name of the driver of the specified metro
	 * @param numVehicle the number of vehicles for the specified metro
	 * @param nameCity the name of the city of the specified metro
	 */
	public Metro(double price, int stops, long route, int opYr, String nameLine, 
			String nameDriver, int numVehicle, String nameCity) {
		super(price, stops, route, opYr, nameLine, nameDriver);
		nbVehicle = numVehicle;
		cityName = nameCity;
	}
	
	/**
	 * This is the copy constructor which makes a copy of a metro.
	 * @param copyMetro the metro being copied
	 */
	public Metro(Metro copyMetro) {
		super(copyMetro);
		nbVehicle = copyMetro.nbVehicle;
		cityName = copyMetro.cityName;
	}
	
	/**
	 * This is the mutator of the number of vehicle of this metro.
	 * @param numVehicle the number of vehicles of this metro
	 */
	public void setNbVehicle(int numVehicle) {
		nbVehicle = numVehicle;
	}
	
	/**
	 * This is the accessor to the number of vehicles of this metro.
	 * @return this metro's number of vehicles
	 */
	public int getNbVehicle() {
		return nbVehicle;
	}
	
	/**
	 * This is the mutator of the city name of this metro.
	 * @param nameCity the city name of this metro
	 */
	public void setCityName(String nameCity) {
		cityName = nameCity;
	}
	
	/**
	 * This is the accessor to the city name of this metro.
	 * @return this metro's city name
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * This is the toString() method for this metro.
	 * @return a clear description and information of this metro
	 */
	public String toString() {
		return ("This metro costs " + getPrice() + "$ and has " + getStops() + " stops." 
				+ " The route number is " + routeNb + " and it began to operate in " + beginOpYear + 
				". The line name is " + lineName + " and the driver's name is " + driverName + 
				". It has " + nbVehicle + " vehicles and it is located in " + cityName + ".");
	}
	
	/**
	 * This is the equals() method for metros to compare whether the metros are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the metro attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Metro otherMetro = (Metro)otherObject;
            return (getPrice() == otherMetro.getPrice() 
            		&& getStops() == otherMetro.getStops() 
            		&& routeNb == otherMetro.routeNb 
            		&& beginOpYear == otherMetro.beginOpYear 
            		&& lineName.equals(otherMetro.lineName) 
            		&& driverName.equals(otherMetro.driverName) 
            		&& nbVehicle == otherMetro.nbVehicle 
            		&& cityName.equals(otherMetro.cityName));
        }
	}

}
