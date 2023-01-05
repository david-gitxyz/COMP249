package package2;

import java.util.Scanner;

//-------------------------------------------------------
//Assignment 3
//Part: 2
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #3
* Due Date: August 16 2020
*/

/**
 * This class implements a cellphone with a serial number, the brand, the manufacturing year and the price.
 * @author David Xie
 *@version 1.0
 */
public class CellPhone implements Cloneable {
	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * This is the parameterized constructor of a specified cellphone
	 * @param number the serial number of this cellphone
	 * @param brand the brand of this cellphone
	 * @param year the manufacturing year of this cellphone
	 * @param price the price of this cellphone
	 */
	public CellPhone(long number, String brand, int year, double price) {
		serialNum = number;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * This is a copy constructor that copies the data of another cellphone with a new serial number.
	 * Since all data is immutable, there should be no privacy leak, but should a mutable data be manipulated, 
	 * It is suggested to make a deep copy to avoid privacy leaks. This can be done by creating a new object 
	 * of this mutable data.
	 * @param toCopy the cellphone to copy
	 * @param newNum the new serial number assigned to this cellphone
	 */
	public CellPhone(CellPhone toCopy, long newNum) {
		serialNum = newNum;
		brand = toCopy.brand;
		year = toCopy.year;
		price = toCopy.price;
	}
	
	/**
	 * This is the mutator to the serial number of this cellphone
	 * @param number the serial number of this cellphone
	 */
	public void setNumber(long number) {
		serialNum = number;
	}
	
	/**
	 * This is the accessor to the serial number of this cellphone
	 * @return this cellphone's serial number
	 */
	public long getNumber() {
		return serialNum;
	}
	
	/**
	 * This is the mutator to the cellphone brand
	 * @param brand the brand of this cellphone
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * This is the accessor to the cellphone brand
	 * @return this cellphone brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * This is the mutator to the manufacturing year of this cellphone
	 * @param year the manufacturing year of this cellphone
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * This is the accessor to the manufacturing year of this cellphone
	 * @return this cellphone's manufacturing year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * This is the mutator to the price of this cellphone
	 * @param price the price of this cellphone
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This is the accessor to the price of this cellphone
	 * @return this cellphone's price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This is the clone method for the class CellPhone. It first prompts the user for a new serial number for 
	 * this cellphone. It then copies the data of the cellphone, changes the serial number to the new one, 
	 * and returns the copy with modified serial number. Since the data is immutable, there should be no 
	 * privacy leaks. Should a mutable data be added, it is suggested to also replace the mutable data by a 
	 * clone of this mutable data. The Cloneable interface was implemented so that the clone() method is defined 
	 * in a way to reduce risk of privacy leaks as defined above.
	 * @return a copy of this cellphone
	 */
	public Object clone() {
		try {
			//Prompt user to enter a new serial number
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Please enter a new serial number for this clone cellphone: ");
			long number = keyboard.nextLong();
			
			CellPhone copy = (CellPhone)super.clone();
			copy.serialNum = number; //change the attribute of the old serial number to the new one
			return copy;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	/**
	 * This method gives an appropriate String value to return if a CellPhone object is called
	 * @return String value of object of class CellPhone
	 */
	public String toString() {
		return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "]");
	}
	
	/**
	 * This method checks if two CellPhone objects are equal. Note that the serial number need not be equal.
	 * In fact, it shouldn't.
	 * @return whether the two CellPhone objects are equal or not.
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null)
			return false;
		else if(getClass() != otherObject.getClass())
			return false;
		else {
			CellPhone otherPhone = (CellPhone)otherObject;
			return (brand.equals(otherPhone.brand) 
					&& year == otherPhone.year 
					&& price == otherPhone.price);
		}
	}

}
