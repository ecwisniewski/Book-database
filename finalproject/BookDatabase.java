package finalproject;

import java.io.File;
import java.util.ArrayList;

public class BookDatabase implements java.io.Serializable {

	private ArrayList<UsefulBook> database;
	private static final long serialVersionUID = 6751649745541556469L;
	private File fileLocation;
	
	public BookDatabase()
	{
		database = new ArrayList<UsefulBook>();
		
	}
	public BookDatabase(File fileLocation)
	{
		database = new ArrayList<UsefulBook>();
		this.fileLocation=fileLocation;
	}
	public void setFileLocation(File fileLocation) {
		this.fileLocation = fileLocation;
	}
	public File getFileLocation() {
		return fileLocation;
	}
	public void add(UsefulBook book)
	{
		database.add(book);
	}
	public UsefulBook get(int i)
	{
		return database.get(i);
	}
	public int getSize()
	{
		return database.size();
	}
	public boolean compare(UsefulBook book) {
		// Will check equals method
		return database.contains(book);
	}
	public void delete(UsefulBook book) {
		database.remove(book);
	}
	public UsefulBook findBook(String title, String author) {
		UsefulBook found=null;
		UsefulBook test;
		System.out.println("Expected Title: " + title + ", Author: " + author);
		for(int i =0; i<database.size(); i++) {
			test = database.get(i);
			System.out.println("Test Title: " + test.getTitle() + ", Test Author: " + test.getAuthor());
			if(test.getTitle().equals(title) && test.getAuthor().equals(author)) {
				System.out.println("Found match!");
				found = test;
				break;
			}
		}
		return found;
	}
	public void readFromText()
	{
		System.out.println(database.size());
		for(int i = 0; i < database.size(); i++)
		{
			System.out.print(database.get(i));
		}
		System.out.println();
	}
	public void saveToText() {
		
	}
	
}

