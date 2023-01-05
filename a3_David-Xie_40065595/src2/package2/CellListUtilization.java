package package2;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
 * This class tests the implementations of CellPhone and CellList.
 * @author David Xie
 * @version 1.0
 */
public class CellListUtilization {

	public static void main(String[] args) {

		CellList list1 = new CellList();
		CellList list2 = new CellList();
		
		Scanner inputStream = null;
		//Open input file
        try {
        	inputStream = new Scanner(new FileInputStream("Cell_Info.txt"));
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files.");
           System.exit(0);
        }
        
        //load the input file into list1
        while(inputStream.hasNext()) {
        	//get the attributes in the order that the list has them in
        	long number = inputStream.nextLong();
        	String brand = inputStream.next();
        	double price = inputStream.nextDouble();
        	int year = inputStream.nextInt();
        	
        	//load them in the way the constructor was defined in CellPhone class
        	CellPhone newPhone = new CellPhone(number, brand, year, price);
        	if(!(list1.contains(newPhone.getNumber())))
        		list1.addToStart(newPhone);
        }
        System.out.println();
        
        //Show contents
        System.out.println("Contents of list1:");
        list1.showContents();
        System.out.println();
        
        //Find a specific cellphone using its serial number
        Scanner keyboard = new Scanner(System.in);
        String response = "Y";
        while(response.toUpperCase().equals("Y")) {
            //Find and print values of cellphone
        	System.out.println("Please enter a serial number you'd like to search in the list: ");
            long number = keyboard.nextLong();
            list1.contains(number);
            
            //Prompt user if they would like to continue to search
            System.out.println("Would you like to look for another serial number? (Y/N)");
            response = keyboard.next();
        }
        System.out.println();
        
        //Parameterized constructor of CellPhone class
        CellPhone phone1 = new CellPhone(123456, "Nokia", 2001, 50.00);
        //toString of CellPhone class
        System.out.println("Parameterized constructor of CellPhone class gives phone1: " + phone1); 
        
        //Testing copy constructor of CellPhone class
        CellPhone phone2 = new CellPhone(phone1, 987654);
        System.out.println("Copy constructor of CellPhone class gives phone2: " + phone2);
        //Testing equals method, should return true
        System.out.println("Is phone1 equal to phone2? " + phone1.equals(phone2));
        System.out.println();
        
        //Testing accessors and mutators of CellPhone class
        phone1.setNumber(1357924);
        System.out.println("Using the accessor of the CellPhone class, the mutator changed the serial number "
        		+ "of phone1 to: " + phone1.getNumber());
        
        phone1.setBrand("Samsung");
        System.out.println("Using the accessor of the CellPhone class, the mutator changed the brand "
        		+ "of phone1 to: " + phone1.getBrand());
        
        phone1.setYear(2019);
        System.out.println("Using the accessor of the CellPhone class, the mutator changed the manufacturing "
        		+ "year of phone1 to: " + phone1.getYear());
        
        phone1.setPrice(900);
        System.out.println("Using the accessor of the CellPhone class, the mutator changed the price "
        		+ "of phone1 to: " + phone1.getPrice());
        System.out.println();
        
        //Yet the copy constructor should remain untouched
        System.out.println("Yet phone2 should remain untouched: " + phone2);
        System.out.println("Is modified phone1 equal to phone2? " + phone1.equals(phone2));
        System.out.println();
        
        //Testing the clone method of CellPhone class, should return a deep copy
        CellPhone phone3 = (CellPhone)phone1.clone();
        System.out.println("The clone method of CellPhone class gives phone3: " + phone3);
        //Changing clone brand value and testing if it's the same as phone1 which it copied
        phone3.setBrand("Asus");
        System.out.println("After changing brand of phone3 to Asus, is it still equal to phone1? " 
        		+ phone3.equals(phone1));
        System.out.println();
        
        
        //Testing unique cases of equals of CellPhone class
        CellPhone phone0 = null;
        System.out.println("Testing unique cases of equals method in CellPhone class.");
        System.out.println("Is phone1 equal to phone0? " + phone1.equals(phone0));
        System.out.println("Is phone1 equal to list1? " + phone1.equals(list1));
        System.out.println();

        //Note constructors and methods in CellNode class are being tested within methods of CellList class
        //Testing remaining methods of CellList class
        //Default CellList constructor, addToStart, find, and contains methods already tested
        //Testing CellList insertAtIndex method
        CellPhone phone4 = new CellPhone(1000000, "OnePlus", 2018, 600);
        list2.addToStart(phone1);
        list2.addToStart(phone2);
        list2.insertAtIndex(phone3, 1);
        System.out.println("Contents of list2 after using insertAtIndex: ");
        list2.showContents();
        //Testing special cases of the method. Remove comment brackets to test the ones that exit the program
        list2.insertAtIndex(phone4, 0); //inserting at start of list
        //list2.insertAtIndex(phone1, 10); //out of bounds
        System.out.println();
        
        //Testing CellList copy constructor and equals method. Copy constructor uses copyOf helping method
        CellList list3 = new CellList(list2);
        System.out.println("Contents of list3 after using copy constructor of CellList: ");
        list3.showContents();
        System.out.println();
        CellList list4 = null;
        System.out.println("list2 is equal to list3: " + list2.equals(list3));
        System.out.println("list1 is equal to list2: " + list1.equals(list2));
        System.out.println("list1 is equal to list4: " + list1.equals(list4));
        System.out.println("list1 is equal to phone1: " + list1.equals(phone1));
        System.out.println();
        
        //Testing deleteFromIndex, deleteFromStart, and replaceAtIndex methods
        CellPhone phone5 = new CellPhone(9000000, "Google", 2020, 999.99);
        CellList list5 = new CellList(); //creating a new empty CellList
        list3.deleteFromIndex(2);
        list3.replaceAtIndex(phone5, 1);
        //Special cases. Remove comment brackets to test the ones that exit program
        list3.deleteFromIndex(0); //deleting from the start. This also tests deleteFromStart since it uses it.
        //list5.deleteFromIndex(2); //list is empty
        list3.replaceAtIndex(phone5, 10); //out of bounds, it should simply return, but no modifications made
        System.out.println("Contents of list3 after using delete methods and replace method of CellList: ");
        list3.showContents();
        //to show that list3 is a deep copy
        System.out.println("list2 is equal to list3 after modifications: " + list2.equals(list3)); 
	}

}
