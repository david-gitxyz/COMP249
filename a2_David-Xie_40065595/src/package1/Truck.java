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

/**
 * This class implements a Truck that delivers packages. It contains the name of the driver, the originating and 
 * destination cities, the unloaded weight of the truck, the gross weight, the number of packages, and the 
 * package information.
 * @author David Xie
 * @version 1.0
 *
 */
public class Truck {
	
	private String driverName;
	private String origin;
	private String destination;
	private double grossWeight; //in pounds
	private double unloadedWeight; //in pounds
	private int nbPackages;
	private Package[] packageInfo;
	private final int maxNumber = 200;
	
	/**
	 * This is the default constructor of a truck.
	 */
	public Truck() {
		driverName = "no name";
		origin = "none";
		destination = "none";
		grossWeight = 0;
		unloadedWeight = 0;
		nbPackages = 0;
		packageInfo = new Package[maxNumber];
	}
	
	/**
	 * This constructs a truck with specified parameters for the driver name, the unloaded weight of the truck,
	 *  the originating and destination cities
	 * @param driverName the name of the driver for this truck
	 * @param unloadedWeight the unloaded weight of this truck, in pounds
	 * @param origin the originating city of this truck
	 * @param destination the destination city of this truck
	 */
	public Truck(String driverName, double unloadedWeight, String origin, String destination) {
		this.driverName = driverName;
		this.unloadedWeight = unloadedWeight;
		this.origin = origin;
		this.destination = destination;
		grossWeight = 0;
		nbPackages = 0;
		packageInfo = new Package[maxNumber];
	}
	
	/**
	 * This is the mutator to the unloaded weight of this truck
	 * @param weight unloaded weight of this truck
	 */
	public void setUnloadedWeight(double weight) {
		unloadedWeight = weight;
	}
	
	/**
	 * This is the accessor to the number of packages in this truck
	 * @return this truck's number of packages
	 */
	public int getNbPackages() {
		return nbPackages;
	}
	
	/**
	 * This is the accessor to the packages' information in this truck
	 * @return this truck's packages' information
	 */
	public Package[] getPackages() {
		Package[] temp = new Package[nbPackages];
		for(int i = 0; i < nbPackages; i++)
			temp[i] = packageInfo[i];
		return temp;
	}
	
	/**
	 * This method calculates the gross weight of this truck.
	 */
	public void setGrossWeight() {
		Package[] copyPack = getPackages();
		double sum = 0;
		double element = 0;
		for(int i = 0; i < nbPackages; i++) {
			if(copyPack[i].getNumber() % 10 == 0)
				element = copyPack[i].toPounds(copyPack[i].getWeight());
			else
				element = copyPack[i].getWeight();
			sum += element;
		}
		grossWeight = sum;
	}
	
	/**
	 * This is the accessor to the gross weight of this truck.
	 * @return this truck's gross weight
	 */
	public double getGrossWeight() {
		return grossWeight;
	}

	
	/**
	 * This method loads a package into this truck.
	 * @param newPackage the package being loaded in this truck
	 */
	public void load(Package newPackage) {
		try {
			if((newPackage.getNumber() % 10 == 0) && (newPackage.getWeight() > 32))
				throw new PackageException("This letter is too heavy! Package not loaded.");
			else if((newPackage.getNumber() % 10 == 1) && (newPackage.getWeight() > 40))
				throw new PackageException("This box is too heavy! Package not loaded.");
			else if((newPackage.getNumber() % 10 == 2) && (newPackage.getWeight() > 80))
				throw new PackageException("This wood crate is too heavy! Package not loaded.");
			else if((newPackage.getNumber() % 10 == 3) && (newPackage.getWeight() > 100))
				throw new PackageException("This metal crate is too heavy! Package not loaded.");
			else if(newPackage.getNumber() % 10 > 3)
				throw new PackageException("This type of package cannot be loaded onto this truck! Package "
						+ "not loaded.");
			else if(nbPackages == maxNumber)
				throw new PackageException("This truck is full! Package not loaded");
			else {
				packageInfo[nbPackages] = newPackage;
				nbPackages++;
			}
		}
		catch(PackageException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method unloads a package from this truck.
	 * @param index the index in the array where the package is located
	 */
	public void unload(int index) {
		System.out.println("This package will be unloaded. " + packageInfo[index]);
		for(int i = index; i < nbPackages; i++)
			packageInfo[i] = packageInfo[i+1];
		nbPackages--;
	}
	
	/**
	 * This method calculates the gross income of this truck
	 * @return this truck's gross income
	 */
	public double grossIncome() {
		Package[] copyPack = getPackages();
		double sum = 0;
		for(int i = 0; i < nbPackages; i++)
			sum += copyPack[i].getCost();
		return sum;
	}
	
	/**
	 * This method converts pounds to kilograms
	 * @param weight the weight of this truck in pounds
	 * @return this truck's weight in kilograms
	 */
	public double toKilograms(double weight) {
		return weight/2.205;
	}
	
	/**
	 * This method converts kilograms to pounds
	 * @param weight the weight of this truck in kilograms
	 * @return this truck's weight in pounds
	 */
	public double toPounds(double weight) {
		return weight*2.205;
	}
	
	/**
	 * This method contains the information of this truck.
	 * @return this truck's information
	 */
	public String toString() {
		return "This truck's driver is " + driverName + ". Its originating city is " + origin + " and its"
				+ " destination is " + destination +". It weighs " + unloadedWeight + " lbs before loading.";
	}

}
