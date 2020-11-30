package finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FinalProject {

	public static BookDatabase MainBookDatabase;
	public static void main(String[] args) {
		
		MainBookDatabase = new BookDatabase();
		try {
	         FileInputStream fileIn = new FileInputStream("bookdata.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         MainBookDatabase = (BookDatabase) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch(FileNotFoundException f) { // End should create new 
		         System.out.println("Database Not found");
	      } catch (IOException i) {
	      
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Database Not found");
	         c.printStackTrace();
	         return;
	      }
		Design.firstPage();

		
		
		/*
		try {
	         FileOutputStream fileOut = new FileOutputStream("bookdata");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(MainBookDatabase);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in bookdata");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }*/
	}

}

