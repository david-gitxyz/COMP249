package package2;

import java.util.NoSuchElementException;

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
 * This class implements a list of cellphones
 * @author David Xie
 *@version 1.0
 */
public class CellList {
	
	/**
	 * This inner class implements a cellphone node
	 * @author David Xie
	 *@version 1.0
	 */
	private class CellNode implements Cloneable {
		private CellPhone phone;
		private CellNode link;
		
		/**
		 * This is the default constructor for this cellphone node
		 */
		public CellNode() {
			phone = null;
			link = null;
		}
		
		/**
		 * This is the parameterized constructor of a specified cellphone node
		 * @param newPhone
		 * @param linkValue
		 */
		public CellNode(CellPhone newPhone, CellNode linkValue) {
			phone = newPhone;
			link = linkValue;
		}
		
		/**
		 * This is the copy constructor to copy another cellphone node. Both attributes dealt with are mutable 
		 * data. Measures were taken in place to prevent privacy leaks by creating deep copies. A clone method 
		 * was employed for the phone attribute. This allows the user to give a new serial number to the copy 
		 * of this phone. The link attribute is assigned to a new CellNode as opposed to the reference of the 
		 * link attribute of the copied cellphone node so as to prevent privacy leaks. Note that the clone method 
		 * works because of concepts of polymorphism.
		 * @param toCopy the cellphone node to copy
		 */
		public CellNode(CellNode toCopy) {
			phone = (CellPhone)toCopy.phone.clone();
			link = new CellNode(toCopy.link);
		}
		
		/**
		 * This is the clone method for this CellNode class. Both attributes dealt with are mutable 
		 * data. Measures were taken in place to prevent privacy leaks by creating deep copies. This was done 
		 * by replacing both attributes by their clone counterparts. This works because of polymorphism. 
		 * The Cloneable interface was implemented so that the clone() method is defined in a way to reduce risk 
		 * of privacy leaks as defined above.
		 */
		public Object clone() {
			try {
				CellNode copy = (CellNode)super.clone();
				copy.phone = (CellPhone)phone.clone();
				copy.link = (CellNode)link.clone();
				
				return copy;
			}
			catch(CloneNotSupportedException e) {
				return null;
			}
		}
		
		/**
		 * This is the mutator to the phone of this cellphone node. To reduce risk of privacy leak, this 
		 * node's phone is assigned to a new reference of the set cellphone.
		 * @param phone The phone to set to this cellnode
		 */
		public void setPhone(CellPhone phone) {
			this.phone = new CellPhone(phone.getNumber(), phone.getBrand(), phone.getYear(), phone.getPrice());
		}
		
		/**
		 * This is the accessor to the phone of this cellnode. To reduce risk of privacy leak, it returns a new 
		 * reference with the attributes of this node's phone.
		 * @return This node's cellphone
		 */
		public CellPhone getPhone() {
			return new CellPhone(phone.getNumber(), phone.getBrand(), phone.getYear(), phone.getPrice());
		}
		
		/**
		 * This is the mutator to the link of this cellnode. To reduce risk of privacy leak, this node's link 
		 * is assigned to a new reference of the set link.
		 * @param link The link to set to this cellnode
		 */
		public void setLink(CellNode link) {
			this.link = new CellNode(link);
		}
		
		/**
		 * This is the accessor to the link of this cellnode. To reduce risk of privacy leak, it returns a new 
		 * reference with the attribute of this node's link.
		 * @return
		 */
		public CellNode getLink() {
			return new CellNode(link);
		}
	}
	
	private CellNode head;
	private int size;
	
	/**
	 * This is the default constructor to a CellList. The head points at null since there is nothing in the list 
	 * yet. Size is starts at 0.
	 */
	public CellList() {
		head = null;
		size = 0;
	}
	
	/**
	 * This is the copy constructor of a CellList. It uses the helping method copyOf to return a true deep copy 
	 * of the CellList toCopy by using the clone method. This addresses the concerns of privacy leaks. Size is 
	 * of a primitive type, so there should be no concerns.
	 * @param toCopy The CellList to copy from.
	 */
	public CellList(CellList toCopy) {
		if(toCopy == null)
			throw new NullPointerException();
		if(toCopy.head == null) {
			head = null;
			size = 0;
		}
		else {
			head = copyOf(toCopy.head);
			size = toCopy.size;
		}
	}
	
	/**
	 * This is a helping method to return a true deep copy of a CellList. The precondition is that the 
	 * head is not null.
	 * @param otherHead The head of the CellList to copy.
	 * @return A reference to the head of a copy of the CellList and a true deep copy of the CellList
	 */
	private CellNode copyOf(CellNode otherHead) {
		CellNode position = otherHead; //moves down the list
		CellNode newHead; //points to the head of the copied list
		CellNode end = null; //positioned at the end of a growing list
		
		//Creating the first node
		newHead = new CellNode((CellPhone)(position.phone).clone(), null);
		end = newHead;
		position = position.link;
		
		//go through and copy the list
		while(position != null) {
			end.link = new CellNode((CellPhone)(position.phone).clone(), null);
			end = end.link;
			position = position.link;
		}
		
		return newHead;
	}
	
	/**
	 * This method adds a new phone at the start of the list
	 * @param newPhone The new phone to add to this CellList
	 */
	public void addToStart(CellPhone newPhone) {
		head = new CellNode(newPhone, head);
		size++;
	}
	
	/**
	 * This method inserts a new phone at a certain position in the list.
	 * @param newPhone The new phone to insert to the list
	 * @param index The position where to insert it in the list
	 */
	public void insertAtIndex(CellPhone newPhone, int index) {
		try {
			if(index < 0 || index > size - 1) {
				throw new NoSuchElementException();
			}
			else if(index == 0) {
				addToStart(newPhone);
			}
			else {
				CellNode position = head;
				CellNode previous = null;
				
				//Find the position where to insert the new phone
				for(int i = 0; i < index; i++) {
					previous = position;
					position = position.link;
				}
				
				CellNode temp = new CellNode(newPhone, position);
				previous.link = temp;
				previous = temp;
				size++;
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("There is no such index in this list! Shutting down the program...");
			System.exit(0);
		}
	}
	
	/**
	 * This method deletes a cellnode at a specified index
	 * @param index The position where to delete
	 */
	public void deleteFromIndex(int index) {
		try {
			if(index < 0 || index > size - 1) {
				throw new NoSuchElementException();
			}
			else if(index == 0) {
				deleteFromStart();
			}
			else {
				CellNode position = head;
				CellNode previous = null;
				
				//Find the position where to delete
				for(int i = 0; i < index; i++) {
					previous = position;
					position = position.link;
				}
				previous.link = position.link;
				position = position.link;
				size--;
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("There is no such index in this list! Shutting down the program...");
			System.exit(0);
		}
	}
	
	/**
	 * This method removes the first node in the list. It returns false if the list is empty.
	 * @return Whether the node was deleted or not.
	 */
	public boolean deleteFromStart() {
		if(head != null) {
			head = head.link;
			size--;
			return true;
		}
		else
			return false;
	}
	
	public boolean replaceAtIndex(CellPhone newPhone, int index) {
		if(index < 0 || index > size - 1) {
			return false;
		}
		else {
			CellNode position = head;
			for(int i = 0; i < index; i++) {
				position = position.link;
			}
			position.phone = new CellPhone(newPhone.getNumber(), newPhone.getBrand(), 
					newPhone.getYear(), newPhone.getPrice());
			return true;
		}
	}
	
	/**
	 * This method finds the position of a cellnode containing a cellphone with a specified serial number. 
	 * It keeps track of the number of iterations done before reaching the position.
	 * @param number The serial number of the cellphone searched
	 * @return The cellnode position of the cellphone searched in this list
	 */
	private CellNode find(long number) {
		CellNode position = head;
		CellPhone phoneAtPosition;
		int count = 0;
		while(position != null) {
			count++;
			phoneAtPosition = position.phone;
			if(phoneAtPosition.getNumber() == number) {
				System.out.println("The cellphone with serial number " + number + 
						" was found after " + count + " iterations.");
				System.out.println("The cellphone is: " + phoneAtPosition);
				return position;
			}
			position = position.link;
		}
		System.out.println("The cellphone with serial number " + number + " was not found in this list.");
		return null;
	}
	
	/**
	 * This method finds if the list contains a cellphone of a specified serial number.
	 * @param number The serial number of the cellphone to find in the list
	 * @return Whether the cellphone of the specified serial number exists in the list or not
	 */
	public boolean contains(long number) {
		return (find(number) != null);
	}
	
	/**
	 * This method shows the contents of this list.
	 */
	public void showContents() {
		System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
		System.out.println("=====================================================================");
		
		CellNode position = head;
		int count = 0;
		while(position != null) {
			System.out.print(position.phone + " ---> "); //toString() already implemented the desired format
			position = position.link;
			count++;
			if(count % 3 == 0)
				System.out.println();
		}
		
		System.out.println("X"); //When position = null
	}
	
	/**
	 * This method finds if two lists are equal.
	 * @return whether the 2 lists are equal
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null)
			return false;
		else if(getClass() != otherObject.getClass())
			return false;
		else {
			CellList otherList = (CellList)otherObject;
			if(size != otherList.size)
				return false;
			CellNode position = head;
			CellNode otherPosition = otherList.head;
			while(position != null) {
				if(!(position.phone.equals(otherPosition.phone)))
					return false;
				position = position.link;
				otherPosition = otherPosition.link;
			}
			return true; //no mismatch found
		}
	}

}
