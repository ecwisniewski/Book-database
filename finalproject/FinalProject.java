package finalproject;

import java.io.*;
import java.util.ArrayList;

public class FinalProject {

	public static BookDatabase MainBookDatabase;
	public static BookDatabase LoanedBookDatabase;
	public static BookDatabase ReadBookDatabase;
	public static PersonDatabase MyFriends;
	public static void main(String[] args) {
		
		MainBookDatabase = new BookDatabase();
		LoanedBookDatabase= new BookDatabase();
		ReadBookDatabase = new BookDatabase();
		MyFriends = new PersonDatabase();
		// Get database info
		try {
			try {
				// Main
				File databaseFile = new File("bookdata.ser");
		        FileInputStream fileIn = new FileInputStream(databaseFile);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        MainBookDatabase = (BookDatabase) in.readObject();
		        MainBookDatabase.setFileLocation(databaseFile);
		        in.close();
		        fileIn.close();
			} catch(FileNotFoundException f) { // End should create new 
				System.out.println("Database Not found");
				MainBookDatabase.setFileLocation(new File("bookdata.ser"));
			}
			try {
		        // Loaned
				File loanedDataFile = new File("loaneddata.ser");
				 FileInputStream fileIn = new FileInputStream(loanedDataFile);
				 ObjectInputStream in = new ObjectInputStream(fileIn);
		        LoanedBookDatabase = (BookDatabase) in.readObject();
		        LoanedBookDatabase.setFileLocation(loanedDataFile);
		        in.close();
		        fileIn.close();
			} catch(FileNotFoundException f) { // End should create new 
				System.out.println("Database Not found");
				LoanedBookDatabase.setFileLocation(new File("loaneddata.ser"));
			}
			
			try {
				// Read
		        File readDataFile = new File("readdata.ser");
		        FileInputStream fileIn = new FileInputStream(readDataFile);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        ReadBookDatabase = (BookDatabase) in.readObject();
		        ReadBookDatabase.setFileLocation(readDataFile);
		        in.close();
		        fileIn.close();
			} catch(FileNotFoundException f) { // End should create new 
				System.out.println("Database Not found");
				ReadBookDatabase.setFileLocation(new File("readdata.ser"));
			}
			try {
				// Friends
		        File friendFile = new File("persondata.ser");
		        FileInputStream fileIn = new FileInputStream(friendFile);
				ObjectInputStream in = new ObjectInputStream(fileIn);
		        MyFriends = (PersonDatabase) in.readObject();
		        MyFriends.setFileLocation(friendFile);
		        in.close();
		        fileIn.close();
			} catch(FileNotFoundException f) { // End should create new 
				System.out.println("Database Not found");
				MyFriends.setFileLocation(new File("persondata.ser"));
			}
		
	    } catch (IOException i) {
	    	i.printStackTrace();
	        return;
	    } catch (ClassNotFoundException c) {
	    	System.out.println("Database Not found");
	        c.printStackTrace();
	        return;
	    }
		
		// Show first page
		Design.firstPage();

	}
}

