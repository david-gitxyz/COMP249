package package2;

//-------------------------------------------------------
//Assignment 2 
//Part: 2
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #2
* Due Date: July 26 2020
*/


import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;


/**
 * This class implements a cargoship inventory, fixes said inventory, and displays its contents.
 * @author David Xie
 *@version 1.0
 */
public class CargoshipInventory1 {
	
	static Cargoship[] wsArr;
	
	/**
	 * This method fixes the serial numbers of a cargoship inventory
	 * @param inputFileName the file name of the file to fix
	 * @param outputFileName the file name with the corrected numbers
	 */
	public static void fixInventory(String inputFileName, String outputFileName) {
		Scanner inputStream = null;
        PrintWriter outputStream = null;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Attempting to open file: " + inputFileName);
        try
        {
           inputStream =
              new Scanner(new FileInputStream(inputFileName));
           outputStream = new PrintWriter(
                           new FileOutputStream(outputFileName));
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files.");
           System.exit(0);
        }
        
        int count = 0;
        
        //Find the size of the array
        System.out.println("\nDetecting number of records in file: " + inputFileName);
        while(inputStream.hasNextLine()) {
        	inputStream.nextLine();
        	count++;
        }
        
        //Close if no fixes to do
        if(count == 0 || count == 1) {
        	System.out.println("The file has " + count + " records. No fixing to be done. Exiting program.");
        	inputStream.close();
        	outputStream.close();
            System.exit(0);
        }
        
        System.out.println("\nThe file has " + count + " records");
        
        wsArr = new Cargoship[count];
        inputStream.close();
        
        try
        {
        	inputStream = new Scanner(new FileInputStream(inputFileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening files.");
            System.exit(0);
        }
        
        int index = 0;
        
        //Copy file content to array
        while(inputStream.hasNextLine( )) {
        	long number = inputStream.nextLong();
        	String name = inputStream.next();
        	int year = inputStream.nextInt();
        	String country = inputStream.next();
        	double price = inputStream.nextDouble();
        	int speed = inputStream.nextInt();
        	Cargoship ship = new Cargoship(number, name, year, country, price, speed);
        	wsArr[index] = ship;
        	index++;
        }
        
        inputStream.close();
        
        //Fix duplicate numbers
        for(int i = 0; i < wsArr.length - 1; i++) {
        	for(int j = i + 1; j < wsArr.length; j++) {
        		if(wsArr[i].getNumber() == wsArr[j].getNumber()) {
                    boolean done = false;
        			while(!done) {
            			try {
                			System.out.println("Duplicate serial number " + wsArr[j].getNumber() + " detected in "
                					+ "record # " + (j+1) + ". Please enter the correct serial number: ");
                			long number = keyboard.nextLong();
                			if(duplicateExists(number))
                				throw new DuplicateSerialNumberException("Attempt of duplicate entry to a "
                						+ "previous record.\n Initial appearance of serial number " + number + 
                						" was found at record #:" + indexDuplicate(number) + ".\n Error... "
                								+ "Duplicate Entry of Serial Number. The entered serial "
                								+ "number exists for another record.");
                			wsArr[j].setNumber(number);
                			done = true;
            			}
            			catch(DuplicateSerialNumberException e) {
            				System.out.println(e.getMessage());
            			}
        			}
        		}
        	}
        }
        
        //Put new content in output file
        for(int i = 0; i < wsArr.length; i++)
        	outputStream.println(wsArr[i]);
        
        outputStream.close();
	}
	
	/**
	 * This private method helps in finding existence of a duplicate serial number
	 * @param number the serial number to check
	 * @return the existence of duplicates
	 */
	private static boolean duplicateExists(long number) {
		for(int i = 0; i < wsArr.length; i++)
			if(wsArr[i].getNumber() == number)
				return true;
		return false;
	}
	
	/**
	 * This private method helps find the first instance of a duplicate number
	 * @param number the duplicate serial number
	 * @return the record of the first instance of that number
	 */
	private static int indexDuplicate(long number) {
		for(int i = 0; i < wsArr.length; i++)
			if(wsArr[i].getNumber() == number)
				return i+1;
		return -1;
	}
	
	/**
	 * This method prints the contents of a file to the console
	 * @param inputFileName the file name of the contents you wish to see
	 */
	public static void displayFileContents(String inputFileName) {
	       Scanner inputStream = null;

	       try
	       {
	           inputStream =
	              new Scanner(new FileInputStream(inputFileName));
	       }
	       catch(FileNotFoundException e)
	       {
	           System.out.println("File" + inputFileName + " was not found");
	           System.out.println("or could not be opened.");
	           System.exit(0);
	       }
	       
	       while(inputStream.hasNextLine())
	    	   System.out.println(inputStream.nextLine());
	       
	       inputStream.close();
	}

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String newFileName = null;
		String initialFile = "Initial_Cargoship_Info.txt";
		
		System.out.println("Please enter the name of output file, which will have correct information: ");
		newFileName = keyboard.nextLine( );
		File fileObject = new File(newFileName);
		
		//Check if file name exists already
		while (fileObject.exists( ))
	       {
	           System.out.println("Error: There is an existing file called: "
	                                      + newFileName);
	           System.out.println("This file already has a size of " + fileObject.length() + " bytes.\n");
	           System.out.println("Please enter another file name to create: ");
	           newFileName = keyboard.nextLine( );
	           fileObject = new File(newFileName);
	       }
		
		fixInventory(initialFile, newFileName);
		
		System.out.println("Here are the contents of file " + initialFile + " AFTER copying operation: ");
		System.out.println("===========================================================================");
		displayFileContents(initialFile);
		
		System.out.println("\nHere are the contents of file " + newFileName);
		System.out.println("===========================================================================");
		displayFileContents(newFileName);

	}

}
