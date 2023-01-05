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

import java.util.Scanner;

/**
 * This class implements a cargo, loads the truck, finds the number of packages loaded, finds the gross income 
 * of the cargo, finds the weight of the truck, drives the truck to its destination, and unloads the truck.
 * @author David Xie
 *@version 1.0
 */
public class CargoTest {

	public static void main(String[] args) {
		
		String response = "Y";
		
		Scanner keyboard = new Scanner(System.in);
		
		Truck truck = new Truck();
		
		while(response.toUpperCase().equals("Y")) {
			System.out.println("What would you like to do?");
			System.out.println("\t1. Start a cargo");
			System.out.println("\t2. Load the truck with packages");
			System.out.println("\t3. Unload a package");
			System.out.println("\t4. Find the number of packages loaded");
			System.out.println("\t5. Find the gross income earned by shipping of the cargo");
			System.out.println("\t6. Find the weight of the truck(after it has been completely loaded)");
			System.out.println("\t7. Drive the truck to destination");
			System.out.println("\t0. To quit");
			System.out.println("Please enter your choice and press <Enter>:");
			
			int choice = keyboard.nextInt();
			switch(choice) {
			case 1: //Start cargo
				keyboard.nextLine();
				System.out.println("Please enter the driver's name: ");
				String name = keyboard.nextLine();
				System.out.println("Would you like to enter the unloaded weight of the truck in kg or in lbs? "
						+ "(Enter kg or lbs)");
				String measureTruck = keyboard.next();
				System.out.println("Please enter the truck's unloaded weight: ");
				double unloadWeight = keyboard.nextDouble();
				System.out.println("Please enter the truck's originating city: ");
				String origin = keyboard.next();
				System.out.println("Please enter the truck's destination city: ");
				String destination = keyboard.next();
				truck = new Truck(name, unloadWeight, origin, destination);
				if(measureTruck.equals("kg"))
					truck.setUnloadedWeight(truck.toPounds(unloadWeight));
				System.out.println(truck);
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 2: //load truck
				System.out.println("Please enter the package tracking number: ");
				long trackNum = keyboard.nextLong();
				System.out.println("Would you like to enter the weight of the package in oz or in lbs? "
						+ "(Enter oz or lbs)");
				String measurePack = keyboard.next();
				System.out.println("Please enter the package's weight: ");
				double packWeight = keyboard.nextDouble();
				if(trackNum % 10 == 0) {
					Package pack = new Letter(trackNum, packWeight);
					if(measurePack.equals("lbs"))
						pack = new Letter(trackNum, pack.toOunces(packWeight));
					truck.load(pack);
				}
				else if(trackNum % 10 == 1) {
					Package pack = new Box(trackNum, packWeight);
					if(measurePack.equals("oz"))
						pack = new Box(trackNum, pack.toPounds(packWeight));
					truck.load(pack);
				}
				else if(trackNum % 10 == 2) {
					Package pack = new WoodCrate(trackNum, packWeight);
					if(measurePack.equals("oz"))
						pack = new WoodCrate(trackNum, pack.toPounds(packWeight));
					truck.load(pack);
				}
				else if(trackNum % 10 == 3) {
					Package pack = new MetalCrate(trackNum, packWeight);
					if(measurePack.equals("oz"))
						pack = new MetalCrate(trackNum, pack.toPounds(packWeight));
					truck.load(pack);
				}
				else {
					Package pack = new Letter(trackNum, packWeight);
					truck.load(pack);
				}
				Package[] copyPack = truck.getPackages();
				System.out.println("Loaded packages so far are: ");
				for(int i = 0; i < truck.getNbPackages(); i++)
					System.out.println(copyPack[i]);
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 3: //unload package
				System.out.println("Please enter the tracking number of the package you wish to unload: ");
				long unloadNum = keyboard.nextLong();
				Package[] copyPack2 = truck.getPackages();
				int index = 0;
				for(int i = 0; i < truck.getNbPackages(); i++)
					if(copyPack2[i].getNumber() == unloadNum)
						index = i;
				truck.unload(index);
				Package[] copyPack3 = truck.getPackages();
				System.out.println("Updated loaded packages: ");
				for(int i = 0; i < truck.getNbPackages(); i++)
					System.out.println(copyPack3[i]);
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 4: //return number of packages
				System.out.println("The number of packages currently loaded in the truck: " 
						+ truck.getNbPackages());
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 5: //return the gross income
				System.out.println("The gross income earned by shipping of the cargo: $" + truck.grossIncome());
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 6: //return the gross weight
				truck.setGrossWeight();
				System.out.println("The weight of the truck after it has been completely loaded is: "
						 + truck.getGrossWeight() + " lbs, or " + truck.toKilograms(truck.getGrossWeight()) 
						 + " kg.");
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 7: //drives truck to destination
				System.out.println("The truck is being driven to its destination!");
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
				
			case 0: //quit menu
				response = "N";
				break;
				
			default:
				System.out.println("There is no such choice!");
				System.out.println("Do you wish to return to the main menu? (Y/N)");
				response = keyboard.next();
				break;
			}
		}
		
	}

}
