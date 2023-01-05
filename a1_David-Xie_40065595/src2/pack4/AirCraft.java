package pack4;

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
 * This implements an aircraft which is a public transportation.
 * @author David Xie
 * @version 1.0
 *
 */

public class AirCraft extends PublicTransportation {
	
	
	public static enum ClassType {HELICOPTER, AIRLINE, GLIDER, BALLOON}
    public static enum Maintenance {WEEKLY,MONTHLY,YEARLY}

    private ClassType cType;
    private Maintenance mType;

    /**
	 * This is the default constructor for an aircraft with no parameters.
	 */
    public AirCraft()
    {
        super();
        cType = null;
        mType = null;
    }

     /**
      * This is the parameterized constructor of a specified aircraft.
      * @param price the price of this aircraft
      * @param stops the number of stops for this aircraft
      * @param cType the class type of this aircraft
      * @param mType the maintenance type for this aircraft
      */
    public AirCraft(double price, int stops, ClassType cType, Maintenance mType)
     {
         super(price, stops);
         this.cType = cType;
         this.mType = mType;     
     }
    
    /**
     * This is the copy constructor which makes a copy of an aircraft.
     * @param copyAircraft This is the Aircraft being copied.
     */    
    public AirCraft(AirCraft copyAircraft)
    {
        super(copyAircraft);
        cType = copyAircraft.cType;
        mType = copyAircraft.mType;
    }

    /**
     * This is the mutator of the class type of this aircraft
     * @param cType the class type of this aircraft
     */    
    public void setClassType(ClassType cType) {
    	
    	this.cType=cType;
    	
    }
    
    /**
     * This is the accessor to the class type of this aircraft.
     * @return this aircraft's class type
     */
    public ClassType getClassType() {
    	
    	return cType;
    }
    
    /**
     * This is the mutator of the maintenance type for this aircraft. 
     * @param mType the maintenance type of this aircraft
     */
    public void setMaintenance (Maintenance mType) {
    	
    	this.mType=mType;
    }    
    
    /**
     * This is the accessor to the maintenance type for this aircraft.
     * @return maintenance type
     */
    public Maintenance getMaintenance() {
    	return mType;
    	
    }
	
    /**
	 *This is the toString() method for this aircraft.
	 *@return a clear description and information of this aircraft
	 */
	public String toString() {
		return ("This aircraft costs " + getPrice() + "$ and has " + getStops() + " stops."
				 + " Its class is " + cType + " and it requires maintenance " + mType + ".");
	}
	
	/**
	 * This is the equals() method for aircrafts to compare whether the aircrafts are the same.
	 * The null verification is important in making sure that the program does not crash as null does not refer 
	 * to an object so the method will throw a Null Pointer Exception error message. This will cause the program 
	 * to crash. The verification avoids the Null Pointer Exception, allowing the program to keep running.
	 * @return comparison of the aircraft attributes
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            AirCraft otherAircraft = (AirCraft)otherObject;
            return (getPrice() == otherAircraft.getPrice()
               && getStops() == otherAircraft.getStops() 
               && cType.equals(otherAircraft.cType) 
               && mType.equals(otherAircraft.mType));
        }
	}

}
