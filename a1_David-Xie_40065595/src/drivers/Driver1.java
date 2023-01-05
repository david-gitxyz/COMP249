package drivers;

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

import package1.PublicTransportation;
import package2.CityBus;
import package2.Metro;
import package2.Tram;
import package3.Ferry;
import package4.AirCraft;
import package4.AirCraft.ClassType;
import package4.AirCraft.Maintenance;

/**
 * This class implements public transportations and manipulates that data.
 * @author David Xie
 * @version 1.0
 *
 */
public class Driver1 {

	public static void main(String[] args) {
		
		// Creating 15 public transportations and display their info
		System.out.println("We are printing 15 public transportations:");
		
		PublicTransportation transport1 = new PublicTransportation(21.50, 5);
		System.out.println(transport1.toString());
		PublicTransportation transport2 = new PublicTransportation(transport1);
		System.out.println(transport2.toString());
		PublicTransportation transport3 = new PublicTransportation();
		System.out.println(transport3.toString());
		
		CityBus bus1 = new CityBus(3.50, 20, 1000500, 1950, "Green", "Sam Johnson");
		System.out.println(bus1.toString());
		CityBus bus2 = new CityBus(bus1);
		System.out.println(bus2.toString());
		CityBus bus3 = new CityBus();
		System.out.println(bus3.toString());
		
		Tram tram1 = new Tram(3.50, 50, 2000700, 1860, "Leonard", "Tom Grand", 50);
		System.out.println(tram1.toString());
		Tram tram2 = new Tram(tram1);
		System.out.println(tram2.toString());
		
		Metro metro1 = new Metro(3.50, 20, 1000500, 1950, "Green", "Sam Johnson", 10, "Montreal");
		System.out.println(metro1.toString());
		Metro metro2 = new Metro();
		System.out.println(metro2.toString());
		
		Ferry ferry1 = new Ferry(21.50, 5, 1980, "Jackson");
		System.out.println(ferry1.toString());
		Ferry ferry2 = new Ferry(ferry1);
		System.out.println(ferry2.toString());
		Ferry ferry3 = new Ferry();
		System.out.println(ferry3.toString());
		
		AirCraft air1 = new AirCraft(50.00, 2, ClassType.AIRLINE, Maintenance.MONTHLY);
		System.out.println(air1.toString());
		AirCraft air2 = new AirCraft(air1);
		System.out.println(air2.toString());
		
		//Testing the equality of some objects
		System.out.println("\nWe are testing the equality of some of the transportations:");
		System.out.println("transport1 and ferry1: " + transport1.equals(ferry1));
		System.out.println("bus1 and bus2: " + bus1.equals(bus2));
		System.out.println("tram1 and tram2: " + tram1.equals(tram2));
		System.out.println("metro1 and metro2: " + metro1.equals(metro2));
		System.out.println("air1 and air2: " + air1.equals(air2));
		
		//Array of 15 public transportations
		PublicTransportation [] transports = new PublicTransportation[15];
		
		transports[0] = transport1;
		transports[1] = transport2;
		transports[2] = transport3;
		transports[3] = bus1;
		transports[4] = bus2;
		transports[5] = bus3;
		transports[6] = tram1;
		transports[7] = tram2;
		transports[8] = metro1;
		transports[9] = metro2;
		transports[10] = ferry1;
		transports[11] = ferry2;
		transports[12] = ferry3;
		transports[13] = air1;
		transports[14] = air2;
		
		//Search least and most expensive transport
		System.out.println("\nWe are searching for the least and most expensive transport in an array:");
		int minIndex = 0;
		int maxIndex = 0;
		for(int i = 1; i < transports.length; i++) {
			if(transports[i].getPrice() < transports[minIndex].getPrice())
				minIndex = i;
			if(transports[i].getPrice() > transports[maxIndex].getPrice())
				maxIndex = i;
		}
		
		System.out.println("The least expensive transport has index " + minIndex + ". " 
				+ transports[minIndex].toString());
		System.out.println("The most expensive transport has index " + maxIndex + ". " 
				+ transports[maxIndex].toString());

	}

}
