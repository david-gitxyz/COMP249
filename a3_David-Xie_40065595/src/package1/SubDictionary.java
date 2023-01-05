package package1;

//-------------------------------------------------------
//Assignment 3
//Part: 1
//Written by: David Xie 40065595
//-------------------------------------------------------

/*
* David Xie 40065595
* COMP 249
* Assignment #3
* Due Date: August 16 2020
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class implements a sub-dictionary of an inputed text file containing all the words in 
 * alphabetical order from said text file.
 * @author David Xie
 * @version 1.0
 */
public class SubDictionary {

	public static void main(String[] args) {

        Scanner inputStream = null;
        PrintWriter outputStream = null;
        
        Scanner keyboard = new Scanner(System.in);
        
        String filename;
        System.out.println("Please enter the name of the file you wish to make a sub-dictionary out of: ");
        filename = keyboard.nextLine();
        
        ArrayList<String> output = new ArrayList<String>();
        
        //open the input and output files
        try {
        	inputStream = new Scanner(new FileInputStream(filename));
        	outputStream = new PrintWriter(new FileOutputStream("SubDictionary.txt"));        	       	
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files.");
           System.exit(0);
        }
        
        String next = null;
        
        //load the input file contents into an ArrayList
        while(inputStream.hasNext()) {
        	next = inputStream.next().toUpperCase(); //make all words in uppercase
        	next = removePunctuation(next);
        	output.add(next);
        }
        
        inputStream.close();
        
        //More fixing of the content
        removeSpecial(output); //removes "\'" and "="
        removeSingleChar(output); //removes single characters except A and I
        removeNumbers(output); //removes numbers and words with numbers
        removeRepeat(output); //removes repeat words
        sort(output); //sorts the content
        
        //Write to the output stream file
        writeToFile(output, outputStream);
        
        outputStream.close();
        
	}
	
	/**
	 * This method removes punctuation at the end of a word
	 * @param word the word taken from the inputStream
	 * @return this word fixed
	 */
	public static String removePunctuation(String word) {
        char[] character = word.toCharArray();
        
        if (character[character.length - 1] == '.' 
        		|| character[character.length - 1] == ':' 
        		|| character[character.length - 1] == ',' 
        		|| character[character.length - 1] == '?'
                || character[character.length - 1] == ';' 
                || character[character.length - 1] == '!')
            return word.substring(0, word.length() - 1);
        else
        	return word;

	}
	
	/**
	 * This method removes the special characters " \' " and "="
	 * @param output the content of the output
	 */
	public static void removeSpecial(ArrayList<String> output) {
        for(int i = 0; i < output.size(); i++) {
        	String word = output.get(i);
        	if(word.contains("’S")
        			|| word.contains("’M")
        			|| word.contains("\'S")
        			|| word.contains("\'M")) //remove " 's " and " 'm " punctuation
        		output.set(i, word.substring(0, word.length() - 2));
        	        	
        	if(word.contains("=")) //remove "=" character
        		output.remove(i);
        }
	}
	
	/**
	 * This method removes single characters except A and I
	 * @param output the content of the output
	 */
	public static void removeSingleChar(ArrayList<String> output) {
        //Generate the list of characters of the alphabet
		ArrayList<Character> alphabetChar = new ArrayList<Character>(26);
		for(char c = 'A'; c <= 'Z'; c++) {
				alphabetChar.add(c);
		}
		ArrayList<String> alphabet = new ArrayList<String>(26);
		for(Character letter : alphabetChar)
			alphabet.add(letter.toString());
		
        for(int i = 0; i < output.size(); i++) {
        	for(String letter : alphabet) {
        		if(letter.equals("A") || letter.equals("I"))
        			continue;
        		else if(output.get(i).equals(letter))
        			output.remove(i);
        	}
        }
	}
	
	/**
	 * This method removes numbers and words containing numbers
	 * @param output the content of the output
	 */
	public static void removeNumbers(ArrayList<String> output) {
		
		//Generate the list of digits
		ArrayList<Integer> digits = new ArrayList<Integer>(10);
		for(int i = 0; i < 10; i++)
			digits.add(i);
		
        //Remove digits and single characters
		for(int i = 0; i < output.size(); i++) {
	    	for(Integer number : digits) {
	    		if(output.get(i).equals("MC²"))
	    			continue;
	    		else if(output.get(i).contains(number.toString()))
	    			output.remove(i);
	    	}
		}
	}
	
	/**
	 * This method removes repeat words
	 * @param output the content of the output
	 */
	public static void removeRepeat(ArrayList<String> output) {
        for(int i = 0; i < output.size() - 1; i++) {
        	for(int j = i + 1; j < output.size(); j++) {
        		if(output.get(i).equals(output.get(j)))
        			output.remove(j);
        	}
        }
	}
	
	/**
	 * This method sorts a String ArrayList
	 * @param a the ArrayList to sort
	 */
    public static void sort(ArrayList<String> a)
    {
       int index, indexOfNextSmallest;
       for (index = 0; index < a.size( ) - 1; index++)
       {
           indexOfNextSmallest = 
                           indexOfSmallest(index, a);
           interchange(index,indexOfNextSmallest, a);
       }
    }
    
    /**
     * This method interchanges the order of elements in a String ArrayList
     * @param i index of the smaller value
     * @param j index of the bigger value
     * @param a the ArrayList to be sorted
     */
    private static void interchange(
                               int i, int j, ArrayList<String> a)
    {
       String temp;
       temp = a.get(i);
       a.set(i, a.get(j));
       a.set(j, temp);
    }
    
    /**
     * This method returns the index of the smallest element of a String ArrayList
     * @param startIndex the starting index in the ArrayList
     * @param a the ArrayList to be sorted
     * @return this ArrayList's index of smallest element from the starting index
     */
   private static int indexOfSmallest(
                                int startIndex, ArrayList<String> a)
   {
       String min = a.get(startIndex);
       int indexOfMin = startIndex;
       int index;
       for (index = startIndex + 1; index < a.size( ); index++)
       if ((a.get(index)).compareTo(min) < 0)
       {
           min = a.get(index);
           indexOfMin = index;
       }
       return indexOfMin;
   }
   
   /**
    * This method writes to the output file
    * @param output the content of the output
    */
   public static void writeToFile(ArrayList<String> output, PrintWriter outputStream) {
	   int count = 0;
	   String line = null;
	   
	   for(String word : output)
		   count++;
	   
	   line = "The document produced this sub-dictionary, which includes " + count + " entries.";
	   outputStream.println(line); //prints the word count
	   
	   outputStream.println("\n" + output.get(0).charAt(0));
	   outputStream.println("==");
	   for(int i = 0; i < output.size() - 1; i++) {
		   String word1 = output.get(i);
		   String word2 = output.get(i + 1);
		   outputStream.println(word1);
		   if(word1.charAt(0) != word2.charAt(0)) {
			   outputStream.println("\n" + word2.charAt(0));
			   outputStream.println("==");
		   }
	   }
	   outputStream.println(output.get(output.size() - 1));
   }
}
   
