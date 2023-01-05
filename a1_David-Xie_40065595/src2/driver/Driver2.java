package driver;

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
import pack2.CityBus;
import pack2.Metro;
import pack2.Tram;
import pack3.Ferry;
import pack4.AirCraft;
import pack4.AirCraft.ClassType;
import pack4.AirCraft.Maintenance;

/**
 * This class implements an array of public transportations and attempts to copy it.
 * @author David Xie
 * @version 1.0
 *
 */
public class Driver2 {
	
	/**
	 * This method copies the content of an array of public transportations. The for loop was constructed 
	 * carefully so as to avoid problems with the instanceof method due to inheritance. This method checks 
	 * instances from the most child classes before parent classes. Thus, the test in the main() method 
	 * succeeded on the first attempt, i.e. the copy obtained is the same as the original as expected.
	 * @param original the original array of public transportations
	 * @return a copy of this original array of public transportations
	 */
	public static PublicTransportation[] copyCityBuss(PublicTransportation [] original) {
		
		PublicTransportation[] copy = new PublicTransportation[original.length];
		for(int i=0; i < original.length; i++) {
			if(original[i] instanceof Metro)
				copy[i]=new Metro((Metro)original[i]);
			else if(original[i] instanceof Tram)
				copy[i]=new Tram((Tram)original[i]);
			else if(original[i] instanceof CityBus)
				copy[i]=new CityBus((CityBus)original[i]);
			else if(original[i] instanceof Ferry)
				copy[i]=new Ferry((Ferry)original[i]);
			else if(original[i] instanceof AirCraft)
				copy[i]=new AirCraft((AirCraft)original[i]);
			else if(original[i] instanceof PublicTransportation)
				copy[i]=new PublicTransportation(original[i]);
		}
		
		return copy;
	}

	public static void main(String[] args) {
		
		PublicTransportation transport1 = new PublicTransportation(21.50, 5);
		PublicTransportation transport2 = new PublicTransportation();
		
		CityBus bus1 = new CityBus(3.50, 20, 1000500, 1950, "Green", "Sam Johnson");
		CityBus bus2 = new CityBus();
		
		Tram tram1 = new Tram(3.50, 50, 2000700, 1860, "Leonard", "Tom Grand", 50);
		Tram tram2 = new Tram();
		
		Metro metro1 = new Metro(3.50, 20, 1000500, 1950, "Green", "Sam Johnson", 10, "Montreal");
		Metro metro2 = new Metro();
		
		Ferry ferry1 = new Ferry(21.50, 5, 1980, "Jackson");
		Ferry ferry2 = new Ferry();
		
		AirCraft air1 = new AirCraft(50.00, 2, ClassType.AIRLINE, Maintenance.MONTHLY);
		AirCraft air2 = new AirCraft(60.00, 4, ClassType.HELICOPTER, Maintenance.WEEKLY);
		
		//Create the original array of public transportations
		PublicTransportation [] transports = {transport1, transport2, bus1, bus2, tram1, tram2, 
				metro1, metro2, ferry1, ferry2, air1, air2};
		
		System.out.println("This is the original array:");
		System.out.println("Index			Content");
		for(int i = 0; i < transports.length; i++) {
			System.out.println(i + "		" + transports[i]);
		}
		
		//Attempt to copy the array of public transportations
		System.out.println("\nThis is the copied array:");
		System.out.println("Index			Content");
		PublicTransportation [] copy = copyCityBuss(transports);
		for(int i = 0; i < transports.length; i++) {
			System.out.println(i + "		" + copy[i]);
		}

	}

}
